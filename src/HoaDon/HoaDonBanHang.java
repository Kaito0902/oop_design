package HoaDon;

import java.time.LocalDate;
import java.util.Arrays;

import KhachHang.KhachHang;
import KhuyenMai.KhuyenMai;
import NhanVien.NhanVien;

import static main_project.oop_project.qlkm;

public class HoaDonBanHang extends HoaDon {
    private ChiTietHoaDonBanHang[] chiTietHoaDonBanHangList = new ChiTietHoaDonBanHang[0]; // Danh sách chi tiết hóa đơn
    private int soLuongChiTiet = 0;
    private KhuyenMai khuyenMai; // Chương trình khuyến mãi
    private double tienThue;
    private double chietKhau;
    private String phuongThucThanhToan; 
    private double tongTien; // Tổng tiền của hóa đơn

    // Constructor mặc định
    public HoaDonBanHang() {
    }

    // constructor day du tham so
    public HoaDonBanHang(String maHoaDon, LocalDate ngayLapHoaDon, NhanVien nhanVienLapHoaDon, KhachHang khachHang,String loaiHoaDon, ChiTietHoaDonBanHang[] chiTietHoaDonList, int soLuongChiTiet, KhuyenMai khuyenMai, double tienThue, double chietKhau, String phuongThucThanhToan, double tongTien) {
        super(maHoaDon, ngayLapHoaDon, nhanVienLapHoaDon, khachHang, loaiHoaDon);
        this.chiTietHoaDonBanHangList = chiTietHoaDonList;
        this.soLuongChiTiet = soLuongChiTiet;
        this.khuyenMai = khuyenMai;
        this.tienThue = tienThue;
        this.chietKhau = chietKhau;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.tongTien = tongTien;
    }

    public ChiTietHoaDonBanHang[] getChiTietHoaDonBanHangList() {
        return chiTietHoaDonBanHangList;
    }

    public int getSoLuongChiTiet() {
        return soLuongChiTiet;
    }

    public KhuyenMai getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(KhuyenMai khuyenMai) {
        while (khuyenMai == null) {
            System.out.println("Nhap lai ma khuyen mai:");
            khuyenMai = qlkm.timKhuyenMai(scanner.nextLine());
        }
        this.khuyenMai = khuyenMai;
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

    public double getTongTien() {
        return tongTien;
    }

    public void setChiTietHoaDonBanHangList(ChiTietHoaDonBanHang[] chiTietHoaDonBanHangList) {
        this.chiTietHoaDonBanHangList = chiTietHoaDonBanHangList;
    }

    public void setSoLuongChiTiet(int soLuongChiTiet) {
        this.soLuongChiTiet = soLuongChiTiet;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public void themChiTietHoaDonBanHang(ChiTietHoaDonBanHang chiTietHoaDonBanHang) {
        ChiTietHoaDonBanHang[] newdsChiTietHoaDonBanHang = Arrays.copyOf(chiTietHoaDonBanHangList, soLuongChiTiet + 1);
        newdsChiTietHoaDonBanHang[soLuongChiTiet] = chiTietHoaDonBanHang;
        chiTietHoaDonBanHangList = newdsChiTietHoaDonBanHang;
        soLuongChiTiet++;
    }

    @Override
    public void input() {
        super.input(); 
        loaiHoaDon = "HoaDonBanHang";

        System.out.print("Nhap so luong chi tiet hoa don: ");
        int soLuong = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= soLuong; i++) {
            System.out.println("Nhap chi tiet hoa don thu " + (i + 1) + ":");
            ChiTietHoaDonBanHang chiTiet = new ChiTietHoaDonBanHang();
            chiTiet.input(1);
            themChiTietHoaDonBanHang(chiTiet);
        }

        System.out.print("Nhap tien thue (theo %): ");
        setTienThue(Double.parseDouble(scanner.nextLine()));

        System.out.print("Nhap chiet khau (theo %): ");
        setChietKhau(Double.parseDouble(scanner.nextLine()));

        System.out.print("Nhap phuong thuc thanh toan: ");
        setPhuongThucThanhToan(scanner.nextLine());

        //muon nhap km hay ko
        
        System.out.println("Nhap ma khuyen mai:");

        setKhuyenMai(qlkm.timKhuyenMai(scanner.nextLine()));

        tinhTongTien(); // Tính tổng tiền hóa đơn
    }


    // Phương thức tính tổng tiền hóa đơn
    public void tinhTongTien() {
        tongTien = 0;
        for (int i = 0; i < soLuongChiTiet; i++) {
            tongTien += chiTietHoaDonBanHangList[i].getThanhTien();
        }
        tongTien += tongTien * (tienThue / 100); // Thêm thuế
        tongTien -= tongTien * (chietKhau / 100); // Trừ chiết khấu
        tongTien -= tongTien * (khuyenMai.getTongKhuyenMai()/100); // Trừ khuyến mãi
    }

//     Ghi thông tin ra chuỗi (hỗ trợ ghi file)
//    @Override
//    public String toString() {
//        String.format("")
//    }

// private ChiTietHoaDonBanHang[] chiTietHoaDonBanHangList = new ChiTietHoaDonBanHang[0]; // Danh sách chi tiết hóa đơn


@Override
public String toString() {
    // TODO Auto-generated method stub
    return super.toString()+String.format( "%-10d %-20s %-10.2f %-10.2f %-20s %-10.2f",soLuongChiTiet,khuyenMai.getTenKhuyenMai(),tienThue,chietKhau,phuongThucThanhToan,tongTien );
}


}



