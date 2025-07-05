package domain.model.user;

public class User {
    private String name;
    private boolean isBorrower;

    public User(String name) {
        this.name = name;
        isBorrower = false;
    }

    public User(String name, Boolean isBorrower) {
        this.name = name;
        this.isBorrower = isBorrower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBorrower() {
        return isBorrower;
    }

    public void changeBorrower() {
        this.isBorrower = !isBorrower;
    }
}
