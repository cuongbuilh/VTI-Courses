package entity;

public class MyMath {
    final static float PI = 3.14f;

    public static int min(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static float sum(int a) {
        return PI + a;
    }
}
