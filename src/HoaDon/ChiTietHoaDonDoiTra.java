package HoaDon;
import static main_project.oop_project.qlsp;

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

    public ChiTietHoaDonDoiTra(int stt, String sanPhamTra, int soLuong, String lyDo, String tinhTrang, double thanhTien) {
        this.stt = stt;
        this.sanPhamTra = qlsp.timKiem(sanPhamTra);
        this.soLuong = soLuong;
        this.lyDo = lyDo;
        this.tinhTrang = tinhTrang;
        this.thanhTien = soLuong * sanPhamTra.getGiaSP(); // Tính thành tiền
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
            this.thanhTien = this.soLuong * sanPhamTra.getGiaSP();
        } else {
            this.thanhTien = 0;
        }
    }

    public void xuat() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return stt + "," + sanPhamTra.toString() + "," + soLuong + "," + lyDo + "," + tinhTrang + "," + thanhTien;
    }
}
