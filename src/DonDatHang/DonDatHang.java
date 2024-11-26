package DonDatHang;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import ChuoiCungCap.NhaCungCap;

import static ChucNang.ChuanHoaDuLieu.chuanHoaNgayThangNam;
import static main_project.oop_project.qlncc;

public class DonDatHang {
    private String maDonDatHang;
    private LocalDate ngayDatHang;
    private LocalDate ngayNhanHang;
    private NhaCungCap nhaCungCap;
    private ChiTietDonDatHang[] dschiTietDonDatHang = new ChiTietDonDatHang[0];
    private int soLuongChiTiet = 0;
    private double tongTien;
    private String hinhThucGiaoHang;
    private String trangThai;
    static String[] loaiTrangThai = {"Dang xu ly", "Da hoan thanh", "Da huy"};
    static Scanner sc = new Scanner(System.in);


    public DonDatHang() {
    }

    public DonDatHang(String maDonDatHang, LocalDate ngayDatHang, LocalDate ngayNhanHang, NhaCungCap nhaCungCap, ChiTietDonDatHang[] dschiTietDonDatHang, int soLuongChiTiet, double tongTien, String hinhThucGiaoHang, String trangThai) {
        this.maDonDatHang = maDonDatHang;
        this.ngayDatHang = ngayDatHang;
        this.ngayNhanHang = ngayNhanHang;
        this.nhaCungCap = nhaCungCap;
        this.dschiTietDonDatHang = dschiTietDonDatHang;
        this.soLuongChiTiet = soLuongChiTiet;
        this.tongTien = tongTien;
        this.hinhThucGiaoHang = hinhThucGiaoHang;
        this.trangThai = trangThai;
    }

    public String getMaDonDatHang() {
        return maDonDatHang;
    }

    public void setMaDonDatHang(String maDonDatHang) {
        this.maDonDatHang = maDonDatHang;
    }

    public LocalDate getNgayDatHang() {
        return ngayDatHang;
    }

    public void setNgayDatHang(String ngayDatHang) {
        this.ngayDatHang = chuanHoaNgayThangNam(ngayDatHang);
    }

    public LocalDate getNgayNhanHang() {
        return ngayNhanHang;
    }

    public void setNgayNhanHang(String ngayNhanHang) {
        this.ngayNhanHang = chuanHoaNgayThangNam(ngayNhanHang);
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public String getHinhThucGiaoHang() {
        return hinhThucGiaoHang;
    }

    public void setHinhThucGiaoHang(String hinhThucGiaoHang) {
        this.hinhThucGiaoHang = hinhThucGiaoHang;
    }

    public ChiTietDonDatHang[] getDschiTietDonDatHang() {
        return dschiTietDonDatHang;
    }

    public void setDschiTietDonDatHang(ChiTietDonDatHang[] dschiTietDonDatHang) {
        this.dschiTietDonDatHang = dschiTietDonDatHang;
    }

    public int getSoLuongChiTiet() {
        return soLuongChiTiet;
    }

    public void setSoLuongChiTiet(int soLuongChiTiet) {
        this.soLuongChiTiet = soLuongChiTiet;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public void nhap() {
        System.out.print("Nhap ngay dat hang: ");
        setNgayDatHang(sc.nextLine());

        System.out.print("Nhap ngay nhan hang: ");
        setNgayNhanHang(sc.nextLine());

        System.out.println("Nhap ma nha cung cap:");
//        qlncc.

        System.out.println("Nhap so luong chi tiet don hang: ");
        int soLuong = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= soLuong; i++) {
            ChiTietDonDatHang x = new ChiTietDonDatHang();
            x.input(i);
            themChiTiet(x);
        }

        System.out.print("Nhap hinh thuc giao hang: ");
        setHinhThucGiaoHang(sc.nextLine());

        setTrangThai(loaiTrangThai[0]);
    }

    public void themChiTiet(ChiTietDonDatHang chiTietDonDatHang) {
        ChiTietDonDatHang[] newdsChiTiet = Arrays.copyOf(dschiTietDonDatHang, soLuongChiTiet + 1);
        newdsChiTiet[soLuongChiTiet] = chiTietDonDatHang;
        dschiTietDonDatHang = newdsChiTiet;
        soLuongChiTiet++;
    }

//    @Override
//    public String toString() {
//        return ;
//    }

    public void xuat() {
        System.out.println(toString());
    }
}
