package SanPham;

public class GPU extends PhanCung{
    private int dungLuongVRAM;
    private String loaiVRAM;
    private int tocDoXungNhip;
    private int soNhanCUDA;
    private boolean rayTracing;

    public GPU() 
    {

    }

    public GPU(int dungLuongVRAM, String loaiVRAM, int tocDoXungNhip, int soNhanCUDA, boolean rayTracing) {
        this.dungLuongVRAM = dungLuongVRAM;
        this.loaiVRAM = loaiVRAM;
        this.tocDoXungNhip = tocDoXungNhip;
        this.soNhanCUDA = soNhanCUDA;
        this.rayTracing = rayTracing;
    }

    public GPU(int dungLuongVRAM, String loaiVRAM, boolean rayTracing, int soNhanCUDA, int tocDoXungNhip, String maSP, String tenSP, float giaSP, float khuyenMaiSP, int thoiGianBaoHanhSP, float trongLuongSP, String mauSacSP, String nhaSanXuat, String loaiLinhKien, String model) {
        super(maSP, tenSP, giaSP, khuyenMaiSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, nhaSanXuat, loaiLinhKien, model);
        this.dungLuongVRAM = dungLuongVRAM;
        this.loaiVRAM = loaiVRAM;
        this.rayTracing = rayTracing;
        this.soNhanCUDA = soNhanCUDA;
        this.tocDoXungNhip = tocDoXungNhip;
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

    public boolean isRayTracing() {
        return rayTracing;
    }

    public void setRayTracing(boolean rayTracing) {
        this.rayTracing = rayTracing;
    }

    @Override
    public float ThanhTien(){
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
        System.out.println(Boolean.parseBoolean(sc.nextLine()));
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
        System.out.println(Boolean.parseBoolean(sc.nextLine()));
    }

    @Override
    public String toString() {
        return super.toString() + "GPU [dungLuongVRAM=" + dungLuongVRAM + ", loaiVRAM=" + loaiVRAM + ", tocDoXungNhip=" + tocDoXungNhip
                + ", soNhanCUDA=" + soNhanCUDA + ", rayTracing=" + rayTracing + "]";
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
