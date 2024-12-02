package KhachHang;

import java.time.LocalDate;
import java.util.Scanner;

import static ChucNang.ChuanHoaDuLieu.*;

public abstract class KhachHang {
    static int tongKH = 0;
    static Scanner scanner = new Scanner(System.in);

    //atrribute thông tin cá nhân 
    protected String hoTen;
    protected String gioiTinh;
    protected String ngaySinh;
    protected String diaChi;
    protected String sdt;
    protected String email;
    protected String maKhachHang;
    protected String loaiKhachHang;
    protected boolean isdelete;
    static String[] loai = {"Tiem nang", "Than Thiet", "Uu dai", "Binh Thuong"};

    //các thuộc tính/tính năng thêm cho khách hàng
    // protected HoaDon giaodich[] = new HoaDon[5];//1khách hàng có nhiều hóa đơn mua hàng
    // protected int soluonggiaodich = 0;
    // protected DonDatHang gioHang[];//1 khách hàng có nhiều đơn đặt hàng
    // protected BaoHanh baoHang[];//1 khách hàng có nhiều loại sản phẩm cần bảo hành
    // protected String khieuNai;//khách hàng có thể góp ý dịch vụ
    protected int tichDiem = 0;//điểm tích lũy của khách hàng khi đã mua các sản phẩm

    //non-parameted constructor
    public KhachHang() {
        this.tichDiem = 0;
    }

    //parameted constructor
    public KhachHang(String hoTen, String gioiTinh, String ngaySinh, String diaChi, String sdt, String email,
            String maKhachHang, String loaiKhachHang, boolean isdelete, int tichDiem) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.maKhachHang = maKhachHang;
        this.loaiKhachHang = loaiKhachHang;
        this.isdelete = isdelete;
        this.tichDiem = tichDiem;
        tongKH++;
    }

    //getter and setter
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = chuanHoaTen(hoTen);
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh =  chuanHoaGioiTinh(gioiTinh);
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        LocalDate date = chuanHoaNgayThangNam(ngaySinh);
        while (date == null) {
            ngaySinh = scanner.nextLine();
            date = chuanHoaNgayThangNam(ngaySinh);
        }
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
            this.sdt = chuanHoaSoDienThoaikh(sdt);//123
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = chuanHoaEmail(email);
    }

    public String getMaKhachHang() {
        if ( maKhachHang == null )
            maKhachHang = "kh" + String.format("%02d", tongKH);
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(String loaiKhachHang) {
        while (!ktra(loaiKhachHang)) {
            System.out.println("loai khach hang khong hop le!!!");
            System.out.println("Nhap lai:");
            loaiKhachHang = scanner.nextLine();
        }
        this.loaiKhachHang = loaiKhachHang;
    }

    public boolean isIsdelete() {
        return isdelete;
    }

    public void setIsdelete(boolean isdelete) {
        this.isdelete = isdelete;
    }

    public int getTichDiem() {
        return tichDiem;
    }

    public void setTichDiem(int tichDiem) {
        this.tichDiem = tichDiem;
    }

    //input
    public void input() {
        tongKH++;
        inputInfo();
        inputType();
        // inputGiaoDich();

        tichDiem = 0;
    }

    public void input(String sdt) {
        tongKH++;
        inputInfo(sdt);
        inputType();
        // inputGiaoDich();

        tichDiem = 0;
    }

    // nhap thong tin khach hang
    public void inputInfo() {
        System.out.println("Nhap HoTen:");
        setHoTen(scanner.nextLine());
        System.out.println("Nhap gioi tinh (Nam, Nu, Khac):");
        setGioiTinh(scanner.nextLine());
        System.out.println("Nhap SoDienThoai:");
        setSdt(scanner.nextLine()); 
        System.out.println("Nhap ngay sinh(đinh dang: dd/MM/yyyy):");
        setNgaySinh(scanner.nextLine());
        System.out.println("Nhap email:");
        setEmail(scanner.nextLine());
        System.out.println("Nhap dia chi:");
        setDiaChi(scanner.nextLine());
        isdelete = true;
    }

    public void inputInfo(String sdt) {
        System.out.println("Nhap HoTen:");
        setHoTen(scanner.nextLine());
        System.out.println("Nhap gioi tinh (Nam, Nu, Khac):");
        setGioiTinh(scanner.nextLine());
        setSdt(sdt);
        System.out.println("Nhap ngay sinh(đinh dang: dd/MM/yyyy):");
        setNgaySinh(scanner.nextLine());
        System.out.println("Nhap email:");
        setEmail(scanner.nextLine());
        System.out.println("Nhap dia chi:");
        setDiaChi(scanner.nextLine());
        isdelete = true;
    }

    public void inputType() {
        if ( (this instanceof KhachHangCaNhan)){
            // System.out.println("Nhap loai khach hang (Tiem nang, Than Thiet, Uu dai, Binh Thuong):");
            setLoaiKhachHang("Binh Thuong");
        }
        else if ( this instanceof KhachHangTanSinhVien) {
            setLoaiKhachHang("Uu dai");
        }
        else if ( this instanceof KhachHangVip ){
            setLoaiKhachHang("Than Thiet");
        }else 
            setLoaiKhachHang("Tiem Nang");
    }

    //output 
    public void output() {
        System.out.println(toString());
    }

    //toString
    @Override
    public String toString() {
        return String.format("%-10s %-20s %-10s %-15s %-15s %-25s %-15s %-15s",getMaKhachHang(), hoTen, gioiTinh, sdt, ngaySinh, email,
        diaChi, loaiKhachHang);
    }

    // ktra
    public boolean ktra (String loaiKH) {
        for (var i : loai)
            if ( i.equalsIgnoreCase(loaiKH) )
                return true;
        return false; 
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
    //tinh diemThuong
    public abstract int tinhDiemThuong(double tongTien);

    public void capNhatDiemThuong(double tienMua) {
        tichDiem += (int) (tinhDiemThuong(tienMua)*(1 - tinhUuDai()));
    }
}
