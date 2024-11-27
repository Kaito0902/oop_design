package main_project;

import BaoHanh.QLBaoHanh;
import ChuoiCungCap.QLNhaCungCap;
import DonDatHang.QLDonDatHang;
import HoaDon.QLHoaDon;
import KhachHang.QLKhachHang;
import KhuyenMai.QLKhuyenMai;
import NhanVien.QLNghiPhep;
import NhanVien.QLNhanVien;
import SanPham.QLSanPham;

import java.util.Scanner;

public class oop_project {
    public static QLNhanVien qlnv = new QLNhanVien();
    public static QLNghiPhep qlnp = new QLNghiPhep();
    public static QLSanPham qlsp = new QLSanPham();
    public static QLBaoHanh qlbh = new QLBaoHanh();
    public static QLKhachHang qlkh = new QLKhachHang();
    public static QLHoaDon qlhd = new QLHoaDon();
    public static QLKhuyenMai qlkm = new QLKhuyenMai();
    public static QLDonDatHang qlddh = new QLDonDatHang();
    public static QLNhaCungCap qlncc = new QLNhaCungCap();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        qlnv.docTuFileDSNV();
        qlsp.docTuFile();
        qlnp.docTuFileDSNP();
        qlkm.docTuFile();
//        qlhd.docTuFileDSHD();
        qlncc.docTuFile();
        boolean kt = true;
        int lc;
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
                    System.out.println("Nhap so dien thoai: ");
                    String soDienThoai = new Scanner(System.in).nextLine();
                    System.out.println("Nhap mat khau: ");
                    String matKhau = new Scanner(System.in).nextLine();
                    if (qlnv.dangNhap(soDienThoai, matKhau) != null) {
                        System.out.println("Dang nhap thanh cong");
                        qlnv.menuTheoNhanVien(qlnv.dangNhap(soDienThoai, matKhau));
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
                    kt = false;
                    break;
                }
                default: {
                    System.out.println("Lua chon khong phu hop");
                    break;
                }
            }
        }
    }

}
