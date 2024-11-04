package KhachHang;

public class DoiTacDoanhNghiep extends KhachHang {
    //attribute
    private String tenCongTy;

    //non-parameted
    public DoiTacDoanhNghiep() {
        this.loaiKhachHang = "Tiem nang";
    }

    //parameted
    public DoiTacDoanhNghiep(String hoTen, String gioiTinh, String ngaySinh, String diaChi, int sdt, String email,
            String maKhachHang, String loaiKhachHang, String khieuNai, int tichDiem, String tenCongTy) {
        super(hoTen, gioiTinh, ngaySinh, diaChi, sdt, email, maKhachHang, loaiKhachHang, khieuNai, tichDiem);
        this.tenCongTy = tenCongTy;
    }

    //getter and setter
    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    @Override
    public double tinhDiemThuong() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double tinhUuDai() {
        return xeploaiuudai();
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-10s", tenCongTy);
    }

    

    
}
