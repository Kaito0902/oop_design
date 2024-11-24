package KhuyenMai;

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

    public KhuyenMai() {}

    public KhuyenMai(String maKhuyenMai, String tenKhuyenMai, LocalDate ngayBatDau, LocalDate ngayKetThuc,
            String dieuKienApDung, String sanPhamApDung, double tongKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
        this.tenKhuyenMai = tenKhuyenMai;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.dieuKienApDung = dieuKienApDung;
        this.sanPhamApDung = sanPhamApDung;
        this.tongKhuyenMai = tongKhuyenMai;
    }

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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Cập nhật định dạng ngày mới

        System.out.print("Nhap ma khuyen mai: ");
        maKhuyenMai = scanner.nextLine();

        System.out.print("Nhap ten khuyen mai: ");
        tenKhuyenMai = scanner.nextLine();

        System.out.print("Nhap ngay bat dau (dd/MM/yyyy): ");
        ngayBatDau = LocalDate.parse(scanner.nextLine(), formatter);

        System.out.print("Nhap ngay ket thuc (dd/MM/yyyy): ");
        ngayKetThuc = LocalDate.parse(scanner.nextLine(), formatter);

        System.out.print("Nhap dieu kien ap dung: ");
        dieuKienApDung = scanner.nextLine();

        System.out.print("Nhap san pham ap dung: ");
        sanPhamApDung = scanner.nextLine();

        System.out.print("Nhap tong khuyen mai: ");
        tongKhuyenMai = scanner.nextDouble();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        return "KhuyenMai{" +
                "maKhuyenMai='" + maKhuyenMai + '\'' +
                ", tenKhuyenMai='" + tenKhuyenMai + '\'' +
                ", ngayBatDau=" + ngayBatDau.format(formatter) + // Đổi định dạng hiển thị
                ", ngayKetThuc=" + ngayKetThuc.format(formatter) +
                ", dieuKienApDung='" + dieuKienApDung + '\'' +
                ", sanPhamApDung='" + sanPhamApDung + '\'' +
                ", tongKhuyenMai=" + tongKhuyenMai +
                '}';
    }

    public void output() {
        System.out.println(toString());
    }

    public static KhuyenMai timKhuyenMai(String maKhuyenMai2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'timKhuyenMai'");
    }

    public void fromString(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fromString'");
    }
}
