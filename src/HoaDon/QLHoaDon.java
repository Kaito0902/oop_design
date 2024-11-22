package HoaDon;


import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

import KhachHang.KhachHang;
import KhuyenMai.KhuyenMai;
import NhanVien.NhanVien;

public class QLHoaDon {
    HoaDon[] dshd = new HoaDon[0];
    private static final Scanner sc = new Scanner(System.in);

    public void themHD(HoaDon hd) {
        dshd = Arrays.copyOf(dshd, dshd.length + 1);
        dshd[dshd.length - 1] = hd;
    }

    public void xuatdshd() {
        if (dshd.length == 0) {
            System.out.println("Danh sach hoa don trong!");
            return;
        }
        for (HoaDon hd : dshd) {
            if (hd != null) {
                System.out.println(hd instanceof HoaDonBanHang ? "Loai hoa don: HoaDonBanHang" : "Loai hoa don: HoaDonDoiTraHang");
                hd.output();
            }
        }
    }

    public void timKiemHoaDonTheoMa() {
        System.out.print("Nhap ma hoa don can tim: ");
        String maHoaDon = sc.nextLine();
        boolean found = false;
        for (HoaDon hd : dshd) {
            if (hd != null && hd.getMaHoaDon().equals(maHoaDon)) {
                System.out.println("Hoa don tim thay:");
                hd.output();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay hoa don co ma: " + maHoaDon);
        }
    }

    public void timKiemHoaDonTheoTen() {
        System.out.print("Nhap ten khach hang can tim: ");
        String tenKhachHang = sc.nextLine();
        boolean found = false;
        for (HoaDon hd : dshd) {
            if (hd != null && hd.getKhachHang().gettenKhachHang().equalsIgnoreCase(tenKhachHang)) {
                System.out.println("Hoa don tim thay:");
                hd.output();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay hoa don cua khach hang: " + tenKhachHang);
        }
    }
    // sap xep theo tong tien hoadon
    public void sapXep() {
        Arrays.sort(dshd, (hd1, hd2) -> {
            if (hd1 == null) return 1;
            if (hd2 == null) return -1;
            return Double.compare(hd2.getTongSoTien(), hd1.getTongSoTien());
        });
        System.out.println("Danh sach hoa don da sap xep theo tong tien (giam dan).");
    }

    public void laySLHoaDon() {
        System.out.println("So luong hoa don hien tai: " + dshd.length);
    }

    public void ghiVaoFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("DanhSachHoaDon.txt"))) {
            for (HoaDon hoaDon : dshd) {
                DateTimeFormatter formatter;
                if (hoaDon instanceof HoaDonBanHang) {
                    HoaDonBanHang hdbh = (HoaDonBanHang) hoaDon;
                    writer.write("HoaDonBanHang,");
                    writer.write(String.join(",",
                            hdbh.getMaHoaDon(),
                            hdbh.getNgayLapHoaDon().format(formatter),
                            hdbh.getNhanVienLapHoaDon().toString(),
                            hdbh.getKhachHang().toString(),
                            hdbh.getKhuyenMai().toString(),
                            String.valueOf(hdbh.getTienThue()),
                            String.valueOf(hdbh.getChietKhau()),
                            hdbh.getPhuongThucThanhToan(),
                            String.valueOf(hdbh.getTongTien())
                    ));
                    writer.newLine();
                } else if (hoaDon instanceof HoaDonDoiTraHang) {
                    HoaDonDoiTraHang hddt = (HoaDonDoiTraHang) hoaDon;
                    writer.write("HoaDonDoiTra,");
                    writer.write(String.join(",",
                            hddt.getMaHoaDon(),
                            hddt.getNgayLapHoaDon().format(formatter),
                            hddt.getNhanVienLapHoaDon().toString(),
                            hddt.getKhachHang().toString(),
                            hddt.getHoaDonGoc().getMaHoaDon(),
                            String.valueOf(hddt.getTongGiaTri()),
                            hddt.getGhiChu(),
                            String.valueOf(hddt.getTienHoanTra()),
                            String.valueOf(hddt.getTiLeTru())
                    ));
                    writer.newLine();
                }
            }
            System.out.println("Ghi file thanh cong!");
        } catch (IOException e) {
            System.err.println("Loi ghi file: " + e.getMessage());
        }
    }

    public void docTuFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("DanhSachHoaDon.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                DateTimeFormatter formatter;
                if (data[0].equals("HoaDonBanHang")) {
                    String maHoaDon = data[1];
                    LocalDate ngayLap = LocalDate.parse(data[2], formatter);
                    NhanVien nhanVien = NhanVien.fromString(data[3]);
                    KhachHang khachHang = KhachHang.fromString(data[4]); 
                    KhuyenMai khuyenMai = KhuyenMai.fromString(data[5]); 
                    double tienThue = Double.parseDouble(data[6]);
                    double chietKhau = Double.parseDouble(data[7]);
                    String phuongThucThanhToan = data[8];
                    double tongTien = Double.parseDouble(data[9]);

                    HoaDonBanHang hdbh = new HoaDonBanHang(maHoaDon, ngayLap, nhanVien, khachHang, khuyenMai, tienThue, chietKhau, phuongThucThanhToan, tongTien);
                    themHD(hdbh);
                } else if (data[0].equals("HoaDonDoiTra")) {
                    String maHoaDon = data[1];
                    LocalDate ngayLap = LocalDate.parse(data[2], formatter);
                    NhanVien nhanVien = NhanVien.fromString(data[3]);
                    KhachHang khachHang = KhachHang.fromString(data[4]);
                    HoaDon hoaDonGoc = HoaDon(data[5]); 
                    double tongGiaTri = Double.parseDouble(data[6]);
                    String ghiChu = data[7];
                    double tienHoanTra = Double.parseDouble(data[8]);
                    double tiLeTru = Double.parseDouble(data[9]);

                    HoaDonDoiTraHang hddt = new HoaDonDoiTraHang(maHoaDon, ngayLap, nhanVien, khachHang, hoaDonGoc, tongGiaTri, ghiChu, tienHoanTra, tiLeTru);
                    themHD(hddt);
                }
            }
            System.out.println("Doc file thanh cong!");
        } catch (IOException e) {
            System.err.println("Loi doc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Loi dinh dang du lieu: " + e.getMessage());
        }
    }

    public double getTongSoTien(String maKhachHang) {
        double tongSoTien = 0;
        for (HoaDon hd : dshd) {
            if (hd != null && hd.getKhachHang().getMaKhachHang().equals(maKhachHang)) {
                tongSoTien += hd.getTongSoTien();
            }
        }
        return tongSoTien;
    }




    
    public void menu() {
        boolean running = true;
        while (running) {
            System.out.println("===================================");
            System.out.println("|            MENU CHINH           |");
            System.out.println("===================================");
            System.out.println("1. Them hoa don");
            System.out.println("2. Xuat danh sach hoa don");
            System.out.println("3. Tim kiem hoa don theo ma");
            System.out.println("4. Tim kiem hoa don theo ten khach hang");
            System.out.println("5. Sap xep danh sach hoa don");
            System.out.println("6. Lay so luong hoa don");
            System.out.println("7. Ghi danh sach vao file");
            System.out.println("8. Doc danh sach tu file");
            System.out.println("9. Tinh tong so tien theo ma khach hang");
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
                case 3 -> timKiemHoaDonTheoMa();
                case 4 -> timKiemHoaDonTheoTen();
                case 5 -> sapXep();
                case 6 -> laySLHoaDon();
                case 7 -> ghiVaoFile();
                case 8 -> docTuFile();
                case 9 -> {
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