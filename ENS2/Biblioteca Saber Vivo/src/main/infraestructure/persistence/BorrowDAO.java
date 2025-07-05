package infraestructure.persistence;

import domain.model.book.Book;
import domain.model.borrow.Borrow;
import domain.model.user.User;

import java.util.List;
import java.util.Objects;

public class BorrowDAO {

    FakeDatabase db = new FakeDatabase();

    public List<Borrow> getBorrowTable() {
        return db.borrowTable;
    }

    public Borrow getBorrow(int index) {
        return db.borrowTable.get(index);
    }

    public void registerBorrow(Borrow borrow) {
        db.borrowTable.add(borrow);
    }

    public Borrow searchBorrow(User user, Book book) {
        System.out.println(db.borrowTable.get(0));
        List<Borrow> fullList = db.borrowTable;
        Borrow tempBorrow = null;

        for (Borrow internalBorrow : fullList) {
            if (Objects.equals(internalBorrow.getBorrower(), user) && Objects.equals(internalBorrow.getBorrowedBook(), book)) {
                tempBorrow = internalBorrow;
            }
        }

        return tempBorrow;
    }

    public List<Borrow> searchBorrows(User user) {
        List<Borrow> fullList = db.borrowTable;
        List<Borrow> tempBorrows = null;

        for (Borrow internalBorrow : fullList) {
            if (Objects.equals(internalBorrow.getBorrower(), user)) {
                tempBorrows.add(internalBorrow);
            }
        }
        return tempBorrows;
    }

    public void deleteBorrow(User user, Book book) {
        db.borrowTable.remove(searchBorrow(user,book));
    }

    public void updateBorrow(User user, Book book, Borrow borrow) {
        db.borrowTable.set(db.borrowTable.indexOf(searchBorrow(user,book)), borrow);
    }
}
