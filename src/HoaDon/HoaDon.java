package HoaDon;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import KhachHang.KhachHang;
import NhanVien.NhanVien;

import static main_project.oop_project.qlkh;
import static main_project.oop_project.qlnv;

public class HoaDon {
    protected String maHoaDon; 
    protected LocalDate ngayLapHoaDon; 
    protected NhanVien nhanVienLapHoaDon;
    protected KhachHang khachHang;
    protected String loaiHoaDon;
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static int tongHoaDon = 0;
    static Scanner scanner = new Scanner(System.in);


    public HoaDon() {
    }

    public HoaDon(String maHoaDon, LocalDate ngayLapHoaDon, NhanVien nhanVienLapHoaDon, KhachHang khachHang, String loaiHoaDon) {
        this.maHoaDon = maHoaDon;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.nhanVienLapHoaDon = nhanVienLapHoaDon;
        this.khachHang = khachHang;
        this.loaiHoaDon = loaiHoaDon;
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
    
    public static DateTimeFormatter getFormatter() {
        return formatter;
    }

    public static void setFormatter(DateTimeFormatter formatter) {
        HoaDon.formatter = formatter;
    }

    public static int getTongHoaDon() {
        return tongHoaDon;
    }

    public static void setTongHoaDon(int tongHoaDon) {
        HoaDon.tongHoaDon = tongHoaDon;
    }


    // Phương thức nhập thông tin hóa đơn
    public void input() {
        System.out.print("Nhap ma hoa don: ");
        setMaHoaDon(scanner.nextLine());

        System.out.print("Nhap ngay lap hoa don (dd/MM/yyyy): ");
        String ngayLap = scanner.nextLine();
        LocalDate ngayLapHoaDon = LocalDate.parse(ngayLap, formatter);
        setNgayLapHoaDon(ngayLapHoaDon);

        NhanVien nv = qlnv.nguoiDangNhap();
        setNhanVienLapHoaDon(nv);

        System.out.println("Nhap so dien thoai khach hang:");
        String sdt = scanner.nextLine();
        KhachHang kh = qlkh.timkiemKhachHangTheoSdt(sdt);
        if (kh != null) {
            setKhachHang(kh);
        }
        else {
            qlkh.nhapKhachHang();
            setKhachHang(qlkh.timkiemKhachHangTheoSdt(sdt));
        }

        maHoaDon = "hd" + String.format("%02d", ++tongHoaDon);
        tongHoaDon++;

    }

    // Phương thức xuất thông tin hóa đơn
    public void xuat() {
        System.out.println(toString());
    }

    // Ghi thông tin ra chuỗi (hỗ trợ ghi file)
    @Override
    public String toString() {
        return String.format(
                "%-15s %-20s %-15s %-20s %-20s %-15s %-30s",
                maHoaDon, // Mã hóa đơn
                ngayLapHoaDon, // Ngày lập hóa đơn
                nhanVienLapHoaDon.getMaNhanVien(), // Mã nhân viên
                nhanVienLapHoaDon.getTenNhanVien(), // Tên nhân viên
                khachHang.getHoTen(), // Họ tên khách hàng
                khachHang.getSdt(), // Số điện thoại khách hàng
                khachHang.getDiaChi() // Địa chỉ khách hàng
        );
    }

    public String getLoaiHoaDon() {
        return loaiHoaDon;
    }

    public void setLoaiHoaDon(String loaiHoaDon) {
        this.loaiHoaDon = loaiHoaDon;
    }

}
