package KhachHang;

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
                                      String maKhachHang, String loaiKhachHang, int tichDiem, String tenCongTy) {
        super(hoTen, gioiTinh, ngaySinh, diaChi, sdt, email, maKhachHang, loaiKhachHang, tichDiem);
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
        System.out.println("Ban co muon thanh toan tra gop?(Y/N):");
        String chon = scanner.nextLine();
        if ( chon.equals("y") || chon.equals("Y"))
            traGop = true;
        else
            traGop = false;
    }

    @Override
    public double laiSuatTraGop() {
        return 0;
    }

    @Override
    public int tinhDiemThuong() {
        return 0;
    }

    @Override
    public double tinhUuDai() {
        return xeploaiuudai();
    }

    @Override
    public String toString() {
        if (traGop)
            return super.toString() + String.format("%-10.2f %-15d %-10.2f",tinhUuDai(),tinhDiemThuong(), laiSuatTraGop());
        else
            return super.toString() + String.format("%-10.2f %-15d",tinhUuDai(),tinhDiemThuong());
    }

}