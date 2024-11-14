package SanPham;

public class RAM extends PhanCung{
    private int dungLuongRAM;
    private String loaiRAM;

    public RAM() 
    {

    }

    public RAM(String maSP, String tenSP, float giaSP, String thoiGianBaoHanhSP, float trongLuongSP, String mauSacSP, String loaiLinhKien, String nhaSanXuat, String model, int dungLuongRAM, String loaiRAM){
        super(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, loaiLinhKien, nhaSanXuat, model);
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
        System.out.println("Tong tien phai tra: " + String.format("%.3f", thanhTien()) + " VND");
    }

    @Override
    public void hienThiCauHinh()
    {
        super.hienThiCauHinh();
        System.out.println("Dung luong RAM: " + dungLuongRAM + "GB");
        System.out.println("Loai RAM: " + loaiRAM);
    }
}
