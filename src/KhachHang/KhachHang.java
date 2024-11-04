package KhachHang;

import java.util.Scanner;
public abstract class KhachHang {
    static int tongKH = 0;
    static Scanner scanner = new Scanner(System.in);
    //atrribute thông tin cá nhân 
    protected String hoTen;
    protected String gioiTinh;
    protected String ngaySinh;
    protected String diaChi;
    protected int sdt;
    protected String email;
    protected String maKhachHang;
    protected String loaiKhachHang;
    private String[] loai = {"Tiem nang", "Than Thiet", "Uu dai", "Binh Thuong"};      
    //các thuộc tính/tính năng thêm cho khách hàng
    // protected HoaDon hoaDon[];//1khách hàng có nhiều hóa đơn mua hàng
    // protected DonDatHang gioHang[];//1 khách hàng có nhiều đơn đặt hàng
    // protected BaoHanh baoHang[];//1 khách hàng có nhiều loại sản phẩm cần bảo hành
    protected String khieuNai;//khách hàng có thể góp ý dịch vụ
    protected int tichDiem = 0;//điểm tích lũy của khách hàng khi đã mua các sản phẩm

    //non-parameted constructor
    public KhachHang() {
        this.tichDiem = 0;
    }

    //parameted constructor
    public KhachHang(String hoTen, String gioiTinh, String ngaySinh, String diaChi, int sdt, String email,
            String maKhachHang, String loaiKhachHang, String khieuNai, int tichDiem) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.maKhachHang = "kh" + String.format("%02d", ++tongKH);
        this.loaiKhachHang = loaiKhachHang;
        this.khieuNai = khieuNai;
        this.tichDiem = tichDiem;
        tongKH++;
    }
    
    //getter and setter
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(String loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }

    public String getKhieuNai() {
        return khieuNai;
    }

    public void setKhieuNai(String khieuNai) {
        this.khieuNai = khieuNai;
    }

    public int getTichDiem() {
        return tichDiem;
    }

    public void setTichDiem(int tichDiem) {
        this.tichDiem = tichDiem;
    }

    //input
    public void input() {
        System.out.println("Nhap ma khach hang:");
        setMaKhachHang(scanner.nextLine());
        System.out.println("Nhap HoTen:");
        setHoTen(scanner.nextLine());
        System.out.println("Nhap gioi tinh (Anh/Chi):");
        setGioiTinh(scanner.nextLine());
        System.out.println("Nhap SoDienThoai:");
        setSdt(Integer.parseInt(scanner.nextLine()));
        System.out.println("Nhap ngay sinh:");
        setNgaySinh(scanner.nextLine());
        System.out.println("Nhap email:");
        setEmail(scanner.nextLine());
        System.out.println("Nhap dia chi:");
        setDiaChi(scanner.nextLine());
        System.out.println("Nhap loai khach hang (Tiem nang, Than Thiet, Uu dai):");
        setLoaiKhachHang(scanner.nextLine());
    }
    //output 
    public void output() {
        System.out.println(toString());
    }

    //toString
    @Override
    public String toString() {
        return String.format("%-10s %-10s %-10d %-10s %-10s %-10s %-10s",maKhachHang, hoTen, sdt, ngaySinh, email, 
        diaChi, loaiKhachHang);
    }

    //xeploaiuudai
    public double xeploaiuudai() {
        if ( loaiKhachHang.equalsIgnoreCase( "Tiem nang"))
            return 0.02;
        else if ( loaiKhachHang.equalsIgnoreCase("Uu dai") )
            return 0.01;
        else if ( loaiKhachHang.equalsIgnoreCase("Than thiet"))
            return 0.05;
        else 
            return 0;
    }

    //tinh UuDai
    public abstract double tinhUuDai();
    //gop y, khieu nai
    //tinh diemThuong
    public abstract double tinhDiemThuong();
}
