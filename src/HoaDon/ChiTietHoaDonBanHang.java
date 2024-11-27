package HoaDon;

import java.util.Scanner;

import SanPham.SanPham;

import static main_project.oop_project.qlsp;

public class ChiTietHoaDonBanHang {
    private int stt; // Số thứ tự
    private SanPham sanPham;
    private int soLuong;
    private double thanhTien;
    static Scanner sc = new Scanner(System.in);

    // Constructor mặc định
    public ChiTietHoaDonBanHang() {
    }

    // Constructor với tham số
    public ChiTietHoaDonBanHang(int stt, String sanPham, int soLuong, double thanhTien) {
        this.stt = stt;
        this.sanPham = qlsp.timKiem(sanPham);
        this.soLuong = soLuong;
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
        while (soLuong < 0) {
            System.out.println("So luong khong the am.");
            System.out.println("Nhap lai so luong: ");
            soLuong = Integer.parseInt(sc.nextLine());
        }
        this.soLuong = soLuong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        while (sanPham == null) {
            System.out.println("Khong tim thay san pham.");
            System.out.println("Nhap lai ma hoac ten san pham: ");
            sanPham = qlsp.timKiem(sc.nextLine());
        }
        this.sanPham = sanPham;
    }

    // Phương thức tính lại thành tiền
    private void tinhThanhTien() {
        this.thanhTien = this.soLuong * this.sanPham.getGiaSP();
    }

    // Phương thức nhập thông tin chi tiết hóa đơn
    public void input(int stt) {

        setStt(stt);

        System.out.print("Nhap ma hoac ten san pham: ");
        SanPham sp = qlsp.timKiem(sc.nextLine());
        setSanPham(sp);

        System.out.print("Nhap so luong: ");
        setSoLuong(Integer.parseInt(sc.nextLine()));

        tinhThanhTien(); // Tính thành ti0ền sau khi nhập
    }

    @Override
    public String toString() {
        return String.format("%-5d %-20s %-10d %-15.2f\n",
                          stt, sanPham.getTenSP(), soLuong, thanhTien);
    }


}
