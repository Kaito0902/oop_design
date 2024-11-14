package SanPham;

public class Chuot extends ThietBiNgoaiVi{
    private int dPI;
    private String denLED;

    public Chuot()
    {

    }

    public Chuot(String maSP, String tenSP, float giaSP, String thoiGianBaoHanhSP, float trongLuongSP, String mauSacSP, String loaiThietBi,
            String nhaSanXuat, String phuongThucKetNoi, int dPI, String denLED){
        super(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, loaiThietBi, nhaSanXuat, phuongThucKetNoi);
        this.dPI = dPI;
        this.denLED = denLED;
    }

    public int getdPI() {
        return dPI;
    }

    public void setdPI(int dPI) {
        this.dPI = dPI;
    }

    public String getDenLED() {
        return denLED;
    }

    public void setDenLED(String denLED) {
        this.denLED = denLED;
    }

    @Override
    public float tinhKhuyenMai(){
        return 0;
    }


    @Override
    public float thanhTien(){
        return (float)(giaSP - (giaSP * tinhKhuyenMai()));
    }

    @Override
    public void nhap()
    {
        super.nhap();
        System.out.println("Nhap DPI chuot: ");
        setdPI(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap den LED chuot: ");
        setDenLED(sc.nextLine());
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-10d %-10s", dPI, denLED);
    }

    @Override
    public void xuat(){
        super.xuat();
        System.out.println("DPI chuot: " + dPI);
        System.out.println("Den LED chuot: " + denLED);
        System.out.println("Tong tien phai tra: " + String.format("%.3f", thanhTien()) + " VND");
    }
}
