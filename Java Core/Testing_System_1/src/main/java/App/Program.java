package App;

import entity.Account;
import entity.Department;
import entity.Position;

import java.sql.Date;

public class Program {
    public static void main(String[] args) {
        Department department = new Department(1, "phong giam doc");
        Account account = new Account(1, "gd@gmail.com", "gduser",
                "giam doc 1", 1, 1,
                Date.valueOf("2021-07-10"), "nam");
        Position position = new Position(1, "giam doc");

        System.out.println(department);
        System.out.println(account);
        System.out.println(position);

        System.out.println("1-accountID: " + account.getAccountID());
    }
}
