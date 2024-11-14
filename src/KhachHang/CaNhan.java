package KhachHang;

import HoaDon.HoaDon;

public class CaNhan extends KhachHang {

    public CaNhan () {

    }

    public CaNhan(String hoTen, String gioiTinh, String ngaySinh, String diaChi, String sdt, String email,
                String maKhachHang, String loaiKhachHang, int tichDiem) {
        super(hoTen, gioiTinh, ngaySinh, diaChi, sdt, email, maKhachHang, loaiKhachHang, tichDiem);
    }


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
        return super.toString() + String.format("%-10.2f %-15d",tinhUuDai(), getTichDiem());
    }
    
}
