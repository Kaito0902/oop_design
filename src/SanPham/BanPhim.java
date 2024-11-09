package SanPham;

public class BanPhim extends ThietBiNgoaiVi{
    private String kichThuoc;
    private String denLED;
    private String switchBP;

    public BanPhim()
    {

    }

    

    public BanPhim(String maSP, String tenSP, float giaSP, int thoiGianBaoHanhSP, float trongLuongSP, String mauSacSP,
            String nhaSanXuat, String loaiThietBi, String phuongThucKetNoi, String kichThuoc, String denLED,
            String switchBP) {
        super(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, nhaSanXuat, loaiThietBi, phuongThucKetNoi);
        this.kichThuoc = kichThuoc;
        this.denLED = denLED;
        this.switchBP = switchBP;
    }



    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
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
        return 1;
    }

    @Override
    public void nhap()
    {
        super.nhap();
        System.out.println("Nhap kich thuoc ban phim: ");
        setKichThuoc(sc.nextLine());
        System.out.println("Nhap den LED ban phim: ");
        setDenLED(sc.nextLine());
        System.out.println("Nhap switch BP ban phim: ");
        setSwitchBP(sc.nextLine());
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-20s %-10s %-10s", kichThuoc, denLED, switchBP);
    }


}
