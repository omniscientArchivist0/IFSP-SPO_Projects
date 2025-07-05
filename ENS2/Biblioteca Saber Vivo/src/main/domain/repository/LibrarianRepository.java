package domain.repository;

import domain.model.librarian.Librarian;
import domain.model.user.User;
import infraestructure.persistence.FakeDatabase;
import infraestructure.persistence.LibrarianDAO;
import infraestructure.persistence.UserDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibrarianRepository {

    public LibrarianDAO librarianDAO = new LibrarianDAO();

    public Librarian searchLibrarian(String name) {
        return librarianDAO.searchLibrarian(name);
    }

    public List<Librarian> searchLibrarians(List<String> names) {
        List<Librarian> tempLibrarians = new ArrayList<>();

        for (String name : names) {
            tempLibrarians.add(librarianDAO.searchLibrarian(name));
        }

        return tempLibrarians;
    }

    public void addLibrarian(Librarian librarian) {
        librarianDAO.registerLibrarian(librarian);
    }

    public void addLibrarians(List<Librarian> librarians) {
        for (Librarian librarian : librarians) {
            librarianDAO.registerLibrarian(librarian);
        }
    }

    public void removeLibrarian(String name) {
        librarianDAO.deleteLibrarian(name);
    }

    public void removeLibrarians(List<String> names) {
        for (String name : names) {
            librarianDAO.deleteLibrarian(name);
        }
    }

    public void updateLibrarian(Librarian librarian) {
        librarianDAO.updateLibrarian(librarian.getName(), librarian);
    }

    public void updateLibrarians(List<Librarian> librarians) {
        for (Librarian librarian : librarians) {
            librarianDAO.updateLibrarian(librarian.getName(), librarian);
        }
    }

}
