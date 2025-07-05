package domain.model.borrow;

import domain.model.book.Book;
import domain.model.book.State;
import domain.model.user.User;

import java.time.LocalDate;
import java.util.Calendar;

public class Borrow {
    private Book borrowedBook;
    private LocalDate duration;
    private User borrower;

    public Borrow(Book borrowedBook, LocalDate duration, User borrower) {
        this.borrowedBook = borrowedBook;
        this.duration = duration;
        this.borrower = borrower;
    }

    public void closeBorrow(boolean isDamaged) {
        if (isDamaged) {
            borrowedBook.changeState(State.DAMAGED);
        } else {
            borrowedBook.changeState(State.FREE);
        }
    }

    public LocalDate getDuration() {
        return duration;
    }

    public Book getBorrowedBook() {
        return borrowedBook;
    }

    public User getBorrower() {
        return borrower;
    }
}
