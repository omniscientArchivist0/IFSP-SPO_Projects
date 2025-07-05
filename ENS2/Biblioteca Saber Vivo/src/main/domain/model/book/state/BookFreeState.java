package domain.model.book.state;

import domain.model.book.Book;
import domain.model.book.State;

public class BookFreeState extends BookState {

    private Book book;

    public BookFreeState(Book book) {
        super(book);
    }
    public State checkState() {
       return State.FREE;
    }
    public BookState borrow() {
        return new BookBorrowedState(book);
    }
}
