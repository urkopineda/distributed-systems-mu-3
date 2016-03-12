package data;

/**
 * User profile of a chat.
 *
 * @author urko
 */
public class User {

    private String name;
    private String username;
    private String password;

    public User() {}

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public boolean changePassword(String oldPassword, String newPassword) {
        if (oldPassword.equals(password)) {
            password = newPassword;
            return true;
        } else return false;
    }

    public boolean changeName(String password, String name) {
        if (this.password.equals(password)) {
            this.name = name;
            return true;
        } else return false;
    }

    public boolean changeUserName(String password, String username) {
        if (this.password.equals(password)) {
            this.username = username;
            return true;
        } else return false;
    }

}
