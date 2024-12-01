package SanPham;

public class Chuot extends ThietBiNgoaiVi{
    private int dPI;
    private String denLED;

    public Chuot()
    {

    }

    public Chuot(String maSP, String tenSP, float giaSP, int thoiGianBaoHanhSP, float trongLuongSP, String mauSacSP, int soLuongNhap, int soLuongXuat, int soLuongTonKho, boolean isNotDeleted, String loaiThietBi, String nhaSanXuat, String phuongThucKetNoi, int dPI, String denLED) {
        super(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, soLuongNhap, soLuongXuat, soLuongTonKho, isNotDeleted, loaiThietBi, nhaSanXuat, phuongThucKetNoi);
        this.dPI = dPI;
        this.denLED = denLED;
    }

    public int getdPI() {
        return dPI;
    }

    public void setdPI(int dPI) {
        while(dPI <= 0){
            System.out.println("DPI Chuot lon hon 0!");
            dPI = Integer.parseInt(sc.nextLine());
        }
        this.dPI = dPI;
    }

    public String getDenLED() {
        return denLED;
    }

    public void setDenLED(String denLED) {
        this.denLED = denLED;
    }

    @Override
    public float thanhTien(){
        return (float)(giaSP * 1.45f);
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
        System.out.println("Tong tien phai tra: " + fm.format(thanhTien()).replace("₫", " VND"));
    }
}
