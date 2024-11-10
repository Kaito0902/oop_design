package SanPham;

public class Laptop extends MayTinh implements HienThiCauHinh{
    private String kichThuocManHinh;
    private float thoiLuongPin;
    private String loaiLaptop;

    public Laptop()
    {

    }

    public Laptop(String kichThuocManHinh, String loaiLaptop, float thoiLuongPin, String maSP, String tenSP, float giaSP, int thoiGianBaoHanhSP, float trongLuongSP, String mauSacSP, String nhaSanXuat, String model, String loaiMayTinh, String heDieuHanh, String coCardRoi, PhanCung[] cacLinhKien) {
        super(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, nhaSanXuat, model, loaiMayTinh, heDieuHanh, coCardRoi, cacLinhKien);
        this.kichThuocManHinh = kichThuocManHinh;
        this.loaiLaptop = loaiLaptop;
        this.thoiLuongPin = thoiLuongPin;
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
    public float thanhTien(){
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
        return super.toString() + String.format("%-20s %-10.2f %-20s", kichThuocManHinh, thoiLuongPin, loaiLaptop);
    }

    @Override
    public void xuat(){
        super.xuat();
        System.out.println("Kich thuoc man hinh Laptop: " + kichThuocManHinh);
        System.out.println("Thoi luong pin Laptop: " + thoiLuongPin + "h");
        System.out.println("Loai laptop: " + loaiLaptop);
        hienThiCauHinh();
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
