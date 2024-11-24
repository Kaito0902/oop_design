package HoaDon;

import java.time.LocalDate;
import java.util.Scanner;

import KhachHang.KhachHang;
import NhanVien.NhanVien;

public class HoaDonDoiTraHang extends HoaDon{
    private HoaDon hoaDonGoc;
    private ChiTietHoaDonDoiTra[] dsChiTiet; // Danh sách chi tiết đổi trả
    private double tongGiaTri; // Tổng giá trị hoàn trả
    private String ghiChu; 
    private double tienHoanTra; // Số tiền hoàn trả sau khi trừ
    private double tiLeTru; // Tỷ lệ phần trăm trừ vào số tiền hoàn trả

    private static final int MAX_CHI_TIET = 100; // Số lượng chi tiết tối đa
    private static final Scanner scanner = new Scanner(System.in);

    public HoaDon getHoaDonGoc() {
        return hoaDonGoc;
    }

    public void setHoaDonGoc(HoaDon hoaDonGoc) {
        this.hoaDonGoc = hoaDonGoc;
    }

    public ChiTietHoaDonDoiTra[] getDsChiTiet() {
        return dsChiTiet;
    }

    public void setDsChiTiet(ChiTietHoaDonDoiTra[] dsChiTiet) {
        this.dsChiTiet = dsChiTiet;
    }

    public double getTongGiaTri() {
        return tongGiaTri;
    }

    public void setTongGiaTri(double tongGiaTri) {
        this.tongGiaTri = tongGiaTri;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public double getTienHoanTra() {
        return tienHoanTra;
    }

    public void setTienHoanTra(double tienHoanTra) {
        this.tienHoanTra = tienHoanTra;
    }

    public double getTiLeTru() {
        return tiLeTru;
    }

    public void setTiLeTru(double tiLeTru) {
        this.tiLeTru = tiLeTru;
    }

    public static int getMaxChiTiet() {
        return MAX_CHI_TIET;
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public HoaDonDoiTraHang(String maHoaDon, LocalDate ngayLap, NhanVien nhanVien, KhachHang khachHang, HoaDon hoaDonGoc2, double tongGiaTri2, String ghiChu2, double tienHoanTra2, double tiLeTru2) {
        this.hoaDonGoc = null;
        this.dsChiTiet = new ChiTietHoaDonDoiTra[MAX_CHI_TIET];
        this.tongGiaTri = 0;
        this.tienHoanTra = 0;
        this.tiLeTru = 0;
        this.ghiChu = "";
    }

    public HoaDonDoiTraHang() {
        //TODO Auto-generated constructor stub
    }

    public void input() {
        setHoaDonGoc(hoaDonGoc);

        System.out.print("Nhap so luong chi tiet doi tra: ");
        int soLuongChiTiet = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < soLuongChiTiet && i < MAX_CHI_TIET; i++) {
            System.out.println("Nhap chi tiet doi tra thu " + (i + 1) + ":");
            ChiTietHoaDonDoiTra chiTiet = new ChiTietHoaDonDoiTra();
            chiTiet.input(i + 1);
            dsChiTiet[i] = chiTiet;
        }

        System.out.print("Nhap ty le tru (%): ");
        setTiLeTru(scanner.nextDouble());

        System.out.print("Nhap ghi chu: ");
        setGhiChu(scanner.nextLine());

     
        // Tính tổng giá trị hoàn trả và số tiền sau khi trừ
        this.tongGiaTri = 0;
        for (int i = 0; i < soLuongChiTiet; i++) {
            this.tongGiaTri += dsChiTiet[i].getThanhTien();
        }
        this.tienHoanTra = this.tongGiaTri * (1 - tiLeTru / 100);
    }




    @Override
    public String toString() {
        StringBuilder chiTietStr = new StringBuilder();

        for (int i = 0; i < dsChiTiet.length && dsChiTiet[i] != null; i++) {
            chiTietStr.append(dsChiTiet[i].toString()).append("\n");
        }

        return String.format(
            "Hoa Don Doi Tra:\nHoa Don Goc:\n%s\nDanh Sach Chi Tiet:\n%sTong Gia Tri: %.2f\nTi Le Tru: %.2f%%\nTien Hoan Tra: %.2f\nGhi Chu: %s",
            hoaDonGoc != null ? hoaDonGoc.toString() : "Khong co hoa don goc",
            chiTietStr.toString(),
            tongGiaTri,
            tiLeTru,
            tienHoanTra,
            ghiChu
        );
    }
}
