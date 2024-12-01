package main_project;

import KhachHang.KhachHang;
import MucTieu.QLMucTieu;
import BaoHanh.QLBaoHanh;
import ChuoiCungCap.QLNhaCungCap;
import DonDatHang.QLDonDatHang;
import HoaDon.QLHoaDon;
import KhachHang.QLKhachHang;
import KhuyenMai.QLKhuyenMai;
import NhanVien.QLNghiPhep;
import NhanVien.QLNhanVien;
import SanPham.QLSanPham;
import PhieuTraGop.QLPhieuTraGop;

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
    public static QLPhieuTraGop qlptg = new QLPhieuTraGop();
    public static QLMucTieu qlmt = new QLMucTieu();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        qlnv.docTuFileDSNV();
        qlsp.docTuFile();
        qlnp.docTuFileDSNP();
        qlkm.docTuFile();
        qlkh.docTuFileDSKH();
        qlbh.docTuFileDSBH();
        qlhd.docTuFileDSHD();
        qlptg.docTuFileDSPTG();
        qlncc.docTuFile();
        qlddh.docTuFileDSDDH();
        qlmt.docTuFileDSMT();
        qlhd.tinhTongTienHD();
        qlhd.tinhTongChiPhi();
        qlddh.tinhTongTienDDH();

        boolean kt = true;
        int lc;
        while (kt) {
//            qlnv.resetNgayPhepConLai();
//            qlnv.resetThuocTinhNhanVien();
//            qlnv.tinhLuongCuoiThang();
            System.out.println("=============================");
            System.out.println("|\t     MENU CHINH       \t|");
            System.out.println("=============================");
            System.out.println("| 1. Dang nhap             \t|");
            System.out.println("| 2. Tra cuu don           \t|");
            System.out.println("| 3. Tra cuu bao hanh      \t|");
            System.out.println("| 4. Xem san pham          \t|");
            System.out.println("| 5. Thoat                 \t|");
            System.out.println("=============================");
            System.out.println("Nhap lua chon: ");
            try {
                lc = Integer.parseInt(sc.nextLine());
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
                        System.out.println("Nhap so dien thoai cua ban: ");
                        qlhd.timKiemHoaDon(sc.nextLine());
                        break;
                    }
                    case 3: {
                        System.out.println("Nhap so dien thoai khach hang: ");
                        KhachHang kh = qlkh.timkiemKhachHangTheoSdt(sc.nextLine());
                        if (kh == null) {
                            System.out.println("Khong tim thay khach hang.");
                        } else {
                            qlhd.HienSanPhamBaoHanh(kh);
                        }
                        break;
                    }
                    case 4: {
                        qlsp.xuatDanhSach();
                        break;
                    }
                    case 5: {
                        kt = false;
                        break;
                    }
                    default: {
                        System.out.println("Lua chon khong phu hop");
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen.");
            }
        }
    }

}
