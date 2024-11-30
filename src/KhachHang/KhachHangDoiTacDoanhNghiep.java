package KhachHang;

public class KhachHangDoiTacDoanhNghiep extends KhachHang implements TraGop{
    //attribute
    private String tenCongTy;

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


    //input kiem tra co muon tra gop
    @Override
    public void input() {
        super.input();
        System.out.println("Nhap ten cong ty:");
        setTenCongTy(scanner.nextLine());
    }

    @Override
    public double laiSuatTraGop() {
        return 0.03;
    }

    @Override
    public int tinhDiemThuong(double tongSoTien ) {
        return (int) (tongSoTien / 100000)*10;
    }

    @Override
    public double tinhUuDai() {
        return xeploaiuudai();
    }

    @Override
    public String toString() {
            return super.toString() + String.format("%-10s %-10.2f %-10d" ,tenCongTy ,tinhUuDai(), getTichDiem());
    }

}
