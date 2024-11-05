package KhachHang;

import GiaoDich.GiaoDich;

public class CaNhan extends KhachHang {

    //tinhdiem thuong
    @Override
    public int tinhDiemThuong() {
        return 0;
    }

    //tinh uu dai
    @Override
    public double tinhUuDai() {
        return xeploaiuudai();
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-10.2f %-15d",tinhUuDai(), tinhDiemThuong());
    }
    
}
