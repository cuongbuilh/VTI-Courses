package utils;

import java.util.Scanner;

public class MyScanner {
    public static Scanner scanner;

    public Scanner getScanner() {
        if (scanner == null)
            scanner = new Scanner(System.in);
        return scanner;
    }
}
