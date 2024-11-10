package SanPham;

public class CPU extends PhanCung{
    private int soNhan;
    private int soLuongLoi;
    private float tanSoTurBo;

    public CPU() 
    {

    } 

    public CPU(int soLuongLoi, int soNhan, float tanSoTurBo) {
        this.soLuongLoi = soLuongLoi;
        this.soNhan = soNhan;
        this.tanSoTurBo = tanSoTurBo;
    }

    public CPU(int soLuongLoi, int soNhan, float tanSoTurBo, String maSP, String tenSP, float giaSP, int thoiGianBaoHanhSP, float trongLuongSP, String mauSacSP, String nhaSanXuat, String loaiLinhKien, String model) {
        super(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, nhaSanXuat, loaiLinhKien, model);
        this.soLuongLoi = soLuongLoi;
        this.soNhan = soNhan;
        this.tanSoTurBo = tanSoTurBo;
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

    public float getTanSoTurBo() {
        return tanSoTurBo;
    }

    public void setTanSoTurBo(float tanSoTurBo) {
        this.tanSoTurBo = tanSoTurBo;
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
        System.out.println("Nhap tan so turbo: ");
        setTanSoTurBo(Float.parseFloat(sc.nextLine()));
    }  
    
    @Override
    public void nhapCauHinh()
    {
        System.out.println("Nhap so nhan: ");
        setSoNhan(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap so luong loi: ");
        setSoLuongLoi(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap toc do xung nhip: ");
        setTanSoTurBo(Float.parseFloat(sc.nextLine()));
    }

    @Override
    public String toString() 
    {
        return super.toString() + String.format("%-10d %-10d %-10f", soNhan, soLuongLoi, tanSoTurBo);
    }

    @Override
    public void xuat()
    {
        super.xuat();
        System.out.println("So nhan CPU: " + soNhan);
        System.out.println("So loi CPU: " + soLuongLoi);
        System.out.println("Tan so turbo CPU: " + tanSoTurBo + "GHz");
    }

    @Override
    public void hienThiCauHinh()
    {
        super.hienThiCauHinh();
        System.out.println("So nhan CPU: " + soNhan);
        System.out.println("So loi CPU: " + soLuongLoi);
        System.out.println("Tan so turbo CPU: " + tanSoTurBo + "GHz");
    }
}
