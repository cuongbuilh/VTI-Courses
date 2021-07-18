package asignment_2;

import entity.Account;
import entity.Department;
import entity.Group;
import entity.Position;

import java.util.Date;

public class Exercise1 {
    public static void main(String[] args) {
        Department dep1 = new Department(1, "mar");
        Department dep2 = new Department(2, "mar");
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

//        cau1(acc2);
//        cau2(acc2);
//        cau3(acc2);
//        cau4(acc1);
//        cau5(gr1);
//        cau6(acc2);

//        acc1.getPosition().setPositionName("Dev");
//        cau7(acc1);

//        cau8(new Account[]{acc1, acc2, acc3});
//        cau9(new Department[]{dep1,dep2,dep3});
//        cau10(new Account[]{acc1, acc2, acc3});
//        cau11(new Department[]{dep1, dep2, dep3});
//        cau12(new Department[]{dep1, dep2, dep3});
//        cau13(new Account[]{acc1, acc2, acc3});
//        cau14(new Account[]{acc1, acc2, acc3});

//        cau15();

        cau16(new Account[]{acc1, acc2, acc3}, new Department[]{dep1, dep2, dep3});
        cau17(new Account[]{acc1, acc2, acc3}, new Department[]{dep1, dep2, dep3});

    }

    static void cau1(Account account) {
        if (account.getDepartment() == null) {
            System.out.println("chua co phong ban");
        } else {
            System.out.println("phong ban la" + account.getDepartment().getDepartmentName());
        }
    }

    static void cau2(Account account) {
        if (account.getGroups().length <= 0) {
            System.out.println("khong co gr");
        } else if (account.getGroups().length < 3) {
            System.out.println("gr cua nhan vien nay laf java fressher, c# fresher");
        } else if (account.getGroups().length == 3) {
            System.out.println("nhan vien quan trong");
        } else {
            System.out.println("nv tham gia tat ca gr");
        }
    }

    static void cau3(Account account) {
        System.out.println(account.getDepartment() == null ?
                "chua co phong ban"
                : account.getDepartment().getDepartmentName());
    }

    static void cau4(Account account) {
        System.out.println(account.getPosition().getPositionName().equals("Dev") ? "day laf developer" : "khong phai developer");
    }

    static void cau5(Group group) {
        int numOfAccount = group.getAccounts() == null ? 0 : group.getAccounts().length;

        switch (numOfAccount) {
            case 0 -> System.out.println("nhom trong");
            case 1 -> System.out.println("nhom co 1 thanh vien");
            case 2 -> System.out.println("nhom co 2 tv");
            case 3 -> System.out.println("nhom co 3 tnanh vien");
            default -> System.out.println("nhom co nhieu tv");
        }
    }

    static void cau6(Account account) {
        int numOfGr = account.getGroups() == null ? 0 : account.getGroups().length;

        switch (numOfGr) {
            case 0 -> System.out.println("nv chua co gr");
            case 1, 2 -> System.out.println("gr laf java,c# fresher");
            case 3 -> System.out.println("nv quan trong");
            default -> System.out.println("nv hong chuyen");
        }
    }

    static void cau7(Account account) {
        switch (account.getPosition().getPositionName()) {
            case "Dev" -> System.out.println(" day la dev");
            default -> System.out.println("khong phai dev");
        }
    }

    static void cau8(Account[] accounts) {
        for (Account account : accounts) {
            System.out.printf("%-10s | %-10s | %-10s\n", account.getEmail(), account.getFullName(), account.getDepartment().getDepartmentName());
        }
    }

    static void cau9(Department[] departments) {
        for (Department department : departments) {
            System.out.println(department.getDepartmentID() + " | " + department.getDepartmentName());
        }
    }

    static void cau10(Account[] accounts) {
        int end = accounts.length;
        for (int i = 0; i < end; i++) {
            System.out.printf("thong tin account thu %d la:\n", i + 1);
            System.out.println("Email: " + accounts[i].getEmail());
            System.out.println("Full name: " + accounts[i].getFullName());
            System.out.println("phong ban: " + accounts[i].getDepartment().getDepartmentName());
            System.out.println();
        }
    }

    static void cau11(Department[] departments) {
        int end = departments.length;

        for (int i = 0; i < end; i++) {
            System.out.printf("thong tin department thu %d la:\n", i + 1);
            System.out.printf("\tid: %d\n", departments[i].getDepartmentID());
            System.out.printf("\tName: %s\n\n", departments[i].getDepartmentName());
        }
    }

    static void cau12(Department[] departments) {
        int end = Math.min(departments.length, 2);

        for (int i = 0; i < end; i++) {
            System.out.printf("thong tin department thu %d la:\n", i + 1);
            System.out.printf("\tid: %d\n", departments[i].getDepartmentID());
            System.out.printf("\tName: %s\n\n", departments[i].getDepartmentName());
        }
    }

    static void cau13(Account[] accounts) {
        int end = accounts.length;

        for (int i = 0; i < end; i++) {
            if (i == 1) continue;

            System.out.printf("thong tin account thu %d la:\n", i + 1);
            System.out.println("Email: " + accounts[i].getEmail());
            System.out.println("Full name: " + accounts[i].getFullName());
            System.out.println("phong ban: " + accounts[i].getDepartment().getDepartmentName());
            System.out.println();
        }
    }

    static void cau14(Account[] accounts) {
        int end = accounts.length;

        for (int i = 0; i < end; i++) {
            if (accounts[i].getId() >= 4) continue;

            System.out.printf("thong tin account thu %d la:\n", i + 1);
            System.out.println("id: " + accounts[i].getId());
            System.out.println("Email: " + accounts[i].getEmail());
            System.out.println("Full name: " + accounts[i].getFullName());
            System.out.println("phong ban: " + accounts[i].getDepartment().getDepartmentName());
            System.out.println();
        }
    }

    static void cau15() {
        final int END = 20;
        for (int i = 0; i < 20; i = i + 2) {
            System.out.println(i);
        }
    }

    static void cau16(Account[] accounts, Department[] departments) {
        int end_acc = accounts.length;

        int i = 0;
        while (i < end_acc) {
            System.out.printf("thong tin account thu %d la:\n", i + 1);
            System.out.println("Email: " + accounts[i].getEmail());
            System.out.println("Full name: " + accounts[i].getFullName());
            System.out.println("phong ban: " + accounts[i].getDepartment().getDepartmentName());
            System.out.println();
            i++;
        }


        int end = departments.length;
        i = 0;
        while (i < end) {
            System.out.printf("thong tin department thu %d la:\n", i + 1);
            System.out.printf("\tid: %d\n", departments[i].getDepartmentID());
            System.out.printf("\tName: %s\n\n", departments[i].getDepartmentName());
            i++;
        }
    }

    static void cau17(Account[] accounts, Department[] departments) {
        int end = accounts.length;

        int i = 0;
        do {
            System.out.printf("thong tin account thu %d la:\n", i + 1);
            System.out.println("Email: " + accounts[i].getEmail());
            System.out.println("Full name: " + accounts[i].getFullName());
            System.out.println("phong ban: " + accounts[i].getDepartment().getDepartmentName());
            System.out.println();
            i++;
        } while (i < end);

        end = departments.length;
        i = 0;
        do {
            System.out.printf("thong tin department thu %d la:\n", i + 1);
            System.out.printf("\tid: %d\n", departments[i].getDepartmentID());
            System.out.printf("\tName: %s\n\n", departments[i].getDepartmentName());
            i++;
        } while (i < end);
    }
}
