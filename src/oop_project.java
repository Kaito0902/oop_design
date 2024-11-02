import ChucNang.ChucNangMenu;
import NhanVien.QLNhanVien;

import java.util.Scanner;

public class oop_project {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        QLNhanVien qlnv = new QLNhanVien();
        qlnv.docTuFileDSNV();
        boolean kt = true;
        int lc;
        ChucNangMenu cnmn = new ChucNangMenu(qlnv);
        while (kt) {
            System.out.println("=============================");
            System.out.println("|\t     MENU CHINH       \t|");
            System.out.println("=============================");
            System.out.println("| 1. Dang nhap             \t|");
            System.out.println("| 2. Tra cuu don           \t|");
            System.out.println("| 3. Xem san pham          \t|");
            System.out.println("| 4. Thoat                 \t|");
            System.out.println("=============================");
            System.out.println("Nhap lua chon: ");
            lc = new Scanner(System.in).nextInt();
            switch (lc) {
                case 1: {
                    System.out.println("Nhap ten tai khoan: ");
                    String tenTaiKhoan = new Scanner(System.in).nextLine();
                    System.out.println("Nhap mat khau: ");
                    String matKhau = new Scanner(System.in).nextLine();
                    if (qlnv.dangNhap(tenTaiKhoan, matKhau) != null) {
                        System.out.println("Dang nhap thanh cong");
                        qlnv.menuTheoNhanVien(qlnv.dangNhap(tenTaiKhoan, matKhau));
                    } else {
                        System.out.println("Dang nhap that bai");
                        System.out.println("Vui long dang nhap lai");
                        break;
                    }
                    break;
                }
                case 2: {
                    //tra cuu bang so dien thoai
                    break;
                }
                case 3: {
                    //xem san pham
                    break;
                }
                case 4: {
                    return;
                }
                default: {
                    System.out.println("Lua chon khong phu hop");
                    break;
                }
            }
        }
    }

}
