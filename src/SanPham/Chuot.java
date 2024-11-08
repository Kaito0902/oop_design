package SanPham;

public class Chuot extends ThietBiNgoaiVi{
    private int dPI;
    private int soLanBam;
    private String denLED;
    private String loaiChuot;

    public Chuot()
    {

    }

    

    public Chuot(String maSP, String tenSP, float giaSP, float khuyenMaiSP, int thoiGianBaoHanhSP, float trongLuongSP,
            String mauSacSP, String nhaSanXuat, String loaiThietBi, String phuongThucKetNoi, int dPI, int soLanBam,
            String denLED, String loaiChuot) {
        super(maSP, tenSP, giaSP, khuyenMaiSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, nhaSanXuat, loaiThietBi,
                phuongThucKetNoi);
        this.dPI = dPI;
        this.soLanBam = soLanBam;
        this.denLED = denLED;
        this.loaiChuot = loaiChuot;
    }

    public int getdPI() {
        return dPI;
    }

    public void setdPI(int dPI) {
        this.dPI = dPI;
    }

    public int getSoLanBam() {
        return soLanBam;
    }

    public void setSoLanBam(int soLanBam) {
        this.soLanBam = soLanBam;
    }

    public String getDenLED() {
        return denLED;
    }

    public void setDenLED(String denLED) {
        this.denLED = denLED;
    }

    public String getLoaiChuot() {
        return loaiChuot;
    }

    public void setLoaiChuot(String loaiChuot) {
        this.loaiChuot = loaiChuot;
    }


    @Override
    public void nhap()
    {
        super.nhap();
        System.out.println("Nhap DPI chuot: ");
        setdPI(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap so lan bam chuot: ");
        setSoLanBam(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap den LED chuot: ");
        setDenLED(sc.nextLine());
        System.out.println("Nhap loai chuot: ");
        setLoaiChuot(sc.nextLine());
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-10d %-10d %-15s", dPI, soLanBam, loaiChuot);
    }


}
