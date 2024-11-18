package KhachHang;

import java.time.LocalDate;
import java.util.Scanner;

import ChucNang.ChuanHoaDuLieu;
import HoaDon.HoaDon;
import HoaDon.QLHoaDon; 

public abstract class KhachHang {
    static int tongKH = 0;
    static Scanner scanner = new Scanner(System.in);
    ChuanHoaDuLieu chuanHoa = new ChuanHoaDuLieu();

    //atrribute thông tin cá nhân 
    protected String hoTen;
    protected String gioiTinh;
    protected String ngaySinh;
    protected String diaChi;
    protected String sdt;
    protected String email;
    protected String maKhachHang;
    protected String loaiKhachHang;
    private String[] loai = {"Tiem nang", "Than Thiet", "Uu dai", "Binh Thuong"};  

    //các thuộc tính/tính năng thêm cho khách hàng
    protected HoaDon giaodich[] = new HoaDon[5];//1khách hàng có nhiều hóa đơn mua hàng
    protected int soluonggiaodich = 0;
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
            String maKhachHang, String loaiKhachHang, int tichDiem) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.maKhachHang = maKhachHang;//"kh" + String.format("%02d", ++tongKH)
        this.loaiKhachHang = loaiKhachHang;
        this.tichDiem = tichDiem;
        tongKH++;
    }
    
    //getter and setter
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = chuanHoa.chuanHoaTen(hoTen);
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh =  chuanHoa.chuanHoaGioiTinh(gioiTinh);
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        LocalDate date = chuanHoa.chuanHoaNgaySinh(ngaySinh);
        while (date == null) {
            ngaySinh = scanner.nextLine();
            date = chuanHoa.chuanHoaNgaySinh(ngaySinh);
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
        this.sdt = chuanHoa.chuanHoaSoDienThoai(sdt);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getTichDiem() {
        return tichDiem;
    }

    public void setTichDiem(int tichDiem) {
        this.tichDiem = tichDiem;
    }

    //input
    public void input(QLHoaDon qlhd) {
        tongKH++;
        inputInfo();
        inputType();
        inputGiaoDich(qlhd);
        capNhapTichDiem(qlhd);
    }

    // nhap thong tin khach hang
    public void inputInfo() {
        System.out.println("Nhap HoTen:");
        setHoTen(scanner.nextLine());
        System.out.println("Nhập giới tính (Nam, Nữ, Khác):");
        setGioiTinh(scanner.nextLine());
        System.out.println("Nhap SoDienThoai:");
        setSdt(scanner.nextLine()); 
        System.out.println("Nhap ngay sinh(định dạng: dd/MM/yyyy):");
        setNgaySinh(scanner.nextLine());
        System.out.println("Nhap email:");
        setEmail(scanner.nextLine());
        System.out.println("Nhap dia chi:");
        setDiaChi(scanner.nextLine());
    }

    public void inputType() {
        if ( (this instanceof KhachHangCaNhan)){
            // System.out.println("Nhap loai khach hang (Tiem nang, Than Thiet, Uu dai, Binh Thuong):");
            setLoaiKhachHang("Binh Thuong");
        }
        else if ( this instanceof KhachHangSinhVien ) {
            setLoaiKhachHang("Uu dai");
        }
        else if ( this instanceof KhachHangVip ){
            setLoaiKhachHang("Than Thiet");
        }else 
            setLoaiKhachHang("Tiem Nang");
    }

    public void inputGiaoDich(QLHoaDon qlhd) {
        // giao dich
        boolean themgiaodich = false;
        while (true) {
            System.out.println("Ban co muon them giao dich khong(Y/N):");
            String chon = scanner.nextLine().trim().toUpperCase();
            if (chon.equals("Y")){
                themgiaodich = true;
                break;
            }else if (chon.equals("N")){
                themgiaodich = false;
                break;
            }else{
                System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập 'Y' hoặc 'N'.");
            }
        }
        
        while (themgiaodich) {
            HoaDon gd = new HoaDon();
            gd.input();

            if ( soluonggiaodich < giaodich.length )
                giaodich[soluonggiaodich++] = gd;
            else
                System.out.println("khong the them giao dich:So luong dat toi da!!!");  
            qlhd.themHD(gd);
        

            while ( true ) {
                System.out.println("Ban co muon them giao dich khac khong(Y/N):");
                String chon = scanner.nextLine().trim().toUpperCase();
                if (chon.equals("Y")) {
                    themgiaodich = true;
                    break;
                } else if (chon.equals("N")) {
                    themgiaodich = false;
                    break;
                } else {
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập 'Y' hoặc 'N'.");
                }
            }
        }
    }

    //output 
    public void output() {
        System.out.println(toString());
    }

    //toString
    @Override
    public String toString() {
        return String.format("%-10s %-20s %-10s %-15s %-15s %-15s %-10s %-20s",getMaKhachHang(), hoTen, gioiTinh, sdt, ngaySinh, email, 
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
    public abstract int tinhDiemThuong(double tongSoTien);

    // cap nhap tich diem
    public void  capNhapTichDiem(QLHoaDon qlHoaDon) {
        double tongSoTien = 1000000;//qlHoaDon.getTongSoTien(maKhachHang)
        int diemThuong = (int)tinhDiemThuong(tongSoTien);
        tichDiem = diemThuong;
    }
}
