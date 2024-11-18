package HoaDon;
import java.util.Scanner;

import SanPham.SanPham;

public class ChiTietHoaDonDoiTra {
    private int stt; 
    private SanPham sanPhamTra;
    private int soLuong; 
    private String lyDo; 
    private String tinhTrang; 
    private double thanhTien; // Thành tiền hoàn trả
    static Scanner sc = new Scanner(System.in);
    public ChiTietHoaDonDoiTra() {
    }

    public ChiTietHoaDonDoiTra(int stt, SanPham sanPhamTra, int soLuong, String lyDo, String tinhTrang) {
        this.stt = stt;
        this.sanPhamTra = sanPhamTra;
        this.soLuong = soLuong;
        this.lyDo = lyDo;
        this.tinhTrang = tinhTrang;
        this.thanhTien = soLuong * sanPhamTra.getGiaBan(); // Tính thành tiền
    }

    // Getter và Setter
    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public SanPham getSanPhamTra() {
        return sanPhamTra;
    }

    public void setSanPhamTra(SanPham sanPhamTra) {
        this.sanPhamTra = sanPhamTra;
        tinhThanhTien();
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
        tinhThanhTien();
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    // Phương thức tính lại thành tiền
    private void tinhThanhTien() {
        if (sanPhamTra != null) {
            this.thanhTien = this.soLuong * sanPhamTra.getGiaBan();
        } else {
            this.thanhTien = 0;
        }
    }

    // Nhập dữ liệu
    public void input(int stt) {
        this.stt = stt;
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap thong tin san pham tra:");
        this.sanPhamTra = new SanPham();
        this.sanPhamTra.input();

        System.out.print("Nhap so luong tra: ");
        this.soLuong = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap ly do tra: ");
        this.lyDo = sc.nextLine();

        System.out.print("Nhap tinh trang san pham tra: ");
        this.tinhTrang = sc.nextLine();

        tinhThanhTien();
    }

    public void xuat() {
        System.out.printf("%-5d %-20s %-10d %-20s %-20s %-15.2f\n", 
                          stt, sanPhamTra.getTenSanPham(), soLuong, lyDo, tinhTrang, thanhTien);
    }

    @Override
    public String toString() {
        return stt + "," + sanPhamTra.toString() + "," + soLuong + "," + lyDo + "," + tinhTrang + "," + thanhTien;
    }
}
