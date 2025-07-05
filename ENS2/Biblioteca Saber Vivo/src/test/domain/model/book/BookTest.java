package domain.model.book;

import domain.model.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void testBorrowBook() {
        Book book = new Book("978-1-6607-1495-7");
        User user = new User("Anna");
        assertEquals(State.FREE, book.getState().checkState());
        book.borrow(user);
        assertEquals(State.BORROWED, book.getState().checkState());
    }

    @Test
    public void testChangeState() {
        Book book = new Book("978-1-6607-1495-7");
        assertEquals(State.FREE, book.getState().checkState());
        book.changeState(State.DAMAGED);
        assertEquals(State.DAMAGED, book.getState().checkState());
    }
}
