package lesson_2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        // date format
//        Locale locale = new Locale("vn","VN");
//        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT,locale);
//        String date = dateFormat.format(new Date());
//        System.out.println(date);
//
//        System.out.println("---");
//        String pattern = "dd-MM-yyyy";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        date = simpleDateFormat.format(new Date());
//        System.out.println(date);

//        System.out.println("----");
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        Date d = new Date();
//        System.out.println(dateFormat.format(d));

//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        LocalDate l1 = LocalDate.parse("13-12-2021",dateTimeFormatter);
//        LocalDate l2 = LocalDate.parse("15-12-2021",dateTimeFormatter);
//        System.out.println(l1);
//        System.out.println(l2);
////        System.out.println(Duration.between( l1, l2).toString()); // su dung cho LocalDateTIme
////        System.out.println(ChronoUnit.DAYS.between(l1,l2));
//        LocalDate l3 = ChronoUnit.DAYS.addTo(l1,2);
//        System.out.println(l3);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate l1 = LocalDate.parse("13-12-2021", dateTimeFormatter);
        Random rd = new Random();
        for (int i = 0; i < 20; i++) {
            System.out.println(ChronoUnit.DAYS.addTo(l1, rd.nextInt(100)));
        }

    }
}
