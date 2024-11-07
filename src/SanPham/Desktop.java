package SanPham;

public class Desktop extends MayTinh{
    private String casePC;
    private String tanNhiet;

    public Desktop() 
    {

    }

    public Desktop(String maSP, String tenSP, float giaSP, float khuyenMaiSP, int thoiGianBaoHanhSP, float trongLuongSP,
            String mauSacSP, String nhaSanXuat, String model, String loaiMayTinh, String heDieuHanh, boolean coCardRoi,
            PhanCung[] cacLinhKien, String casePC, String tanNhiet) {
        super(maSP, tenSP, giaSP, khuyenMaiSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, nhaSanXuat, model,
                loaiMayTinh, heDieuHanh, coCardRoi, cacLinhKien);
        this.casePC = casePC;
        this.tanNhiet = tanNhiet;
    }

    public String getCasePC() {
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
    public float ThanhTien(){
        return 1;
    }

    @Override
    public void nhap()
    {
        super.nhap();
        System.out.println("Nhap case PC: ");
        setCasePC(sc.nextLine());
        System.out.println("Nhap tan nhiet: ");
        setTanNhiet(sc.nextLine());
    }

    @Override
    public String toString()
    {
        return super.toString() + "Desktop [casePC=" + casePC + ", tanNhiet=" + tanNhiet + "]";
    }

    @Override
    public void xuat()
    {
        System.out.println(toString());
    }

}
