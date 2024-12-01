package SanPham;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public abstract class SanPham{      
    protected String maSP;
    protected String tenSP;
    protected float giaSP;
    protected int thoiGianBaoHanhSP;
    protected float trongLuongSP;
    protected String mauSacSP;
    protected int soLuongNhap;
    protected int soLuongXuat;
    protected int soLuongTonKho;
    protected boolean isNotDeleted;
    static int soLuongSP = 0;
    static Scanner sc = new Scanner(System.in);
    static NumberFormat fm = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

    public SanPham()
    {

    }

    public SanPham(String maSP, String tenSP, float giaSP, int thoiGianBaoHanhSP, float trongLuongSP, String mauSacSP,
                   int soLuongNhap, int soLuongXuat, int soLuongTonKho, boolean isNotDeleted) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.thoiGianBaoHanhSP = thoiGianBaoHanhSP;
        this.trongLuongSP = trongLuongSP;
        this.mauSacSP = mauSacSP;
        this.soLuongNhap = soLuongNhap;
        this.soLuongXuat = soLuongXuat;
        this.soLuongTonKho = soLuongTonKho;
        this.isNotDeleted = isNotDeleted;
        ++soLuongSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        while(!maSP.startsWith("#sp")){
            System.out.println("Ma san pham bat dau bang: #sp ");
            maSP = sc.nextLine();
        }
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

    public int getThoiGianBaoHanhSP() {
        return thoiGianBaoHanhSP;
    }

    public void setThoiGianBaoHanhSP(int thoiGianBaoHanhSP) {
        while (thoiGianBaoHanhSP <= 0) {
            System.out.println("Thoi gian bao hanh khong hop le");
            System.out.println("Nhap lai thoi gian bao hanh: ");
            thoiGianBaoHanhSP = Integer.parseInt(sc.nextLine());
        }
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

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        while(soLuongNhap <= 0){
            System.out.println("So luong nhap hang lon hon 0");
            soLuongNhap = Integer.parseInt(sc.nextLine());
        }
        this.soLuongNhap = soLuongNhap;
    }

    public int getSoLuongXuat() {
        return soLuongXuat;
    }

    public void setSoLuongXuat(int soLuongXuat) {
        this.soLuongXuat = soLuongXuat;
    }

    public int getSoLuongTonKho() {
        return soLuongTonKho;
    }

    public void setSoLuongTonKho(int soLuongTonKho) {
        this.soLuongTonKho = soLuongTonKho;
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
        setThoiGianBaoHanhSP(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap trong luong san pham: ");
        setTrongLuongSP(Float.parseFloat(sc.nextLine()));
        System.out.println("Nhap mau sac san pham: ");
        setMauSacSP(sc.nextLine());
        System.out.println("Nhap so luong san pham nhap hang: ");
        setSoLuongNhap(Integer.parseInt(sc.nextLine()));
        isNotDeleted = true;
    }

    @Override
    public String toString(){
        return String.format("%-10s %-20s %-15f %-15d %-10f %-10s %-10d",
                maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, soLuongNhap);
    }

    public void xuat()
    {
        System.out.println("Ma san pham: " + maSP);
        System.out.println("Ten san pham: " + tenSP);
        System.out.println("Gia san pham: " + String.format("%.3f", giaSP) + " VND");
        System.out.println("Thoi gian bao hanh san pham: " + thoiGianBaoHanhSP + " thang");
        System.out.println("Trong luong san pham: " + trongLuongSP + "kg");
        System.out.println("Mau sac san pham: " + mauSacSP);
        System.out.println("So luong san pham nhap: " + soLuongNhap);
    }
}