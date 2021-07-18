package asignment_2;

import entity.Account;
import entity.Department;
import entity.Group;
import entity.Position;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

public class Excercise2 {
    public static void main(String[] args) {
        Department dep1 = new Department(1, "mar");
        Department dep2 = new Department(2, "mar");
        Department dep3 = new Department(3, "mar");

        Position pos1 = new Position(1, "dev");
        Position pos2 = new Position(2, "dev");
        Position pos3 = new Position(3, "dev");

        Group gr1 = new Group(1, "test");
        Group gr2 = new Group(2, "test");
        Group gr3 = new Group(3, "test");

        Account acc1 = new Account(1, "a@gmail.com", "a", "nva", dep1, pos1, new Date(2021, 12, 12), new Group[]{gr1, gr3});
        Account acc2 = new Account(1, "a@gmail.com", "a", "nva", dep1, pos1, new Date(2021, 12, 12), new Group[]{gr1, gr3});
        Account acc3 = new Account(1, "a@gmail.com", "a", "nva", dep1, pos1, new Date(2021, 12, 12), new Group[]{gr1, gr3});

//        cau1();
//        cau2();
//        cau3();
//        cau4();
//        cau5();
        cau6(new Account[] {acc1,acc2,acc3});
    }

    static void cau1() {
        int i = 5;
        System.out.println(i);
    }

    static void cau2() {
        int i = 100000000;
        System.out.printf("%,d", i);
    }

    static void cau3() {
        float f = 5.567089f;
        System.out.printf("%.2f", f);
    }

    static void cau4() {
        String name = "Nguen Van A";
        System.out.printf("ten toi la \"%s\" va toi dang doc than", name);
    }

    static void cau5() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mmp:ss");
        System.out.println(dft.format(now));
    }

    static void cau6(Account[] accounts) {
        System.out.printf("%-18s | %-10s | %-18s \n","Email","Full name","department name");
        for (Account account : accounts) {
            System.out.printf("%-18s | %-10s | %-10s\n", account.getEmail(), account.getFullName(), account.getDepartment().getDepartmentName());
        }
    }
}
