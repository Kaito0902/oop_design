package BaoHanh;

import KhachHang.KhachHang;
import NhanVien.NhanVien;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static ChucNang.ChuanHoaDuLieu.chuanHoaNgayThangNam;
import static main_project.oop_project.qlkh;
import static main_project.oop_project.qlnv;

public class BaoHanhSanPham {
    private String maBaoHanh;
    private KhachHang khachHang;
    private NhanVien nhanVienPhuTrach;
    private String lyDo;
    private LocalDate ngayNhan;
    private String trangThai;
    static String[] loaiTrangThai = {"Dang xu ly bao hanh", "Da xu ly bao hanh", "Tu choi bao hanh, Da huy"};
    static int tongBaoHanh = 0;
    static Scanner sc = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public BaoHanhSanPham() {
    }

    public BaoHanhSanPham(String maBaoHanh, String maKhachHang, String maNhanVienPhuTrach, String lyDo, LocalDate ngayNhan, String trangThai) {
        this.maBaoHanh = maBaoHanh;
        this.khachHang = qlkh.timkiemKhachHangTheoMa(maKhachHang);
        this.nhanVienPhuTrach = qlnv.timKiemNhanVien(maNhanVienPhuTrach);
        this.lyDo = lyDo;
        this.ngayNhan = ngayNhan;
        this.trangThai = trangThai;
    }

    public String getMaBaoHanh() {
        return maBaoHanh;
    }

    public void setMaBaoHanh(String maBaoHanh) {
        this.maBaoHanh = maBaoHanh;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public LocalDate getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(String ngayNhan) {
        LocalDate nhan = chuanHoaNgayThangNam(ngayNhan);
        while (nhan.isBefore(LocalDate.now())) {
            System.out.println("Ngay nhan khong the trong qua khu.");
            System.out.println("Nhap lai ngay nhan san pham (dd/MM/yyyy): ");
            ngayNhan = sc.nextLine();
            nhan = chuanHoaNgayThangNam(ngayNhan);
        }
        this.ngayNhan = chuanHoaNgayThangNam(ngayNhan);
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public NhanVien getNhanVienPhuTrach() {
        return nhanVienPhuTrach;
    }

    public void setNhanVienPhuTrach(NhanVien nhanVienPhuTrach) {
        this.nhanVienPhuTrach = nhanVienPhuTrach;
    }

    public void input() {
        System.out.println("Nhap so dien thoai: ");
        setKhachHang(qlkh.timkiemKhachHangTheoSdt(sc.nextLine()));

        setNhanVienPhuTrach(qlnv.nguoiDangNhap());

        System.out.println("Nhap ly do bao hanh: ");
        setLyDo(sc.nextLine());

        System.out.println("Nhap ngay nhan (dd/MM/yyyy): ");
        setNgayNhan(sc.nextLine());

        setTrangThai(loaiTrangThai[0]);

        maBaoHanh = "bh" + String.format("%02d", ++tongBaoHanh);
    }

    @Override
    public String toString() {
        return String.format("%-10s %-15s %-30s %-15s %-15s", maBaoHanh, khachHang, lyDo, ngayNhan.format(formatter), trangThai);
    }

    public void output() {
        System.out.println(toString());
    }
}
