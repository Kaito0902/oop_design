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

    static Scanner scanner = new Scanner(System.in);

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

    // Phương thức nhập thông tin hóa đơn
    public void input() {
        System.out.print("Nhap ma hoa don: ");
        this.maHoaDon = scanner.nextLine();

        System.out.print("Nhap ngay lap hoa don (yyyy-MM-dd): ");
        this.ngayLapHoaDon = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println("Nhap thong tin nhan vien lap hoa don:");
        this.nhanVienLapHoaDon.input();



        // Lấy thông tin khách hàng dựa trên số điện thoại
        System.out.print("Nhap so dien thoai khach hang: ");
        String soDienThoai = scanner.nextLine();

        this.khachHang = KhachHang.timKiemKhachHangTheoSdt(soDienThoai);
        if(khachHang != null)
            System.out.println("Khach hang da ton tai, da cap nhat thong tin khach hang ");
        else
            this.khachHang.input();

            
    }



    public void output() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Ma hoa don: " + maHoaDon + "\n" +
               "Ngay lap hoa don: " + ngayLapHoaDon.format(DateTimeFormatter.ISO_LOCAL_DATE) + "\n" +
               "Nhan vien lap hoa don: " + nhanVienLapHoaDon.toString() + "\n" +
               "Khach hang: " + (khachHang != null ? khachHang.toString() : "Khach hang khong ton tai.");
    }



    public double getTongSoTien() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTongSoTien'");
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setScanner(Scanner scanner) {
        HoaDon.scanner = scanner;
    }
}
