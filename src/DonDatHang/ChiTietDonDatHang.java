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

    public ChiTietDonDatHang(int soThuTu, SanPham sanPham, int soLuong, double thanhTien) {
        this.soThuTu = soThuTu;
        this.sanPham = sanPham;
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
            //thanh tien
        }
        else {
            setSanPham(qlsp.nhapSanPham());
//            setSoLuong(sanPham.getSoLuongNhap());
//            thanh tien
        }
    }

//    public double tinhThanhTien() {
//        return sanPham.getGiaSP()*sanPha
//    }

}
