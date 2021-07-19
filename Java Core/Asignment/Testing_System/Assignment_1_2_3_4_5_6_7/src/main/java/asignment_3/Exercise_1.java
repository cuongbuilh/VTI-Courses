package asignment_3;

import java.util.Random;
import java.util.Scanner;

public class Exercise_1 {
    public static void main(String[] args) {
//        cau1();
//        cau2();
//        cau3();
        cau4();
    }

    static void cau1(){
        float luong1 = 5240.5f;
        float luong2 = 10971.055f;

        int i1 = ((int) luong1);
        int i2 = (int) luong2;

        System.out.println(i1);
        System.out.println(i2);
    }
    static void cau2(){
        Random rd = new Random();
        int rand = (int)(rd.nextDouble()*100000);
        System.out.printf("%05d",rand);
    }
    static void cau3(){
        Random rd = new Random();
        int rand = (int)(rd.nextDouble()*100000);
        System.out.printf("%02d",rand%100);
    }

    static void cau4(){
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap vao 2 so a,b:");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("thuong: "+ ((float)a/b));
    }
}
