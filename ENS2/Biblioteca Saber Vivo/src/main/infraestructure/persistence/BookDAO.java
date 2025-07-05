package infraestructure.persistence;

import domain.model.book.Book;
import domain.model.borrow.Borrow;
import domain.model.librarian.Librarian;
import domain.model.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookDAO {

    FakeDatabase db = new FakeDatabase();

    public List<Book> getBookTable() {
        return db.bookTable;
    }

    public Book getBook(int index) {
        return db.bookTable.get(index);
    }

    public void registerBook(Book book) {
        db.bookTable.add(book);
    }

    public Book searchBook(String name) {
        List<Book> fullList = db.bookTable;
        Book tempBook = null;

        for (Book internalBook : fullList) {
            if (Objects.equals(internalBook.getName(), name)) {
                tempBook = internalBook;
            }
        }
        return tempBook;
    }

    public void deleteBook(String name) {
        db.bookTable.remove(searchBook(name));
    }

    public void updateBook(String name, Book book) {
        db.bookTable.set(db.bookTable.indexOf(searchBook(name)), book);
    }

}
