package asignment_3;

import entity.Account;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Exercise_2 {
    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<Account>();

        for (int i = 0; i < 5; i++) {
            // create an account
            Account account = new Account();
            account.setEmail("Email " + (i + 1));
            account.setUserName("user name " + (i + 1));
            account.setFullName("full name " + (i + 1));
            account.setCreateDate(LocalDate.now());
            // insert account into account list
            accounts.add(account);
        }

        for (Account acc : accounts) {
            System.out.println(acc.toString());
        }

    }
}
