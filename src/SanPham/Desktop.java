package SanPham;

public class Desktop extends MayTinh{
    private String casePC;
    private String tanNhiet;

    public Desktop() {

    }

    public Desktop(String casePC, String tanNhiet, String maSP, String tenSP, float giaSP, int thoiGianBaoHanhSP, float trongLuongSP, String mauSacSP, String nhaSanXuat, String model, String loaiMayTinh, String heDieuHanh, String coCardRoi, PhanCung[] cacLinhKien, int soLuongLinhKien) {
        super(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, nhaSanXuat, model, loaiMayTinh, heDieuHanh, coCardRoi, cacLinhKien, soLuongLinhKien);
        this.casePC = casePC;
        this.tanNhiet = tanNhiet;
    }

    public String getCasePC(){
        return casePC;
    }

    public void setCasePC(String casePC) {
        this.casePC = casePC;
    }

    public String getTanNhiet() {
        return tanNhiet;
    }

    public void setTanNhiet(String tanNhiet) {
        this.tanNhiet = tanNhiet;
    }

    @Override
    public float thanhTien(){
        return 1;
    }

    @Override
    public void nhap()
    {
        super.nhap();
        System.out.println("Nhap case desktop: ");
        setCasePC(sc.nextLine());
        System.out.println("Nhap tan nhiet desktop: ");
        setTanNhiet(sc.nextLine());
    }

    @Override
    public String toString()
    {
        return super.toString() + String.format("%-20s %-20s", casePC, tanNhiet);
    }

    @Override
    public void xuat(){
        super.xuat();
        System.out.println("Case desktop: " + casePC);
        System.out.println("Tan nhiet desktop: " + tanNhiet);
    }
}
