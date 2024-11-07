package SanPham;

public class Laptop extends MayTinh{
    private String kichThuocManHinh;
    private float thoiLuongPin;
    private String loaiLaptop;

    public Laptop()
    {

    }

    public Laptop(String maSP, String tenSP, float giaSP, float khuyenMaiSP, int thoiGianBaoHanhSP, float trongLuongSP,
            String mauSacSP, String nhaSanXuat, String model, String loaiMayTinh, String heDieuHanh, boolean coCardRoi,
            PhanCung[] cacLinhKien, String kichThuocManHinh, float thoiLuongPin, String loaiLaptop) {
        super(maSP, tenSP, giaSP, khuyenMaiSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, nhaSanXuat, model,
                loaiMayTinh, heDieuHanh, coCardRoi, cacLinhKien);
        this.kichThuocManHinh = kichThuocManHinh;
        this.thoiLuongPin = thoiLuongPin;
        this.loaiLaptop = loaiLaptop;
    }

    public String getKichThuocManHinh() {
        return kichThuocManHinh;
    }

    public void setKichThuocManHinh(String kichThuocManHinh) {
        this.kichThuocManHinh = kichThuocManHinh;
    }

    public float getThoiLuongPin() {
        return thoiLuongPin;
    }

    public void setThoiLuongPin(float thoiLuongPin) {
        this.thoiLuongPin = thoiLuongPin;
    }

    public String getLoaiLaptop() {
        return loaiLaptop;
    }

    public void setLoaiLaptop(String loaiLaptop) {
        this.loaiLaptop = loaiLaptop;
    }

    @Override
    public float ThanhTien(){
        return 1;
    }

    @Override
    public void nhap()
    {
        super.nhap();
        System.out.println("Nhap kich thuoc man hinh laptop: ");
        setKichThuocManHinh(sc.nextLine());
        System.out.println("Nhap thoi luong pin laptop: ");
        setThoiLuongPin(Float.parseFloat(sc.nextLine()));
        System.out.println("Nhap loai laptop: ");
        setLoaiLaptop(sc.nextLine());
    }

    @Override
    public String toString() 
    {
        return super.toString() + "Laptop [kichThuocManHinh=" + kichThuocManHinh + ", thoiLuongPin=" + thoiLuongPin + ", loaiLaptop="
                + loaiLaptop + "]";
    }

    @Override
    public void xuat()
    {
        System.out.println(toString());
    }
    
}
