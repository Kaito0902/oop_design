package DonDatHang;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import SanPham.SanPham;

public class QLDonDatHang {
    private int soLuongDonHang;
    DonDatHang[] dsddh = new DonDatHang[0];
    static Scanner sc = new Scanner(System.in);

    public void themDDH(DonDatHang ddh) {
        DonDatHang[] newdsddh = Arrays.copyOf(dsddh, dsddh.length + 1);
        newdsddh[dsddh.length] = ddh;
        dsddh = newdsddh;
    }

    public void xuatDDH() {
        for (DonDatHang i : dsddh) {
            i.xuat();
        }
    }

    public void xoaDonDatHang(String maDonDatHang) {
        boolean found = false;
        for (int i = 0; i < dsddh.length; i++) {
            if (dsddh[i].maDonDatHang.equals(maDonDatHang)) {
                for (int j = i; j < dsddh.length - 1; j++) {
                    dsddh[j] = dsddh[j + 1];
                }
                dsddh = Arrays.copyOf(dsddh, dsddh.length - 1);
                soLuongDonHang--;
                found = true;
                System.out.println("Da xoa don dat hang co ma: " + maDonDatHang);
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay don dat hang co ma: " + maDonDatHang);
        }
    }

    public void timKiemDonDatHangTongTien(double tongTien) {
        boolean found = false;
        for (DonDatHang ddh : dsddh) {
            if (ddh.tongTien == tongTien) {
                System.out.println(ddh);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong co don dat hang nao voi tong tien: " + tongTien);
        }
    }

    public void sapXepDonDatHangTheoGia() {
        Arrays.sort(dsddh, (a, b) -> Double.compare(a.tongTien, b.tongTien));
        System.out.println("Danh sach don dat hang da duoc sap xep theo gia.");
    }

    public void laySoLuongDonDatHang() {
        System.out.println("So luong hoa don hien tai: " + dsddh.length);
    }

    // Phuong thuc ghi danh sach don dat hang vao file
    public void ghiVaoFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("danhSachDonDatHang.txt"))) {
            for (DonDatHang ddh : dsddh) {
                writer.write(ddh.toString());
                writer.newLine();
            }
            System.out.println("Ghi file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    // Phuong thuc doc danh sach don dat hang tu file
    public void docTuFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("danhSachDonDatHang.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 12) {
                   
                    String maDonDatHang = data[0];
                    LocalDate ngayDatHang = LocalDate.parse(data[1]);
                    LocalDate ngayGiaoHang = LocalDate.parse(data[2]);
                    String sanPham =  data[3];
                    double tongTien = Double.parseDouble(data[4]);
                    double soLuong = Double.parseDouble(data[5]);
                    String nhaCungCap =  data[6];
                    String hinhThucGiaoHang = data[7];
                    Double doanhThuDonDatHang = Double.parseDouble(data[8]);
                   
                    DonDatHang ddh = new DonDatHang(maDonDatHang, ngayDatHang, ngayGiaoHang, sanPham, tongTien, soLuong, nhaCungCap, hinhThucGiaoHang, doanhThuDonDatHang);
                    themDDH(ddh);
                }
            }
            System.out.println("Doc file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Loi dinh dang so trong du lieu: " + e.getMessage());
        }
    }

    public void menu() {
        int choice;
        do {
            System.out.println("===== QUAN LY DON DAT HANG =====");
            System.out.println("1. Them don dat hang");
            System.out.println("2. Xuat danh sach don dat hang");
            System.out.println("3. Xoa don dat hang");
            System.out.println("4. Tim kiem don dat hang theo tong tien");
            System.out.println("5. Sap xep don dat hang theo gia");
            System.out.println("6. Lay so luong don dat hang");
            System.out.println("7. Ghi danh sach vao file");
            System.out.println("8. Doc danh sach tu file");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    DonDatHang ddh = new DonDatHang();
                    ddh.nhap();
                    themDDH(ddh);
                }
                case 2 -> xuatDDH();
                case 3 -> {
                    System.out.print("Nhap ma don dat hang can xoa: ");
                    String maXoa = sc.nextLine();
                    xoaDonDatHang(maXoa);
                }
                case 4 -> {
                    System.out.print("Nhap tong tien can tim: ");
                    double tongTienTimKiem = sc.nextDouble();
                    timKiemDonDatHangTongTien(tongTienTimKiem);
                }
                case 5 -> sapXepDonDatHangTheoGia();
                case 6 -> laySoLuongDonDatHang();
                case 7 -> ghiVaoFile();
                case 8 -> docTuFile();
                case 0 -> System.out.println("Thoat chuong trinh.");
                default -> System.out.println("Lua chon khong hop le.");
            }
        } while (choice != 0);
    }
}
