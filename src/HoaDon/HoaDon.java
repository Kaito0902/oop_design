package HoaDon;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import KhachHang.KhachHang;
import NhanVien.NhanVien;

import static main_project.oop_project.qlkh;
import static main_project.oop_project.qlnv;

public abstract class HoaDon {
    protected String maHoaDon; 
    protected LocalDate ngayLapHoaDon; 
    protected NhanVien nhanVienLapHoaDon;
    protected KhachHang khachHang;
    protected String loaiHoaDon;
    static int tongHoaDon = 0;
    static Scanner scanner = new Scanner(System.in);
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static NumberFormat fm = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
    public HoaDon() {
    }

    public HoaDon(String maHoaDon, LocalDate ngayLapHoaDon, String maNhanVienLapHoaDon, String maKhachHang, String loaiHoaDon) {
        this.maHoaDon = maHoaDon;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.nhanVienLapHoaDon = qlnv.timKiemNhanVienTheoMa(maNhanVienLapHoaDon);
        this.khachHang = qlkh.timkiemKhachHangTheoMa(maKhachHang);
        this.loaiHoaDon = loaiHoaDon;
        tongHoaDon++;
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

    public String getLoaiHoaDon() {
        return loaiHoaDon;
    }

    public void setLoaiHoaDon(String loaiHoaDon) {
        this.loaiHoaDon = loaiHoaDon;
    }

    // Phương thức nhập thông tin hóa đơn
    public void input() {
        setNgayLapHoaDon(LocalDate.now());

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
    }

    // Phương thức xuất thông tin hóa đơn
    public void xuat() {
        System.out.println(toString());
        if (this instanceof HoaDonBanHang) {
            for (ChiTietHoaDonBanHang ct : ((HoaDonBanHang) this).getChiTietHoaDonBanHangList()) {
                System.out.println(ct.toString());
            }
        } else {
            for (ChiTietHoaDonDoiTra ct : ((HoaDonDoiTraHang) this).getDsChiTiet()) {
                System.out.println(ct.toString());
            }
        }
    }

    @Override
    public String toString() {
        return String.format(
                "%-5s %-10s %-5s %-18s %-18s %-13s %-15s",
                maHoaDon, // Mã hóa đơn
                ngayLapHoaDon.format(formatter), // Ngày lập hóa đơn
                nhanVienLapHoaDon.getMaNhanVien(), // Mã nhân viên
                nhanVienLapHoaDon.getTenNhanVien(), // Tên nhân viên
                khachHang.getHoTen(), // Họ tên khách hàng
                khachHang.getSdt(), // Số điện thoại khách hàng
                khachHang.getDiaChi() // Địa chỉ khách hàng
        );
    }

    public abstract void xuatPhieu();

}
