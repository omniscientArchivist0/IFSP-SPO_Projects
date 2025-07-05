package domain.model.borrow;

import domain.model.book.Book;
import domain.model.user.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BorrowFactory {
    public Borrow createDefaultBorrow(Book book, User user) {
        if (user.isBorrower()) {
            return null;
        }
        return new Borrow(book, LocalDate.now().plusDays(7), user);
    }
    public Borrow createProlongedBorrow(Book book, User user) {
        if (user.isBorrower()) {
            return null;
        }
        return new Borrow(book, LocalDate.now().plusDays(30), user);
    }
    public List<Borrow> createDefaultBorrows(List<Book> books, User user) {
        if (user.isBorrower()) {
            return null;
        }
        List<Borrow> borrows = new ArrayList<>();
        for (Book book : books) {
            borrows.add(new Borrow(book, LocalDate.now().plusDays(7), user));
        }
        return borrows;
    }
    public List<Borrow> createProlongedBorrows(List<Book> books, User user) {
        if (user.isBorrower()) {
            return null;
        }
        List<Borrow> borrows = new ArrayList<>();
        for (Book book : books) {
            borrows.add(new Borrow(book, LocalDate.now().plusDays(30), user));
        }
        return borrows;
    }
}
