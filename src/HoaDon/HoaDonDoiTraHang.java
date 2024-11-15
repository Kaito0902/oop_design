package HoaDon;

import java.util.Scanner;

public class HoaDonDoiTraHang extends HoaDon {
    private ChiTietHoaDon[] chiTietDoiTraList;
    private int soLuongDoiTra;
    private final int MAX_DOI_TRA = 100;
    private String lyDoDoiTra;

    static Scanner scanner = new Scanner(System.in);

    public HoaDonDoiTraHang() {
        super();
        chiTietDoiTraList = new ChiTietHoaDon[MAX_DOI_TRA];
        soLuongDoiTra = 0;
    }
    
    public ChiTietHoaDon[] getChiTietDoiTraList() {
        return chiTietDoiTraList;
    }

    public void setChiTietDoiTraList(ChiTietHoaDon[] chiTietDoiTraList) {
        this.chiTietDoiTraList = chiTietDoiTraList;
    }

    public int getSoLuongDoiTra() {
        return soLuongDoiTra;
    }

    public void setSoLuongDoiTra(int soLuongDoiTra) {
        this.soLuongDoiTra = soLuongDoiTra;
    }

    public int getMAX_DOI_TRA() {
        return MAX_DOI_TRA;
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setScanner(Scanner scanner) {
        HoaDonDoiTraHang.scanner = scanner;
    }

    @Override
    public void input() {
        super.input();

        System.out.print("Nhap ly do doi tra: ");
        lyDoDoiTra = scanner.nextLine();

        System.out.print("Nhap so luong chi tiet doi tra: ");
        int soLuong = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < soLuong; i++) {
            if (soLuongDoiTra < MAX_DOI_TRA) {
                System.out.println("Nhap chi tiet doi tra thu " + (soLuongDoiTra + 1) + ":");
                ChiTietHoaDon chiTiet = new ChiTietHoaDon();
                chiTiet.input(i);;
                chiTietDoiTraList[soLuongDoiTra] = chiTiet;
                soLuongDoiTra++;
                tongSoTien -= chiTiet.getThanhTien();
            } else {
                System.out.println("Khong the them chi tiet doi tra, da dat so luong toi da.");
                break;
            }
        }
    }

    public String getLyDoDoiTra() {
        return lyDoDoiTra;
    }

    public void setLyDoDoiTra(String lyDoDoiTra) {
        this.lyDoDoiTra = lyDoDoiTra;
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Ly do doi tra: " + lyDoDoiTra);
        System.out.println("Chi tiet doi tra:");
        System.out.printf("%-10s %-20s %-10s %-15s %-15s\n", "STT", "Ten SP", "So luong", "Don gia", "Thanh tien");
        for (int i = 0; i < soLuongDoiTra; i++) {
            chiTietDoiTraList[i].xuat();
        }
    }
}
