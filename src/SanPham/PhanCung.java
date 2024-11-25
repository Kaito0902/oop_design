package SanPham;

public abstract class PhanCung extends SanPham implements NhapCauHinh, HienThiCauHinh{
    protected String loaiLinhKien;
    protected String nhaSanXuat;
    protected String model;

    public PhanCung() 
    {

    }

    public PhanCung(String maSP, String tenSP, float giaSP, String thoiGianBaoHanhSP, float trongLuongSP, String mauSacSP,
                String loaiLinhKien, String nhaSanXuat, String model) {
        super(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP);
        this.nhaSanXuat = nhaSanXuat;
        this.loaiLinhKien = loaiLinhKien;
        this.model = model;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public String getLoaiLinhKien() {
        return loaiLinhKien;
    }

    public void setLoaiLinhKien(String loaiLinhKien) {
        this.loaiLinhKien = loaiLinhKien;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void nhap()
    {
        super.nhap();
        System.out.println("Nhap nha san xuat: ");
        setNhaSanXuat(sc.nextLine());
        System.out.println("Nhap model san pham: ");
        setModel(sc.nextLine());
    }

    @Override
    public void nhapCauHinh()
    {
        System.out.println("Nhap nha san xuat: ");
        setNhaSanXuat(sc.nextLine());
        System.out.println("Nhap model san pham: ");
        setModel(sc.nextLine());
    }

    @Override
    public String toString(){
        return super.toString() + String.format("%-20s %-20s %20s", nhaSanXuat, loaiLinhKien, model);
    }

    @Override
    public void xuat()
    {
        super.xuat();
        System.out.println("Loai linh kien: " + loaiLinhKien);
        System.out.println("Nha san xuat linh kien: " + nhaSanXuat);
        System.out.println("Model linh kien: " + model);
    }

    @Override
    public void hienThiCauHinh()
    {
        System.out.println("Loai linh kien: " + loaiLinhKien);
        System.out.println("Nha san xuat linh kien: " + nhaSanXuat);
        System.out.println("Model linh kien: " + model);
    }
}
