package domain.model.book.state;

import domain.model.book.Book;
import domain.model.book.State;

public class BookDamagedState extends BookState {

    private Book book;

    public BookDamagedState(Book book) {
        super(book);
    }

    public State checkState() {
       return State.DAMAGED;
    }
    public BookState borrow() {
        return null;
    }
}
