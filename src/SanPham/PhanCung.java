package SanPham;

public abstract class PhanCung extends SanPham{
    protected String nhaSanXuat;
    protected String loaiLinhKien;
    protected String model;

    public PhanCung() 
    {

    }

    public PhanCung(String maSP, String tenSP, float giaSP, int thoiGianBaoHanhSP, float trongLuongSP, String mauSacSP,
            String nhaSanXuat, String loaiLinhKien, String model) {
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

    public void nhap1()
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

    public String toString1(){
        return "PhanCung [nhaSanXuat=" + nhaSanXuat + ", loaiLinhKien=" + loaiLinhKien + ", model=" + model + "]";
    }


    @Override
    public void xuat()
    {
        super.xuat();
        System.out.println("Loai linh kien: " + loaiLinhKien);
        System.out.println("Nha san xuat linh kien: " + nhaSanXuat);
        System.out.println("Model linh kien: " + model);
    }

    public void xuat1()
    {
        System.out.println(toString1());
    }
}
