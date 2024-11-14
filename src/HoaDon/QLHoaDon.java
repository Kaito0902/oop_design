package HoaDon;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class QLHoaDon {
    HoaDon[] dshd = new HoaDon[0];
    private static Scanner sc = new Scanner(System.in);

    public void themHD(HoaDon hd) {
        HoaDon[] newdshd = Arrays.copyOf(dshd, dshd.length + 1);
        newdshd[dshd.length] = hd;
        dshd = newdshd;
    }

    public void xuatdshd() {
        for (HoaDon x : dshd) {
            if (x != null) x.xuat();
        }
    }

    // Phương thức tìm kiếm hóa đơn theo tên khách hàng
    public void timKiemHoaDon() {
        System.out.print("Nhap ten khach hang can tim: ");
        String tenKhachHang = sc.nextLine();
        boolean found = false;

        for (HoaDon hd : dshd) {
            if (hd != null && hd.getKhachHang().equalsIgnoreCase(tenKhachHang)) {
                System.out.println("Hoa don tim thay: ");
                hd.xuat();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay hoa don cho khach hang co ten: " + tenKhachHang);
        }
    }

    // Phương thức sắp xếp danh sách hóa đơn theo tổng tiền giảm dần
    public void sapXep() {
        Arrays.sort(dshd, (hd1, hd2) -> {
            if (hd1 == null) return 1;
            if (hd2 == null) return -1;
            return Double.compare(hd2.getTongSoTien(), hd1.getTongSoTien());
        });
        System.out.println("Danh sach hoa don da duoc sap xep theo gia tien (giam dan).");
    }

    public void laySLHoaDon() {
        int count = 0;
        for (HoaDon hd : dshd) {
            if (hd != null) count++;
        }
        System.out.println("So luong hoa don hien tai: " + count);
    }

    public void ghiVaoFileDSHD() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\ADMIN\\oop_design\\src\\HoaDon\\DanhSachHoaDon.txt"))) {
            for (HoaDon hd : dshd) {
                if (hd != null) {
                    writer.write(String.join(",",
                            hd.getMaHoaDon(),
                            hd.getNgayLapHoaDon().toString(),
                            String.valueOf(hd.getSoLuong()),
                            String.valueOf(hd.getTongSoTien()),
                            hd.getKhachHang(),
                            String.valueOf(hd.getTienThue()),
                            String.valueOf(hd.getChietKhau()),
                            hd.getPhuongThucThanhToan()
                    ));
                    writer.newLine();
                }
            }
            System.out.println("Ghi file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    // Phương thức đọc danh sách hóa đơn từ file
    public void docTuFileDSHD() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ADMIN\\oop_design\\src\\HoaDon\\DanhSachHoaDon.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length > 0) {
                    String maHoaDon = data[0];
                    LocalDate ngayLapHoaDon = LocalDate.parse(data[1]);
                    int soLuong = Integer.parseInt(data[2]);
                    double tongSoTien = Double.parseDouble(data[3]);
                    String tenKhachHang = data[4];
                    double tienThue = Double.parseDouble(data[5]);
                    double chietKhau = Double.parseDouble(data[6]);
                    String phuongThucThanhToan = data[7];

                    HoaDon hd = new HoaDon(maHoaDon, ngayLapHoaDon, soLuong, tongSoTien, tenKhachHang, tienThue, chietKhau, phuongThucThanhToan);
                    themHD(hd);
                }
            }
            System.out.println("Doc file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Loi dinh dang so trong du lieu: " + e.getMessage());
        }
    }

    // Phương thức tính tổng số tiền của khách hàng theo mã khách hàng
    public double getTongSoTien(String maKhachHang) {
        double tongSoTien = 0;
        for (HoaDon hd : dshd) {
            if (hd != null && hd.getmaKhachHang().equals(maKhachHang)) {
                tongSoTien += hd.getTongSoTien();
            }
        }
        return tongSoTien;
    }

    // Menu để sử dụng các chức năng
    public void menu() {
        boolean kt = true;
        int choice;
        do {
            System.out.println("===================================");
            System.out.println("|\t        MENU CHINH         \t|");
            System.out.println("===================================");
            System.out.printf("| %-31s|\n", "1. Them hoa don");
            System.out.printf("| %-31s|\n", "2. Xuat danh sach hoa don");
            System.out.printf("| %-31s|\n", "3. Tim kiem hoa don");
            System.out.printf("| %-31s|\n", "4. Sap xep danh sach hoa don");
            System.out.printf("| %-31s|\n", "5. Lay so luong hoa don");
            System.out.printf("| %-31s|\n", "6. Ghi vao file");
            System.out.printf("| %-31s|\n", "7. Doc tu file");
            System.out.printf("| %-31s|\n", "8. Tinh tong so tien theo ma KH");
            System.out.printf("| %-31s|\n", "0. Thoat chuong trinh");
            System.out.println("===================================");
            System.out.print("Nhap lua chon: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> {
                    HoaDon a = new HoaDon();
                    a.input();
                    themHD(a);
                }
                case 2 -> {
                    System.out.println("Danh sach hoa don:");
                    xuatdshd();
                }
                case 3 -> timKiemHoaDon();
                case 4 -> sapXep();
                case 5 -> laySLHoaDon();
                case 6 -> ghiVaoFileDSHD();
                case 7 -> docTuFileDSHD();
                case 8 -> {
                    System.out.print("Nhap ma khach hang: ");
                    String maKH = sc.nextLine();
                    double tongTien = getTongSoTien(maKH);
                    System.out.println("Tong so tien cua khach hang " + maKH + ": " + tongTien);
                }
                case 0 -> {
                    kt = false;
                    System.out.println("Da thoat chuong trinh");
                }
                default -> System.out.println("Lua chon khong hop le, vui long nhap lai.");
            }
        } while (kt);
    }
}
