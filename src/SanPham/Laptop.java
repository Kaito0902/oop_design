package SanPham;

public class Laptop extends MayTinh implements HienThiCauHinh{
    private String kichThuocManHinh;
    private float thoiLuongPin;
    private String loaiLaptop;

    public Laptop()
    {

    }

    public Laptop(String maSP, String tenSP, float giaSP, String thoiGianBaoHanhSP, float trongLuongSP, String mauSacSP, int soLuongNhap, int soLuongXuat, int soLuongTonKho, boolean isNotDeleted, String loaiMayTinh, String nhaSanXuat, String model, String heDieuHanh, String coCardRoi, PhanCung[] cacLinhKien, String kichThuocManHinh, float thoiLuongPin, String loaiLaptop) {
        super(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, soLuongNhap, soLuongXuat, soLuongTonKho, isNotDeleted, loaiMayTinh, nhaSanXuat, model, heDieuHanh, coCardRoi, cacLinhKien);
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
        while(thoiLuongPin < 3){
            System.out.println("Thoi luong pin laptop lon hon hoac bang 3!");
            thoiLuongPin = Float.parseFloat(sc.nextLine());
        }
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
        return (float)(giaSP * 1.11f);
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
