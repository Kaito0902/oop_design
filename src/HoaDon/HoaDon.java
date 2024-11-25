package HoaDon;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import KhachHang.KhachHang;
import NhanVien.NhanVien;

public class HoaDon {
    protected String maHoaDon; 
    protected LocalDate ngayLapHoaDon; 
    protected NhanVien nhanVienLapHoaDon;
    protected KhachHang khachHang; 
    static int tongHoaDon = 0; 
    static Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public HoaDon() {
    }

    public HoaDon(String maHoaDon, LocalDate ngayLapHoaDon, NhanVien nhanVienLapHoaDon, KhachHang khachHang) {
        this.maHoaDon = maHoaDon;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.nhanVienLapHoaDon = nhanVienLapHoaDon;
        this.khachHang = khachHang;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public LocalDate getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }

    public void setNgayLapHoaDon(LocalDate ngayLapHoaDon) {
        this.ngayLapHoaDon = ngayLapHoaDon;
    }

    public NhanVien getNhanVienLapHoaDon() {
        return nhanVienLapHoaDon;
    }

    public void setNhanVienLapHoaDon(NhanVien nhanVienLapHoaDon) {
        this.nhanVienLapHoaDon = nhanVienLapHoaDon;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public void input() {
        System.out.print("Nhap ngay lap hoa don (dd/MM/yyyy): ");
        this.ngayLapHoaDon = LocalDate.parse(scanner.nextLine(), DATE_FORMATTER);

        System.out.println("Nhap thong tin nhan vien lap hoa don:");
        setNhanVienLapHoaDon(nhanVienLapHoaDon);

        // Lấy thông tin khách hàng dựa trên số điện thoại
        System.out.println("Nhap so dien thoai khach hang: ");
        String soDienThoai = scanner.nextLine();

        this.khachHang = KhachHang.timKiemKhachHangTheoSdt(soDienThoai);
        if (khachHang != null) {
            System.out.println("Khach hang da ton tai, da cap nhat thong tin khach hang.");
            setKhachHang(khachHang);
        } else {
            KhachHang.khachHang.input();
        }


        
        maHoaDon = "hd" + String.format("%02d", ++tongHoaDon);
        tongHoaDon++;
    }

    public void output() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return String.format("%-5s %-10s %-15s %-15s ", maHoaDon, ngayLapHoaDon,getTenNhanVienBanHang,getTenKhachHang);
    }

   
}
