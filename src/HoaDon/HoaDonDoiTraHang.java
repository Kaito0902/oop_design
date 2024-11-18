package HoaDon;

import java.util.Scanner;

public class HoaDonDoiTraHang extends HoaDon {
    private HoaDon hoaDonGoc; 
    private ChiTietHoaDonDoiTra[] dsChiTiet; 
    private int soLuongChiTiet; 
    private double tongGiaTri; // tong so tien hoan trra
    private String ghiChu; 
    private double tienHoanTra; // Số tiền hoàn trả sau khi trừ %
    private double tiLeTru; // Tỷ lệ phần trăm trừ vào số tiền hoàn trả

    private final int MAX_CHI_TIET = 100;
    static Scanner scanner = new Scanner(System.in);

    public HoaDonDoiTraHang() {
        super();
        this.dsChiTiet = new ChiTietHoaDonDoiTra[MAX_CHI_TIET];
        this.soLuongChiTiet = 0;
        this.tongGiaTri = 0;
        this.tienHoanTra = 0;
        this.tiLeTru = 0;
    }

    // Nhập thông tin hóa đơn đổi trả
    @Override
    public void input() {
        super.input();

        System.out.println("Nhap thong tin hoa don goc:");
        this.hoaDonGoc = new HoaDonBanHang();
        this.hoaDonGoc.input();

        System.out.print("Nhap so luong chi tiet doi tra: ");
        int soLuong = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < soLuong; i++) {
            if (soLuongChiTiet < MAX_CHI_TIET) {
                System.out.println("Nhap chi tiet doi tra thu " + (soLuongChiTiet + 1) + ":");
                ChiTietHoaDonDoiTra chiTiet = new ChiTietHoaDonDoiTra();
                chiTiet.input(soLuongChiTiet + 1);
                dsChiTiet[soLuongChiTiet++] = chiTiet;
            } else {
                System.out.println("Khong the them chi tiet, da dat so luong toi da.");
                break;
            }
        }

        System.out.print("Nhap ty le tru (%): ");
        this.tiLeTru = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhap ghi chu: ");
        this.ghiChu = scanner.nextLine();
        tinhTongGiaTri();
    }

    // Tính tổng giá trị hoàn trả và áp dụng tỷ lệ trừ
    private void tinhTongGiaTri() {
        this.tongGiaTri = 0;
        for (int i = 0; i < soLuongChiTiet; i++) {
            this.tongGiaTri += dsChiTiet[i].getThanhTien();
        }
        this.tienHoanTra = this.tongGiaTri * (1 - tiLeTru / 100);
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Hoa don goc:");
        hoaDonGoc.xuat();

        System.out.println("Danh sach chi tiet doi tra:");
        System.out.printf("%-5s %-20s %-10s %-20s %-20s %-15s\n", 
                          "STT", "Ten SP", "So luong", "Ly do", "Tinh trang", "Thanh tien");
        for (int i = 0; i < soLuongChiTiet; i++) {
            dsChiTiet[i].xuat();
        }

        System.out.printf("Tong gia tri truoc khi tru: %.2f\n", tongGiaTri);
        System.out.printf("Ty le tru: %.2f%%\n", tiLeTru);
        System.out.printf("Tien hoan tra sau khi tru: %.2f\n", tienHoanTra);
        System.out.println("Ghi chu: " + ghiChu);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(",").append(hoaDonGoc.toString());
        for (int i = 0; i < soLuongChiTiet; i++) {
            builder.append(",").append(dsChiTiet[i].toString());
        }
        builder.append(",").append(tongGiaTri)
               .append(",").append(tiLeTru)
               .append(",").append(tienHoanTra)
               .append(",").append(ghiChu);
        return builder.toString();
    }
}
