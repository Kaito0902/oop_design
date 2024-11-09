package SanPham;

import java.util.Scanner;

public abstract class SanPham{      
    protected String maSP;
    protected String tenSP;
    protected float giaSP;

    protected int thoiGianBaoHanhSP;
    protected float trongLuongSP;
    protected String mauSacSP;
    static int soLuongSP = 0;
    static Scanner sc = new Scanner(System.in);

    public SanPham()
    {

    }
    
    public SanPham(String maSP, String tenSP, float giaSP, int thoiGianBaoHanhSP, float trongLuongSP,
            String mauSacSP) {
        this.maSP = "#sp" + String.format("00d", ++soLuongSP);
        this.tenSP = tenSP;
        this.giaSP = giaSP;

        this.thoiGianBaoHanhSP = thoiGianBaoHanhSP;
        this.trongLuongSP = trongLuongSP;
        this.mauSacSP = mauSacSP;
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
        this.giaSP = giaSP;
    }



    public int getThoiGianBaoHanhSP() {
        return thoiGianBaoHanhSP;
    }

    public void setThoiGianBaoHanhSP(int thoiGianBaoHanhSP) {
        this.thoiGianBaoHanhSP = thoiGianBaoHanhSP;
    }

    public float getTrongLuongSP() {
        return trongLuongSP;
    }

    public void setTrongLuongSP(float trongLuongSP) {
        this.trongLuongSP = trongLuongSP;
    }

    public String getMauSacSP() {
        return mauSacSP;
    }

    public void setMauSacSP(String mauSacSP) {
        this.mauSacSP = mauSacSP;
    }



    public abstract float thanhTien();    

    // public abstract void hienThiThongTin();

    public void nhap()
    {
        maSP = "sp" + String.format("%02d", ++soLuongSP);
        System.out.println("Nhap ten san pham: ");
        setTenSP(sc.nextLine());
        System.out.println("Nhap gia san pham: ");
        setGiaSP(Float.parseFloat(sc.nextLine()));
        System.out.println("Nhap thoi gian bao hanh san pham: ");
        setThoiGianBaoHanhSP(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap trong luong san pham: ");
        setTrongLuongSP(Float.parseFloat(sc.nextLine()));
        System.out.println("Nhap mau sac san pham: ");
        setMauSacSP(sc.nextLine());
        soLuongSP++;
    }

    // @Override
    // public String toString(){
    //     return String.format("%-10s %-20s %-15d %-15d %-10d %-10.1f %-15s",
    //             maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP);
    // }

    public void xuat()
    {
        System.out.println("Ma san pham: " + maSP);
        System.out.println("Ten san pham: " + maSP);
        System.out.println("Gia san pham: " + maSP);
        System.out.println("Thoi gian bao hanh san pham: " + maSP);
        System.out.println("Trong luong san pham: " + maSP);
        System.out.println("Mau sac san pham: " + maSP);
    }
}