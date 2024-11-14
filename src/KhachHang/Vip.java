package KhachHang;

import HoaDon.HoaDon;
import HoaDon.QLHoaDon;

public class Vip extends KhachHang implements TraGop{
    //atrributes
    private int heSo;
    private boolean traGop;

    //non-parameted
    public Vip() {
        this.heSo = 5;
        this.loaiKhachHang = "Than thiet";
    }

    //parameted
    public Vip(String hoTen, String gioiTinh, String ngaySinh, String diaChi, String sdt, String email, String maKhachHang,
            String loaiKhachHang, int tichDiem, int heSo) {
        super(hoTen, gioiTinh, ngaySinh, diaChi, sdt, email, maKhachHang, loaiKhachHang, tichDiem);
        this.heSo = heSo;
    }

    //getter and setter
    public int getHeSo() {
        return heSo;
    }

    public void setHeSo(int heSo) {
        this.heSo = heSo;
    }

    //input kiem tra co tra gop khong
    @Override
    public void input(QLHoaDon qlhd) {
        super.input(qlhd);
        System.out.println("Nhap he so:");
        setHeSo(Integer.parseInt(scanner.nextLine()));

        System.out.println("Ban co muon thanh toan tra gop?(Y/N):");
        String chon = scanner.nextLine();
        if ( chon.equals("y") || chon.equals("Y"))
            traGop = true;
        else
            traGop = false;
    }

    //tinhdiem thuong, dua vao tong so tien da mua
    @Override
    public int tinhDiemThuong(double tongSoTien) {
        return (int) (tongSoTien / 100000)*5;
    }
    //tinh uu dai
    @Override
    public double tinhUuDai() {
        return xeploaiuudai()*heSo;
    }

    //tra gop dua vao tong so tien mua
    @Override
    public double laiSuatTraGop() {
        return traGop ? 0.05 : 0;
    }

    @Override
    public String toString() {
        if (traGop)    
            return super.toString() + String.format("%-10b %-10d %-15.2f %-10d %-10.2f",traGop, getHeSo() ,tinhUuDai() ,getTichDiem(), laiSuatTraGop());
        else
            return super.toString() + String.format("%-10b %-10d %-15.2f %-10d",traGop ,getHeSo() ,tinhUuDai() ,getTichDiem());
    }

}
