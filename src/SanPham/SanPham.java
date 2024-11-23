package SanPham;

import java.util.Scanner;

public abstract class SanPham{      
    protected String maSP;
    protected String tenSP;
    protected float giaSP;
    protected String thoiGianBaoHanhSP;
    protected float trongLuongSP;
    protected String mauSacSP;
    protected boolean isNotDeleted;
    static int soLuongSP = 0;
    static Scanner sc = new Scanner(System.in);

    public SanPham()
    {

    }
    
    public SanPham(String maSP, String tenSP, float giaSP, String thoiGianBaoHanhSP, float trongLuongSP,
            String mauSacSP, boolean isNotDeleted) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.thoiGianBaoHanhSP = thoiGianBaoHanhSP;
        this.trongLuongSP = trongLuongSP;
        this.mauSacSP = mauSacSP;
        this.isNotDeleted = isNotDeleted;
        soLuongSP++;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public float getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(float giaSP) {
        while(giaSP <= 0){
            System.out.println("Gia san pham lon hon 0!");
            giaSP = Float.parseFloat(sc.nextLine());
        }
        this.giaSP = giaSP;
    }

    public String getThoiGianBaoHanhSP() {
        return thoiGianBaoHanhSP;
    }

    public void setThoiGianBaoHanhSP(String thoiGianBaoHanhSP) {
        this.thoiGianBaoHanhSP = thoiGianBaoHanhSP;
    }

    public float getTrongLuongSP() {
        return trongLuongSP;
    }

    public void setTrongLuongSP(float trongLuongSP) {
        while(trongLuongSP <= 0){
            System.out.println("Trong luong san pham lon hon 0");
            trongLuongSP = Float.parseFloat(sc.nextLine());
        }
        this.trongLuongSP = trongLuongSP;
    }

    public String getMauSacSP() {
        return mauSacSP;
    }

    public void setMauSacSP(String mauSacSP) {
        this.mauSacSP = mauSacSP;
    }

    public boolean isNotDeleted() {
        return isNotDeleted;
    }

    public void setNotDeleted(boolean isNotDeleted) {
        this.isNotDeleted = isNotDeleted;
    }

    public abstract float thanhTien();    

    public void nhap()
    {
        maSP = "#sp" + String.format("%03d", ++soLuongSP);
        System.out.println("Nhap ten san pham: ");
        setTenSP(sc.nextLine());
        System.out.println("Nhap gia san pham: ");
        setGiaSP(Float.parseFloat(sc.nextLine()));
        System.out.println("Nhap thoi gian bao hanh san pham: ");
        setThoiGianBaoHanhSP(sc.nextLine());
        System.out.println("Nhap trong luong san pham: ");
        setTrongLuongSP(Float.parseFloat(sc.nextLine()));
        System.out.println("Nhap mau sac san pham: ");
        setMauSacSP(sc.nextLine());
        soLuongSP++;
    }

    @Override
    public String toString(){
        return String.format("%-10s %-20s %-15f %-15s %-10f %-10s",
                maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP);
    }

    public void xuat()
    {
        System.out.println("Ma san pham: " + maSP);
        System.out.println("Ten san pham: " + tenSP);
        System.out.println("Gia san pham: " + String.format("%.3f", giaSP) + " VND");
        System.out.println("Thoi gian bao hanh san pham: " + thoiGianBaoHanhSP);
        System.out.println("Trong luong san pham: " + trongLuongSP + "kg");
        System.out.println("Mau sac san pham: " + mauSacSP);
    }
}