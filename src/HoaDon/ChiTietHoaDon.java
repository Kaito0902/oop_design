package HoaDon;

import java.util.Scanner;

public class ChiTietHoaDon {
    private int stt; // Số thứ tự
    private String tenSanPham;
    private int soLuong; 
    private double donGia; // Đơn giá sản phẩm
    private double thanhTien; 

    public ChiTietHoaDon() {
    }
    public ChiTietHoaDon(int stt, String tenSanPham, int soLuong, double donGia) {
        if (soLuong < 0 || donGia < 0) {
            throw new IllegalArgumentException("So luong va don gia phai lon hon hoac bang 0!");
        }
        this.stt = stt;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = soLuong * donGia; // Tính thành tiền ngay
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
        if (soLuong < 0) {
            throw new IllegalArgumentException("So luong khong the am!");
        }
        this.soLuong = soLuong;
        tinhThanhTien(); // Cập nhật thành tiền khi thay đổi số lượng
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        if (donGia < 0) {
            throw new IllegalArgumentException("Don gia khong the am!");
        }
        this.donGia = donGia;
        tinhThanhTien(); // Cập nhật thành tiền khi thay đổi đơn giá
    }

    public double getThanhTien() {
        return thanhTien;
    }

    // Phương thức tính lại thành tiền
    private void tinhThanhTien() {
        this.thanhTien = this.soLuong * this.donGia;
    }

    public void input(int stt) {
        Scanner sc = new Scanner(System.in);
        this.stt = stt;

        System.out.print("Nhap ten san pham: ");
        this.tenSanPham = sc.nextLine();

        System.out.print("Nhap so luong: ");
        int sl = Integer.parseInt(sc.nextLine());
        if (sl < 0) {
            throw new IllegalArgumentException("So luong khong the am!");
        }
        this.soLuong = sl;

        System.out.print("Nhap don gia: ");
        double dg = Double.parseDouble(sc.nextLine());
        if (dg < 0) {
            throw new IllegalArgumentException("Don gia khong the am!");
        }
        this.donGia = dg;

        tinhThanhTien(); // Tính thành tiền sau khi nhập
    }

    public void xuat() {
        System.out.printf("%-5d %-20s %-10d %-15.2f %-15.2f\n", 
                          stt, tenSanPham, soLuong, donGia, thanhTien);
    }

    @Override
    public String toString() {
        return stt + "," + tenSanPham + "," + soLuong + "," + donGia + "," + thanhTien;
    }

    // Đọc thông tin từ chuỗi (hỗ trợ đọc file)
    public void fromString(String data) {
        String[] parts = data.split(",");
        if (parts.length != 5) {
            throw new IllegalArgumentException("Du lieu khong hop le!");
        }
        this.stt = Integer.parseInt(parts[0]);
        this.tenSanPham = parts[1];
        this.soLuong = Integer.parseInt(parts[2]);
        this.donGia = Double.parseDouble(parts[3]);
        this.thanhTien = Double.parseDouble(parts[4]);
    }
}
