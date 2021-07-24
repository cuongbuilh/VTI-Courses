package asignment_6.question2.backend;

import asignment_6.question2.entity.QLCB;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Exercise5 {

    public void question1_2() {
        Scanner scanner = new Scanner(System.in);
        QLCB qlcb = new QLCB();


        int choose = 0;


        while (true) {
            System.out.println("\n");
            System.out.println("""
                    Mời bạn nhập vào chức năng muốn dùng
                    1.Thêm mới cán bộ
                    2.Tìm kiếm theo họ tên
                    3.Hiện thị thông tin về danh sách các cán bộ.
                    4.Nhập vào tên của cán bộ và delete cán bộ đó
                    5.Thoát khỏi chương trình.""");
            System.out.print("Mời bạn chọn chức năng: ");

            try {
                choose = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("nhap sai thoat ct");
                choose = 5;
            }

            switch (choose) {
                case 1:
                    qlcb.addCanBo();
                    break;
                case 2:
                    qlcb.findByName();
                    break;
                case 3:
                    qlcb.printListCanBo();
                    break;
                case 4:
                    qlcb.deleteCanBo();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Bạn đã nhập sai. Bạn chỉ được nhập từ 1 tới 5 thôi!");
                    return;
            }
        }
    }
}
