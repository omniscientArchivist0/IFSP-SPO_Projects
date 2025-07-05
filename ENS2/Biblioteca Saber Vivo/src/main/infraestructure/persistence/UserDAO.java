package infraestructure.persistence;

import domain.model.book.Book;
import domain.model.user.User;

import java.util.List;
import java.util.Objects;

public class UserDAO {

    FakeDatabase db = new FakeDatabase();

    public List<User> getUserTable() {
        return db.userTable;
    }

    public User getUser(int index) {
        return db.userTable.get(index);
    }

    public void registerUser(User user) {
        db.userTable.add(user);
    }

    public User searchUser(String name) {
        List<User> fullList = db.userTable;
        User tempUser = null;

        for (User internalUser : fullList) {
            if (Objects.equals(internalUser.getName(), name)) {
                tempUser = internalUser;
            }
        }
        return tempUser;
    }

    public void deleteUser(String name) {
        db.userTable.remove(searchUser(name));
    }

    public void updateUser(String name, User user) {
        db.userTable.set(db.userTable.indexOf(searchUser(name)), user);
    }

}
