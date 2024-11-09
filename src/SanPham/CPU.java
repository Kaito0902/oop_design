package SanPham;

public class CPU extends PhanCung{
    private int soNhan;
    private int soLuongLoi;
    private int tocDoXungNhip;

    public CPU() 
    {

    } 
    
    public CPU(int soNhan, int soLuongLoi, int tocDoXungNhip) {
        this.soNhan = soNhan;
        this.soLuongLoi = soLuongLoi;
        this.tocDoXungNhip = tocDoXungNhip;
    }

    

    public CPU(String maSP, String tenSP, float giaSP, int thoiGianBaoHanhSP, float trongLuongSP, String mauSacSP,
            String nhaSanXuat, String loaiLinhKien, String model, int soNhan, int soLuongLoi, int tocDoXungNhip) {
        super(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, nhaSanXuat, loaiLinhKien, model);
        this.soNhan = soNhan;
        this.soLuongLoi = soLuongLoi;
        this.tocDoXungNhip = tocDoXungNhip;
    }

    public int getSoNhan() {
        return soNhan;
    }

    public void setSoNhan(int soNhan) {
        this.soNhan = soNhan;
    }

    public int getSoLuongLoi() {
        return soLuongLoi;
    }

    public void setSoLuongLoi(int soLuongLoi) {
        this.soLuongLoi = soLuongLoi;
    }

    public int getTocDoXungNhip() {
        return tocDoXungNhip;
    }

    public void setTocDoXungNhip(int tocDoXungNhip) {
        this.tocDoXungNhip = tocDoXungNhip;
    }

    @Override
    public float thanhTien(){
        return 1;
    }

    @Override
    public void nhap()
    {
        super.nhap();
        System.out.println("Nhap so nhan: ");
        setSoNhan(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap so luong loi: ");
        setSoLuongLoi(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap toc do xung nhip: ");
        setTocDoXungNhip(Integer.parseInt(sc.nextLine()));
    }  
    
    @Override
    public void nhap1()
    {
        super.nhap1();
        System.out.println("Nhap so nhan: ");
        setSoNhan(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap so luong loi: ");
        setSoLuongLoi(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap toc do xung nhip: ");
        setTocDoXungNhip(Integer.parseInt(sc.nextLine()));
    }

    @Override
    public String toString() 
    {
        return super.toString() + String.format("%-10d %-10d %-10d", soNhan, soLuongLoi, tocDoXungNhip);
    }

    @Override
    public String toString1() 
    {
        return super.toString1() + "CPU [soNhan=" + soNhan + ", soLuong=" + soLuongLoi + ", tocDoXungNhip=" + tocDoXungNhip + "]";
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
