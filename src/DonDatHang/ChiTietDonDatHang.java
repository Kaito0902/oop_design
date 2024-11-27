package DonDatHang;

import SanPham.SanPham;

import java.util.InputMismatchException;
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

        while (true) {
            System.out.println("Ban muon nhap san pham co san hay san pham moi?");
            System.out.println("1. Nhap san pham moi.");
            System.out.println("2. Nhap san pham co san.");
            System.out.print("Nhap lua chon: ");
            try {
                int luaChon = Integer.parseInt(sc.nextLine());
                if (luaChon == 1) {
                    setSanPham(qlsp.nhapSanPham());
                    setSoLuong(getSanPham().getSoLuongNhap());
                    break;
                } else if (luaChon == 2) {
                    System.out.print("Nhap ma san pham can nhap: ");
                    SanPham sp = qlsp.timKiem(sc.nextLine());
                    if (sp != null) {
                        setSanPham(sp);
                        System.out.print("Nhap so luong nhap: ");
                        setSoLuong(Integer.parseInt(sc.nextLine()));
                        break;
                    } else {
                        System.out.println("Khong tim thay san pham.");
                    }
                } else {
                    System.out.println("Lua chon khong hop le!");
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Lua chon khong hop le! Vui long nhap so nguyen.");
                sc.nextLine();
            }
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
