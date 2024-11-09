package BaoHanh;

import KhachHang.KhachHang;
import SanPham.SanPham;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class BaoHanhSanPham {
    private String maBaoHanh;
    private KhachHang khachHang;
    private String lyDo;
    private Date ngayNhan;
    private String trangThai;
    private String[] lichSuYeuCau;
    static String[] loaiTrangThai = {"Dang xu ly bao hanh", "Da xu ly bao hanh", "Tu choi bao hanh, Da huy"};
    static Scanner sc = new Scanner(System.in);

    public BaoHanhSanPham() {
    }

    public BaoHanhSanPham(String maBaoHanh, KhachHang khachHang, String lyDo, Date ngayNhan, String[] lichSuYeuCau, String trangThai) {
        this.maBaoHanh = maBaoHanh;
        this.khachHang = khachHang;
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

    public Date getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(Date ngayNhan) {
        this.ngayNhan = ngayNhan;
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

    public void input() {
        System.out.println("Nhap so dien thoai: ");
//        timkiemKhachHangTheoSdt(sc.nextline());
        System.out.println("Nhap ly do bao hanh: ");
        setLyDo(sc.nextLine());
        System.out.println("Nhap ngay nhan (dd/MM/yyy): ");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
        try {
            setNgayNhan(dateFormat.parse(sc.nextLine()));
        } catch (ParseException e) {
            System.out.println("Ngay nhan khong hop le.");
        }
        setTrangThai(loaiTrangThai[0]);

        //capnhatlichsu
    }

    @Override
    public String toString() {
        return String.format("%-10s %-15s %-30s %-15s %-15s %-20s", maBaoHanh, khachHang, lyDo, ngayNhan, trangThai, Arrays.toString(lichSuYeuCau));
    }

    public void output() {
        System.out.println(toString());
    }
}
