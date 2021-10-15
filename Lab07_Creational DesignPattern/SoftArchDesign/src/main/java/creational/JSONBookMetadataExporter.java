package creational;

public class JSONBookMetadataExporter extends BookMetadataExporter{
    @Override
    public BookMetadataFormatter newMetaDataExporter() {
        return new JSONBookMetadataFormatter();
    }
}
