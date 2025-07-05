package domain.repository;

import domain.model.book.Book;
import domain.model.borrow.Borrow;
import domain.model.user.User;
import infraestructure.persistence.BookDAO;
import infraestructure.persistence.BorrowDAO;

import java.util.ArrayList;
import java.util.List;

public class BorrowRepository {

    public BorrowDAO borrowDAO = new BorrowDAO();

    public Borrow searchBorrow(User user, Book book) {
        return borrowDAO.searchBorrow(user, book);
    }

    public List<Borrow> searchBorrows(List<User> users, List<Book> books) {
        List<Borrow> tempBorrows = new ArrayList<>();

        for (User user : users) {
            for (Book book : books) {
                Borrow tempBorrow = null;
                tempBorrow = borrowDAO.searchBorrow(user, book);
                if (tempBorrow != null) {
                    tempBorrows.add(tempBorrow);
                }
            }
        }

        return tempBorrows;
    }

    public List<Borrow> searchBorrowsByUser(User user) {
        return borrowDAO.searchBorrows(user);
    }

    public void addBorrow(Borrow borrow) {
        borrowDAO.registerBorrow(borrow);
    }

    public void addBorrows(List<Borrow> borrows) {
        for (Borrow borrow : borrows) {
            borrowDAO.registerBorrow(borrow);
        }
    }

    public void removeBorrow(User user, Book book) {
        borrowDAO.deleteBorrow(user, book);
    }

    public void removeBorrowsByUser(User user, List<Book> books) {
            for (Book book : books) {
                borrowDAO.deleteBorrow(user, book);
            }
    }

    public void updateBorrow(User user, Book book, Borrow borrow) {
        borrowDAO.updateBorrow(user, book, borrow);
    }
}
