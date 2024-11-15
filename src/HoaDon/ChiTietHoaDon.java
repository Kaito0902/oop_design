package HoaDon;

import java.util.Scanner;

public class ChiTietHoaDon {
    private int stt; // Số thứ tự
    private String tenSanPham;
    private int soLuong;
    private double donGia;
    private double thanhTien;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int stt, String tenSanPham, int soLuong, double donGia) {
        this.stt = stt;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = soLuong * donGia; // Tính thành tiền
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
        tinhThanhTien(); // Cập nhật thành tiền khi số lượng thay đổi
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
        tinhThanhTien(); // Cập nhật thành tiền khi đơn giá thay đổi
    }

    public double getThanhTien() {
        return thanhTien;
    }

    // Phương thức tính lại thành tiền
    private void tinhThanhTien() {
        this.thanhTien = this.soLuong * this.donGia;
    }
    public void input(int stt) {
        this.stt = stt;
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ten san pham: ");
        this.tenSanPham = sc.nextLine();

        System.out.print("Nhap so luong: ");
        this.soLuong = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap don gia: ");
        this.donGia = Double.parseDouble(sc.nextLine());

        tinhThanhTien(); // Tính thành tiền sau khi nhập xong
    }

    // Phương thức xuất thông tin chi tiết hóa đơn
    public void xuat() {
        System.out.printf("%-5d %-20s %-10d %-15.2f %-15.2f\n", 
                          stt, tenSanPham, soLuong, donGia, thanhTien);
    }

    // Ghi thông tin ra chuỗi (hỗ trợ ghi file)
    @Override
    public String toString() {
        return stt + "," + tenSanPham + "," + soLuong + "," + donGia + "," + thanhTien;
    }

    // Đọc thông tin từ chuỗi (hỗ trợ đọc file)
    public void fromString(String data) {
        String[] parts = data.split(",");
        this.stt = Integer.parseInt(parts[0]);
        this.tenSanPham = parts[1];
        this.soLuong = Integer.parseInt(parts[2]);
        this.donGia = Double.parseDouble(parts[3]);
        this.thanhTien = Double.parseDouble(parts[4]);
    }
}
