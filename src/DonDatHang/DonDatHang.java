package DonDatHang;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import ChuoiCungCap.NhaCungCap;
import SanPham.SanPham;

public class DonDatHang {
    protected String maDonDatHang;
    protected LocalDate ngayDatHang;
    protected LocalDate ngayGiaoHang; 
    protected SanPham sanPham; 
    protected double tongTien;
    protected double soLuong; 
    protected NhaCungCap nhaCungCap;
    protected String hinhThucGiaoHang;
    protected double doanhThuDonDatHang;
    static Scanner sc = new Scanner(System.in);
    
    public DonDatHang() {
    }
    public DonDatHang(String maDonDatHang, LocalDate ngayDatHang, LocalDate ngayGiaoHang, SanPham sanPham,
            double tongTien, double soLuong, NhaCungCap nhaCungCap, String hinhThucGiaoHang,
            double doanhThuDonDatHang) {
        this.maDonDatHang = maDonDatHang;
        this.ngayDatHang = ngayDatHang;
        this.ngayGiaoHang = ngayGiaoHang;
        this.sanPham = sanPham;
        this.tongTien = tongTien;
        this.soLuong = soLuong;
        this.nhaCungCap = nhaCungCap;
        this.hinhThucGiaoHang = hinhThucGiaoHang;
        this.doanhThuDonDatHang = doanhThuDonDatHang;
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
    public void setNgayDatHang(LocalDate ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }
    public LocalDate getNgayGiaoHang() {
        return ngayGiaoHang;
    }
    public void setNgayGiaoHang(LocalDate ngayGiaoHang) {
        this.ngayGiaoHang = ngayGiaoHang;
    }
    public SanPham getSanPham() {
        return sanPham;
    }
    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }
    public double getTongTien() {
        return tongTien;
    }
    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    public double getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(double soLuong) {
        this.soLuong = soLuong;
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
    public double getDoanhThuDonDatHang() {
        return doanhThuDonDatHang;
    }
    public void setDoanhThuDonDatHang(double doanhThuDonDatHang) {
        this.doanhThuDonDatHang = doanhThuDonDatHang;
    }
    public static Scanner getSc() {
        return sc;
    }
    public static void setSc(Scanner sc) {
        DonDatHang.sc = sc;
    }
     public void nhap() {
        System.out.print("Nhập mã đơn đặt hàng: ");
        maDonDatHang = sc.nextLine();

        System.out.print("Nhập ngày đặt hàng : ");
        String ngayDat = sc.nextLine();
        ngayDatHang = LocalDate.parse(ngayDat, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        System.out.print("Nhập ngày giao hàng : ");
        String ngayGiao = sc.nextLine();
        ngayGiaoHang = LocalDate.parse(ngayGiao, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        System.out.println("Nhập thông tin sản phẩm:");
        sanPham = new SanPham();
        sanPham.nhap();  // Giả sử lớp SanPham có phương thức nhap()

        System.out.print("Nhập số lượng: ");
        soLuong = sc.nextDouble();

        System.out.print("Nhập tổng tiền: ");
        tongTien = sc.nextDouble();

        sc.nextLine(); // Xóa bỏ ký tự xuống dòng còn lại

        System.out.println("Nhập thông tin nhà cung cấp:");
        nhaCungCap = new NhaCungCap();
        nhaCungCap.nhap();  // Giả sử lớp NhaCungCap có phương thức nhap()

        System.out.print("Nhập hình thức giao hàng: ");
        hinhThucGiaoHang = sc.nextLine();

        System.out.print("Nhập doanh thu đơn đặt hàng: ");
        doanhThuDonDatHang = sc.nextDouble();
    }

    // Phương thức toString để hiển thị thông tin
    @Override
    public String toString() {
        return "DonDatHang{" +
                "maDonDatHang='" + maDonDatHang + '\'' +
                ", ngayDatHang=" + ngayDatHang +
                ", ngayGiaoHang=" + ngayGiaoHang +
                ", sanPham=" + sanPham +
                ", tongTien=" + tongTien +
                ", soLuong=" + soLuong +
                ", nhaCungCap=" + nhaCungCap +
                ", hinhThucGiaoHang='" + hinhThucGiaoHang + '\'' +
                ", doanhThuDonDatHang=" + doanhThuDonDatHang +
                '}';
    }
    public void xuat(){
        System.out.println(toString());
    }
}
