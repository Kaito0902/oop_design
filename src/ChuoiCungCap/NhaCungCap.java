package ChuoiCungCap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

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
    protected String ghiChu;

    static Scanner sc = new Scanner(System.in);
  
    public NhaCungCap(String maNhaCungCap, String tenNhaCungCap, String diaChi, String thanhPho, String quocGia,
            String email, String maSoThue, LocalDate ngayHopTac, double chiPhiNhapHang,
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
        this.ghiChu = ghiChu;
    }

    public NhaCungCap() {
        // TODO Auto-generated constructor stub
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
        System.out.print("Nhap ma nha cung cap: ");
        maNhaCungCap = sc.nextLine();

        System.out.print("Nhap ten nha cung cap: ");
        tenNhaCungCap = sc.nextLine();

        System.out.print("Nhap dia chi: ");
        diaChi = sc.nextLine();

        System.out.print("Nhap thanh pho: ");
        thanhPho = sc.nextLine();

        System.out.print("Nhap quoc gia: ");
        quocGia = sc.nextLine();

        System.out.print("Nhap email: ");
        email = sc.nextLine();

        System.out.print("Nhap ma so thue: ");
        maSoThue = sc.nextLine();

        System.out.print("Nhap ngay hop tac (dinh dang yyyy-MM-dd): ");
        String ngayHopTacStr = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ngayHopTac = LocalDate.parse(ngayHopTacStr, formatter);

        System.out.print("Nhap chi phi nhap hang: ");
        chiPhiNhapHang = sc.nextDouble();
        sc.nextLine();  

        System.out.print("Nhap ghi chu: ");
        ghiChu = sc.nextLine();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return "NhaCungCap {" +
                "Ma nha cung cap: '" + maNhaCungCap + '\'' +
                ", Ten nha cung cap: '" + tenNhaCungCap + '\'' +
                ", Dia chi: '" + diaChi + '\'' +
                ", Thanh pho: '" + thanhPho + '\'' +
                ", Quoc gia: '" + quocGia + '\'' +
                ", Email: '" + email + '\'' +
                ", Ma so thue: '" + maSoThue + '\'' +
                ", Ngay hop tac: " + ngayHopTac.format(formatter) +
                ", Chi phi nhap hang: " + chiPhiNhapHang +
                ", Ghi chu: '" + ghiChu + '\'' +
                '}';
    }

    public void xuat(){
        System.out.println(toString());
    }
}