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
    public ChiTietHoaDonBanHang(int stt, SanPham sanPham, int soLuong, double thanhTien) {
        this.stt = stt;
        this.sanPham = sanPham;
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
        if (soLuong < 0) {
            throw new IllegalArgumentException("So luong khong the am!");
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
        this.sanPham = sanPham;
    }

    // Phương thức tính lại thành tiền
    private void tinhThanhTien() {
        this.thanhTien = this.soLuong * this.sanPham.getGiaSP();
    }

    // Phương thức nhập thông tin chi tiết hóa đơn
    public void input() {

        setStt(Integer.parseInt(sc.nextLine()));

        System.out.print("Nhap ma hoac ten san pham: ");
        SanPham sp = qlsp.timKiem(sc.nextLine());
        setSanPham(sp);

        System.out.print("Nhap so luong: ");
        setSoLuong(Integer.parseInt(sc.nextLine()));

        tinhThanhTien(); // Tính thành tiền sau khi nhập
    }

    // Phương thức xuất thông tin chi tiết hóa đơn
    public void xuat() {
        System.out.printf("%-5d %-20s %-10d %-15.2f\n",
                          stt, sanPham.getTenSP(), soLuong, thanhTien);
    }

    // Phương thức chuyển đổi thành chuỗi
//    @Override
//    public String toString() {
//        String sanPhamStr = sanPham != null ? sanPham.toString() : "null";
//        return stt + "," + tenSanPham + "," + soLuong + "," + thanhTien + "," + sanPhamStr;
//    }

    // Phương thức đọc thông tin từ chuỗi
//    public void fromString(String data) {
//        String[] parts = data.split(",");
//        if (parts.length < 6) {
//            throw new IllegalArgumentException("Du lieu khong hop le!");
//        }
//        this.stt = Integer.parseInt(parts[0]);
//        this.tenSanPham = parts[1];
//        this.soLuong = Integer.parseInt(parts[2]);
//        this.thanhTien = Double.parseDouble(parts[4]);
//
//        if (!parts[5].equals("null")) {
//            this.sanPham = new SanPham();
//            this.sanPham.fromString(parts[5]);
//        } else {
//            this.sanPham = null;
//        }
//    }
}
