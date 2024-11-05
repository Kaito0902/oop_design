package KhachHang;

import GiaoDich.GiaoDich;

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
            String loaiKhachHang, String khieuNai, int tichDiem, int heSo) {
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
    public void input() {
        super.input();
        System.out.println("Ban co muon thanh toan tra gop?(Y/N):");
        String chon = scanner.nextLine();
        if ( chon.equals("y") || chon.equals("Y"))
            traGop = true;
        else
            traGop = false;
    }

    //tinhdiem thuong, dua vao tong so tien da mua
    @Override
    public int tinhDiemThuong() {
        return 0;
    }
    //tinh uu dai
    @Override
    public double tinhUuDai() {
        return xeploaiuudai()*heSo;
    }

    //tra gop dua vao tong so tien mua
    @Override
    public double laiSuatTraGop() {
        return 0;
    }

    @Override
    public String toString() {
        if (traGop)    
            return super.toString() + String.format("%-15.2f %-10d %-10.2f",tinhUuDai() ,tinhDiemThuong() , laiSuatTraGop());
        else
            return super.toString() + String.format("%-15.2f %-10d",tinhUuDai() ,tinhDiemThuong());
    }

}
