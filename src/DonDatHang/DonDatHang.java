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

    public DonDatHang(String maDonDatHang2, LocalDate ngayDatHang2, LocalDate ngayGiaoHang2, String sanPham2, double tongTien2, double soLuong2, String nhaCungCap2, String hinhThucGiaoHang2, Double doanhThuDonDatHang2) {
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

    public DonDatHang() {
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
        System.out.print("Nhap ma don dat hang: ");
        maDonDatHang = sc.nextLine();

        System.out.print("Nhap ngay dat hang: ");
        String ngayDat = sc.nextLine();
        ngayDatHang = LocalDate.parse(ngayDat, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        System.out.print("Nhap ngay giao hang: ");
        String ngayGiao = sc.nextLine();
        ngayGiaoHang = LocalDate.parse(ngayGiao, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        System.out.println("Nhap thong tin san pham:");
//        sanPham = new SanPham();
//        sanPham.input(); // Gia su lop SanPham co phuong thuc nhap()

        System.out.print("Nhap so luong: ");
        soLuong = sc.nextDouble();

        System.out.print("Nhap tong tien: ");
        tongTien = sc.nextDouble();

        sc.nextLine(); // Xoa bo ky tu xuong dong con lai

        System.out.println("Nhap thong tin nha cung cap:");
        nhaCungCap = new NhaCungCap();
        nhaCungCap.nhap(); // Gia su lop NhaCungCap co phuong thuc nhap()

        System.out.print("Nhap hinh thuc giao hang: ");
        hinhThucGiaoHang = sc.nextLine();

        System.out.print("Nhap doanh thu don dat hang: ");
        doanhThuDonDatHang = sc.nextDouble();
    }

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

    public void xuat() {
        System.out.println(toString());
    }
}
