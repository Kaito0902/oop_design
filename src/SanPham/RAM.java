package SanPham;

public class RAM extends PhanCung{
    private int dungLuongRAM;
    private String loaiRAM;

    public RAM() 
    {

    }

    public RAM(int dungLuongRAM, String loaiRAM) {
        this.dungLuongRAM = dungLuongRAM;
        this.loaiRAM = loaiRAM;
    }

    public RAM(int dungLuongRAM, String loaiRAM, String maSP, String tenSP, float giaSP, int thoiGianBaoHanhSP, float trongLuongSP, String mauSacSP, String nhaSanXuat, String loaiLinhKien, String model) {
        super(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, nhaSanXuat, loaiLinhKien, model);
        this.dungLuongRAM = dungLuongRAM;
        this.loaiRAM = loaiRAM;
    }

    public int getDungLuongRAM() {
        return dungLuongRAM;
    }

    public void setDungLuongRAM(int dungLuongRAM) {
        this.dungLuongRAM = dungLuongRAM;
    }

    public String getLoaiRAM() {
        return loaiRAM;
    }

    public void setLoaiRAM(String loaiRAM) {
        this.loaiRAM = loaiRAM;
    }

    @Override
    public float thanhTien(){
        return 1;
    }

    @Override
    public void nhap()
    {
        super.nhap();
        System.out.println("Nhap dung luong RAM: ");
        setDungLuongRAM(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap loai RAM: ");
        setLoaiRAM(sc.nextLine());
    }   

    @Override
    public void nhapCauHinh()
    {
        System.out.println("Nhap dung luong RAM: ");
        setDungLuongRAM(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap loai RAM: ");
        setLoaiRAM(sc.nextLine());
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-10d %-10s", dungLuongRAM, loaiRAM);
    }

    @Override
    public void xuat(){
        super.xuat();
        System.out.println("Dung luong RAM: " + dungLuongRAM + "GB");
        System.out.println("Loai RAM: " + loaiRAM);
    }

    @Override
    public void hienThiCauHinh()
    {
        System.out.println("Dung luong RAM: " + dungLuongRAM + "GB");
        System.out.println("Loai RAM: " + loaiRAM);
    }
}
