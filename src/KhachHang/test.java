package KhachHang;

import Baitap.menu;
import HoaDon.QLHoaDon;

public class test { 
    public static void main(String[] args) {
        QLHoaDon qlhd = new QLHoaDon();
        QLKhachHang dskh = new QLKhachHang();
        dskh.menu(qlhd);
    }
}
