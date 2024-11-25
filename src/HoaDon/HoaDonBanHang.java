package HoaDon;

import java.time.LocalDate;
import java.util.Arrays;

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
    public HoaDonBanHang(String maHoaDon, LocalDate ngayLapHoaDon, NhanVien nhanVienLapHoaDon, KhachHang khachHang, ChiTietHoaDonBanHang[] chiTietHoaDonList, int soLuongChiTiet, KhuyenMai khuyenMai, double tienThue, double chietKhau, String phuongThucThanhToan, double tongTien) {
        super(maHoaDon, ngayLapHoaDon, nhanVienLapHoaDon, khachHang);
        this.chiTietHoaDonBanHangList = chiTietHoaDonList;
        this.soLuongChiTiet = soLuongChiTiet;
        this.khuyenMai = khuyenMai;
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

//    public void setKhuyenMai(KhuyenMai khuyenMai) {
//        this.khuyenMai = khuyenMai;
//    }

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

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhap chi tiet hoa don thu " + (i + 1) + ":");
            ChiTietHoaDonBanHang chiTiet = new ChiTietHoaDonBanHang();
            chiTiet.input();
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

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Chi tiet hoa don:");
        System.out.printf("%-10s %-20s %-10s %-15s %-15s\n", "STT", "Ten SP", "So luong", "Don gia", "Thanh tien");

        for (int i = 0; i < soLuongChiTiet; i++) {
            chiTietHoaDonBanHangList[i].xuat();
        }

        System.out.println("Tien thue: " + tienThue + "%");
        System.out.println("Chiet khau: " + chietKhau + "%");
        System.out.println("Phuong thuc thanh toan: " + phuongThucThanhToan);
        System.out.println("Tong tien: " + tongTien);
        System.out.println("Khuyen mai:");
        khuyenMai.xuat();
    }

    // Phương thức tính tổng tiền hóa đơn
    private void tinhTongTien() {
        tongTien = 0;
        for (int i = 0; i < soLuongChiTiet; i++) {
            tongTien += chiTietHoaDonBanHangList[i].getThanhTien();
        }
        tongTien += tongTien * (tienThue / 100); // Thêm thuế
        tongTien -= tongTien * (chietKhau / 100); // Trừ chiết khấu
        tongTien -= khuyenMai.getTongKhuyenMai(); // Trừ khuyến mãi
    }

//     Ghi thông tin ra chuỗi (hỗ trợ ghi file)
//    @Override
//    public String toString() {
//        String.format("")
//    }


}
