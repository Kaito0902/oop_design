package BaoHanh;

import java.util.Arrays;

public class QLBaoHanh {
    BaoHanhSanPham[] dsBaoHanh = new BaoHanhSanPham[0];
    int soLuong = 0;

    public void themBaoHanh(BaoHanhSanPham baoHanhSanPham) {
        BaoHanhSanPham[] newdsBaoHanh = Arrays.copyOf(dsBaoHanh, soLuong + 1);
        newdsBaoHanh[soLuong] = baoHanhSanPham;
        dsBaoHanh = newdsBaoHanh;
        soLuong++;
    }

    public void xuatDanhSachBaoHang() {
        for (BaoHanhSanPham ds : dsBaoHanh) {

        }
    }
}
