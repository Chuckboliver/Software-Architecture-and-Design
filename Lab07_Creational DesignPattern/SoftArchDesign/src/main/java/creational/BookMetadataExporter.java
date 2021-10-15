package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintStream;

public abstract class BookMetadataExporter extends BookCollection {

    public abstract BookMetadataFormatter newMetaDataExporter() throws IOException, ParserConfigurationException;

    public void export(PrintStream stream) throws IOException, ParserConfigurationException {
        // Please implement this method. You may create additional methods as you see fit.
        BookMetadataFormatter metadataFormatter = this.newMetaDataExporter();
        metadataFormatter.reset();
        for(Book book: this.books) {
            metadataFormatter.append(book);
        }
        stream.println(metadataFormatter.getMetadataString());
    }
}
