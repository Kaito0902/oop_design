package HoaDon;

import java.util.Scanner;
import SanPham.SanPham;

public class ChiTietHoaDonDoiTra {
    private int stt; 
    private SanPham sanPhamTra;
    private int soLuong; 
    private String lyDo; 
    private String tinhTrang; 
    private double thanhTien; // Thanh tien hoan tra
    static Scanner sc = new Scanner(System.in);

    public ChiTietHoaDonDoiTra() {
    }
    public ChiTietHoaDonDoiTra(int stt, SanPham sanPhamTra, int soLuong, String lyDo, String tinhTrang) {
        this.stt = stt;
        this.sanPhamTra = sanPhamTra;
        this.soLuong = soLuong;
        this.lyDo = lyDo;
        this.tinhTrang = tinhTrang;
        tinhThanhTien();
    }

    public int getStt() {
        return stt;
    }
    
    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
    public static Scanner getSc() {
        return sc;
    }
    public static void setSc(Scanner sc) {
        ChiTietHoaDonDoiTra.sc = sc;
    }
    public void setStt(int stt) {
        this.stt = stt;
    }

    public SanPham getSanPhamTra() {
        return sanPhamTra;
    }

    public void setSanPhamTra(SanPham sanPhamTra) {
        this.sanPhamTra = sanPhamTra;
        tinhThanhTien();
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
        tinhThanhTien();
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    // Phuong thuc tinh lai thanh tien
    private void tinhThanhTien() {
        if (sanPhamTra != null) {
            this.thanhTien = this.soLuong * sanPhamTra.getGiaBan();
        } else {
            this.thanhTien = 0;
        }
    }

    public void input(int stt) {
        this.stt = stt;

        System.out.print("Nhap ma san pham tra: ");
        String maSanPham = sc.nextLine();
        // Lay thong tin san pham tra
        this.sanPhamTra = SanPham.timKiemSanPhamTheoMa(maSanPham);
        if (sanPhamTra == null) {
            System.out.println("San pham khong ton tai!");
            return;
        }
        else
            setSanPhamTra(sanPhamTra);


        System.out.println("Nhap so luong tra: ");
        this.soLuong = Integer.parseInt(sc.nextLine());

        System.out.println("Nhap ly do tra: ");
        this.lyDo = sc.nextLine();

        System.out.println("Nhap tinh trang san pham tra: ");
        this.tinhTrang = sc.nextLine();

        tinhThanhTien();
    }

    public void output() {
       System.out.println(toString());
    }

    // Chuyen doi thanh chuoi
    @Override
    public String toString() {
        return String.format(
            "STT: %d\nSan pham tra: %s\nSo luong: %d\nLy do: %s\nTinh trang: %s\nThanh tien: %.2f",
            stt,
            sanPhamTra != null ? sanPhamTra.toString() : "Khong co san pham",
            soLuong,
            lyDo,
            tinhTrang,
            thanhTien
        );
    }
}
