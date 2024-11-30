package NhanVien;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static ChucNang.ChuanHoaDuLieu.*;

public abstract class NhanVien {
    protected String maNhanVien;
    protected String tenNhanVien;
    protected String soDienThoai;
    protected String email;
    protected LocalDate sinhNhat;
    protected String gioiTinh;
    protected String chucVu;
    protected LocalDate ngayVaoLam;
    protected double heSoLuong;
    protected int ngayPhepConLai;
    protected double luong;
    protected String matKhau;
    protected boolean isnotdelete;
    static double luongCoBan = 250;
    static int tongNhanVien = 0;
    static Scanner sc = new Scanner(System.in);
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public NhanVien() {
    }

    public NhanVien(String maNhanVien, String tenNhanVien, String soDienThoai, String email, LocalDate namSinh, String gioiTinh, String chucVu, LocalDate ngayVaoLam, double heSoLuong, int ngayPhepConLai, double luong, String matKhau, boolean isdelete) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.sinhNhat = namSinh;
        this.gioiTinh = gioiTinh;
        this.chucVu = chucVu;
        this.ngayVaoLam = ngayVaoLam;
        this.heSoLuong = heSoLuong;
        this.ngayPhepConLai = ngayPhepConLai;
        this.luong = luong;
        this.matKhau = matKhau;
        this.isnotdelete = isdelete;
        tongNhanVien++;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public boolean isIsnotdelete() {
        return isnotdelete;
    }

    public void setIsnotdelete(boolean isnotdelete) {
        this.isnotdelete = isnotdelete;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getEmail() {
        return email;
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

    public String getChucVu() {
        return chucVu;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = chuanHoaTen(tenNhanVien);
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = chuanHoaSoDienThoainv(soDienThoai);
    }

    public LocalDate getSinhNhat() {
        return sinhNhat;
    }

    public void setSinhNhat(String sinhNhat) {
        LocalDate ngaySinh = chuanHoaNgayThangNam(sinhNhat);

        assert ngaySinh != null;
        int age = Period.between(ngaySinh, LocalDate.now()).getYears();

        // Kiểm tra tuổi người dùng có đủ 18 chưa
        while (age < 18) {
            System.out.println("Chưa đủ 18 tuổi.");
            System.out.println("Vui lòng nhập lại ngày sinh (dd/MM/yyyy): ");
            sinhNhat = sc.nextLine();
            ngaySinh = chuanHoaNgayThangNam(sinhNhat);

            assert ngaySinh != null;
            age = Period.between(ngaySinh, LocalDate.now()).getYears();
        }

        this.sinhNhat = ngaySinh;
    }


    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = chuanHoaGioiTinh(gioiTinh);
    }

    public void setEmail(String email) {
        this.email = chuanHoaEmail(email);
    }

    public LocalDate getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(String ngayVaoLam) {
        LocalDate ngayVaoLamDate = chuanHoaNgayThangNam(ngayVaoLam);
        if (ngayVaoLamDate.isAfter(LocalDate.now())) {
            this.ngayVaoLam = LocalDate.now();
        } else {
            this.ngayVaoLam = chuanHoaNgayThangNam(ngayVaoLam);
        }
    }

    public void setNgayPhepConLai(int ngayPhepConLai) {
        this.ngayPhepConLai = ngayPhepConLai;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public void setHeSoLuong(double heSoLuong) {
        while (heSoLuong <= 0) {
            System.out.println("He so luong khong duoc <= 0");
            System.out.println("Nhap lai he so luong: ");
            heSoLuong = Integer.parseInt(sc.nextLine());
        }
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

        System.out.println("Nhap ngay sinh (dd/MM/yyyy): ");
        setSinhNhat(sc.nextLine());

        System.out.println("Nhap gioi tinh: ");
        setGioiTinh(sc.nextLine());

        System.out.println("Nhap ngay vao lam (dd/MM/yyyy): ");
        setNgayVaoLam(sc.nextLine());

        System.out.println("Nhap he so luong: ");
        setHeSoLuong(Double.parseDouble(sc.nextLine()));

        isnotdelete = true;
        luong = tinhLuong();

        ngayPhepConLai = (LocalDate.now().getYear() - this.ngayVaoLam.getYear()) >= 1 ? 12 : 6;

        maNhanVien = "nv" + String.format("%02d", ++tongNhanVien);
        matKhau = String.valueOf(sinhNhat.getYear());

    }

    @Override
    public String toString() {
        return String.format("%-8s %-20s %-13s %-30s %-12s %-8s %-20s %-12s %-12.5f",
                maNhanVien, tenNhanVien, soDienThoai, email, sinhNhat.format(formatter), gioiTinh,
                chucVu, ngayVaoLam.format(formatter), luong);
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