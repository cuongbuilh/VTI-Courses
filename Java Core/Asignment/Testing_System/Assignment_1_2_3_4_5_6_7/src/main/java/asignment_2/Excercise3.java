package asignment_2;

import entity.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Excercise3 {
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

        Exam exam = new Exam(1, LocalDateTime.now());

//        cau1(exam);
//        cau2(exam);
//        cau3();
//        cau4();
        cau5();
    }

    static void cau1(Exam exam) {
//        Locale locale = new Locale("vn","VN");
        String pattern = "dd/MM/yyyy HH:mm:ss";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        System.out.println(dateTimeFormatter.format(exam.getCreateDate()));

    }


    static void cau2(Exam exam) {
        String pattern = "dd-MM-yyyy - HH-mm-ss";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        System.out.println(dateTimeFormatter.format(exam.getCreateDate()));

    }


    static void cau3() {
        String pattern = "dd-MM-yyyy - HH-mm-ss";
        String str = "18-07-2021 - 15-58-19";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);

        LocalDateTime lct = LocalDateTime.parse(str, dateTimeFormatter);
        System.out.printf("nam %d\n", lct.getYear());
    }


    static void cau4() {
        String pattern = "dd-MM-yyyy - HH-mm-ss";
        String str = "18-07-2021 - 15-58-19";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);

        LocalDateTime lct = LocalDateTime.parse(str, dateTimeFormatter);
        System.out.printf("thnag %d nam %d \n", lct.getMonthValue(), lct.getYear());
    }


    static void cau5() {
        String pattern = "dd-MM-yyyy - HH-mm-ss";
        String str = "18-07-2021 - 15-58-19";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime lct = LocalDateTime.parse(str, dateTimeFormatter);

        String prt_pattern = "MM-DD";
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern(prt_pattern);
        System.out.println(dateTimeFormatter1.format(lct));
    }
}
