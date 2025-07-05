package domain.model.book.state;

import domain.model.book.Book;
import domain.model.book.State;

public abstract class BookState {

    Book book;

    public BookState(Book book) {
        this.book = book;
    }

    public abstract State checkState();
    public abstract BookState borrow();
}
