package HoaDon;

import java.time.LocalDate;
import java.util.Arrays;

import DonDatHang.ChiTietDonDatHang;
import KhachHang.KhachHang;
import KhuyenMai.KhuyenMai;
import NhanVien.NhanVien;

import static main_project.oop_project.qlkm;

public class HoaDonBanHang extends HoaDon {
    private ChiTietHoaDonBanHang[] chiTietHoaDonBanHangList = new ChiTietHoaDonBanHang[0]; // Danh sách chi tiết hóa đơn
    private int soLuongChiTiet = 0;
    private KhuyenMai khuyenMai; // Chương trình khuyến mãi
    private double tienThue;
    private double chietKhau;
    private String phuongThucThanhToan; 
    private double tongTien; // Tổng tiền của hóa đơn

    // Constructor mặc định
    public HoaDonBanHang() {
    }

    // constructor day du tham so


    public HoaDonBanHang(String maHoaDon, LocalDate ngayLapHoaDon, String maNhanVienLapHoaDon, String maKhachHang, String loaiHoaDon, ChiTietHoaDonBanHang[] chiTietHoaDonBanHangList, int soLuongChiTiet, String maKhuyenMai, double tienThue, double chietKhau, String phuongThucThanhToan, double tongTien) {
        super(maHoaDon, ngayLapHoaDon, maNhanVienLapHoaDon, maKhachHang, loaiHoaDon);
        this.chiTietHoaDonBanHangList = chiTietHoaDonBanHangList;
        this.soLuongChiTiet = soLuongChiTiet;
        this.khuyenMai = qlkm.timKhuyenMai(maKhuyenMai);
        this.tienThue = tienThue;
        this.chietKhau = chietKhau;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.tongTien = tongTien;
    }

    public ChiTietHoaDonBanHang[] getChiTietHoaDonBanHangList() {
        return chiTietHoaDonBanHangList;
    }

    public int getSoLuongChiTiet() {
        return soLuongChiTiet;
    }

    public KhuyenMai getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(KhuyenMai khuyenMai) {
        this.khuyenMai = khuyenMai;
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

    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setChiTietHoaDonBanHangList(ChiTietHoaDonBanHang[] chiTietHoaDonBanHangList) {
        this.chiTietHoaDonBanHangList = chiTietHoaDonBanHangList;
    }

    public void setSoLuongChiTiet(int soLuongChiTiet) {
        this.soLuongChiTiet = soLuongChiTiet;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public void themChiTietHoaDonBanHang(ChiTietHoaDonBanHang chiTietHoaDonBanHang) {
        ChiTietHoaDonBanHang[] newdsChiTietHoaDonBanHang = Arrays.copyOf(chiTietHoaDonBanHangList, soLuongChiTiet + 1);
        newdsChiTietHoaDonBanHang[soLuongChiTiet] = chiTietHoaDonBanHang;
        chiTietHoaDonBanHangList = newdsChiTietHoaDonBanHang;
        soLuongChiTiet++;
    }

    @Override
    public void input() {
        super.input(); // Nhập thông tin cơ bản từ lớp cha

        System.out.print("Nhap so luong chi tiet hoa don: ");
        int soLuong = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= soLuong; i++) {
            System.out.println("Nhap chi tiet hoa don thu " + (i + 1) + ":");
            ChiTietHoaDonBanHang chiTiet = new ChiTietHoaDonBanHang();
            chiTiet.input(1);
            themChiTietHoaDonBanHang(chiTiet);
        }

        System.out.print("Nhap tien thue (theo %): ");
        setTienThue(Double.parseDouble(scanner.nextLine()));

        System.out.print("Nhap chiet khau (theo %): ");
        setChietKhau(Double.parseDouble(scanner.nextLine()));

        System.out.print("Nhap phuong thuc thanh toan: ");
        setPhuongThucThanhToan(scanner.nextLine());

        System.out.println("Nhap ma khuyen mai:");
        qlkm.timKhuyenMai(scanner.nextLine());

        tinhTongTien(); // Tính tổng tiền hóa đơn
    }

    // Phương thức tính tổng tiền hóa đơn
    public void tinhTongTien() {
        tongTien = 0;
        for (int i = 0; i < soLuongChiTiet; i++) {
            tongTien += chiTietHoaDonBanHangList[i].getThanhTien();
        }
        tongTien += tongTien * (tienThue / 100); // Thêm thuế
        tongTien -= tongTien * (chietKhau / 100); // Trừ chiết khấu
        tongTien -= khuyenMai.getTongKhuyenMai(); // Trừ khuyến mãi
    }

    @Override
    public String toString() {
        return super.toString()+String.format("%-5s %-5.2f %-5.2f %-15s %-10.2f",khuyenMai.getMaKhuyenMai(),tienThue,chietKhau,phuongThucThanhToan,tongTien);
    }





}
