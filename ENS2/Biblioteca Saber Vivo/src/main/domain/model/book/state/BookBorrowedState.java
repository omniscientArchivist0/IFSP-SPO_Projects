package domain.model.book.state;

import domain.model.book.Book;
import domain.model.book.State;

public class BookBorrowedState extends BookState {

    private Book book;

    public BookBorrowedState(Book book) {
        super(book);
    }

    public State checkState() {
       return State.BORROWED;
    }
    public BookState borrow() {
        return null;
    }
}
