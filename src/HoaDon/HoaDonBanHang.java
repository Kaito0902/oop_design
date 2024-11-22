package HoaDon;

import java.time.LocalDate;
import java.util.Scanner;

import KhachHang.KhachHang;
import KhuyenMai.KhuyenMai;
import NhanVien.NhanVien;

public class HoaDonBanHang extends HoaDon {
    private ChiTietHoaDon[] chiTietHoaDonList; // Danh sách chi tiết hóa đơn
    private KhuyenMai khuyenMai; // Chương trình khuyến mãi
    private double tienThue;
    private double chietKhau;
    private String phuongThucThanhToan; 
    private double tongTien; // Tổng tiền của hóa đơn

    private static final int MAX_CHI_TIET = 100; // Giới hạn số lượng chi tiết hóa đơn
    private static final Scanner scanner = new Scanner(System.in);

    public ChiTietHoaDon[] getChiTietHoaDonList() {
        return chiTietHoaDonList;
    }

    public void setChiTietHoaDonList(ChiTietHoaDon[] chiTietHoaDonList) {
        this.chiTietHoaDonList = chiTietHoaDonList;
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

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public static int getMaxChiTiet() {
        return MAX_CHI_TIET;
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public HoaDonBanHang(String maHoaDon, LocalDate ngayLap, NhanVien nhanVien, KhachHang khachHang, KhuyenMai khuyenMai2, double tienThue2, double chietKhau2, String phuongThucThanhToan2, double tongTien2) {
        super();
        this.chiTietHoaDonList = new ChiTietHoaDon[MAX_CHI_TIET];
        this.tienThue = 0;
        this.chietKhau = 0;
        this.tongTien = 0;
        this.phuongThucThanhToan = "Tiền mặt";
    }

    public HoaDonBanHang() {
        //TODO Auto-generated constructor stub
    }

    @Override
    public void input() {
        super.input();

        System.out.print("Nhap so luong chi tiet hoa don: ");
        int soLuong = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < soLuong && i < MAX_CHI_TIET; i++) {
            System.out.println("Nhap chi tiet hoa don thu " + (i + 1) + ":");
            ChiTietHoaDon chiTiet = new ChiTietHoaDon();
            chiTiet.input(i + 1); // STT bắt đầu từ 1
            chiTietHoaDonList[i] = chiTiet;
        }

        System.out.print("Nhap tien thue (theo %): ");
        tienThue = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhap chiet khau (theo %): ");
        chietKhau = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhap phuong thuc thanh toan: ");
        phuongThucThanhToan = scanner.nextLine();


        System.out.println("Nhap thong tin khuyen mai:");
        khuyenMai.input();

        // Tính tổng tiền
        tinhTongTien(soLuong);
    }



     // Phương thức tính tổng tiền hóa đơn
     private void tinhTongTien(int soLuongChiTiet) {
        tongTien = 0;
        for (int i = 0; i < soLuongChiTiet; i++) {
            tongTien += chiTietHoaDonList[i].getThanhTien();
        }
        tongTien += tongTien * (tienThue / 100); // Thêm thuế
        tongTien -= tongTien * (chietKhau / 100); // Trừ chiết khấu
        tongTien -= khuyenMai.getTongKhuyenMai(); // Trừ khuyến mãi
    }
    



    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append("\nChi tiet hoa don:\n")
               .append(String.format("%-10s %-20s %-10s %-15s %-15s\n", "STT", "Ten SP", "So luong", "Don gia", "Thanh tien"));

        for (ChiTietHoaDon chiTiet : chiTietHoaDonList) {
            if (chiTiet != null) {
                builder.append(chiTiet.toString()).append("\n");
            }
        }

        builder.append(String.format("Tien thue: %.2f%%\n", tienThue))
               .append(String.format("Chiet khau: %.2f%%\n", chietKhau))
               .append(String.format("Phuong thuc thanh toan: %s\n", phuongThucThanhToan))
               .append(String.format("Tong tien: %.2f\n", tongTien))
               .append("Khuyen mai:\n")
               .append(khuyenMai.toString());
        return builder.toString();
    }

   
}
