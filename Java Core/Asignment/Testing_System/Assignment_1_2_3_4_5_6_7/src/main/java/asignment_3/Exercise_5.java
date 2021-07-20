package asignment_3;

import entity.Account;
import entity.Department;
import entity.Group;
import entity.Position;

import java.util.Arrays;
import java.util.Date;

public class Exercise_5 {
    public static void main(String[] args) {
        Department dep1 = new Department(1, "mar");
        Department dep2 = new Department(2, "mar2");
        Department dep3 = new Department(3, "mar");

        Position pos1 = new Position(1, "dev");
        Position pos2 = new Position(2, "dev");
        Position pos3 = new Position(3, "dev");

        Group gr1 = new Group(1, "test");
        Group gr2 = new Group(2, "test");
        Group gr3 = new Group(3, "test");

        Account acc1 = new Account(1, "a@gmail.com", "a", "nva", dep1, pos1, new Date(2021, 12, 12), new Group[]{gr1, gr3});
        Account acc2 = new Account(1, "a@gmail.com", "a", "nva", dep1, pos1, new Date(2021, 12, 12), new Group[]{gr1, gr3});
        Account acc3 = new Account(1, "a@gmail.com", "a", "nva", dep1, pos1, new Date(2021, 12, 12), new Group[]{gr1, gr3});


//        cau1(dep1);
//        cau2(new Department[]{dep1,dep2,dep3});
//        cau3(dep1);
//        cau4(dep1);
//        cau5(new Department[]{dep1,dep2,dep3});
//        cau6();
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
        Department d1 = new Department(1, "Accounting");
        Department d2 = new Department(1, "Mar");
        Department d3 = new Department(1, "Sale");
        Department d4 = new Department(1, "Bos");
        Department d5 = new Department(1, "Wait");
        Department[] departments = {d1, d2, d3, d3, d4, d5};

        // sap xep mang;
        for (int i = 0; i < departments.length - 1; i++) {
            for (int j = i + 1; j < departments.length; j++) {
                // lay cac ki tu dau
                char fisrtCharDepI = departments[i].getDepartmentName().charAt(0);
                char fisrtCharDepJ = departments[j].getDepartmentName().charAt(0);

                if (fisrtCharDepI < fisrtCharDepJ) {
                    Department temp = departments[i];
                    departments[i] = departments[j];
                    departments[j] = temp;
                }
            }
        }

        for (Department d : departments) {
            System.out.println(d.getDepartmentName());
        }
    }

    static void cau7() {
        Department d1 = new Department(1, "Accounting");
        Department d2 = new Department(1, "Mar");
        Department d3 = new Department(1, "Sale A");
        Department d4 = new Department(1, "Bos");
        Department d5 = new Department(1, "Wait B");
        Department[] departments = {d1, d2, d3, d3, d4, d5};

        for (int i = 0; i < departments.length - 1; i++) {
            for (int j = i + 1; j < departments.length; j++) {
                // tach chuoi ra thanh cac tu
                String[] tokensI = departments[i].getDepartmentName().split(" ");
                String[] tokensJ = departments[j].getDepartmentName().split(" ");
                // lay tu cuoi
                String lastTokenI = tokensI[tokensI.length - 1];
                String lastTokenJ = tokensJ[tokensJ.length - 1];
                // lay chu cai dau
                char firstCharI = lastTokenI.charAt(0);
                char firstCharJ = lastTokenJ.charAt(0);

                // doi vi tri
                if (firstCharI > firstCharJ) {
                    Department temp = departments[i];
                    departments[i] = departments[j];
                    departments[j] = temp;
                }
            }
        }
        // in danh sach
        for (Department d: departments){
            System.out.println(d.getDepartmentName());
        }
    }
}
