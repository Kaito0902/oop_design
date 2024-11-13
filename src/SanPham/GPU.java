package SanPham;

public class GPU extends PhanCung{
    private int dungLuongVRAM;
    private String loaiVRAM;
    private float tocDoXungNhip;
    private int soNhanCUDA;
    private String rayTracing;

    public GPU() 
    {

    }

    public GPU(String maSP, String tenSP, float giaSP, String thoiGianBaoHanhSP, float trongLuongSP, String mauSacSP, String loaiLinhKien,
            String nhaSanXuat, String model, int dungLuongVRAM, String loaiVRAM, float tocDoXungNhip, int soNhanCUDA, String rayTracing){
        super(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, loaiLinhKien, nhaSanXuat, model);
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

    public float getTocDoXungNhip() {
        return tocDoXungNhip;
    }

    public void setTocDoXungNhip(float tocDoXungNhip) {
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
        System.out.println("Nhap dung luong VRAM: ");
        setDungLuongVRAM(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap loai VRAM: ");
        setLoaiVRAM(sc.nextLine());
        System.out.println("Nhap toc do xung nhip: ");
        setTocDoXungNhip(Float.parseFloat(sc.nextLine()));
        System.out.println("Nhap so nhan CUDA: ");
        setSoNhanCUDA(Integer.parseInt(sc.nextLine()));
        System.out.println("Co Ray Tracing khong: ");
        System.out.println(sc.nextLine());
    }     

    @Override
    public void nhapCauHinh()
    {
        System.out.println("Nhap dung luong VRAM: ");
        setDungLuongVRAM(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap loai VRAM: ");
        setLoaiVRAM(sc.nextLine());
        System.out.println("Nhap toc do xung nhip: ");
        setTocDoXungNhip(Float.parseFloat(sc.nextLine()));
        System.out.println("Nhap so nhan CUDA: ");
        setSoNhanCUDA(Integer.parseInt(sc.nextLine()));
        System.out.println("Co Ray Tracing khong: ");
        System.out.println(sc.nextLine());
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-10d %-15s %-10f %-10d %-10s", dungLuongVRAM, loaiVRAM, tocDoXungNhip, soNhanCUDA, rayTracing);
    }

    @Override
    public void xuat()
    {
        super.xuat();
        System.out.println("Dung luong VRAM GPU: " + dungLuongVRAM + "GB");
        System.out.println("Nhap loai VRAM: " + loaiVRAM);
        System.out.println("Nhap toc do xung nhip: " + tocDoXungNhip +"Ghz");
        System.out.println("So nhan CUDA: " + soNhanCUDA);
        System.out.println("GPU " + rayTracing + " RayTracing");
        System.out.println("Tong tien phai tra: " + thanhTien() + " VND");
    }

    @Override
    public void hienThiCauHinh()
    {
        super.hienThiCauHinh();
        System.out.println("Dung luong VRAM GPU: " + dungLuongVRAM + "GB");
        System.out.println("Nhap loai VRAM: " + loaiVRAM);
        System.out.println("Nhap toc do xung nhip: " + tocDoXungNhip +"Ghz");
        System.out.println("So nhan CUDA: " + soNhanCUDA);
        System.out.println("GPU " + rayTracing + " RayTracing");
    }
}
