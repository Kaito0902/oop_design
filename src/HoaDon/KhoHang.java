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

    // Phương thức thêm sản phẩm vào kho
    public void themSanPham(SanPham sanPham) {
        // Giả sử kho hàng chỉ lưu một loại sản phẩm, nếu sản phẩm đã tồn tại thì tăng số lượng
        if (this.sanPhamConLai != null && this.sanPhamConLai.getMaSanPham().equals(sanPham.getMaSanPham())) {
            int newSoLuong = this.sanPhamConLai.soLuongTon + SanPham.soLuongTon;
            this.sanPhamConLai.setSoLuongTon(newSoLuong);
        } else {
            this.sanPhamConLai = sanPham;
        }
        System.out.println("Thêm sản phẩm vào kho: " + sanPham);
    }
    

    // Phương thức cập nhật số lượng sản phẩm trong kho
    public void capNhatSoLuongSanPham(SanPham sanPham, int soLuong) {
        if (this.sanPhamConLai != null && this.sanPhamConLai.getMaSanPham().equals(sanPham.getMaSanPham())) {
            int newSoLuong = this.sanPhamConLai.getSoLuongTon() - soLuong;
            if (newSoLuong < 0) {
                System.out.println("Số lượng sản phẩm trong kho không đủ để cập nhật!");
            } else {
                this.sanPhamConLai.setSoLuongTon(newSoLuong);
                System.out.println("Cập nhật số lượng sản phẩm " + sanPham.getTenSanPham() + " còn lại: " + newSoLuong);
            }
        } else {
            System.out.println("Sản phẩm không có trong kho!");
        }
    }

    
    public void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã kho: ");
        maKho = scanner.nextLine();

        System.out.print("Nhập tên kho: ");
        tenKho = scanner.nextLine();

        System.out.print("Nhập địa chỉ kho: ");
        diaChiKho = scanner.nextLine();

        System.out.print("Nhập tên nhân viên quản lý kho: ");
        String tenNhanVien = scanner.nextLine();
        System.out.print("Nhập mã nhân viên quản lý kho: ");
        String maNhanVien = scanner.nextLine();

        // tenNhanVienQuanLyKho = new NhanVien(maNhanVien, tenNhanVien);

        System.out.print("Nhập mã sản phẩm trong kho: ");
        String maSanPham = scanner.nextLine();
        System.out.print("Nhập tên sản phẩm trong kho: ");
        String tenSanPham = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm trong kho: ");
        double giaSanPham = scanner.nextDouble();
        System.out.print("Nhập số lượng sản phẩm trong kho: ");
        int soLuong = scanner.nextInt();

        // sanPhamConLai = new SanPham(maSanPham, tenSanPham, giaSanPham, soLuong);

        System.out.println("Nhập thông tin kho hàng thành công!");
    }

    // Phương thức toString để hiển thị thông tin kho hàng
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
