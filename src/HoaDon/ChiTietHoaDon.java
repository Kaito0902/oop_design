package HoaDon;

import java.util.Scanner;
import SanPham.SanPham;

public class ChiTietHoaDon {
    private int stt; // So thu tu
    private String tenSanPham;
    private int soLuong;
    private double thanhTien;
    private SanPham sanPham;

    public ChiTietHoaDon() {
    }

    // Constructor voi tham so
    public ChiTietHoaDon(int stt, SanPham sanPham, int soLuong) {
        if (soLuong < 0) {
            throw new IllegalArgumentException("So luong va don gia phai lon hon hoac bang 0!");
        }
        this.stt = stt;
        this.sanPham = sanPham;
        this.tenSanPham = sanPham != null ? sanPham.getTenSanPham() : "Chua xac dinh";
        this.soLuong = soLuong;
        this.thanhTien = soLuong * SanPham.giaSP; // Tinh thanh tien ngay
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
        tinhThanhTien(); // Cap nhat thanh tien khi thay doi so luong
    }



    public double getThanhTien() {
        return thanhTien;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
        this.tenSanPham = sanPham != null ? sanPham.getTenSanPham() : "Chua xac dinh";
    }




    private void tinhThanhTien() {
        this.thanhTien = this.soLuong * SanPham.giaSP;
    }



    public void input(int stt) {
        Scanner sc = new Scanner(System.in);
        this.stt = stt;

        System.out.print("Nhap ma san pham: ");
        String maSanPham = sc.nextLine();



        // Lay thong tin san pham tu lop SanPham
        this.sanPham = SanPham.timKiem(maSanPham);
        if (sanPham != null) {
            this.tenSanPham = sanPham.getTenSanPham();
        } else {
            System.out.println("San pham khong ton tai!");
            this.tenSanPham = "Khong ton tai";
        }



        System.out.print("Nhap so luong: ");
        this.soLuong = Integer.parseInt(sc.nextLine());
        if (soLuong < 0) {
            throw new IllegalArgumentException("So luong khong the am!");
        }
        tinhThanhTien(); // Tinh thanh tien sau khi nhap
    }

    public void output() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return String.format(
            "STT: %d\nTen san pham: %s\nSo luong: %d\nGia san pham: %f\nThanh tien: %.2f\nThong tin san pham: %s",
            stt,
            tenSanPham,
            soLuong,
            sanPham != null ? sanPham.giaSP : 0,
            thanhTien,
            sanPham != null ? sanPham.toString() : "Khong co thong tin san pham"
        );
    }
}
