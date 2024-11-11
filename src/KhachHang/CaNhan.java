package KhachHang;

import HoaDon.HoaDon;

public class CaNhan extends KhachHang {

    //tinhdiem thuong
    @Override
    public int tinhDiemThuong( double tongSoTien ) {
        return (int) (tongSoTien / 100000);
    }

    //tinh uu dai
    @Override
    public double tinhUuDai() {
        return xeploaiuudai();
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-10.2f %-15d",tinhUuDai(), tinhDiemThuong(1000000));
    }
    
}
