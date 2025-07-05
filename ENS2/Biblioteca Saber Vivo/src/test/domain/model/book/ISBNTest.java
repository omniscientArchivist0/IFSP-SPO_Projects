package domain.model.book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ISBNTest {

    @Test
    public void testISBN() {
        ISBN validISBN = new ISBN("978-1-6607-1495-7");
        ISBN invalidISBN = new ISBN("978-1-6607-1495-6");
        assertFalse(invalidISBN.checkISBN());
        assertTrue(validISBN.checkISBN());
    }
}
