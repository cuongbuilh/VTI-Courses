package asignment_2;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Exercise4 {
    public static void main(String[] args) {
//        cau1();
//        cau2();
//        cau3();
//        cau4();
//        cau5();
//        cau6();
        cau7();
    }

    static void cau1() {
        Random rd = new Random();
        System.out.println(rd.nextInt());
    }

    static void cau2() {
        Random rd = new Random();
        System.out.println(rd.nextDouble());
    }

    static void cau3() {
        ArrayList<String> students = new ArrayList<String>();
        students.add("name 1");
        students.add("name 2");
        students.add("name 3");
        students.add("name 4");
        students.add("name 5");

        Random rd = new Random();

        int i = rd.nextInt(students.size() - 1);
        System.out.println(students.get(i));
    }

    static void cau4() {
        Random rd = new Random();
        LocalDate begin =  LocalDate.of(1995,7,24);
        LocalDate end =  LocalDate.of(1995,10,20);

        long bound = end.toEpochDay() - begin.toEpochDay();
        int plus = rd.nextInt(Math.toIntExact(bound));

        System.out.println(begin.plusDays(plus));
    }

    static void cau5() {
        Random rd = new Random();
        int plus = - rd.nextInt(365);

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.plusDays(plus));
    }

    static void cau6() {
        Random rd = new Random();
        int plus = - rd.nextInt((int)LocalDate.now().toEpochDay());

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.plusDays(plus));
    }

    static void cau7() {
        Random rd = new Random();
        System.out.println(100+rd.nextInt(899));
    }
}
