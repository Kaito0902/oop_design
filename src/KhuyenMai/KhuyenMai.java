package KhuyenMai;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static ChucNang.ChuanHoaDuLieu.chuanHoaNgayThangNam;

public class KhuyenMai {
    private String maKhuyenMai;
    private String tenKhuyenMai;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private double tongKhuyenMai;
    private String dieuKienApDung;
    private boolean isdelete;
    static int soLuongKhuyenMai = 0;
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static Scanner sc = new Scanner(System.in);

    public KhuyenMai(){}

    public KhuyenMai(String maKhuyenMai, String tenKhuyenMai, LocalDate ngayBatDau, LocalDate ngayKetThuc, double tongKhuyenMai, String dieuKienApDung, boolean isdelete) {
        this.maKhuyenMai = maKhuyenMai;
        this.tenKhuyenMai = tenKhuyenMai;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.tongKhuyenMai = tongKhuyenMai;
        this.dieuKienApDung = dieuKienApDung;
        this.isdelete = isdelete;
        soLuongKhuyenMai++;
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

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = chuanHoaNgayThangNam(ngayBatDau);
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        LocalDate ngayKetThucMoi = chuanHoaNgayThangNam(ngayKetThuc);

        while (ngayKetThucMoi.isBefore(ngayBatDau)) {
            System.out.println("Ngay ket thuc khong the truoc ngay bat dau.");
            System.out.println("Vui long nhap lai ngay ket thuc (dd/MM/yyyy): ");
            ngayKetThucMoi = chuanHoaNgayThangNam(sc.nextLine());
        }
        this.ngayKetThuc = ngayKetThucMoi;
    }

    public String getDieuKienApDung() {
        return dieuKienApDung;
    }

    public void setDieuKienApDung(String dieuKienApDung) {
        this.dieuKienApDung = dieuKienApDung;
    }

    public double getTongKhuyenMai() {
        return tongKhuyenMai;
    }

    public void setTongKhuyenMai(double tongKhuyenMai) {
        while (tongKhuyenMai <= 0) {
            System.out.println("Tong khuyen mai khong <= 0");
            System.out.println("Nhap lai tong khuyen mai: ");
            tongKhuyenMai = Double.parseDouble(sc.nextLine());
        }
        this.tongKhuyenMai = tongKhuyenMai;
    }

    public boolean isIsdelete() {
        return isdelete;
    }

    public void setIsdelete(boolean isdelete) {
        this.isdelete = isdelete;
    }

    public void input() {
        System.out.print("Nhap ten khuyen mai: ");
        setTenKhuyenMai(sc.nextLine());

        System.out.print("Nhap ngay bat dau (dd/MM/yyyy): ");
        setNgayBatDau(sc.nextLine());

        System.out.print("Nhap ngay ket thuc (dd/MM/yyyy): ");
        setNgayKetThuc(sc.nextLine());

        System.out.print("Nhap dieu kien ap dung: ");
        setDieuKienApDung(sc.nextLine());

        System.out.print("Nhap tong khuyen mai (theo %): ");
        setTongKhuyenMai(Double.parseDouble(sc.nextLine()));

        isdelete = false;
        maKhuyenMai = "km" + String.format("%02d", ++soLuongKhuyenMai);
    }

    @Override
    public String toString() {
        return String.format("%-5s %-20s %-15s %-15s %-10.2f %-20s", maKhuyenMai, tenKhuyenMai, ngayBatDau, ngayKetThuc, tongKhuyenMai, dieuKienApDung);
    }

    public void xuat(){
        System.out.println(toString());
    }

}
