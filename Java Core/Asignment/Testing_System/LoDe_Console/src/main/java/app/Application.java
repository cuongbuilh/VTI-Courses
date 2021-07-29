package app;

import entity.BangSo;

public class Application {
    public static void main(String[] args) {
        BangSo bs = new BangSo();
        bs.quaySo();
        System.out.println(bs.toString());
    }
}
