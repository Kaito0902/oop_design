package KhachHang;

public class DoiTacDoanhNghiep extends KhachHang implements TraGop{
    //attribute
    private String tenCongTy;
    private boolean traGop;

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
    public double tinhDiemThuong() {
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
            return super.toString();
    }

    

    
}
