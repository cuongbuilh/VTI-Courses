package asignment_3;

import java.util.*;

public class Exercise_4 {
    public static void main(String[] args) {
//        cau1();
//        cau2();
//        cau3();
//        cau4();
//        cau5();
//        cau6();
//        cau7();
//        cau8();
        cau9();
        cau10();
        cau11();
        cau12();
        cau13();
        cau14();
        cau15();
        cau16();
    }

    static void cau1() {
        String test = "mot hai  ba   bon   ";
        String fmat = test.replaceAll("\\s\\s+", " ").trim();

        String[] tokens = fmat.split(" ");
        System.out.println(tokens.length);
    }

    static void cau2() {
        String s1 = "s1 ";
        String s2 = "s2";
        System.out.println(s1.concat(s2));
    }

    static void cau3() {
        String test1 = "Adfs";
        String test2 = "asdas";

        String result = Character.isUpperCase(test1.charAt(0)) ? "hoa " : "thuong";
        String result2 = Character.isUpperCase(test2.charAt(0)) ? "hoa " : "thuong";


        System.out.println(result);
        System.out.println(result2);
    }

    static void cau4() {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap ten: ");
        String s = sc.nextLine();
        char[] chars = s.toUpperCase().toCharArray();

        for (char c : chars) {
            System.out.println(c);
        }

    }

    static void cau5() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ho: ");
        String ho;
        ho = sc.nextLine();

        System.out.print("ten: ");
        String ten;
        ten = sc.nextLine();
        String fullname = ho + " " + ten;

        System.out.println("ho va ten: " + fullname);
    }

    static void cau6() {
        Scanner sc = new Scanner(System.in);
        System.out.print("fullname: ");
        String fullname = sc.nextLine();
        fullname = fullname.replaceAll("\\s\\s+", " ").trim();

        List<String> tokens = Arrays.stream(fullname.split(" ")).toList();

        String hodem = "";
        for (int i = 1; i < tokens.size() - 1; i++)
            hodem = hodem + " " + tokens.get(i);

        System.out.println("ho: " + tokens.get(0));
        System.out.println("dem: " + hodem);
        System.out.println("ten: " + tokens.get(tokens.size() - 1));

    }

    static void cau7() {
        Scanner sc = new Scanner(System.in);
        System.out.print("fullname: ");
        String fullname = sc.nextLine();
        // xoa khoang trang thua va dau cuoi
        fullname = fullname.replaceAll("\\s\\s+", " ").trim().toLowerCase();
        // tach chuoi bang dau cach
        String[] tokens = fullname.split(" ");

        StringBuilder stringBuilder = new StringBuilder();

        for (String tok : tokens) {
            char[] chars = tok.toCharArray();
            // upcase ki tu dau
            chars[0] = Character.toUpperCase(chars[0]);
            stringBuilder.append(chars);
            stringBuilder.append(" ");
        }

        System.out.println(stringBuilder);

    }

    static void cau8() {
        String[] strs = {"abcJava", "Java", "java", "asdas", "aJavab", "asd"};
        for (String tok : strs) {
            if (tok.contains("Java")) {
                System.out.println(tok);
            }
        }
    }

    static void cau9() {

    }

    static void cau10() {
    }

    static void cau11() {
    }

    static void cau12() {
    }

    static void cau13() {
    }

    static void cau14() {
    }

    static void cau15() {
    }

    static void cau16() {
    }
}
