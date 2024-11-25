package KhuyenMai;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class QLKhuyenMai {
    KhuyenMai[] danhSachKhuyenMai = new KhuyenMai[0];
    int soLuongKhuyenMai = 0;
    static Scanner sc = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Phương thức thêm khuyến mãi
    public void themKhuyenMai(KhuyenMai km) {
        KhuyenMai[] newdsKhuyenMai = Arrays.copyOf(danhSachKhuyenMai, soLuongKhuyenMai + 1);
        newdsKhuyenMai[soLuongKhuyenMai] = km;
        danhSachKhuyenMai = newdsKhuyenMai;
        soLuongKhuyenMai++;
    }

    //tim theo mã
    public KhuyenMai timKhuyenMai(String maKhuyenMai) {
        for (KhuyenMai ds : danhSachKhuyenMai) {
            if (ds.getMaKhuyenMai().equals(maKhuyenMai)) {
                return ds;
            }
        }
        return null; // Không tìm thấy khuyến mãi với mã này
    }

    public void hienThiDanhSachKhuyenMai() {
        if (soLuongKhuyenMai == 0) {
            System.out.println("Khong co khuyen mai nao trong danh sach.");
        } else {
            for (KhuyenMai ds : danhSachKhuyenMai) {
                if (!ds.isIsdelete())
                    ds.xuat();
            }
        }
    }

    public void xoaKhuyenMai(String ma) {
        boolean ktra = false;
        for (KhuyenMai ds : danhSachKhuyenMai) {
            if (ds.getMaKhuyenMai().equals(ma)) {
                ds.setIsdelete(true);
                System.out.println("Da xoa khuyen mai");
                ktra = true;
            }
        }
        if (!ktra) {
            System.out.println("Khong tim thay khuyen mai co ma " + ma);
        }
    }

    public void suaThongTinKhuyenMai(String ma) {
        boolean timThay = false;
        for (KhuyenMai ds : danhSachKhuyenMai) {
            if (ds.getMaKhuyenMai().equals(ma)) {
                int lc;
                boolean ktra = true;
                timThay = true;
                while (ktra) {
                    ds.xuat();
                    System.out.println("1. Sua ten khuyen mai");
                    System.out.println("2. Sua ngay bat dau");
                    System.out.println("3. Sua ngay ket thuc");
                    System.out.println("4. Sua tong khuyen mai");
                    System.out.println("5. Sua dieu kien ap dung");
                    System.out.println("6. Thoat");
                    System.out.println("Nhap lua chon: ");
                    lc = Integer.parseInt(sc.nextLine());
                    switch (lc) {
                        case 1: {
                            System.out.println("Nhap ten khuyen mai moi: ");
                            ds.setTenKhuyenMai(sc.nextLine());
                            System.out.println("Da sua ten.");
                            break;
                        }
                        case 2: {
                            System.out.println("Nhap ngay bat dau moi: ");
                            ds.setNgayBatDau(sc.nextLine());
                            System.out.println("Da sua ngay bat dau.");
                            break;
                        }
                        case 3: {
                            System.out.println("Nhap ngay ket thuc moi: ");
                            ds.setNgayKetThuc(sc.nextLine());
                            System.out.println("Da sua ngay ket thuc.");
                            break;
                        }
                        case 4: {
                            System.out.println("Nhap tong khuyen mai moi: ");
                            ds.setTongKhuyenMai(Double.parseDouble(sc.nextLine()));
                            System.out.println("Da sua tong khuyen mai.");
                            break;
                        }
                        case 5: {
                            System.out.println("Nhap dieu kien ap dung moi: ");
                            ds.setDieuKienApDung(sc.nextLine());
                            System.out.println("Da sua dieu kien ap dung.");
                            break;
                        }
                        case 6: {
                            ktra = false;
                            break;
                        }
                        default: {
                            System.out.println("Lua chon khong hop le.");
                            System.out.println("Vui long lua chon lai.");
                        }
                    }
                }
            }
        }
        if (!timThay) {
            System.out.println("Khong tim thay khuyen mai co ma " + ma);
        }
    }

    public void ghiVaoFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\ACER\\IdeaProjects\\oop_project\\src\\KhuyenMai\\DanhSachKhuyenMai.txt"))) {
            for (int i = 0; i < soLuongKhuyenMai; i++) {
                KhuyenMai km = danhSachKhuyenMai[i];
                writer.write(String.join(",",
                        km.getMaKhuyenMai(),
                        km.getTenKhuyenMai(),
                        String.valueOf(km.getNgayBatDau().format(formatter)),
                        String.valueOf(km.getNgayKetThuc().format(formatter)),
                        String.valueOf(km.getTongKhuyenMai()),
                        km.getDieuKienApDung(),
                        String.valueOf(km.isIsdelete())
                ));
                writer.newLine();
            }
            System.out.println("Ghi file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public void docTuFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ACER\\IdeaProjects\\oop_project\\src\\KhuyenMai\\DanhSachKhuyenMai.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 7) {

                    String maKhuyenMai = data[0];
                    String tenKhuyenMai = data[1];
                    LocalDate ngayBatDau = LocalDate.parse(data[2], formatter);
                    LocalDate ngayKetThuc = LocalDate.parse(data[3], formatter);
                    double tongKhuyenMai = Double.parseDouble(data[4]);
                    String dieuKienApDung = data[5];
                    boolean isdelete = Boolean.parseBoolean(data[6]);

                    KhuyenMai km = new KhuyenMai(maKhuyenMai, tenKhuyenMai, ngayBatDau, ngayKetThuc, tongKhuyenMai, dieuKienApDung, isdelete);
                    themKhuyenMai(km);
                }
                else {
                    System.out.println("Du lieu khong hop le trong dong: " + line);
                }
            }
            System.out.println("Doc file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Loi dinh dang so trong du lieu: " + e.getMessage());
        }
    }


}
