package entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String fullname;
    private String email;
    private String password;
    private boolean isAdmin;

    public User(String fullname, String email, String password) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.isAdmin = false;
    }
}
