package BaoHanh;

import KhachHang.KhachHang;
import NhanVien.NhanVien;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
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
    private String[] lichSuYeuCau;
    static String[] loaiTrangThai = {"Dang xu ly bao hanh", "Da xu ly bao hanh", "Tu choi bao hanh, Da huy"};
    static int tongBaoHanh = 0;
    static Scanner sc = new Scanner(System.in);

    public BaoHanhSanPham() {
    }

    public BaoHanhSanPham(String maBaoHanh, KhachHang khachHang, NhanVien nhanVienPhuTrach, String lyDo, LocalDate ngayNhan, String trangThai, String[] lichSuYeuCau) {
        this.maBaoHanh = maBaoHanh;
        this.khachHang = khachHang;
        this.nhanVienPhuTrach = nhanVienPhuTrach;
        this.lyDo = lyDo;
        this.ngayNhan = ngayNhan;
        this.trangThai = trangThai;
        this.lichSuYeuCau = lichSuYeuCau;
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
        this.ngayNhan = chuanHoaNgayThangNam(ngayNhan);
    }

    public String[] getLichSuYeuCau() {
        return lichSuYeuCau;
    }

    public void setLichSuYeuCau(String[] lichSuYeuCau) {
        this.lichSuYeuCau = lichSuYeuCau;
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
        capNhatLichSu(trangThai);

        maBaoHanh = "bh" + String.format("%02d", ++tongBaoHanh);
    }

    private void capNhatLichSu(String trangThaiMoi) {
        if (lichSuYeuCau == null) {
            lichSuYeuCau = new String[0];
        }

        String[] lichSuMoi = new String[lichSuYeuCau.length + 1];
        System.arraycopy(lichSuYeuCau, 0, lichSuMoi, 0, lichSuYeuCau.length);

        lichSuMoi[lichSuYeuCau.length] = "Trang thai cap nhat: " + trangThaiMoi + " vao ngay " + new Date();
        lichSuYeuCau = lichSuMoi;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-15s %-30s %-15s %-15s %-20s", maBaoHanh, khachHang, lyDo, ngayNhan, trangThai, Arrays.toString(lichSuYeuCau));
    }

    public void output() {
        System.out.println(toString());
    }
}
