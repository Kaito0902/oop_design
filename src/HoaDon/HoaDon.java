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

    // Getter và Setter
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
        this.nhanVienLapHoaDon = new NhanVien();
        this.nhanVienLapHoaDon.input();

        System.out.println("Nhap thong tin khach hang:");
        this.khachHang = new KhachHang();
        this.khachHang.input();
    }

    // Phương thức xuất thông tin hóa đơn
    public void xuat() {
        System.out.println("Ma hoa don: " + maHoaDon);
        System.out.println("Ngay lap hoa don: " + ngayLapHoaDon.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println("Nhan vien lap hoa don:");
        nhanVienLapHoaDon.xuat();
        System.out.println("Khach hang:");
        khachHang.xuat();
    }

    // Ghi thông tin ra chuỗi (hỗ trợ ghi file)
    @Override
    public String toString() {
        return maHoaDon + "," +
               ngayLapHoaDon.format(DateTimeFormatter.ISO_LOCAL_DATE) + "," +
               nhanVienLapHoaDon.toString() + "," +
               khachHang.toString();
    }

    // Đọc thông tin từ chuỗi (hỗ trợ đọc file)
    public void fromString(String data) {
        String[] parts = data.split(",", 4);
        this.maHoaDon = parts[0];
        this.ngayLapHoaDon = LocalDate.parse(parts[1], DateTimeFormatter.ISO_LOCAL_DATE);

        this.nhanVienLapHoaDon = new NhanVien();
        this.nhanVienLapHoaDon.fromString(parts[2]);

        this.khachHang = new KhachHang();
        this.khachHang.fromString(parts[3]);
    }

    public double getTongSoTien() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTongSoTien'");
    }
}
