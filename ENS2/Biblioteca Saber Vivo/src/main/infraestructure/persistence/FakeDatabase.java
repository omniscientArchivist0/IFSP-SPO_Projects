package infraestructure.persistence;

import domain.model.book.Book;
import domain.model.borrow.Borrow;
import domain.model.librarian.Librarian;
import domain.model.user.User;

import java.util.ArrayList;
import java.util.List;

public class FakeDatabase {
    List<Book> bookTable = new ArrayList<>();
    List<Borrow> borrowTable = new ArrayList<>();
    List<Librarian> librarianTable = new ArrayList<>();
    List<User> userTable = new ArrayList<>();
}
