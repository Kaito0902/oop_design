package HoaDon;
import java.time.LocalDate;
import java.util.Scanner;

import KhachHang.KhachHang;
import NhanVien.NhanVien;
import SanPham.SanPham;



public class HoaDon {
    protected String maHoaDon;
    protected int ngayLapHoaDon;
    protected LocalDate ngayDenHanThanhToan;
    protected int soLuong;
    protected double tongSoTien;
    protected NhanVien nhanVienLapHoaDon;
    protected KhuyenMai khuyenMai;
    protected DoiTra doiTra;
    protected KhachHang khachHang;
    protected SanPham sanPham;
    protected double doanhThuHoaDon;
    protected double tienThue;
    protected double chietKhau;
    protected String phuongThucThanhToan;

    static Scanner scanner = new Scanner(System.in);

    public HoaDon() {
    }

    public HoaDon(String maHoaDon, int ngayLapHoaDon, LocalDate ngayDenHanThanhToan, int soLuong, double tongSoTien,
            NhanVien nhanVienLapHoaDon, KhuyenMai khuyenMai, SanPham sanPham, double doanhThuHoaDon, double tienThue,
            double chietKhau, String phuongThucThanhToan) {
        this.maHoaDon = maHoaDon;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.ngayDenHanThanhToan = ngayDenHanThanhToan;
        this.soLuong = soLuong;
        this.tongSoTien = tongSoTien;
        this.nhanVienLapHoaDon = nhanVienLapHoaDon;
        this.khuyenMai = khuyenMai;
        this.sanPham = sanPham;
        this.doanhThuHoaDon = doanhThuHoaDon;
        this.tienThue = tienThue;
        this.chietKhau = chietKhau;
        this.phuongThucThanhToan = phuongThucThanhToan;
    }
    public void input() {
        System.out.print("Nhap ma hoa don: "); 
        maHoaDon = scanner.nextLine(); 

        System.out.print("Nhap ngay lap hoa don: "); 
        ngayLapHoaDon = Integer.parseInt(scanner.nextLine()); 

        System.out.print("Nhap ngay den han thanh toan: ");
        ngayDenHanThanhToan = LocalDate.parse(scanner.nextLine()); 

        System.out.print("Nhap so luong: "); 
        soLuong = Integer.parseInt(scanner.nextLine()); 

        System.out.print("Nhap tong so tien: "); 
        tongSoTien = Double.parseDouble(scanner.nextLine());


        
        System.out.print("Nhap doanh thu hoa don: "); 
        doanhThuHoaDon = Double.parseDouble(scanner.nextLine()); 

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
                ", ngayDenHanThanhToan=" + ngayDenHanThanhToan +
                ", soLuong=" + soLuong +
                ", tongSoTien=" + tongSoTien +
                ", nhanVienLapHoaDon=" + nhanVienLapHoaDon +
                ", khuyenMai=" + khuyenMai +
                ", khachHang='" + khachHang + '\'' +
                ", sanPham=" + sanPham +
                ", doanhThuHoaDon=" + doanhThuHoaDon +
                ", tienThue=" + tienThue +
                ", chietKhau=" + chietKhau +
                ", phuongThucThanhToan='" + phuongThucThanhToan + '\'' +
                '}';
        }
        public void xuat(){
            System.out.println(toString());
        }

     }


