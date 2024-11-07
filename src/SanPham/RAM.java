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

    public RAM(String maSP, String tenSP, float giaSP, float khuyenMaiSP, int thoiGianBaoHanhSP, float trongLuongSP,
            String mauSacSP, String nhaSanXuat, String loaiLinhKien, String model, int dungLuongRAM, String loaiRAM) {
        super(maSP, tenSP, giaSP, khuyenMaiSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, nhaSanXuat, loaiLinhKien,
                model);
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
    public float ThanhTien(){
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
    public void nhap1()
    {
        super.nhap1();
        System.out.println("Nhap dung luong RAM: ");
        setDungLuongRAM(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap loai RAM: ");
        setLoaiRAM(sc.nextLine());
    }

    @Override
    public String toString() {
        return super.toString() + "RAM [dungLuong=" + dungLuongRAM + ", loaiRAM=" + loaiRAM + "]";
    }

    @Override
    public String toString1() {
        return super.toString1() + "RAM [dungLuong=" + dungLuongRAM + ", loaiRAM=" + loaiRAM + "]";
    }

    @Override
    public void xuat()
    {
        System.out.println(toString());
    }

    @Override
    public void xuat1()
    {
        System.out.println(toString1());
    }
}
