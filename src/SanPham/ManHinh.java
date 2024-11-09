package SanPham;

public class ManHinh extends ThietBiNgoaiVi{
    private String kieuManHinh;
    private String kichThuoc;
    private int tanSoQuet;
    private String tamNen;
    private int doPhanGiai;

    public ManHinh() 
    {
    
    }

    public ManHinh(String maSP, String tenSP, float giaSP, int thoiGianBaoHanhSP, float trongLuongSP, String mauSacSP,
            String nhaSanXuat, String loaiThietBi, String phuongThucKetNoi, String kieuManHinh, String kichThuoc,
            int tanSoQuet, String tamNen, int doPhanGiai) {
        super(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, nhaSanXuat, loaiThietBi, phuongThucKetNoi);
        this.kieuManHinh = kieuManHinh;
        this.kichThuoc = kichThuoc;
        this.tanSoQuet = tanSoQuet;
        this.tamNen = tamNen;
        this.doPhanGiai = doPhanGiai;
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

    public int getDoPhanGiai() {
        return doPhanGiai;
    }

    public void setDoPhanGiai(int doPhanGiai) {
        this.doPhanGiai = doPhanGiai;
    }

    @Override
    public float thanhTien(){
        return 1;
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
        setDoPhanGiai(Integer.parseInt(sc.nextLine()));
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
    }
}
