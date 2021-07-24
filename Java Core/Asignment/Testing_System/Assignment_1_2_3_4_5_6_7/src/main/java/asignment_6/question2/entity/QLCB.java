package asignment_6.question2.entity;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class QLCB {

    private List<CanBo> canBos;
    private Scanner scanner;

    public QLCB() {
        canBos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public QLCB(List<CanBo> canBos) {
        this.canBos = canBos;
    }

    public void addCanBo() {
        scanner = new Scanner(System.in);
        System.out.print("Bạn muốn add bao nhiêu cán bộ: ");
        int x = 0;
        try {
            x = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("nhap sai -> thoat");
            return;
        }

        for (int i = 0; i < x; i++) {
            System.out.print("Bạn muốn nhập vào nhân viên(nhập vào 1), Công nhân (nhập vào 2), kỹ sư (nhập vào 3): ");
            int choose = 0;
            try {
                choose = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("nhap sai -> default = 1");
                choose = 1;
            }

            switch (choose) {
                case 1:
                    NhanVien nhanVien = new NhanVien(null, choose, null, null, null);
                    canBos.add(nhanVien);
                    break;
                case 2:
                    CongNhan congNhan = new CongNhan();
                    canBos.add(congNhan);
                    break;
                case 3:
                    KySu kySu = new KySu(null, choose, null, null, null);
                    canBos.add(kySu);
                    break;
                default:
                    return;
            }
            System.out.println("Nhập thành cong Cán bộ " + (i + 1));
        }
    }

    public void findByName() {
        // TODO
        if (canBos.isEmpty()) return;

        Scanner sc = new Scanner(System.in);
        System.out.println("nhap ten");
        String _name = sc.nextLine();

        for (CanBo canBo : canBos) {
            if (canBo.getHoTen().equals(_name)) {
                System.out.println(canBo.toString());
            }
        }

        System.out.println("findByName");
    }

    public void printListCanBo() {
        if (canBos.isEmpty()) return;

        for (int i = 0; i < canBos.size(); i++) {
            System.out.println("Thông tin cán bộ " + (i + 1) + " là: ");
            System.out.println(canBos.get(i).toString());
        }
        System.out.println("----------------------------");
    }

    public void deleteCanBo(String name) {
        // TODO
        if (canBos.isEmpty()) return;

        for (int i = 0; i < canBos.size(); i++) {
            if (canBos.get(i).getHoTen()== null) continue;

            if (canBos.get(i).getHoTen().equals(name)) {
                canBos.remove(i);
                System.out.println("removed");
                i--;
            }
        }

        System.out.println("deleteCanBo");
    }

    public void deleteCanBo() {
        scanner = new Scanner(System.in);
        System.out.print("nhap ten can xoa: ");
        String inputName = scanner.nextLine();
        deleteCanBo(inputName);
    }
}
