package asignment_3;

import entity.Account;
import entity.Department;
import entity.Group;
import entity.Position;

import java.util.Arrays;
import java.util.Date;

public class Exercise_5 {
    public static void main(String[] args) {
        Department dep1 = new Department(1,"mar");
        Department dep2 = new Department(2,"mar2");
        Department dep3 = new Department(3,"mar");

        Position pos1 = new Position(1,"dev");
        Position pos2 = new Position(2,"dev");
        Position pos3 = new Position(3,"dev");

        Group gr1 = new Group(1,"test");
        Group gr2 = new Group(2,"test");
        Group gr3 = new Group(3,"test");

        Account acc1 = new Account(1,"a@gmail.com","a","nva",dep1,pos1,new Date(2021,12,12), new Group[]{gr1,gr3});
        Account acc2 = new Account(1,"a@gmail.com","a","nva",dep1,pos1,new Date(2021,12,12), new Group[]{gr1,gr3});
        Account acc3 = new Account(1,"a@gmail.com","a","nva",dep1,pos1,new Date(2021,12,12), new Group[]{gr1,gr3});


//        cau1(dep1);
//        cau2(new Department[]{dep1,dep2,dep3});
//        cau3(dep1);
//        cau4(dep1);
//        cau5(new Department[]{dep1,dep2,dep3});
        cau6();
        cau7();
    }

    static void cau1(Department department) {
        System.out.println(department.toString());
    }

    static void cau2(Department[] departments) {
        for (Department department : departments) {
            String toString = department.toString();
            System.out.println(toString);
        }
    }

    static void cau3(Department department) {
        // depart ment ko co dia chi ; lay name thay the
        System.out.println(department.getDepartmentName());
    }

    static void cau4(Department department) {
        System.out.println(department.getDepartmentName().equals("phong a"));
    }

    static void cau5(Department[] departments) {
        System.out.println(departments[0].equals(departments[1]));
    }

    static void cau6() {

    }

    static void cau7() {

    }
}
