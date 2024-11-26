package SanPham;

public class BoNho extends PhanCung{
    private int dungLuongBoNho;
    private String loaiBoNho;

    public BoNho() 
    {

    }

    public BoNho(String maSP, String tenSP, float giaSP, String thoiGianBaoHanhSP, float trongLuongSP, String mauSacSP, int soLuongNhap, boolean isNotDeleted, String loaiLinhKien, String nhaSanXuat, String model, int dungLuongBoNho, String loaiBoNho){
        super(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, soLuongNhap, isNotDeleted, loaiLinhKien, nhaSanXuat, model);
        this.dungLuongBoNho = dungLuongBoNho;
        this.loaiBoNho = loaiBoNho;
    }

    public int getDungLuongBoNho() {
        return dungLuongBoNho;
    }

    public void setDungLuongBoNho(int dungLuongBoNho) {
        while(!(dungLuongBoNho <= 1024 && dungLuongBoNho % 128 == 0)){
            System.out.println("Dung luong Bo Nho phai theo don vi Bo Nho tieu chuan");
            dungLuongBoNho = Integer.parseInt(sc.nextLine());
        }
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
        return (float)(giaSP * 1.15f);
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
        System.out.println("Tong tien phai tra: " + String.format("%.3f", thanhTien()) + " VND");
    }

    @Override
    public void nhapCauHinh()
    {
        super.nhapCauHinh();
        super.loaiLinhKien = "Bo Nho";
        System.out.println("Nhap dung luong: ");
        setDungLuongBoNho(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap loai bo nho: ");
        setLoaiBoNho(sc.nextLine());
    }

    @Override
    public void hienThiCauHinh()
    {
        super.hienThiCauHinh();
        System.out.println("Dung luong bo nho: " + dungLuongBoNho + "GB");
        System.out.println("Loai bo nho: " + loaiBoNho);
    }
}
