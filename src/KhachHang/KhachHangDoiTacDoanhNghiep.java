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
        while (true) {
            System.out.println("Ban co muon thanh toan tra gop?(Y/N):");
            String chon = scanner.nextLine().trim().toUpperCase();
            if ( chon.equals("Y")){
                traGop = true;
                break;
            }else if (chon.equals("N")){
                traGop = false;
                break;
            }else {
                System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập 'Y' hoặc 'N'.");
            }
        }
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
            return super.toString() + String.format("%-10s %-10.2f %-15d %-10b %-10.2f" ,tenCongTy,tinhUuDai(),getTichDiem() ,traGop, laiSuatTraGop());
        else
            return super.toString() + String.format("%-10s %-10.2f %-15d %-10b" ,tenCongTy ,tinhUuDai(), getTichDiem(), traGop);
    }

}
