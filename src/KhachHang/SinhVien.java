package KhachHang;

import HoaDon.HoaDon;

public class SinhVien extends KhachHang {
    //attributes
    private double diemTB;

    //non-parameted constructor
    public SinhVien() {
        this.loaiKhachHang = "Uu dai";
    }

    //parameted constructor
    public SinhVien(String hoTen, String gioiTinh, String ngaySinh, String diaChi, String sdt, String email,
            String maKhachHang, String loaiKhachHang, String khieuNai, int tichDiem, String maSV, double diemTB) {
        super(hoTen, gioiTinh, ngaySinh, diaChi, sdt, email, maKhachHang, loaiKhachHang, tichDiem);
        this.diemTB = diemTB;
    }

    //getter and setter
    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        while (diemTB < 0.0 && diemTB > 10.0 ) {
            System.out.println("diemtb khong duoc duoi 0 ");
            System.out.println("Vui long nhap lai: ");
            scanner.nextDouble();
        }
        this.diemTB = diemTB;
    }

    //input
    @Override
    public void input() {
        super.input();
        System.out.println("Nhap diem TB:");
        setDiemTB(Double.parseDouble(scanner.nextLine()));
    }

    @Override
    public int tinhDiemThuong(double tongSoTien ) {
        return (int) (tongSoTien / 100000)*2;
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
        return super.toString() + String.format("%-10.2f %-10.2f %-15d", diemTB ,tinhUuDai(), tinhDiemThuong(1000000));
    }
    
}
