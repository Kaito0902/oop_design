package KhachHang;

public class KhachHangVip extends KhachHang implements TraGop{
    //atrributes
    private int heSo;

    //non-parameted
    public KhachHangVip() {
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
        return 0.05;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-10d %-10.2f %-10d",getHeSo() ,tinhUuDai() ,getTichDiem());
    }


}
