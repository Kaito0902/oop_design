package SanPham;

public class BoNho extends PhanCung{
    private int dungLuongBoNho;
    private String loaiBoNho;

    public BoNho() 
    {

    }

    public BoNho(int dungLuongBoNho, String loaiBoNho) {
        this.dungLuongBoNho = dungLuongBoNho;
        this.loaiBoNho = loaiBoNho;
    }

    public BoNho(String maSP, String tenSP, float giaSP, float khuyenMaiSP, int thoiGianBaoHanhSP, float trongLuongSP,
            String mauSacSP, String nhaSanXuat, String loaiLinhKien, String model, int dungLuongBoNho,
            String loaiBoNho) {
        super(maSP, tenSP, giaSP, khuyenMaiSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, nhaSanXuat, loaiLinhKien,
                model);
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
    public void nhap()
    {
        super.nhap();
        System.out.println("Nhap dung luong: ");
        setDungLuongBoNho(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap loai bo nho: ");
        setLoaiBoNho(sc.nextLine());
    }  
    
    @Override
    public void nhap1()
    {
        super.nhap1();
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
    public String toString1() 
    {
        return super.toString1() + "BoNho [dungLuong=" + dungLuongBoNho + ", loaiBoNho=" + loaiBoNho + "]";
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
