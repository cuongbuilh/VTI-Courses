package asignment_3;

import com.sun.nio.sctp.AbstractNotificationHandler;
import entity.Group;

import javax.lang.model.element.NestingKind;
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
//        cau9();
//        cau10();
//        cau11();
//        cau12();
//        cau13();
//        cau14();
//        cau15();
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
        Group gr1 = new Group(1, "Java");
        Group gr2 = new Group(2, "Java 2");
        Group gr3 = new Group(3, "test");

        Group[] groups = {gr1, gr2, gr3};

        for (Group gr : groups) {
            if (gr.getName().equals("Java"))
                System.out.println(gr.toString());
        }

    }

    static void cau10() {
        String s1 = "abcd";
        String s2 = "dcba";

        StringBuilder sb1 = new StringBuilder(s1).reverse();
        StringBuilder sb2 = new StringBuilder(s2);

        if (sb1.compareTo(sb2) == 0) {
            System.out.println("OK");
        } else
            System.out.println("KO");

    }

    static void cau11() {
        String str = "aaaaa bva";

        int total = 0;

        for (char c : str.toCharArray()) {
            if (c == 'a') total++;
        }

        System.out.println(total);
    }

    static void cau12() {
        String str = "12345";
        String reverse = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }

        System.out.println(reverse);
    }

    static void cau13() {
        String s = "1avv";
        boolean hasNumber = false;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                hasNumber = true;
                break;
            }
        }

        System.out.println(hasNumber);
    }

    static void cau14() {
        String str = "VTI Academy";

        String result = str.replace("a", "*");

        System.out.println(result);
    }

    static void cau15() {
        String str = "  dev   am i   ";
        // xoa khoang trang o dau
        while (str.startsWith(" ")) {
            str = str.substring(1);
        }
        // xoa cuoi
        while (str.endsWith(" ")) {
            str = str.substring(0, str.length() - 1);
        }
        // xoa giua - tung 2 khoang cachs = 1 khoang cachs den het
        while (str.contains("  ")) {
            str = str.replace("  ", " ");
        }
        // dao chuoi
        String result = "";
        for (String s : str.split(" ")) {
            result += " " + s;
        }
        // xoa khoang trang o dau
        result = result.substring(1);

        System.out.println(result);

    }

    static void cau16() {
        String str = "12345678";
        int n =2;

        if(str.length()%n != 0){
            System.out.println("KO");
            return;
        }

        while (str.length() >= n){
            // in n ki tu dau
            System.out.println(str.substring(0,n));
            // gan = chuoi tu n -> het
            str = str.substring(n);
        }

    }
}
