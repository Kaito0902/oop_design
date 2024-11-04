package KhachHang;

public class Vip extends KhachHang {
    //atrributes
    private int heSo;

    //non-parameted
    public Vip() {
        this.heSo = heSo = 5;
        this.loaiKhachHang = "Than thiet";
    }

    //parameted
    public Vip(String hoTen, String gioiTinh, String ngaySinh, String diaChi, int sdt, String email, String maKhachHang,
            String loaiKhachHang, String khieuNai, int tichDiem, int heSo) {
        super(hoTen, gioiTinh, ngaySinh, diaChi, sdt, email, maKhachHang, loaiKhachHang, khieuNai, tichDiem);
        this.heSo = heSo;
    }

    //getter and setter
    public int getHeSo() {
        return heSo;
    }

    public void setHeSo(int heSo) {
        this.heSo = heSo;
    }

    //tinhdiem thuong
    @Override
    public double tinhDiemThuong() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double tinhUuDai() {
        return xeploaiuudai()*heSo;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-10d", heSo);
    }

    
}
