package DonDatHang;

import java.time.LocalDate;

import ChuoiCungCap.NhaCungCap;
import SanPham.SanPham;

public class ChiTietDonDatHang extends DonDatHang{
    private double tienThue;
    private double chietKhau;
    private double giaNhap;
    
    public ChiTietDonDatHang(){        
    }
    public ChiTietDonDatHang(String maDonDatHang, LocalDate ngayDatHang, LocalDate ngayGiaoHang, SanPham sanPham,
            double tongTien, double soLuong, NhaCungCap nhaCungCap, String hinhThucGiaoHang, double doanhThuDonDatHang,
            double tienThue, double chietKhau, double giaNhap) {
        super(maDonDatHang, ngayDatHang, ngayGiaoHang, sanPham, tongTien, soLuong, nhaCungCap, hinhThucGiaoHang,
                doanhThuDonDatHang);
        this.tienThue = tienThue;
        this.chietKhau = chietKhau;
        this.giaNhap = giaNhap;
    }
    public ChiTietDonDatHang(double tienThue, double chietKhau, double giaNhap) {
        this.tienThue = tienThue;
        this.chietKhau = chietKhau;
        this.giaNhap = giaNhap;
    }
    public double getTienThue() {
        return tienThue;
    }
    public void setTienThue(double tienThue) {
        this.tienThue = tienThue;
    }
    public double getChietKhau() {
        return chietKhau;
    }
    public void setChietKhau(double chietKhau) {
        this.chietKhau = chietKhau;
    }
    public double getGiaNhap() {
        return giaNhap;
    }
    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public void nhap() {
        System.out.print("Nhap tien thue: ");
        tienThue = sc.nextDouble();

        System.out.print("Nhap chiet khau:");
        chietKhau = sc.nextDouble();

        System.out.print("Nhap gia nhap ");
        giaNhap = sc.nextDouble();
    }

    // Phương thức toString để hiển thị thông tin
    @Override
    public String toString() {
        return "DonDatHang{" +
                "tienThue=" + tienThue +
                ", chietKhau=" + chietKhau +
                ", giaNhap=" + giaNhap +
                '}';
    }

    


}
