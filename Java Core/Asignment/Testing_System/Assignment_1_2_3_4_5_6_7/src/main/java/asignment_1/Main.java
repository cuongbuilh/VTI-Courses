package asignment_1;

import entity.Account;
import entity.Department;
import entity.Group;
import entity.Position;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Department dep1 = new Department(1,"mar");
        Department dep2 = new Department(2,"mar");
        Department dep3 = new Department(3,"mar");

        Position pos1 = new Position(1,"dev");
        Position pos2 = new Position(2,"dev");
        Position pos3 = new Position(3,"dev");

        Group gr1 = new Group(1,"test");
        Group gr2 = new Group(2,"test");
        Group gr3 = new Group(3,"test");

        Account acc1 = new Account(1,"a@gmail.com","a","nva",dep1,pos1, LocalDate.now(), new Group[]{gr1,gr3});
        Account acc2 = new Account(1,"a@gmail.com","a","nva",dep1,pos1,LocalDate.now(), new Group[]{gr1,gr3});
        Account acc3 = new Account(1,"a@gmail.com","a","nva",dep1,pos1,LocalDate.now(), new Group[]{gr1,gr3});

        System.out.println(acc1.toString());
        System.out.println(acc2.toString());
        System.out.println(acc3.toString());

    }
}
