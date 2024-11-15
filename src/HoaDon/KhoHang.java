package HoaDon;

import java.util.Scanner;

import NhanVien.NhanVien;
import SanPham.SanPham;

public class KhoHang{
    private String maKho;
    private String tenKho;
    private String diaChiKho;
    private NhanVien tenNhanVienQuanLyKho ;
    private SanPham sanPhamConLai;


    public KhoHang(String maKho, String tenKho, String diaChiKho, NhanVien tenNhanVienQuanLyKho, SanPham sanPhamConLai) {
        this.maKho = maKho;
        this.tenKho = tenKho;
        this.diaChiKho = diaChiKho;
        this.tenNhanVienQuanLyKho  = tenNhanVienQuanLyKho;
        this.sanPhamConLai = sanPhamConLai;
    }

    public String getMaKho() {
        return maKho;
    }

    public void setMaKho(String maKho) {
        this.maKho = maKho;
    }

    public String getTenKho() {
        return tenKho;
    }

    public void setTenKho(String tenKho) {
        this.tenKho = tenKho;
    }

    public String getDiaChiKho() {
        return diaChiKho;
    }

    public void setDiaChiKho(String diaChiKho) {
        this.diaChiKho = diaChiKho;
    }

    public NhanVien getTenNhanVienQuanLyKho() {
        return tenNhanVienQuanLyKho;
    }

    public void setTenNhanVienQuanLyKho(NhanVien tenNhanVienQuanLyKho) {
        this.tenNhanVienQuanLyKho = tenNhanVienQuanLyKho;
    }

    public SanPham getSanPhamConLai() {
        return sanPhamConLai;
    }

    public void setSanPhamConLai(SanPham sanPhamConLai) {
        this.sanPhamConLai = sanPhamConLai;
    }

    // Phuong thuc them san pham vao kho
    public void themSanPham(SanPham sanPham) {
        // Gia su kho hang chi luu mot loai san pham, neu san pham da ton tai thi tang so luong
        if (this.sanPhamConLai != null && this.sanPhamConLai.getMaSanPham().equals(sanPham.getMaSanPham())) {
            int newSoLuong = this.sanPhamConLai.soLuongTon + SanPham.soLuongTon;
            this.sanPhamConLai.setSoLuongTon(newSoLuong);
        } else {
            this.sanPhamConLai = sanPham;
        }
        System.out.println("Them san pham vao kho: " + sanPham);
    }
    

    // Phuong thuc cap nhat so luong san pham trong kho
    public void capNhatSoLuongSanPham(SanPham sanPham, int soLuong) {
        if (this.sanPhamConLai != null && this.sanPhamConLai.getMaSanPham().equals(sanPham.getMaSanPham())) {
            int newSoLuong = this.sanPhamConLai.getSoLuongTon() - soLuong;
            if (newSoLuong < 0) {
                System.out.println("So luong san pham trong kho khong du de cap nhat!");
            } else {
                this.sanPhamConLai.setSoLuongTon(newSoLuong);
                System.out.println("Cap nhat so luong san pham " + sanPham.getTenSanPham() + " con lai: " + newSoLuong);
            }
        } else {
            System.out.println("San pham khong co trong kho!");
        }
    }

    
    public void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap ma kho: ");
        maKho = scanner.nextLine();

        System.out.print("Nhap ten kho: ");
        tenKho = scanner.nextLine();

        System.out.print("Nhap dia chi kho: ");
        diaChiKho = scanner.nextLine();

        System.out.print("Nhap ten nhan vien quan ly kho: ");
        String tenNhanVien = scanner.nextLine();
        System.out.print("Nhap ma nhan vien quan ly kho: ");
        String maNhanVien = scanner.nextLine();

        // tenNhanVienQuanLyKho = new NhanVien(maNhanVien, tenNhanVien);

        System.out.print("Nhap ma san pham trong kho: ");
        String maSanPham = scanner.nextLine();
        System.out.print("Nhap ten san pham trong kho: ");
        String tenSanPham = scanner.nextLine();
        System.out.print("Nhap gia san pham trong kho: ");
        double giaSanPham = scanner.nextDouble();
        System.out.print("Nhap so luong san pham trong kho: ");
        int soLuong = scanner.nextInt();

        // sanPhamConLai = new SanPham(maSanPham, tenSanPham, giaSanPham, soLuong);

        System.out.println("Nhap thong tin kho hang thanh cong!");
    }

    // Phuong thuc toString de hien thi thong tin kho hang
    @Override
    public String toString() {
        return "KhoHang{" +
                "maKho='" + maKho + '\'' +
                ", tenKho='" + tenKho + '\'' +
                ", diaChiKho='" + diaChiKho + '\'' +
                ", tenNhanVienQuanLyKho=" + tenNhanVienQuanLyKho +
                ", sanPhamConLai=" + sanPhamConLai +
                '}';
    }
}
