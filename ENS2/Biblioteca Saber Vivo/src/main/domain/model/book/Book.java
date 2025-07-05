package domain.model.book;

import domain.model.book.state.BookBorrowedState;
import domain.model.book.state.BookDamagedState;
import domain.model.book.state.BookFreeState;
import domain.model.book.state.BookState;
import domain.model.borrow.Borrow;
import domain.model.borrow.BorrowFactory;
import domain.model.user.User;

public class Book {

    private String name;
    private String description;
    private final ISBN isbn;
    private BookState state;
    private BookPosition libraryPosition;

    public Book(String ISBNCode) {
        state = new BookFreeState(this);
        isbn = new ISBN(ISBNCode);
    };

    public Book(String name, String description, String ISBNCode) {
        this.name = name;
        this.description = description;
        isbn = new ISBN(ISBNCode);
        state = new BookFreeState(this);
        libraryPosition = new BookPosition("A", "1");
    }

    public Book(String name, String description, String ISBNCode, State state, String shelf, String section) {
        this.name = name;
        this.description = description;
        isbn = new ISBN(ISBNCode);
        changeState(state);
        libraryPosition = new BookPosition(shelf, section);
    }

    public Borrow borrow(User user) {
        BookState tempState = state.borrow();
        if (tempState != null) {
            state = tempState;
        }

        return new BorrowFactory().createDefaultBorrow(this, user);
    }

    public void changeState(State bookState) {
        switch(bookState) {
            case FREE: state = (new BookFreeState(this));
            break;
            case BORROWED: state = (new BookBorrowedState(this));
            break;
            case DAMAGED: state = (new BookDamagedState(this));

        }
    }

    public BookState getState() {
        return state;
    }

    public void updateBook(String name, String description) {
        if (name != null) {
            this.name = name;
        }
        if (description != null) {
            this.description = description;
        }
    }

    public void updateBook(String name, String description, String shelf, String section) {
        if (name != null) {
            this.name = name;
        }
        if (description != null) {
            this.description = description;
        }
        this.libraryPosition = new BookPosition(shelf, section);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
