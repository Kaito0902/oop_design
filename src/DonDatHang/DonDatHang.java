package DonDatHang;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

import ChuoiCungCap.NhaCungCap;

import static ChucNang.ChuanHoaDuLieu.chuanHoaSoLieu;
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
    static String[] loaiTrangThai = {"Dang xu ly", "Da hoan thanh", "Da huy", "Giao som", "Giao muon"};
    static int soLuongDDH = 0;
    static Scanner sc = new Scanner(System.in);
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public DonDatHang() {
    }

    public DonDatHang(String maDonDatHang, LocalDate ngayDatHang, LocalDate ngayNhanHang, String maNhaCungCap, ChiTietDonDatHang[] dschiTietDonDatHang, int soLuongChiTiet, double tongTien, String hinhThucGiaoHang, String trangThai) {
        this.maDonDatHang = maDonDatHang;
        this.ngayDatHang = ngayDatHang;
        this.ngayNhanHang = ngayNhanHang;
        this.nhaCungCap = qlncc.timKiem(maNhaCungCap);
        this.dschiTietDonDatHang = dschiTietDonDatHang;
        this.soLuongChiTiet = soLuongChiTiet;
        this.tongTien = tongTien;
        this.hinhThucGiaoHang = hinhThucGiaoHang;
        this.trangThai = trangThai;
        soLuongDDH++;
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

    public LocalDate getNgayNhanHang() {
        return ngayNhanHang;
    }

    public void setNgayNhanHang(String ngayNhanHang) {
        LocalDate nhanHang = chuanHoaNgayThangNam(ngayNhanHang);

        while (nhanHang.isBefore(getNgayDatHang())) {
            System.out.println("Ngay nhan hang phai sau hoac bang ngay hien tai. Vui long nhap lai (dd/MM/yyyy): ");
            ngayNhanHang = sc.nextLine();
            nhanHang = chuanHoaNgayThangNam(ngayNhanHang);
        }

        this.ngayNhanHang = nhanHang;
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
        while (nhaCungCap == null) {
            System.out.println("Khong tim thay nha cung cap da hop tac.");
            System.out.println("Nhap lai ma nha cung cap: ");
            nhaCungCap = qlncc.timKiem(sc.nextLine());
        }
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

        maDonDatHang = "ddh" + String.format("%03d", ++soLuongDDH);

        setNgayDatHang(LocalDate.now());

        System.out.print("Nhap ngay nhan hang: ");
        setNgayNhanHang(sc.nextLine());

        System.out.println("Nhap ma nha cung cap:");
        setNhaCungCap(qlncc.timKiem(sc.nextLine()));

        System.out.println("Nhap so luong chi tiet don hang: ");
        int soLuong = chuanHoaSoLieu(Integer.parseInt(sc.nextLine()));
        for (int i = 1; i <= soLuong; i++) {
            ChiTietDonDatHang x = new ChiTietDonDatHang();
            x.input(i);
            themChiTiet(x);
        }

        setTongTien(tinhTongTien());

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

    @Override
    public String toString() {
        return String.format("%-5s %-15s %-15s %-5s %-15s %-15.2f %-15s %-10s", maDonDatHang, ngayDatHang.format(formatter), ngayNhanHang.format(formatter), nhaCungCap.getMaNCC(), nhaCungCap.getTenNCC(), tongTien, hinhThucGiaoHang, trangThai);
    }

    public void xuat() {
        System.out.println(toString());
        for (ChiTietDonDatHang ds : dschiTietDonDatHang) {
            ds.ouput();
        }
    }

    public double tinhTongTien() {
        double sum = 0;
        for (ChiTietDonDatHang ds : dschiTietDonDatHang) {
            sum += ds.getThanhTien();
        }
        return sum;
    }
}
