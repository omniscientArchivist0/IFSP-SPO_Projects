package domain.repository;

import domain.model.book.Book;
import infraestructure.persistence.BookDAO;
import infraestructure.persistence.UserDAO;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    public BookDAO bookDAO = new BookDAO();

    public Book searchBook(String name) {
        return bookDAO.searchBook(name);
    }

    public List<Book> searchBooks(List<String> names) {
        List<Book> tempBooks = new ArrayList<>();

        for (String name : names) {
            tempBooks.add(bookDAO.searchBook(name));
        }

        return tempBooks;
    }

    public void addBook(Book book) {
        bookDAO.registerBook(book);
    }

    public void addBooks(List<Book> books) {
        for (Book book : books) {
            bookDAO.registerBook(book);
        }
    }

    public void removeBook(String name) {
        bookDAO.deleteBook(name);
    }

    public void removeBooks(List<String> names) {
        for (String name : names) {
            bookDAO.deleteBook(name);
        }
    }

    public void updateBook(Book book) {
        bookDAO.updateBook(book.getName(), book);
    }

    public void updateBooks(List<Book> books) {
        for (Book book : books) {
            bookDAO.updateBook(book.getName(), book);
        }
    }


}
