package asignment_2;

import entity.Account;
import entity.Department;
import entity.Position;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
//        cau1();
//        cau2();
//        cau3();
//        cau4();
//        cau5();
//        cau6();
//        cau7();
        cau8();
        cau9();
        cau10();
        cau11();
    }

    static void cau1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap 3 so nguyen");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
    }

    static void cau2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap 2 so thuc");
        float a = sc.nextFloat();
        float b = sc.nextFloat();

    }

    static void cau3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap ho ten");
        String s = sc.nextLine();
    }

    static void cau4() {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap ngay sinh (dd/MM/yyyy): ");
        String str = sc.next();

        String pattern = "dd/MM/yyyy";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);

        LocalDate localDate = LocalDate.parse(str, dtf);

        System.out.println(localDate.toString());
    }

    static void cau5() {
        int id, position_id;
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap acc id: ");
        id = sc.nextInt();
        System.out.print("nhap position num: ");
        position_id = sc.nextInt();

        Account account = new Account(id);
        switch (position_id) {
            case 1 -> account.setPosition(Position.Dev);
            case 2 -> account.setPosition(Position.Test);
            case 3 -> account.setPosition(Position.ScrumMaster);
            case 4 -> account.setPosition(Position.PM);
        }

        System.out.println(account.toString());
    }

    static void cau6() {
        Department department = new Department();

        Scanner sc = new Scanner(System.in);
        System.out.print("nhap department id: ");
        department.setDepartmentID(sc.nextInt());
        sc.skip("\n");
        System.out.print("nhap department name: ");
        department.setDepartmentName(sc.nextLine());

        System.out.println(department.toString());
    }

    static void cau7() {
        Scanner sc = new Scanner(System.in);
        int odd_num;
        do {
            System.out.print("nhap 1 so chan: ");
            odd_num = sc.nextInt();
        } while (odd_num % 2 != 0);
        System.out.println("ban vua nhap: " + odd_num);
    }

    static void cau8() {
        String choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                nhap lua chon:
                \t1, tao acc
                \t2, tao dept
                """);
        choice = scanner.nextLine();

        int i_choice=0;

        try {
            i_choice = Integer.parseInt(choice);
        } catch (Exception ignored){
        }

        switch (i_choice) {
            case 1 -> cau5();
            case 2 -> cau6();
            default -> {
                System.out.println("nhap lai ");
                cau8();
            }
        }

    }

    static void cau9() {
    }

    static void cau10() {
    }

    static void cau11() {
    }
}
