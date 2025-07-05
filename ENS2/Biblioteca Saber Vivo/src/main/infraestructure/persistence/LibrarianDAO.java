package infraestructure.persistence;

import domain.model.librarian.Librarian;
import domain.model.user.User;

import java.util.List;
import java.util.Objects;

public class LibrarianDAO {

    FakeDatabase db = new FakeDatabase();

    public List<Librarian> getLibrarianTable() {
        return db.librarianTable;
    }

    public Librarian getLibrarian(int index) {
        return db.librarianTable.get(index);
    }

    public void registerLibrarian(Librarian librarian) {
        db.librarianTable.add(librarian);
    }

    public Librarian searchLibrarian(String name) {
        List<Librarian> fullList = db.librarianTable;
        Librarian tempLibrarian = null;

        for (Librarian internalLibrarian : fullList) {
            if (Objects.equals(internalLibrarian.getName(), name)) {
                tempLibrarian = internalLibrarian;
            }
        }
        return tempLibrarian;
    }

    public void deleteLibrarian(String name) {
        db.librarianTable.remove(searchLibrarian(name));
    }

    public void updateLibrarian(String name, Librarian librarian) {
        db.librarianTable.set(db.librarianTable.indexOf(searchLibrarian(name)), librarian);
    }


}
