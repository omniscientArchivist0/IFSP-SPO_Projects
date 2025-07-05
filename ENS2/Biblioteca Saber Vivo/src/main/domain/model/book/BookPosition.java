package domain.model.book;

public class BookPosition {
    private String section;
    private String shelf;

    public BookPosition(String section, String shelf) {
        this.section = section;
        this.shelf = shelf;
    }

    public String getSection() {
        return section;
    }

    public String getShelf() {
        return shelf;
    }
}
