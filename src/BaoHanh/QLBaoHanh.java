package BaoHanh;

import java.util.Arrays;
import java.util.Scanner;

public class QLBaoHanh {
    BaoHanhSanPham[] dsBaoHanh = new BaoHanhSanPham[0];
    int soLuong = 0;
    static Scanner sc = new Scanner(System.in);

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
}
