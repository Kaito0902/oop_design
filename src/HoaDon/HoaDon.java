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
    protected ChiTietHoaDon[] danhSachChiTiet;
    protected static int soLuongChiTiet=0; 
    
    static Scanner scanner = new Scanner(System.in);
    
     
    
        public HoaDon(String maHoaDon, LocalDate ngayLapHoaDon, int soLuong, double tongSoTien, NhanVien nhanVienLapHoaDon,
                KhuyenMai khuyenMai, DoiTra doiTra, KhachHang khachHang, SanPham sanPham, double tienThue, double chietKhau,
                String phuongThucThanhToan, ChiTietHoaDon[] danhSachChiTiet) {
            this.maHoaDon = maHoaDon;
            this.ngayLapHoaDon = ngayLapHoaDon;
            this.soLuong = soLuong;
            this.tongSoTien = tongSoTien;
            this.nhanVienLapHoaDon = nhanVienLapHoaDon;
            this.khuyenMai = khuyenMai;
            this.doiTra = doiTra;
            this.khachHang = khachHang;
            this.sanPham = sanPham;
            this.tienThue = tienThue;
            this.chietKhau = chietKhau;
            this.phuongThucThanhToan = phuongThucThanhToan;
            this.danhSachChiTiet = danhSachChiTiet;
            this.soLuongChiTiet = 0;
    }

    public void themChiTietHoaDon(ChiTietHoaDon cthd) {
        if (soLuongChiTiet < danhSachChiTiet.length) {
            danhSachChiTiet[soLuongChiTiet] = cthd;
            soLuongChiTiet++;
        } else {
            System.out.println("Khong the them do danh sach da day");
        }
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

         khachHang = KhachHang.timKiemKhachHangTheoSdt(soDienThoai);
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

        int soLuongSanPham = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < soLuongSanPham; i++) {
            System.out.println("Nhap thong tin choi tiet san pham thu " + (i + 1) + ":");
            ChiTietHoaDon cthd = new ChiTietHoaDon();
            cthd.input(i);
            themChiTietHoaDon(cthd);
        }
        }

@Override
public String toString() {
    StringBuilder builder = new StringBuilder();
    
    // Thêm thông tin cơ bản của hóa đơn
    builder.append(super.toString())
           .append("HoaDon{")
           .append("maHoaDon='").append(maHoaDon).append('\'')
           .append(", ngayLapHoaDon=").append(ngayLapHoaDon)
           .append(", soLuong=").append(soLuong)
           .append(", tongSoTien=").append(tongSoTien)
           .append(", nhanVienLapHoaDon=").append(nhanVienLapHoaDon)
           .append(", khuyenMai=").append(khuyenMai)
           .append(", khachHang='").append(khachHang).append('\'')
           .append(", sanPham=").append(sanPham)
           .append(", tienThue=").append(tienThue)
           .append(", chietKhau=").append(chietKhau)
           .append(", phuongThucThanhToan='").append(phuongThucThanhToan).append('\'')
           .append("}\n");

    // Thêm danh sách chi tiết hóa đơn
    builder.append("Danh sách chi tiết hóa đơn:\n");
    for (int i = 0; i < soLuongChiTiet; i++) {
        builder.append(String.format("\tChi tiết %d: %s\n", i + 1, danhSachChiTiet[i] != null ? danhSachChiTiet[i].toString() : "N/A"));
    }

    return builder.toString();
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

        public void fromString(String string) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'fromString'");
        }

     }


