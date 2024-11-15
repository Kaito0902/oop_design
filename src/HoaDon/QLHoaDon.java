package HoaDon;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class QLHoaDon {
    private HoaDon[] dshd = new HoaDon[0];
    private static final Scanner sc = new Scanner(System.in);

    // Thêm hóa đơn mới
    public void themHD(HoaDon hd) {
        dshd = Arrays.copyOf(dshd, dshd.length + 1);
        dshd[dshd.length - 1] = hd;
    }

    // Xuất danh sách hóa đơn
    public void xuatdshd() {
        if (dshd.length == 0) {
            System.out.println("Danh sach hoa don trong!");
            return;
        }
        for (HoaDon hd : dshd) {
            if (hd != null) {
                System.out.println(hd instanceof HoaDonBanHang ? "Loai hoa don: HoaDonBanHang" : "Loai hoa don: HoaDonDoiTraHang");
                hd.xuat();
            }
        }
    }

    // Tìm kiếm hóa đơn theo tên khách hàng
    public void timKiemHoaDon() {
        System.out.print("Nhap ten khach hang can tim: ");
        String tenKhachHang = sc.nextLine();
        boolean found = false;
        for (HoaDon hd : dshd) {
            if (hd != null && hd.getKhachHang().equalsIgnoreCase(tenKhachHang)) {
                System.out.println("Hoa don tim thay:");
                hd.xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay hoa don cua khach hang: " + tenKhachHang);
        }
    }

    // Sắp xếp danh sách hóa đơn theo tổng tiền giảm dần
    public void sapXep() {
        Arrays.sort(dshd, (hd1, hd2) -> {
            if (hd1 == null) return 1;
            if (hd2 == null) return -1;
            return Double.compare(hd2.getTongSoTien(), hd1.getTongSoTien());
        });
        System.out.println("Danh sach hoa don da sap xep theo tong tien (giam dan).");
    }

    // Lấy số lượng hóa đơn hiện tại
    public void laySLHoaDon() {
        System.out.println("So luong hoa don hien tai: " + dshd.length);
    }

    // Ghi danh sách hóa đơn vào file
    public void ghiVaoFileDSHD() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("DanhSachHoaDon.txt"))) {
            for (HoaDon hd : dshd) {
                if (hd != null) {
                    writer.write(hd instanceof HoaDonBanHang ? "HoaDonBanHang," : "HoaDonDoiTraHang,");
                    writer.write(hd.toString());
                    writer.newLine();
                }
            }
            System.out.println("Ghi file thanh cong!");
        } catch (IOException e) {
            System.err.println("Loi khi ghi file: " + e.getMessage());
        }
    }

    // Đọc danh sách hóa đơn từ file
    public void docTuFileDSHD() {
        try (BufferedReader reader = new BufferedReader(new FileReader("DanhSachHoaDon.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 2);
                HoaDon hd;
                if (parts[0].equals("HoaDonBanHang")) {
                    hd = new HoaDonBanHang();
                } else if (parts[0].equals("HoaDonDoiTraHang")) {
                    hd = new HoaDonDoiTraHang();
                } else {
                    System.err.println("Loai hoa don khong hop le: " + parts[0]);
                    continue;
                }
                hd.fromString(parts[1]); // Phương thức fromString trong mỗi lớp hóa đơn
                themHD(hd);
            }
            System.out.println("Doc file thanh cong!");
        } catch (IOException e) {
            System.err.println("Loi khi doc file: " + e.getMessage());
        }
    }

    // Tính tổng số tiền của khách hàng theo mã
    public double getTongSoTien(String maKhachHang) {
        return Arrays.stream(dshd)
                .filter(hd -> hd != null && hd.getmaKhachHang().equals(maKhachHang))
                .mapToDouble(HoaDon::getTongSoTien)
                .sum();
    }

    // Menu chính
    public void menu() {
        boolean running = true;
        while (running) {
            System.out.println("===================================");
            System.out.println("|            MENU CHINH           |");
            System.out.println("===================================");
            System.out.println("1. Them hoa don");
            System.out.println("2. Xuat danh sach hoa don");
            System.out.println("3. Tim kiem hoa don");
            System.out.println("4. Sap xep danh sach hoa don");
            System.out.println("5. Lay so luong hoa don");
            System.out.println("6. Ghi vao file");
            System.out.println("7. Doc tu file");
            System.out.println("8. Tinh tong so tien theo ma KH");
            System.out.println("0. Thoat chuong trinh");
            System.out.print("Nhap lua chon: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> {
                    System.out.println("1: HoaDonBanHang | 2: HoaDonDoiTraHang");
                    int loai = Integer.parseInt(sc.nextLine());
                    HoaDon hd = loai == 1 ? new HoaDonBanHang() : loai == 2 ? new HoaDonDoiTraHang() : null;
                    if (hd != null) {
                        hd.input();
                        themHD(hd);
                    } else {
                        System.out.println("Loai hoa don khong hop le!");
                    }
                }
                case 2 -> xuatdshd();
                case 3 -> timKiemHoaDon();
                case 4 -> sapXep();
                case 5 -> laySLHoaDon();
                case 6 -> ghiVaoFileDSHD();
                case 7 -> docTuFileDSHD();
                case 8 -> {
                    System.out.print("Nhap ma khach hang: ");
                    String maKH = sc.nextLine();
                    System.out.println("Tong so tien: " + getTongSoTien(maKH));
                }
                case 0 -> {
                    running = false;
                    System.out.println("Thoat chuong trinh.");
                }
                default -> System.out.println("Lua chon khong hop le!");
            }
        }
    }
}
