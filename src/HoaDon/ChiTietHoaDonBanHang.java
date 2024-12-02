package HoaDon;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

import SanPham.SanPham;

import static main_project.oop_project.qlsp;

public class ChiTietHoaDonBanHang {
    private int stt; // Số thứ tự
    private SanPham sanPham;
    private int soLuong;
    private double donGia;
    private double thanhTien;
    static Scanner sc = new Scanner(System.in);
    static NumberFormat fm = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

    // Constructor mặc định
    public ChiTietHoaDonBanHang() {
    }

    // Constructor với tham số
    public ChiTietHoaDonBanHang(int stt, String maSanPham, int soLuong, double donGia, double thanhTien) {
        this.stt = stt;
        this.sanPham = qlsp.timKiem(maSanPham);
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    // Getter và Setter
    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        do {
            while (soLuong <= 0) {
                System.out.println("So luong khong the am.");
                System.out.println("Nhap lai so luong: ");
                soLuong = Integer.parseInt(sc.nextLine());
            }

            if (soLuong > getSanPham().getSoLuongTonKho()) {
                System.out.println("So luong mua lon hon so luong san pham co.");
                System.out.println("Nhap lai so luong san pham: ");
                soLuong = -1;
            }

        } while (soLuong < 0 || soLuong > getSanPham().getSoLuongTonKho());
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {

        do {
            while (sanPham == null) {
                System.out.println("Khong tim thay san pham.");
                System.out.println("Nhap lai ma hoac ten san pham: ");
                sanPham = qlsp.timKiem(sc.nextLine());
            }

            while (sanPham.getSoLuongTonKho() == 0) {
                System.out.println("So luong san pham da het");
                System.out.println("Nhap lai ma hoac ten san pham: ");
                sanPham = qlsp.timKiem(sc.nextLine());
            }
        }while (sanPham == null || sanPham.getSoLuongTonKho() == 0);
        this.sanPham = sanPham;
    }

    // Phương thức tính lại thành tiền
    private void tinhThanhTien() {
        this.thanhTien = this.soLuong * this.sanPham.thanhTien();
    }

    // Phương thức nhập thông tin chi tiết hóa đơn
    public void input(int stt) {

        setStt(stt);

        System.out.print("Nhap ma hoac ten san pham: ");
        SanPham sp = qlsp.timKiem(sc.nextLine());
        setSanPham(sp);

        System.out.print("Nhap so luong: ");
        setSoLuong(Integer.parseInt(sc.nextLine()));

        setDonGia(getSanPham().thanhTien());

        tinhThanhTien();

        qlsp.xuatSanPhamTuHoaDon(getSanPham().getMaSP(), getSoLuong());

    }

    @Override
    public String toString() {
        return String.format("%-8d %-30s %-15d %-20s %-20s",
                          stt, sanPham.getTenSP(), soLuong, fm.format(donGia).replace("₫", "VND"), fm.format(thanhTien).replace("₫", "VND"));
    }


}
