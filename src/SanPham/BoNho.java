package SanPham;

public class BoNho extends PhanCung{
    private int dungLuongBoNho;
    private String loaiBoNho;

    public BoNho() 
    {

    }

    public BoNho(String maSP, String tenSP, float giaSP, int thoiGianBaoHanhSP, float trongLuongSP, String mauSacSP,
            String nhaSanXuat, String loaiLinhKien, String model, int dungLuongBoNho, String loaiBoNho) {
        super(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, nhaSanXuat, loaiLinhKien, model);
        this.dungLuongBoNho = dungLuongBoNho;
        this.loaiBoNho = loaiBoNho;
    }

    public int getDungLuongBoNho() {
        return dungLuongBoNho;
    }

    public void setDungLuongBoNho(int dungLuongBoNho) {
        this.dungLuongBoNho = dungLuongBoNho;
    }

    public String getLoaiBoNho() {
        return loaiBoNho;
    }

    public void setLoaiBoNho(String loaiBoNho) {
        this.loaiBoNho = loaiBoNho;
    }

    @Override
    public float thanhTien(){
        return 1;
    }

    @Override
    public void nhap()
    {
        super.nhap();
        System.out.println("Nhap dung luong: ");
        setDungLuongBoNho(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap loai bo nho: ");
        setLoaiBoNho(sc.nextLine());
    }  
    
    @Override
    public String toString() 
    {
        return super.toString() + String.format("%-10d %-20s", dungLuongBoNho, loaiBoNho);
    }
    
    @Override
    public void xuat()
    {
        super.xuat();
        System.out.println("Dung luong bo nho: " + dungLuongBoNho + "GB");
        System.out.println("Loai bo nho: " + loaiBoNho);
    }

    @Override
    public void nhapCauHinh()
    {
        System.out.println("Nhap dung luong: ");
        setDungLuongBoNho(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap loai bo nho: ");
        setLoaiBoNho(sc.nextLine());
    }

    @Override
    public void hienThiCauHinh()
    {
        System.out.println("Dung luong bo nho: " + dungLuongBoNho + "GB");
        System.out.println("Loai bo nho: " + loaiBoNho);
    }
}
