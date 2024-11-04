package KhachHang;

public class SinhVien extends KhachHang {
    //attributes
    private String maSV;
    private double diemTB;

    //non-parameted constructor
    public SinhVien() {
        this.loaiKhachHang = "Uu dai";
    }

    //parameted constructor
    public SinhVien(String hoTen, String gioiTinh, String ngaySinh, String diaChi, String sdt, String email,
                    String maKhachHang, String loaiKhachHang, String khieuNai, int tichDiem, String maSV, double diemTB) {
        super(hoTen, gioiTinh, ngaySinh, diaChi, sdt, email, maKhachHang, loaiKhachHang, tichDiem);
        this.maSV = maSV;
        this.diemTB = diemTB;
    }

    //getter and setter
    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }

    //input
    @Override
    public void input() {
        super.input();
        System.out.println("Nhap ma SV:");
        setMaSV(scanner.nextLine());
        System.out.println("Nhap diem TB:");
        setDiemTB(Double.parseDouble(scanner.nextLine()));
    }

    @Override
    public int tinhDiemThuong() {//chưa làm
        return 0;
    }

    @Override
    public double tinhUuDai() {
        return xeploaiuudai() + xeploaidiemTB();
    }

    //xeploaidiemTB
    public double xeploaidiemTB() {
        return diemTB >= 8.5?0.1:(diemTB >= 7?0.05:(diemTB >= 5?0.02:0));
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-10s %-10.2f %-10.2f %-15d",maSV, diemTB ,tinhUuDai(), tinhDiemThuong());
    }

}