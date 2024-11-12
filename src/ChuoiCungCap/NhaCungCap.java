package ChuoiCungCap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import SanPham.SanPham;

public class NhaCungCap {
    protected String maNhaCungCap; 
    protected String tenNhaCungCap; 
    protected String diaChi; 
    protected String thanhPho; 
    protected String quocGia; 
    protected String email;
    protected String maSoThue; 
    protected LocalDate ngayHopTac;
    protected double chiPhiNhapHang; 
    protected SanPham tenSanPham; 
    protected String ghiChu;
    static Scanner sc = new Scanner(System.in);
    public NhaCungCap() {
    }
    public NhaCungCap(String maNhaCungCap, String tenNhaCungCap, String diaChi, String thanhPho, String quocGia,
            String email, String maSoThue, LocalDate ngayHopTac, double chiPhiNhapHang, SanPham tenSanPham,
            String ghiChu) {
        this.maNhaCungCap = maNhaCungCap;
        this.tenNhaCungCap = tenNhaCungCap;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
        this.email = email;
        this.maSoThue = maSoThue;
        this.ngayHopTac = ngayHopTac;
        this.chiPhiNhapHang = chiPhiNhapHang;
        this.tenSanPham = tenSanPham;
        this.ghiChu = ghiChu;
    }
    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }
    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }
    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }
    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public String getThanhPho() {
        return thanhPho;
    }
    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }
    public String getQuocGia() {
        return quocGia;
    }
    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMaSoThue() {
        return maSoThue;
    }
    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }
    public LocalDate getNgayHopTac() {
        return ngayHopTac;
    }
    public void setNgayHopTac(LocalDate ngayHopTac) {
        this.ngayHopTac = ngayHopTac;
    }
    public double getChiPhiNhapHang() {
        return chiPhiNhapHang;
    }
    public void setChiPhiNhapHang(double chiPhiNhapHang) {
        this.chiPhiNhapHang = chiPhiNhapHang;
    }
    public SanPham getTenSanPham() {
        return tenSanPham;
    }
    public void setTenSanPham(SanPham tenSanPham) {
        this.tenSanPham = tenSanPham;
    }
    public String getGhiChu() {
        return ghiChu;
    }
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    public static Scanner getSc() {
        return sc;
    }
    public static void setSc(Scanner sc) {
        NhaCungCap.sc = sc;
    }

    public void nhap() {
        System.out.print("Nhập mã nhà cung cấp: ");
        maNhaCungCap = sc.nextLine();

        System.out.print("Nhập tên nhà cung cấp: ");
        tenNhaCungCap = sc.nextLine();

        System.out.print("Nhập địa chỉ: ");
        diaChi = sc.nextLine();

        System.out.print("Nhập thành phố: ");
        thanhPho = sc.nextLine();

        System.out.print("Nhập quốc gia: ");
        quocGia = sc.nextLine();

        System.out.print("Nhập email: ");
        email = sc.nextLine();

        System.out.print("Nhập mã số thuế: ");
        maSoThue = sc.nextLine();

        System.out.print("Nhập ngày hợp tác (định dạng yyyy-MM-dd): ");
        String ngayHopTacStr = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ngayHopTac = LocalDate.parse(ngayHopTacStr, formatter);

        System.out.print("Nhập chi phí nhập hàng: ");
        chiPhiNhapHang = sc.nextDouble();
        sc.nextLine();  
        
        System.out.println("Nhập thông tin sản phẩm:");
        tenSanPham = new SanPham();  
        tenSanPham.input(); // Giả sử có hàm `nhap()` trong lớp SanPham để nhập thông tin sản phẩm

        System.out.print("Nhập ghi chú: ");
        ghiChu = sc.nextLine();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return "NhaCungCap {" +
                "Mã nhà cung cấp: '" + maNhaCungCap + '\'' +
                ", Tên nhà cung cấp: '" + tenNhaCungCap + '\'' +
                ", Địa chỉ: '" + diaChi + '\'' +
                ", Thành phố: '" + thanhPho + '\'' +
                ", Quốc gia: '" + quocGia + '\'' +
                ", Email: '" + email + '\'' +
                ", Mã số thuế: '" + maSoThue + '\'' +
                ", Ngày hợp tác: " + ngayHopTac.format(formatter) +
                ", Chi phí nhập hàng: " + chiPhiNhapHang +
                ", Tên sản phẩm: " + tenSanPham + // Giả sử lớp SanPham có phương thức toString()
                ", Ghi chú: '" + ghiChu + '\'' +
                '}';
    }
    public void xuat(){
        System.out.println(toString());
    }
    
}
