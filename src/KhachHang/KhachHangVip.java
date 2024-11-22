package KhachHang;

import HoaDon.HoaDon;
import HoaDon.QLHoaDon;

public class KhachHangVip extends KhachHang implements TraGop{
    //atrributes
    private int heSo;
    private boolean traGop;

    //non-parameted
    public KhachHangVip() {
        this.heSo = 5;
        this.loaiKhachHang = "Than thiet";
    }

    //parameted
    public KhachHangVip(String hoTen, String gioiTinh, String ngaySinh, String diaChi, String sdt, String email, String maKhachHang,
            String loaiKhachHang,boolean isdelete, int tichDiem, int heSo) {
        super(hoTen, gioiTinh, ngaySinh, diaChi, sdt, email, maKhachHang, loaiKhachHang, isdelete, tichDiem);
        this.heSo = heSo;
    }

    //getter and setter
    public int getHeSo() {
        return heSo;
    }

    public void setHeSo(int heSo) {
        this.heSo = heSo;
    }
    
    public boolean isTraGop() {
        return traGop;
    }

    public void setTraGop(boolean traGop) {
        this.traGop = traGop;
    }
    
    //input kiem tra co tra gop khong
    @Override
    public void input(QLHoaDon qlhd) {
        super.input(qlhd);
        inputThongTinVip();
    }

    // input thongtin Vip
    public void inputThongTinVip() {
        System.out.println("Nhap he so:");
        setHeSo(Integer.parseInt(scanner.nextLine()));
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
            return super.toString() + String.format("%-10d %-15.2f %-10d %-10b %-10.2f", getHeSo() ,tinhUuDai() ,getTichDiem(),traGop, laiSuatTraGop());
        else
            return super.toString() + String.format("%-10d %-15.2f %-10d %-10b",getHeSo() ,tinhUuDai() ,getTichDiem(), traGop );
    }


}
