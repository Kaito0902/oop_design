package ChuoiCungCap;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import SanPham.SanPham;

public class QLNhaCungCap {
    NhaCungCap[] dsncc = new NhaCungCap[0];
    static Scanner sc = new Scanner(System.in);

    public void themNCC(NhaCungCap ncc) {
        NhaCungCap[] newdsncc = Arrays.copyOf(dsncc, dsncc.length + 1);
        newdsncc[dsncc.length] = ncc;
        dsncc = newdsncc;
    }

    public void xuatNCC() {
        for (NhaCungCap ncc : dsncc) {
            ncc.xuat();
        }
    }

    // Phương thức xóa nhà cung cấp theo mã
    public void xoaNhaCungCap(String maNCC) {
        boolean found = false;
        for (int i = 0; i < dsncc.length; i++) {
            if (dsncc[i].maNhaCungCap.equals(maNCC)) {
                for (int j = i; j < dsncc.length - 1; j++) {
                    dsncc[j] = dsncc[j + 1];
                }
                dsncc = Arrays.copyOf(dsncc, dsncc.length - 1);
                found = true;
                System.out.println("Da xoa nha cung cap co ma: " + maNCC);
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay nha cung cap co ma nay: " + maNCC);
        }
    }

    // Phương thức tìm kiếm nhà cung cấp theo chi phí nhập hàng
    public void timKiemNhaCungCapTheoChiPhi(double chiPhi) {
        boolean found = false;
        for (NhaCungCap ncc : dsncc) {
            if (ncc.chiPhiNhapHang == chiPhi) {
                System.out.println(ncc);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong co nha cung cap co chi phi nhap hang: " + chiPhi);
        }
    }

    public void sapXepNhaCungCapTheoChiPhi() {
        Arrays.sort(dsncc, (a, b) -> Double.compare(a.chiPhiNhapHang, b.chiPhiNhapHang));
        System.out.println("Danh sach nha cung cap da duoc sap xep theo chi phi nhap hang.");
    }

    public void laySoLuongNhaCungCap() {
        System.out.println("So luong nha cung cap: " + dsncc.length);
    }

    public void ghiVaoFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\ADMIN\\oop_design\\src\\ChuoiCungCap\\danhSachNhaCungCap.txt"))) {
            for (NhaCungCap ncc : dsncc) {
                writer.write(ncc.toString());
                writer.newLine();
            }
            System.out.println("Ghi file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public void docTuFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ADMIN\\oop_design\\src\\ChuoiCungCap\\danhSachNhaCungCap.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 11) {
                    String maNhaCungCap = data[0];
                    String tenNhaCungCap = data[1];
                    String diaChi = data[2];
                    String thanhPho = data[3];
                    String quocGia = data[4];
                    String email = data[5];
                    String maSoThue = data[6];
                    LocalDate ngayHopTac = LocalDate.parse(data[7]);
                    double chiPhiNhapHang = Double.parseDouble(data[8]);

                    String tenSanPham =(data[9]); 
                    String ghiChu = data[10];

                    NhaCungCap ncc = new NhaCungCap(maNhaCungCap, tenNhaCungCap, diaChi, thanhPho, quocGia, email, maSoThue, ngayHopTac, chiPhiNhapHang, ghiChu);
                    themNCC(ncc);
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
        int choice;
        do {
            System.out.println("===== Quan ly nha cung cap =====");
            System.out.println("1. Them nha cung cap");
            System.out.println("2. Xuat danh sach nha cung cap");
            System.out.println("3. Xoa nha cung cap");
            System.out.println("4. Tim kiem nha cung cap theo chi phi nhap hang");
            System.out.println("5. Sap xep nha cung cap theo chi phi nhap hang");
            System.out.println("6. Lay so luong nha cung cap");
            System.out.println("7. Ghi danh sach vao file");
            System.out.println("8. Doc danh sach tu file");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1 -> {
                    NhaCungCap ncc = new NhaCungCap();
                    ncc.nhap();
                    themNCC(ncc);
                }
                case 2 -> xuatNCC();
                case 3 -> {
                    System.out.print("Nhap ma nha cung cap can xoa: ");
                    String maXoa = sc.nextLine();
                    xoaNhaCungCap(maXoa);
                }
                case 4 -> {
                    System.out.print("Nhap chi phi nhap hang can tim: ");
                    double chiPhiTimKiem = sc.nextDouble();
                    timKiemNhaCungCapTheoChiPhi(chiPhiTimKiem);
                }
                case 5 -> sapXepNhaCungCapTheoChiPhi();
                case 6 -> laySoLuongNhaCungCap();
                case 7 -> ghiVaoFile();
                case 8 -> docTuFile();
                case 0 -> System.out.println("Thoat chuong trinh.");
                default -> System.out.println("Lua chon khong hop le.");
            }
        } while (choice != 0);
    }
}
