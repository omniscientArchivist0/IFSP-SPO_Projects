package domain.repository;

import domain.model.book.Book;
import domain.model.user.User;
import infraestructure.persistence.UserDAO;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public UserDAO userDAO = new UserDAO();

    public User searchUser(String name) {
        return userDAO.searchUser(name);
    }

    public List<User> searchUsers(List<String> names) {
        List<User> tempUsers = new ArrayList<>();

        for (String name : names) {
            tempUsers.add(userDAO.searchUser(name));
        }

        return tempUsers;
    }

    public void addUser(User user) {
        userDAO.registerUser(user);
    }

    public void addUsers(List<User> users) {
        for (User user : users) {
            userDAO.registerUser(user);
        }
    }

    public void removeUser(String name) {
        userDAO.deleteUser(name);
    }

    public void removeUsers(List<String> names) {
        for (String name : names) {
            userDAO.deleteUser(name);
        }
    }

    public void updateUser(User user) {
        userDAO.updateUser(user.getName(), user);
    }

    public void updateUsers(List<User> users) {
        for (User user : users) {
            userDAO.updateUser(user.getName(), user);
        }
    }
}
