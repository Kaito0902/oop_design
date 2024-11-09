package NhanVien;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class NhanVien {
    protected String maNhanVien;
    protected String tenNhanVien;
    protected String soDienThoai;
    protected String email;
    protected int namSinh;
    protected String gioiTinh;
    protected String chucVu;
    protected int namVaoLam;
    protected double heSoLuong;
    protected int ngayPhepConLai;
    protected double luong;
    protected String matKhau;
    protected boolean isdelete;
    static double luongCoBan = 250;
    static int tongNhanVien = 0;
    static Scanner sc = new Scanner(System.in);

    public NhanVien() {
    }

    public NhanVien(String maNhanVien, String tenNhanVien, String soDienThoai, String email, int namSinh, String gioiTinh, String chucVu, int namVaoLam, double heSoLuong, int ngayPhepConLai, double luong, String matKhau, boolean isdelete) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.chucVu = chucVu;
        this.namVaoLam = namVaoLam;
        this.heSoLuong = heSoLuong;
        this.ngayPhepConLai = ngayPhepConLai;
        this.luong = luong;
        this.matKhau = matKhau;
        this.isdelete = isdelete;
        tongNhanVien++;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public int getNgayPhepConLai() {
        return ngayPhepConLai;
    }

    public int getNamVaoLam() {
        return namVaoLam;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNamVaoLam(int namVaoLam) {
        this.namVaoLam = namVaoLam;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public boolean dangNhap(String soDienThoai, String matKhau) {
        return this.soDienThoai.equals(soDienThoai) && this.matKhau.equals(matKhau);
    }

    public void doiMatKhau(String matKhauMoi) {
        this.matKhau = matKhauMoi;
    }

    public abstract void menunv();

    public void input() {
        System.out.println("Nhap ten nhan vien: ");
        setTenNhanVien(sc.nextLine());

        System.out.println("Nhap so dien thoai: ");
        setSoDienThoai(sc.nextLine());

        System.out.println("Nhap email: ");
        setEmail(sc.nextLine());

        System.out.println("Nhap nam sinh: ");
        setNamSinh(Integer.parseInt(sc.nextLine()));

        System.out.println("Nhap gioi tinh: ");
        setGioiTinh(sc.nextLine());

        System.out.println("Nhap nam vao lam: ");
        setNamVaoLam(Integer.parseInt(sc.nextLine()));

        System.out.println("Nhap he so luong: ");
        setHeSoLuong(Double.parseDouble(sc.nextLine()));

        isdelete = true;
        luong = tinhLuong();

        ngayPhepConLai = (LocalDate.now().getYear() - namVaoLam) >= 1 ? 12 : 6;

        maNhanVien = "nv" + String.format("%02d", ++tongNhanVien);
        matKhau = Integer.toString(namSinh);

        tongNhanVien++;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-15s %-25s %-10d %-15s %-20s %-10d %-12.5f",
                maNhanVien, tenNhanVien, soDienThoai, email, namSinh, gioiTinh,
                chucVu, namVaoLam, luong);
    }

    public void output() {
        System.out.println(toString());
    }

    public abstract double heSoPhuCap();
    public abstract double tinhLuong();

    // System.out.println("Nhan vien " + getTenNhanVien() + " da xin nghi " + soNgayNghi + " ngay. Con lai: " + this.ngayPhepConLai + " ngay phep.");

    public void nghiPhep(int soNgayNghi) {
        if (soNgayNghi <= this.ngayPhepConLai) {
            this.ngayPhepConLai -= soNgayNghi;
        } else {
            double luongBiTru = tinhLuong() / 30 * soNgayNghi;
            luong -= luongBiTru;
            this.ngayPhepConLai = 0;
        }
    }

}
