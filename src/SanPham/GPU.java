package SanPham;

public class GPU extends PhanCung{
    private int dungLuongVRAM;
    private String loaiVRAM;
    private int tocDoXungNhip;
    private int soNhanCUDA;
    private String rayTracing;

    public GPU() 
    {

    }

    public GPU(int dungLuongVRAM, String loaiVRAM, int tocDoXungNhip, int soNhanCUDA, String rayTracing) {
        this.dungLuongVRAM = dungLuongVRAM;
        this.loaiVRAM = loaiVRAM;
        this.tocDoXungNhip = tocDoXungNhip;
        this.soNhanCUDA = soNhanCUDA;
        this.rayTracing = rayTracing;
    }

    public GPU(String maSP, String tenSP, float giaSP, int thoiGianBaoHanhSP, float trongLuongSP, String mauSacSP,
            String nhaSanXuat, String loaiLinhKien, String model, int dungLuongVRAM, String loaiVRAM, int tocDoXungNhip,
            int soNhanCUDA, String rayTracing) {
        super(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, nhaSanXuat, loaiLinhKien, model);
        this.dungLuongVRAM = dungLuongVRAM;
        this.loaiVRAM = loaiVRAM;
        this.tocDoXungNhip = tocDoXungNhip;
        this.soNhanCUDA = soNhanCUDA;
        this.rayTracing = rayTracing;
    }

    public int getDungLuongVRAM() {
        return dungLuongVRAM;
    }

    public void setDungLuongVRAM(int dungLuongVRAM) {
        this.dungLuongVRAM = dungLuongVRAM;
    }

    public String getLoaiVRAM() {
        return loaiVRAM;
    }

    public void setLoaiVRAM(String loaiVRAM) {
        this.loaiVRAM = loaiVRAM;
    }

    public int getTocDoXungNhip() {
        return tocDoXungNhip;
    }

    public void setTocDoXungNhip(int tocDoXungNhip) {
        this.tocDoXungNhip = tocDoXungNhip;
    }

    public int getSoNhanCUDA() {
        return soNhanCUDA;
    }

    public void setSoNhanCUDA(int soNhanCUDA) {
        this.soNhanCUDA = soNhanCUDA;
    }

    public String getCoRayTracing(){
        return rayTracing;
    }

    public void setRayTracing(String rayTracing) {
        this.rayTracing = rayTracing;
    }

    @Override
    public float thanhTien(){
        return 1;
    }

    @Override
    public void nhap()
    {
        super.nhap();
        System.out.println("Nhap dung luong VRAM: ");
        setDungLuongVRAM(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap loai VRAM: ");
        setLoaiVRAM(sc.nextLine());
        System.out.println("Nhap toc do xung nhip: ");
        setTocDoXungNhip(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap so nhan CUDA: ");
        setSoNhanCUDA(Integer.parseInt(sc.nextLine()));
        System.out.println("Co Ray Tracing khong: ");
        System.out.println(sc.nextLine());
    }     
    
    @Override
    public void nhap1()
    {
        super.nhap1();
        System.out.println("Nhap dung luong VRAM: ");
        setDungLuongVRAM(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap loai VRAM: ");
        setLoaiVRAM(sc.nextLine());
        System.out.println("Nhap toc do xung nhip: ");
        setTocDoXungNhip(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap so nhan CUDA: ");
        setSoNhanCUDA(Integer.parseInt(sc.nextLine()));
        System.out.println("Co Ray Tracing khong: ");
        System.out.println(sc.nextLine());
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-10d %-15s %-10d %-10d %-10s", dungLuongVRAM, loaiVRAM, tocDoXungNhip, soNhanCUDA, rayTracing);
    }

    @Override
    public String toString1() {
        return super.toString1() + "GPU [dungLuongVRAM=" + dungLuongVRAM + ", loaiVRAM=" + loaiVRAM + ", tocDoXungNhip=" + tocDoXungNhip
                + ", soNhanCUDA=" + soNhanCUDA + ", rayTracing=" + rayTracing + "]";
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
