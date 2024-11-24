package DonDatHang;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import ChuoiCungCap.NhaCungCap;
import SanPham.SanPham;

public class DonDatHang {
    private String maDonDatHang;
    private LocalDate ngayDatHang;
    private LocalDate ngayGiaoHang;
    private SanPham sanPham;
    private double tongTien;
    private double soLuong;
    private NhaCungCap nhaCungCap;
    private String hinhThucGiaoHang;
    private double doanhThuDonDatHang;
    private boolean isDeleted; // Cờ xóa đơn hàng

    static Scanner sc = new Scanner(System.in);

    // Định dạng ngày dd/MM/yyyy
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Constructor đầy đủ
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
        this.isDeleted = false; // Mặc định chưa bị xóa
    }

    // Constructor mặc định
    public DonDatHang() {
        this.isDeleted = false; // Mặc định chưa bị xóa
    }

    public DonDatHang(String maDonDatHang2, LocalDate ngayDatHang2, LocalDate ngayGiaoHang2, String sanPham2,
            double tongTien2, double soLuong2, String nhaCungCap2, String hinhThucGiaoHang2,
            Double doanhThuDonDatHang2) {
        //TODO Auto-generated constructor stub
    }

    // Getter và Setter
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

    public static Scanner getSc() {
        return sc;
    }

    public static void setSc(Scanner sc) {
        DonDatHang.sc = sc;
    }

    public static DateTimeFormatter getDateFormatter() {
        return DATE_FORMATTER;
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

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    // Phương thức nhập thông tin đơn đặt hàng
    public void input() {
        System.out.print("Nhap ma don dat hang: ");
        maDonDatHang = sc.nextLine();

        System.out.print("Nhap ngay dat hang (dd/MM/yyyy): ");
        ngayDatHang = LocalDate.parse(sc.nextLine(), DATE_FORMATTER);

        System.out.print("Nhap ngay giao hang (dd/MM/yyyy): ");
        ngayGiaoHang = LocalDate.parse(sc.nextLine(), DATE_FORMATTER);

        System.out.println("Nhap thong tin san pham:");
        sanPham.input(); // Giả sử lớp SanPham có phương thức nhập dữ liệu

        System.out.print("Nhap so luong: ");
        soLuong = sc.nextDouble();

        System.out.print("Nhap tong tien: ");
        tongTien = sc.nextDouble();

        sc.nextLine(); // Xóa bỏ ký tự xuống dòng còn lại

        System.out.println("Nhap thong tin nha cung cap:");
        nhaCungCap.input(); // Giả sử lớp NhaCungCap có phương thức nhập dữ liệu

        System.out.print("Nhap hinh thuc giao hang: ");
        hinhThucGiaoHang = sc.nextLine();

        System.out.print("Nhap doanh thu don dat hang: ");
        doanhThuDonDatHang = sc.nextDouble();
    }

    // Phương thức hiển thị thông tin đơn đặt hàng
    @Override
    public String toString() {
        return "DonDatHang{" +
                "maDonDatHang='" + maDonDatHang + '\'' +
                ", ngayDatHang=" + ngayDatHang.format(DATE_FORMATTER) +
                ", ngayGiaoHang=" + ngayGiaoHang.format(DATE_FORMATTER) +
                ", sanPham=" + sanPham +
                ", tongTien=" + tongTien +
                ", soLuong=" + soLuong +
                ", nhaCungCap=" + nhaCungCap +
                ", hinhThucGiaoHang='" + hinhThucGiaoHang + '\'' +
                ", doanhThuDonDatHang=" + doanhThuDonDatHang +
                '}';
    }

    public void output() {
        if (!isDeleted) {
            System.out.println(toString());
        } else {
            System.out.println("Don dat hang da bi xoa.");
        }
    }
}
