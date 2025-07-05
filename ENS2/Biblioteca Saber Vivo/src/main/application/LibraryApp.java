package application;

import domain.model.book.State;
import domain.model.borrow.Borrow;
import domain.model.librarian.Librarian;
import domain.model.user.User;
import domain.repository.BookRepository;
import domain.model.book.Book;
import domain.repository.BorrowRepository;
import domain.repository.LibrarianRepository;
import domain.repository.UserRepository;
import presentation.ui.UI;
import java.util.Scanner;

public class LibraryApp {

    private final BookRepository bookRepository = new BookRepository();
    private final UserRepository userRepository = new UserRepository();
    private final BorrowRepository borrowRepository = new BorrowRepository();
    private final LibrarianRepository librarianRepository = new LibrarianRepository();
    private final UI ui = new UI();
    private boolean flow = true;

    public void execute() {
        while (flow) {
            ui.showMessage("----------------");
            ui.instructions();
            Scanner sc = new Scanner(System.in);
            switch(sc.nextInt()) {
                case 1: registerNewUser();
                break;
                case 2: registerNewLibrarian();
                break;
                case 3: registerBook();
                break;
                case 4: checkBook();
                break;
                case 5: removeBook();
                break;
                case 6: borrowBook();
                break;
                case 7: returnBook();
                break;
                case 8: checkBorrow();
                break;
                case 9: checkUser();
                break;
                case 10: flow = false;
                break;

            }
        }
    }

    private void checkBook() {
        ui.insertData();
        ui.showMessage("Nome do Livro");

        Scanner sc = new Scanner(System.in);
        String name = sc.next();

        Book book = bookRepository.searchBook(name);
        if (book == null) {
            ui.notFound("Livro");
        }
        else {
            ui.found("Livro");
        }
    }

    private void registerBook() {

        ui.insertData();
        ui.showMessage("Nome do Livro; Descrição do Livro; ISBN");

        Scanner sc = new Scanner(System.in);

        String[] input = new String[3];
        sc.nextLine(); //consuming the <enter> from input above

        for (int i = 0; i < input.length; i++) {
            input[i] = sc.nextLine();
        }

        String name = input[0];
        String description = input[1];
        String ISBNCode = input[2];

        Book book = new Book(name, description, ISBNCode);
        bookRepository.addBook(book);
        ui.added("Livro");
    }

    private void registerNewUser() {
        ui.insertData();
        ui.showMessage("Nome do Usuário");

        Scanner sc = new Scanner(System.in);
        String name = sc.next();

        User user = new User(name);
        userRepository.addUser(user);
        ui.added("Usuário");
    }

    private void registerNewLibrarian() {
        ui.insertData();
        ui.showMessage("Nome do Bibliotecario");

        Scanner sc = new Scanner(System.in);
        String name = sc.next();

        Librarian librarian = new Librarian(name);
        librarianRepository.addLibrarian(librarian);
        ui.added("Bibliotecario");
    }

    private void removeBook() {
        ui.insertData();
        ui.showMessage("Nome do Livro");

        Scanner sc = new Scanner(System.in);
        String name = sc.next();

        bookRepository.removeBook(name);
        ui.removed("Livro");
    }

    private void borrowBook() {

        ui.insertData();
        ui.showMessage("Nome do Livro; Nome do Usuario");

        String[] input = new String[2];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < input.length; i++) {
            input[i] = sc.nextLine();
        }

        String bookName = input[0];
        String userName = input[1];

        Book book = bookRepository.searchBook(bookName);
        User user = userRepository.searchUser(userName);

        if (book == null) {
            ui.unableToFindBook();
        }
        else {
           Borrow borrow = book.borrow(user);
           borrowRepository.addBorrow(borrow);
           bookRepository.updateBook(book);
           ui.updated("Livro");
        }
    }

    private void checkBorrow() {
        ui.insertData();
        ui.showMessage("Nome do Usuário; Nome do Livro");

        String[] input = new String[2];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < input.length; i++) {
            input[i] = sc.nextLine();
        }

        String userName = input[0];
        String bookName = input[1];

        Borrow borrow = borrowRepository.searchBorrow(userRepository.searchUser(userName),bookRepository.searchBook(bookName));

        if (borrow == null) {
            ui.notFound("Emprestimo");
        }
        else {
            ui.found("Emprestimo");
        }
    }

    private void checkUser() {
        ui.insertData();
        ui.showMessage("Nome do Usuário");

        Scanner sc = new Scanner(System.in);
        String name = sc.next();

        User user = userRepository.searchUser(name);

        if (user == null) {
            ui.notFound("Usuário");
        }
        else {
            ui.found("Usuário");
        }
    }

    private void returnBook() {

        ui.insertData();
        ui.showMessage("Nome do Usuário; Nome do Livro");

        String[] input = new String[2];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < input.length; i++) {
            input[i] = sc.nextLine();
        }

        String userName = input[0];
        String bookName = input[1];

        boolean isDamaged;

        ui.showMessage("O livro foi danificado? (S/N {O padrão é Não})");
        String damaged = sc.next();
        switch (damaged) {
            case "S": {
                isDamaged = true;
            }
            break;
            default: {
                isDamaged = false;
            }
        }

        Borrow borrow = borrowRepository.searchBorrow(userRepository.searchUser(userName),bookRepository.searchBook(bookName));
        if (borrow == null) {
            ui.notFound("Emprestimo");
        }
        else {
            Book tempBook;
            User tempUser;
            tempBook = borrow.getBorrowedBook();
            tempUser = borrow.getBorrower();
            borrow.closeBorrow(isDamaged);
            if (isDamaged) {
                tempBook.changeState(State.DAMAGED);
            } else {
                tempBook.changeState(State.FREE);
            }
            borrowRepository.removeBorrow(tempUser,tempBook);
            bookRepository.updateBook(tempBook);
            ui.bookReturned();
        }
    }
}
