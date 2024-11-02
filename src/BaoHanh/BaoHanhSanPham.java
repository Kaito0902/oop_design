package BaoHanh;

import KhachHang.KhachHang;
import SanPham.SanPham;

import java.util.Date;

public class BaoHanhSanPham {
    private String maBaoHanh;
    private KhachHang khachHang;
    private SanPham sanPham;
    private String trangThai;
    private String lyDo;
    private Date ngayNhan;
    private String[] lichSuYeuCau;

    public BaoHanhSanPham() {
    }

    public BaoHanhSanPham(String maBaoHanh, KhachHang khachHang, SanPham sanPham, String trangThai, String lyDo, Date ngayNhan, String[] lichSuYeuCau) {
        this.maBaoHanh = maBaoHanh;
        this.khachHang = khachHang;
        this.sanPham = sanPham;
        this.trangThai = trangThai;
        this.lyDo = lyDo;
        this.ngayNhan = ngayNhan;
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

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public void input() {

    }
}
