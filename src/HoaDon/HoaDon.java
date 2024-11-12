package HoaDon;
import java.time.LocalDate;
import java.util.Scanner;

import KhachHang.KhachHang;
import KhuyenMai.KhuyenMai;
import NhanVien.NhanVien;
import SanPham.SanPham;



public class HoaDon {
    protected String maHoaDon;
    protected LocalDate ngayLapHoaDon;
    protected int soLuong;
    protected double tongSoTien;
    protected NhanVien nhanVienLapHoaDon;
    protected KhuyenMai khuyenMai;
    protected DoiTra doiTra;
    protected KhachHang khachHang;
    protected SanPham sanPham;
    protected double tienThue;
    protected double chietKhau;
    protected String phuongThucThanhToan;

    static Scanner scanner = new Scanner(System.in);

   

    public HoaDon(String maHoaDon, LocalDate ngayLapHoaDon, int soLuong, double tongSoTien,
            NhanVien nhanVienLapHoaDon, KhuyenMai khuyenMai, SanPham sanPham,   double tienThue,
            double chietKhau, String phuongThucThanhToan) {
        this.maHoaDon = maHoaDon;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.soLuong = soLuong;
        this.tongSoTien = tongSoTien;
        this.nhanVienLapHoaDon = nhanVienLapHoaDon;
        this.khuyenMai = khuyenMai;
        this.sanPham = sanPham;
        this.tienThue = tienThue;
        this.chietKhau = chietKhau;
        this.phuongThucThanhToan = phuongThucThanhToan;
    }
    
    public HoaDon() {
        //TODO Auto-generated constructor stub
    }


    public HoaDon(String maHoaDon2, LocalDate ngayLapHoaDon2, int soLuong2, double tongSoTien2, String tenKhachHang,
            double tienThue2, double chietKhau2, String phuongThucThanhToan2) {
        //TODO Auto-generated constructor stub
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }


    public LocalDate getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }


    public void setNgayLapHoaDon(LocalDate ngayLapHoaDon) {
        this.ngayLapHoaDon = ngayLapHoaDon;
    }


    public int getSoLuong() {
        return soLuong;
    }


    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }


    public void setTongSoTien(double tongSoTien) {
        this.tongSoTien = tongSoTien;
    }


    public NhanVien getNhanVienLapHoaDon() {
        return nhanVienLapHoaDon;
    }


    public void setNhanVienLapHoaDon(NhanVien nhanVienLapHoaDon) {
        this.nhanVienLapHoaDon = nhanVienLapHoaDon;
    }


    public KhuyenMai getKhuyenMai() {
        return khuyenMai;
    }


    public void setKhuyenMai(KhuyenMai khuyenMai) {
        this.khuyenMai = khuyenMai;
    }


    public DoiTra getDoiTra() {
        return doiTra;
    }


    public void setDoiTra(DoiTra doiTra) {
        this.doiTra = doiTra;
    }


    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }


    public SanPham getSanPham() {
        return sanPham;
    }


    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }


    public double getTienThue() {
        return tienThue;
    }


    public void setTienThue(double tienThue) {
        this.tienThue = tienThue;
    }


    public double getChietKhau() {
        return chietKhau;
    }


    public void setChietKhau(double chietKhau) {
        this.chietKhau = chietKhau;
    }


    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }


    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }


    public static Scanner getScanner() {
        return scanner;
    }


    public static void setScanner(Scanner scanner) {
        HoaDon.scanner = scanner;
    }


    public void input() {
        System.out.print("Nhap ma hoa don: "); 
        maHoaDon = scanner.nextLine(); 

        System.out.print("Nhap ngay lap hoa don: "); 
        ngayLapHoaDon =  LocalDate.parse(scanner.nextLine());  

        System.out.print("Nhap ngay den han thanh toan: ");

        System.out.print("Nhap so luong: "); 
        soLuong = Integer.parseInt(scanner.nextLine()); 

        System.out.print("Nhap tong so tien: "); 
        tongSoTien = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhap tien thue: "); 
        tienThue = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhap chiet khau: ");
        chietKhau = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhap phuong thuc thanh toan: "); 
        phuongThucThanhToan = scanner.nextLine(); 



         // Kiểm tra và nhập thông tin khách hàng
         System.out.print("Nhập số điện thoại khách hàng: ");
         String soDienThoai = scanner.nextLine();

         khachHang = KhachHang.timKhachHangTheoSdt(soDienThoai);
        if (khachHang == null) {
            System.out.println("Khách hàng chưa mua lần nào, vui lòng nhập thông tin khách hàng mới:");
            khachHang = new KhachHang();
            khachHang.input(); // Gọi phương thức nhập thông tin từ lớp KhachHang
        }
        System.out.print("Nhập mã khuyến mãi (nếu có): ");
        String maKhuyenMai = scanner.nextLine();
        if (!maKhuyenMai.isEmpty()) {
            khuyenMai = KhuyenMai.timKhuyenMai(maKhuyenMai);
            if (khuyenMai == null) {
                System.out.println("Mã khuyến mãi không tồn tại, bỏ qua khuyến mãi.");
            }
        }


        }
        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return super.toString()+"HoaDon{" +
                "maHoaDon='" + maHoaDon + '\'' +
                ", ngayLapHoaDon=" + ngayLapHoaDon +
                ", soLuong=" + soLuong +
                ", tongSoTien=" + tongSoTien +
                ", nhanVienLapHoaDon=" + nhanVienLapHoaDon +
                ", khuyenMai=" + khuyenMai +
                ", khachHang='" + khachHang + '\'' +
                ", sanPham=" + sanPham +
                ", tienThue=" + tienThue +
                ", chietKhau=" + chietKhau +
                ", phuongThucThanhToan='" + phuongThucThanhToan + '\'' +
                '}';
        }
        public void xuat(){
            System.out.println(toString());
        }

        public CharSequence getMaHoaDon() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getMaHoaDon'");
        }

        public String getKhachHang() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getKhachHang'");
        }

        public double getTongSoTien() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getTongSoTien'");
        }

     }


