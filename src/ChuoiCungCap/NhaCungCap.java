package ChuoiCungCap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static ChucNang.ChuanHoaDuLieu.*;

public class NhaCungCap {
    protected String maNCC;
    protected String tenNCC;
    protected String diaChi;
    protected String email;
    protected String maSoThue;
    protected LocalDate ngayHopTac;
    protected boolean isNotDeleted;
    static int soLuongNCC;
    static Scanner sc = new Scanner(System.in);
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public NhaCungCap() {

    }

    public NhaCungCap(String maNCC, String tenNCC, String diaChi, String email, String maSoThue, LocalDate ngayHopTac, boolean isNotDeleted) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.email = email;
        this.maSoThue = maSoThue;
        this.ngayHopTac = ngayHopTac;
        this.isNotDeleted = isNotDeleted;
        soLuongNCC++;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        while(!maNCC.startsWith("#ncc"))
            System.out.println("Ma san pham bat dau bang: #ncc ");
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = chuanHoaTen(tenNCC);
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = chuanHoaEmail(email);
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

    public void setNgayHopTac(String ngayHopTac) {
        this.ngayHopTac = chuanHoaNgayThangNam(ngayHopTac);
    }

    public boolean isNotDeleted() {
        return isNotDeleted;
    }

    public void setIsNotDeleted(boolean isNotDelete) {
        this.isNotDeleted = isNotDelete;
    }

    public void nhap() {
        maNCC = "#ncc" + String.format("%03d", ++soLuongNCC);
        System.out.print("Nhap ten nha cung cap: ");
        setTenNCC(sc.nextLine());
        System.out.print("Nhap dia chi: ");
        setDiaChi(sc.nextLine());
        System.out.print("Nhap email: ");
        setEmail(sc.nextLine());
        System.out.print("Nhap ma so thue: ");
        setMaSoThue(sc.nextLine());
        System.out.print("Nhap ngay hop tac (dinh dang dd/mm/yyyy): ");
        setNgayHopTac(sc.nextLine());
        isNotDeleted = true;
    }

    @Override
    public String toString(){
        return String.format("%-10s %-15s %-15s %-15s %-15s %-15s",
                maNCC, tenNCC, diaChi, email, maSoThue, ngayHopTac);
    }

    public void xuat() {
        System.out.println("Ma nha cung cap: " + maNCC);
        System.out.println("Ten nha cung cap: " + tenNCC);
        System.out.println("Dia chi nha cung cap: " + diaChi);
        System.out.println("Email nha cung cap: " + email);
        System.out.println("Ma so thue nha cung cap: " + maSoThue);
        System.out.println("Ngay hop tac nha cung cap: " + ngayHopTac.format(formatter));
    }
}