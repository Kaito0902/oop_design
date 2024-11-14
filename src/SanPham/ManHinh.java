package SanPham;

public class ManHinh extends ThietBiNgoaiVi{
    private String kieuManHinh;
    private String kichThuoc;
    private String tamNen;
    private String doPhanGiai;
    private int tanSoQuet;

    public ManHinh() 
    {
    
    }

    public ManHinh(String maSP, String tenSP, float giaSP, String thoiGianBaoHanhSP, float trongLuongSP, String mauSacSP, String loaiThietBi, String nhaSanXuat, String phuongThucKetNoi, String kieuManHinh, String kichThuoc, String tamNen, String doPhanGiai, int tanSoQuet){
        super(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, loaiThietBi, nhaSanXuat, phuongThucKetNoi);
        this.doPhanGiai = doPhanGiai;
        this.kichThuoc = kichThuoc;
        this.kieuManHinh = kieuManHinh;
        this.tamNen = tamNen;
        this.tanSoQuet = tanSoQuet;
    }

    public String getKieuManHinh() {
        return kieuManHinh;
    }

    public void setKieuManHinh(String kieuManHinh) {
        this.kieuManHinh = kieuManHinh;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public int getTanSoQuet() {
        return tanSoQuet;
    }

    public void setTanSoQuet(int tanSoQuet) {
        this.tanSoQuet = tanSoQuet;
    }

    public String getTamNen() {
        return tamNen;
    }

    public void setTamNen(String tamNen) {
        this.tamNen = tamNen;
    }

    public String getDoPhanGiai() {
        return doPhanGiai;
    }

    public void setDoPhanGiai(String doPhanGiai) {
        this.doPhanGiai = doPhanGiai;
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
        System.out.println("Nhap kieu man hinh: ");
        setKieuManHinh(sc.nextLine());
        System.out.println("Nhap kich thuoc man hinh: ");
        setKichThuoc(sc.nextLine());
        System.out.println("Nhap tan so quet man hinh: ");
        setTanSoQuet(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap tam nen man hinh: ");
        setTamNen(sc.nextLine());
        System.out.println("Nhap do phan giai man hinh: ");
        setDoPhanGiai(sc.nextLine());
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-10s %-20s %-10d %-10s %-20s",kieuManHinh, kichThuoc, tanSoQuet, tamNen, doPhanGiai);
    }

    @Override
    public void xuat(){
        super.xuat();
        System.out.println("Kieu man hinh: " + kieuManHinh);
        System.out.println("Kich thuoc man hinh: " + kichThuoc);
        System.out.println("Tan so quet man hinh: " + tanSoQuet + "Hz");
        System.out.println("Tam nen man hinh: " + tamNen);
        System.out.println("Nhap do phan giai man hinh: " + doPhanGiai);
        System.out.println("Tong tien phai tra: " + String.format("%.3f", thanhTien()) + " VND");
    }
}
