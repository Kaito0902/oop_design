package KhachHang;

import HoaDon.HoaDon;

public class KhachHangCaNhan extends KhachHang {

    public KhachHangCaNhan () {

    }

    public KhachHangCaNhan(String hoTen, String gioiTinh, String ngaySinh, String diaChi, String sdt, String email,
                String maKhachHang, String loaiKhachHang, boolean isdelete,int tichDiem) {
        super(hoTen, gioiTinh, ngaySinh, diaChi, sdt, email, maKhachHang, loaiKhachHang, isdelete, tichDiem);
    }


    //tinhdiem thuong
    @Override
    public int tinhDiemThuong( double tongSoTien ) { //can thuoc tinh tong so tiền để viết điều kiện 
        if ( tongSoTien >= 10000000)
            return (int) (tongSoTien / 100000 )*5;
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
