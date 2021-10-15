package creational;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Arrays;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {

    private JSONObject json;
    private JSONArray rootElement;

    public JSONBookMetadataFormatter() {
        reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        // Please implement this method. You may create additional methods as you see fit.
        json = new JSONObject();
        rootElement = new JSONArray();
        json.put(Book.class.getSimpleName() + "s", rootElement);
        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        // Please implement this method. You may create additional methods as you see fit.
        JSONObject book = new JSONObject();
        JSONArray authors = new JSONArray();
        book.put(Book.Metadata.ISBN.value, b.getISBN());
        authors.addAll(Arrays.asList(b.getAuthors()));
        book.put(Book.Metadata.AUTHORS.value, authors);
        book.put(Book.Metadata.TITLE.value, b.getTitle());
        book.put(Book.Metadata.PUBLISHER.value, b.getPublisher());
        rootElement.add(book);
        return this;
    }

    @Override
    public String getMetadataString() {
        // Please implement this method. You may create additional methods as you see fit.
        return json.toJSONString();
    }
}
