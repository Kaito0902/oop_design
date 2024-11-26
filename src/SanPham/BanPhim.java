package SanPham;

public class BanPhim extends ThietBiNgoaiVi{
    private String denLED;
    private String switchBP;

    public BanPhim()
    {

    }

    public BanPhim(String maSP, String tenSP, float giaSP, String thoiGianBaoHanhSP, float trongLuongSP, String mauSacSP, int soLuongNhap,
                boolean isNotDeleted, String loaiThietBi, String nhaSanXuat, String phuongThucKetNoi, String denLED, String switchBP){
        super(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, soLuongNhap, isNotDeleted, loaiThietBi, nhaSanXuat, phuongThucKetNoi);
        this.denLED = denLED;
        this.switchBP = switchBP;
    }

    public String getDenLED() {
        return denLED;
    }

    public void setDenLED(String denLED) {
        this.denLED = denLED;
    }

    public String getSwitchBP() {
        return switchBP;
    }

    public void setSwitchBP(String switchBP) {
        this.switchBP = switchBP;
    }

    @Override
    public float thanhTien(){
        return (float)(giaSP * 1.40f);
    }

    @Override
    public void nhap()
    {
        super.nhap();
        System.out.println("Nhap den LED ban phim: ");
        setDenLED(sc.nextLine());
        System.out.println("Nhap switch ban phim: ");
        setSwitchBP(sc.nextLine());
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-10s %-10s", denLED, switchBP);
    }

    @Override
    public void xuat(){
        super.xuat();
        System.out.println("Nhap den LED ban phim: " + denLED);
        System.out.println("Switch ban phim: " + switchBP);
        System.out.println("Tong tien phai tra: " + String.format("%.3f", thanhTien()) + " VND");
    }
}
