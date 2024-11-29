package SanPham;

public class RAM extends PhanCung{
    private int dungLuongRAM;
    private String loaiRAM;

    public RAM() 
    {

    }

    public RAM(String maSP, String tenSP, float giaSP, int thoiGianBaoHanhSP, float trongLuongSP, String mauSacSP, int soLuongNhap, int soLuongXuat, int soLuongTonKho, boolean isNotDeleted, String loaiLinhKien, String nhaSanXuat, String model, int dungLuongRAM, String loaiRAM) {
        super(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, soLuongNhap, soLuongXuat, soLuongTonKho, isNotDeleted, loaiLinhKien, nhaSanXuat, model);
        this.dungLuongRAM = dungLuongRAM;
        this.loaiRAM = loaiRAM;
    }

    public int getDungLuongRAM() {
        return dungLuongRAM;
    }

    public void setDungLuongRAM(int dungLuongRAM) {
        while(!(dungLuongRAM <= 64 && dungLuongRAM % 4 == 0)){
            System.out.println("Dung luong RAM phai theo don vi RAM tieu chuan");
            dungLuongRAM = Integer.parseInt(sc.nextLine());
        }
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
        return (float)(giaSP * 1.2f);
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
        super.nhapCauHinh();
        super.loaiLinhKien = "RAM";
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
