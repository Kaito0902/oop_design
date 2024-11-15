package HoaDon;

import java.time.LocalDate;
import java.util.Scanner;

public class HoaDonBanHang extends HoaDon {
    private ChiTietHoaDon[] chiTietHoaDonList;
    private int soLuongChiTiet; // So luong chi tiet hien tai
    private final int MAX_CHI_TIET = 100; // So luong chi tiet toi da

    static Scanner scanner = new Scanner(System.in);

    public HoaDonBanHang() {
        super();
        chiTietHoaDonList = new ChiTietHoaDon[MAX_CHI_TIET];
        soLuongChiTiet = 0;
    }

    @Override
    public void input() {
        super.input(); // Goi phuong thuc nhap tu lop cha
        System.out.print("Nhap so luong chi tiet hoa don: ");
        int soLuong = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < soLuong; i++) {
            if (soLuongChiTiet < MAX_CHI_TIET) {
                System.out.println("Nhap chi tiet hoa don thu " + (soLuongChiTiet + 1) + ":");
                ChiTietHoaDon chiTiet = new ChiTietHoaDon();
                chiTiet.input(i);
                chiTietHoaDonList[soLuongChiTiet] = chiTiet;
                soLuongChiTiet++;
                tongSoTien += chiTiet.getThanhTien();
            } else {
                System.out.println("Khong the them chi tiet hoa don, da dat so luong toi da.");
                break;
            }
        }
    }

    public ChiTietHoaDon[] getChiTietHoaDonList() {
        return chiTietHoaDonList;
    }

    public int getSoLuongChiTiet() {
        return soLuongChiTiet;
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Chi tiet hoa don:");
        System.out.printf("%-10s %-20s %-10s %-15s %-15s\n", "STT", "Ten SP", "So luong", "Don gia", "Thanh tien");
        for (int i = 0; i < soLuongChiTiet; i++) {
            chiTietHoaDonList[i].xuat();
        }
    }
}
