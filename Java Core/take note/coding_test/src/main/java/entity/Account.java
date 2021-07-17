package entity;

import java.time.LocalDate;
import java.util.Date;

public class Account {
    int accountID;
    String email;
    String username;
    String fullName;
    int[] departments;
    int[] positions;
    Date createDate;
    Gender gender;

    public Account() {
    }

    public Account(int accountID, String email, String username, String fullName, int[] departments, int[] positions, Date createDate, Gender gender) {
        this.accountID = accountID;
        this.email = email;
        this.username = username;
        this.fullName = fullName;
        this.departments = departments;
        this.positions = positions;
        this.createDate = createDate;
        this.gender = gender;
    }
}
