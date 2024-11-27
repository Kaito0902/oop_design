package DonDatHang;

import SanPham.SanPham;

import java.util.Scanner;

import static main_project.oop_project.qlsp;

public class ChiTietDonDatHang{
    private int soThuTu;
    private SanPham sanPham;
    private int soLuong;
    private double thanhTien;
    static Scanner sc = new Scanner(System.in);

    public ChiTietDonDatHang(){        
    }

    public ChiTietDonDatHang(int soThuTu, String maSanPham, int soLuong, double thanhTien) {
        this.soThuTu = soThuTu;
        this.sanPham = qlsp.timKiem(maSanPham);
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public int getSoThuTu() {
        return soThuTu;
    }

    public void setSoThuTu(int soThuTu) {
        this.soThuTu = soThuTu;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void input(int stt) {

        setSoThuTu(stt);

        System.out.println("Nhap ma san pham can nhap: ");
        SanPham sp = qlsp.timKiem(sc.nextLine());
        if (sp != null) {
            setSanPham(sp);
            System.out.println("Nhap so luong nhap: ");
            setSoLuong(Integer.parseInt(sc.nextLine()));
        }
        else {
            setSanPham(qlsp.nhapSanPham());
            setSoLuong(getSanPham().getSoLuongNhap());
        }

        setThanhTien(tinhThanhTien());
    }

    public double tinhThanhTien() {
        return getSanPham().getGiaSP()*getSoLuong();
    }

    @Override
    public String toString() {
        return String.format("%-3s %-5s %-12s %-8d %-10.2f", soThuTu, sanPham.getMaSP(), sanPham.getTenSP(), soLuong, thanhTien);
    }

    public void ouput() {
        System.out.println(toString());
    }
}
