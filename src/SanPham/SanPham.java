package SanPham;

import java.util.Scanner;

public abstract class SanPham{      
    protected String maSP;
    protected String tenSP;
    protected float giaSP;
    protected float khuyenMaiSP;
    protected int thoiGianBaoHanhSP;
    protected float trongLuongSP;
    protected String mauSacSP;

    static int soLuongSP = 0;
    static Scanner sc = new Scanner(System.in);

    public SanPham()
    {

    }
    
    public SanPham(String maSP, String tenSP, float giaSP, float khuyenMaiSP, int thoiGianBaoHanhSP, float trongLuongSP,
            String mauSacSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.khuyenMaiSP = khuyenMaiSP;
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

    public float getKhuyenMaiSP() {
        return khuyenMaiSP;
    }

    public void setKhuyenMaiSP(float khuyenMaiSP) {
        this.khuyenMaiSP = khuyenMaiSP;
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

    public abstract float ThanhTien();

    public void nhap()
    {
        System.out.println("Nhap ma san pham: ");
        setMaSP(sc.nextLine());
        System.out.println("Nhap ten san pham: ");
        setTenSP(sc.nextLine());
        System.out.println("Nhap gia san pham: ");

        System.out.println("Nhap khuyen mai san pham: ");
        setKhuyenMaiSP(Float.parseFloat(sc.nextLine()));
        System.out.println("Nhap thoi gian bao hanh san pham: ");
        setThoiGianBaoHanhSP(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap trong luong san pham: ");
        setTrongLuongSP(Float.parseFloat(sc.nextLine()));
        System.out.println("Nhap mau sac san pham: ");
        setMauSacSP(sc.nextLine());
        soLuongSP++;
    }

    @Override
    public String toString() {
        return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", giaSP=" + giaSP + ", khuyenMaiSP=" + khuyenMaiSP
                + ", thoiGianBaoHanhSP=" + thoiGianBaoHanhSP + ", trongLuongSP=" + trongLuongSP + ", mauSacSP="
                + mauSacSP + "]";
    }

    public void xuat()
    {
        System.out.println(toString());
    }
}