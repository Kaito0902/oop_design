package KhuyenMai;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class QLKhuyenMai {
    KhuyenMai[] danhSachKhuyenMai;
    private int soLuongKhuyenMai;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public QLKhuyenMai(int kichThuocBanDau) {
        danhSachKhuyenMai = new KhuyenMai[kichThuocBanDau];
        soLuongKhuyenMai = 0;
    }

    // Phương thức thêm khuyến mãi
    public void themKhuyenMai(KhuyenMai km) {
        if (soLuongKhuyenMai == danhSachKhuyenMai.length) {
            tangKichThuocMang();
        }
        danhSachKhuyenMai[soLuongKhuyenMai] = km;
        soLuongKhuyenMai++;
    }

    private void tangKichThuocMang() {
        int kichThuocMoi = danhSachKhuyenMai.length * 2;
        KhuyenMai[] mangMoi = new KhuyenMai[kichThuocMoi];
        System.arraycopy(danhSachKhuyenMai, 0, mangMoi, 0, danhSachKhuyenMai.length);
        danhSachKhuyenMai = mangMoi;
    }

    // Tìm khuyến mãi theo mã
    public KhuyenMai timKhuyenMai(String maKhuyenMai) {
        for (int i = 0; i < soLuongKhuyenMai; i++) {
            if (danhSachKhuyenMai[i].getMaKhuyenMai().equals(maKhuyenMai)) {
                return danhSachKhuyenMai[i];
            }
        }
        return null; // Không tìm thấy khuyến mãi với mã này
    }

    public void hienThiDanhSachKhuyenMai() {
        if (soLuongKhuyenMai == 0) {
            System.out.println("Khong co khuyen mai nao trong danh sach.");
        } else {
            for (int i = 0; i < soLuongKhuyenMai; i++) {
                System.out.println(danhSachKhuyenMai[i]);
            }
        }
    }

    public void nhapKhuyenMaiMoi() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ma khuyen mai: ");
        String maKhuyenMai = sc.nextLine();
        System.out.print("Nhap ten khuyen mai: ");
        String tenKhuyenMai = sc.nextLine();
        System.out.print("Nhap ngay bat dau (dd/MM/yyyy): ");
        LocalDate ngayBatDau = LocalDate.parse(sc.nextLine(), DATE_FORMATTER);
        System.out.print("Nhap ngay ket thuc (dd/MM/yyyy): ");
        LocalDate ngayKetThuc = LocalDate.parse(sc.nextLine(), DATE_FORMATTER);
        System.out.print("Nhap dieu kien ap dung: ");
        String dieuKienApDung = sc.nextLine();
        System.out.print("Nhap san pham ap dung: ");
        String sanPhamApDung = sc.nextLine();
        System.out.print("Nhap tong khuyen mai (%): ");
        double tongKhuyenMai = sc.nextDouble();

        KhuyenMai km = new KhuyenMai(maKhuyenMai, tenKhuyenMai, ngayBatDau, ngayKetThuc, dieuKienApDung, sanPhamApDung, tongKhuyenMai);
        themKhuyenMai(km);
        System.out.println("Them khuyen mai thanh cong.");
    }

    public void ghiVaoFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\ADMIN\\oop_design\\src\\KhuyenMai\\danhSachKhuyenMai.txt"))) {
            for (int i = 0; i < soLuongKhuyenMai; i++) {
                KhuyenMai km = danhSachKhuyenMai[i];
                writer.write(String.join(",",
                        km.getMaKhuyenMai(),
                        km.getTenKhuyenMai(),
                        km.getNgayBatDau().format(DATE_FORMATTER),
                        km.getNgayKetThuc().format(DATE_FORMATTER),
                        km.getDieuKienApDung(),
                        km.getSanPhamApDung(),
                        String.valueOf(km.getTongKhuyenMai())
                ));
                writer.newLine();
            }
            System.out.println("Ghi file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public void docTuFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ADMIN\\oop_design\\src\\KhuyenMai\\danhSachKhuyenMai.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 7) {
                    String maKhuyenMai = data[0];
                    String tenKhuyenMai = data[1];
                    LocalDate ngayBatDau = LocalDate.parse(data[2], DATE_FORMATTER);
                    LocalDate ngayKetThuc = LocalDate.parse(data[3], DATE_FORMATTER);
                    String dieuKienApDung = data[4];
                    String sanPhamApDung = data[5];
                    double tongKhuyenMai = Double.parseDouble(data[6]);

                    KhuyenMai km = new KhuyenMai(maKhuyenMai, tenKhuyenMai, ngayBatDau, ngayKetThuc, dieuKienApDung, sanPhamApDung, tongKhuyenMai);
                    themKhuyenMai(km);
                }
            }
            System.out.println("Doc file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Loi dinh dang so trong du lieu: " + e.getMessage());
        }
    }

    // Phương thức hiển thị menu
    public void menu() {
        Scanner sc = new Scanner(System.in);
        boolean kt = true;
        while (kt) {
            System.out.println("==== Menu Quan Ly Khuyen Mai ====");
            System.out.println("1. Them khuyen mai moi");
            System.out.println("2. Hien thi danh sach khuyen mai");
            System.out.println("3. Tim khuyen mai theo ma");
            System.out.println("4. Ghi danh sach vao file");
            System.out.println("5. Doc danh sach tu file");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            int chon = sc.nextInt();
            sc.nextLine(); // Đọc bỏ dòng mới

            switch (chon) {
                case 1 -> nhapKhuyenMaiMoi();
                case 2 -> hienThiDanhSachKhuyenMai();
                case 3 -> {
                    System.out.print("Nhap ma khuyen mai can tim: ");
                    String maKM = sc.nextLine();
                    KhuyenMai km = timKhuyenMai(maKM);
                    if (km != null) {
                        System.out.println("Tim thay khuyen mai: " + km);
                    } else {
                        System.out.println("Khong tim thay khuyen mai voi ma: " + maKM);
                    }
                }
                case 4 -> ghiVaoFile();
                case 5 -> docTuFile();
                case 0 -> {
                    kt = false;
                    System.out.println("Da thoat chuong trinh.");
                }
                default -> System.out.println("Lua chon khong hop le!");
            }
        }
    }
}
