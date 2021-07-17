package lesson_1;

import entity.Account;
import entity.Gender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Calendar;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        SimpleDateFormat fomat = new SimpleDateFormat("dd-MM-yyyy");
        // System.out.println(fomat.format(new Date()));
//        try {
//            Date a = fomat.parse("12-12-2020");
//            System.out.println(fomat.format(a));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        Date a = new Date(12, 11, 1212);
        System.out.println(fomat.format(a));
        // Account acc1 = new Account(1,"","","",null,null,new Date(), Gender.MALE);
    }
}
