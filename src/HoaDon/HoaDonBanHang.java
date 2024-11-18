package HoaDon;

import java.util.Scanner;
import KhuyenMai.KhuyenMai;

public class HoaDonBanHang extends HoaDon {
    private ChiTietHoaDon[] chiTietHoaDonList; // Danh sách chi tiết hóa đơn
    private int soLuongChiTiet; // Số lượng chi tiết hiện tại
    private KhuyenMai khuyenMai; // Chương trình khuyến mãi
    private double tienThue;
    private double chietKhau;
    private String phuongThucThanhToan; 
    private double tongTien; // Tổng tiền của hóa đơn

    private static final int MAX_CHI_TIET = 100; // Giới hạn số lượng chi tiết hóa đơn
    private static final Scanner scanner = new Scanner(System.in);

    // Constructor mặc định
    public HoaDonBanHang() {
        super();
        this.chiTietHoaDonList = new ChiTietHoaDon[MAX_CHI_TIET];
        this.soLuongChiTiet = 0;
        this.tienThue = 0;
        this.chietKhau = 0;
        this.tongTien = 0;
        this.phuongThucThanhToan = "Tiền mặt";
    }

    public ChiTietHoaDon[] getChiTietHoaDonList() {
        return chiTietHoaDonList;
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

    @Override
    public void input() {
        super.input(); // Nhập thông tin cơ bản từ lớp cha
        System.out.print("Nhap so luong chi tiet hoa don: ");
        int soLuong = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < soLuong && soLuongChiTiet < MAX_CHI_TIET; i++) {
            System.out.println("Nhap chi tiet hoa don thu " + (i + 1) + ":");
            ChiTietHoaDon chiTiet = new ChiTietHoaDon();
            chiTiet.input(i + 1); // STT bắt đầu từ 1
            chiTietHoaDonList[soLuongChiTiet++] = chiTiet;
        }

        System.out.print("Nhap tien thue (theo %): ");
        tienThue = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhap chiet khau (theo %): ");
        chietKhau = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhap phuong thuc thanh toan: ");
        phuongThucThanhToan = scanner.nextLine();

        System.out.println("Nhap thong tin khuyen mai:");
        khuyenMai = new KhuyenMai();
        khuyenMai.input();

        tinhTongTien(); // Tính tổng tiền hóa đơn
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Chi tiet hoa don:");
        System.out.printf("%-10s %-20s %-10s %-15s %-15s\n", "STT", "Ten SP", "So luong", "Don gia", "Thanh tien");

        for (int i = 0; i < soLuongChiTiet; i++) {
            chiTietHoaDonList[i].xuat();
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
            tongTien += chiTietHoaDonList[i].getThanhTien();
        }
        tongTien += tongTien * (tienThue / 100); // Thêm thuế
        tongTien -= tongTien * (chietKhau / 100); // Trừ chiết khấu
        tongTien -= khuyenMai.getTongKhuyenMai(); // Trừ khuyến mãi
    }

    // Ghi thông tin ra chuỗi (hỗ trợ ghi file)
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(",").append(tienThue)
               .append(",").append(chietKhau)
               .append(",").append(phuongThucThanhToan)
               .append(",").append(tongTien)
               .append(",").append(khuyenMai.toString());
        for (int i = 0; i < soLuongChiTiet; i++) {
            builder.append(",").append(chiTietHoaDonList[i].toString());
        }
        return builder.toString();
    }

    // Đọc thông tin từ chuỗi (hỗ trợ đọc file)
    @Override
    public void fromString(String data) {
        String[] parts = data.split(",", 5);
        super.fromString(data); // Đọc thông tin cơ bản từ lớp cha
        this.tienThue = Double.parseDouble(parts[0]);
        this.chietKhau = Double.parseDouble(parts[1]);
        this.phuongThucThanhToan = parts[2];
        this.tongTien = Double.parseDouble(parts[3]);

        khuyenMai = new KhuyenMai();
        khuyenMai.fromString(parts[4]);

        for (int i = 5; i < parts.length; i++) {
            ChiTietHoaDon chiTiet = new ChiTietHoaDon();
            chiTiet.fromString(parts[i]);
            chiTietHoaDonList[soLuongChiTiet++] = chiTiet;
        }
    }
}
