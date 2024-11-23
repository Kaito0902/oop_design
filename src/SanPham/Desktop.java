package SanPham;

public class Desktop extends MayTinh implements HienThiCauHinh{
    private String casePC;
    private String tanNhiet;

    public Desktop() {

    }

    public Desktop(String maSP, String tenSP, float giaSP, String thoiGianBaoHanhSP, float trongLuongSP, String mauSacSP, boolean isNotDeleted, String loaiMayTinh, String nhaSanXuat, String model, String heDieuHanh, String coCardRoi, PhanCung[] cacLinhKien, String casePC, String tanNhiet){
        super(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, isNotDeleted, loaiMayTinh, nhaSanXuat, model, heDieuHanh, coCardRoi, cacLinhKien);
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
        return (float)(giaSP * 1.12f);
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
        hienThiCauHinh();
        System.out.println("Tong tien phai tra: " + String.format("%.3f", thanhTien()) + " VND");
    }

    @Override
    public void hienThiCauHinh()
    {
        System.out.println("Cau hinh may tinh: ");
        for(PhanCung i:cacLinhKien){
            i.hienThiCauHinh();
        }
    }
}
