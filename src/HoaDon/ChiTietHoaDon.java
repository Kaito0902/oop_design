package HoaDon;

import java.util.Scanner;

import SanPham.SanPham;

public class ChiTietHoaDon {
    private int stt; // Số thứ tự
    private String tenSanPham;
    private int soLuong;
    private double donGia; // Đơn giá sản phẩm
    private double thanhTien;
    private SanPham sanPham; // Thuộc tính sản phẩm

    // Constructor mặc định
    public ChiTietHoaDon() {
    }

    // Constructor với tham số
    public ChiTietHoaDon(int stt, SanPham sanPham, int soLuong, double donGia) {
        if (soLuong < 0 || donGia < 0) {
            throw new IllegalArgumentException("So luong va don gia phai lon hon hoac bang 0!");
        }
        this.stt = stt;
        this.sanPham = sanPham;
        this.tenSanPham = sanPham != null ? sanPham.getTenSanPham() : "Chưa xác định";
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = soLuong * donGia; // Tính thành tiền ngay
    }

    // Getter và Setter
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

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
        this.tenSanPham = sanPham != null ? sanPham.getTenSanPham() : "Chưa xác định";
    }

    // Phương thức tính lại thành tiền
    private void tinhThanhTien() {
        this.thanhTien = this.soLuong * this.donGia;
    }

    // Phương thức nhập thông tin chi tiết hóa đơn
    public void input(int stt) {
        Scanner sc = new Scanner(System.in);
        this.stt = stt;

        System.out.print("Nhap ten san pham: ");
        String tenSP = sc.nextLine();
        this.tenSanPham = tenSP;

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

        System.out.print("Nhap ma san pham (neu co): ");
        String maSanPham = sc.nextLine();
        if (!maSanPham.isEmpty()) {
            this.sanPham = new SanPham(maSanPham, tenSP); // Tạo sản phẩm mới từ mã và tên
        } else {
            this.sanPham = null;
        }

        tinhThanhTien(); // Tính thành tiền sau khi nhập
    }

    // Phương thức xuất thông tin chi tiết hóa đơn
    public void xuat() {
        System.out.printf("%-5d %-20s %-10d %-15.2f %-15.2f\n", 
                          stt, tenSanPham, soLuong, donGia, thanhTien);
    }

    // Phương thức chuyển đổi thành chuỗi
    @Override
    public String toString() {
        String sanPhamStr = sanPham != null ? sanPham.toString() : "null";
        return stt + "," + tenSanPham + "," + soLuong + "," + donGia + "," + thanhTien + "," + sanPhamStr;
    }

    // Phương thức đọc thông tin từ chuỗi
    public void fromString(String data) {
        String[] parts = data.split(",");
        if (parts.length < 6) {
            throw new IllegalArgumentException("Du lieu khong hop le!");
        }
        this.stt = Integer.parseInt(parts[0]);
        this.tenSanPham = parts[1];
        this.soLuong = Integer.parseInt(parts[2]);
        this.donGia = Double.parseDouble(parts[3]);
        this.thanhTien = Double.parseDouble(parts[4]);

        if (!parts[5].equals("null")) {
            this.sanPham = new SanPham();
            this.sanPham.fromString(parts[5]);
        } else {
            this.sanPham = null;
        }
    }
}
