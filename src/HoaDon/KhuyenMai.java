package HoaDon;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class KhuyenMai {
    private String maKhuyenMai;
    private String tenKhuyenMai;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private String dieuKienApDung;
    private String sanPhamApDung;
    private double tongKhuyenMai;

    public KhuyenMai(){}

    public KhuyenMai(String maKhuyenMai, String tenKhuyenMai, LocalDate ngayBatDau, LocalDate ngayKetThuc,
            String dieuKienApDung, String sanPhamApDung, double tongKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
        this.tenKhuyenMai = tenKhuyenMai;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.dieuKienApDung = dieuKienApDung;
        this.sanPhamApDung = sanPhamApDung;
        this.tongKhuyenMai = tongKhuyenMai;
    };
    
    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public String getTenKhuyenMai() {
        return tenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        this.tenKhuyenMai = tenKhuyenMai;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getDieuKienApDung() {
        return dieuKienApDung;
    }

    public void setDieuKienApDung(String dieuKienApDung) {
        this.dieuKienApDung = dieuKienApDung;
    }

    public String getSanPhamApDung() {
        return sanPhamApDung;
    }

    public void setSanPhamApDung(String sanPhamApDung) {
        this.sanPhamApDung = sanPhamApDung;
    }

    public double getTongKhuyenMai() {
        return tongKhuyenMai;
    }

    public void setTongKhuyenMai(double tongKhuyenMai) {
        this.tongKhuyenMai = tongKhuyenMai;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.print("Nhập mã khuyến mãi: ");
        maKhuyenMai = scanner.nextLine();

        System.out.print("Nhập tên khuyến mãi: ");
        tenKhuyenMai = scanner.nextLine();

        System.out.print("Nhập ngày bắt đầu (yyyy-MM-dd): ");
        ngayBatDau = LocalDate.parse(scanner.nextLine(), formatter);

        System.out.print("Nhập ngày kết thúc (yyyy-MM-dd): ");
        ngayKetThuc = LocalDate.parse(scanner.nextLine(), formatter);

        System.out.print("Nhập điều kiện áp dụng: ");
        dieuKienApDung = scanner.nextLine();

        System.out.print("Nhập sản phẩm áp dụng: ");
        sanPhamApDung = scanner.nextLine();

        System.out.print("Nhập tổng khuyến mãi: ");
        tongKhuyenMai = scanner.nextDouble();
    }

    // Phương thức toString để hiển thị thông tin khuyến mãi
    @Override
    public String toString() {
        return "KhuyenMai{" +
                "maKhuyenMai='" + maKhuyenMai + '\'' +
                ", tenKhuyenMai='" + tenKhuyenMai + '\'' +
                ", ngayBatDau=" + ngayBatDau +
                ", ngayKetThuc=" + ngayKetThuc +
                ", dieuKienApDung='" + dieuKienApDung + '\'' +
                ", sanPhamApDung='" + sanPhamApDung + '\'' +
                ", tongKhuyenMai=" + tongKhuyenMai +
                '}';
    }

    public static KhuyenMai timKhuyenMai(String maKhuyenMai2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'timKhuyenMai'");
    }
    
    
}
