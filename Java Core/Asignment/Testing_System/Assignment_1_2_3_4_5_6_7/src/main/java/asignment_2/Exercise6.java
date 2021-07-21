package asignment_2;

import entity.Account;
import entity.Group;

import java.time.LocalDate;
import java.util.Date;

public class Exercise6 {
    public static void main(String[] args) {
        Account acc1 = new Account(1, "a@gmail.com", "a", "nva", null, null, LocalDate.now(), null);

        cau1();
        cau2(acc1);
        cau3();
    }

    static void cau1() {
        int i = 0;
        while (i < 10) {
            System.out.println(i);
            i += 2;
        }
    }

    static void cau2(Account account) {
        System.out.println(account);
    }

    static void cau3() {
        int i = 0;
        while (i < 10) {
            System.out.println(i);
            i++;
        }
    }
}
