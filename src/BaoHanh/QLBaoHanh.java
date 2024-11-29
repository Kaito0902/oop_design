package BaoHanh;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class QLBaoHanh {
    BaoHanhSanPham[] dsBaoHanh = new BaoHanhSanPham[0];
    int soLuong = 0;
    static Scanner sc = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void themBaoHanh(BaoHanhSanPham baoHanhSanPham) {
        BaoHanhSanPham[] newdsBaoHanh = Arrays.copyOf(dsBaoHanh, soLuong + 1);
        newdsBaoHanh[soLuong] = baoHanhSanPham;
        dsBaoHanh = newdsBaoHanh;
        soLuong++;
    }

    public void xuatDanhSachBaoHang() {
        for (BaoHanhSanPham ds : dsBaoHanh) {
            ds.output();
        }
    }

    public void capNhatTrangThaiBaoHanh(String ma) {
        boolean found = false;
        for (BaoHanhSanPham ds : dsBaoHanh) {
            if (ds.getMaBaoHanh().equals(ma)) {
                found = true;
                if (!ds.getTrangThai().equals(BaoHanhSanPham.loaiTrangThai[0])) {
                    System.out.println("1. Da xu ly bao hanh");
                    System.out.println("2. Tu choi bao hanh");
                    System.out.println("3. Huy yeu cau bao hanh");
                    System.out.println("Cap nhat trang thai: ");
                    int lc = Integer.parseInt(sc.nextLine());
                    if (lc == 1 || lc == 2 || lc == 3) {
                        ds.setTrangThai(BaoHanhSanPham.loaiTrangThai[lc]);
                        System.out.println("Da cap nhat trang thai.");
                    } else {
                        System.out.println("Lua chon khong hop le.");
                    }
                } else {
                    System.out.println("San pham da duoc cap nhat trang thai.");
                    System.out.println("Trang thai: " + ds.getTrangThai());
                }
                break;
            }
        }

        if (!found) {
            System.out.println("Ma bao hanh khong dung.");
        }
    }

    public void docTuFileDSBH() {
        try(BufferedReader reader = new BufferedReader(new FileReader("src/BaoHanh/danhSachBaoHanhSanPham"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length > 0) {
                    String maBaoHang = data[0];
                    String maKhachHang = data[1];
                    String tenKhachHang = data[2];
                    String maSP = data[3];
                    String tenSP = data[4];
                    String maNhanVienPhuTrach = data[5];
                    String tenNhanVienPhuTrach = data[6];
                    String lyDo = data[7];
                    LocalDate ngayNhan = LocalDate.parse(data[8], formatter);
                    String trangThai = data[9];
                    BaoHanhSanPham bhsp = new BaoHanhSanPham(maBaoHang, maKhachHang, maSP,maNhanVienPhuTrach, lyDo, ngayNhan, trangThai);
                    themBaoHanh(bhsp);
                }
                else {
                    System.out.println("Du lieu khong hop le.");
                }
            }

        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Loi dinh dang so trong du lieu: " + e.getMessage());
        }
    }

    public void ghiVaoFileDSBH() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/BaoHanh/danhSachBaoHanhSanPham"))) {
            for (BaoHanhSanPham bh : dsBaoHanh){
                writer.write(String.join(",",
                        bh.getMaBaoHanh(),
                        bh.getKhachHang().getMaKhachHang(),
                        bh.getKhachHang().getHoTen(),
                        bh.getSanPham().getMaSP(),
                        bh.getSanPham().getTenSP(),
                        bh.getNhanVienPhuTrach().getMaNhanVien(),
                        bh.getNhanVienPhuTrach().getTenNhanVien(),
                        bh.getLyDo(),
                        String.valueOf(bh.getNgayNhan().format(formatter)),
                        bh.getTrangThai()
                ));
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }
}
