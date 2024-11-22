package KhachHang;

import HoaDon.HoaDon;
import HoaDon.QLHoaDon;

public class KhachHangDoiTacDoanhNghiep extends KhachHang implements TraGop{
    //attribute
    private String tenCongTy;
    private boolean traGop;

    //non-parameted
    public KhachHangDoiTacDoanhNghiep() {
        this.loaiKhachHang = "Tiem nang";
    }

    //parameted
    public KhachHangDoiTacDoanhNghiep(String hoTen, String gioiTinh, String ngaySinh, String diaChi, String sdt, String email,
            String maKhachHang, String loaiKhachHang,boolean isdelete, int tichDiem, String tenCongTy) {
        super(hoTen, gioiTinh, ngaySinh, diaChi, sdt, email, maKhachHang, loaiKhachHang,isdelete, tichDiem);
        this.tenCongTy = tenCongTy;
    }

    //getter and setter
    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public boolean isTraGop() {
        return traGop;
    }

    public void setTraGop(boolean traGop) {
        this.traGop = traGop;
    }

    //input kiem tra co muon tra gop
    @Override
    public void input(QLHoaDon qlhd) {
        super.input(qlhd);
        System.out.println("Nhap ten cong ty:");
        setTenCongTy(scanner.nextLine());
        System.out.println("Ban co muon thanh toan tra gop?(Y/N):");
        String chon = scanner.nextLine();
        if ( chon.equals("y") || chon.equals("Y"))
            traGop = true;
        else
            traGop = false;
    }

    @Override
    public double laiSuatTraGop() {
        return traGop ? 0.03:0;
    }

    @Override
    public int tinhDiemThuong( double tongSoTien ) {
        return (int) (tongSoTien / 100000)*10;
    }

    @Override
    public double tinhUuDai() {
        return xeploaiuudai();
    }

    @Override
    public String toString() {
        if (traGop)    
            return super.toString() + String.format("%-10b %-10s %-10.2f %-15d %-10.2f",traGop ,tenCongTy,tinhUuDai(),getTichDiem(), laiSuatTraGop());
        else
            return super.toString() + String.format("%-10b %-10s %-10.2f %-15d",traGop ,tenCongTy ,tinhUuDai(), getTichDiem());
    }

}
