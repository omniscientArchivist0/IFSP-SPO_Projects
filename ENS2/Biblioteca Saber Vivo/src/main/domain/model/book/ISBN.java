package domain.model.book;

import net.creativecouple.validation.isbn.ISBNValidator;
import static net.creativecouple.validation.isbn.ISBNValidatorBuilder.HyphenationOption.ANY;

public class ISBN {
    private String ISBN;

    public ISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }

    public Boolean checkISBN() {
        ISBNValidator validator = ISBNValidator.anyIsbn().hyphenation(ANY);
        return validator.test(ISBN);
    }


}
