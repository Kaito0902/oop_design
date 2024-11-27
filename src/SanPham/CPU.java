package SanPham;

public class CPU extends PhanCung{
    private int soNhan;
    private int soLuongLoi;
    private float tanSoTurBo;

    public CPU() 
    {

    }

    public CPU(String maSP, String tenSP, float giaSP, String thoiGianBaoHanhSP, float trongLuongSP, String mauSacSP, int soLuongNhap, int soLuongXuat, int soLuongTonKho, boolean isNotDeleted, String loaiLinhKien, String nhaSanXuat, String model, int soNhan, int soLuongLoi, float tanSoTurBo) {
        super(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, soLuongNhap, soLuongXuat, soLuongTonKho, isNotDeleted, loaiLinhKien, nhaSanXuat, model);
        this.soNhan = soNhan;
        this.soLuongLoi = soLuongLoi;
        this.tanSoTurBo = tanSoTurBo;
    }

    public int getSoNhan() {
        return soNhan;
    }

    public void setSoNhan(int soNhan) {
        while(soNhan <= 0){
            System.out.println("So nhan CPU lon hon 0!");
            soNhan = Integer.parseInt(sc.nextLine());
        }
        this.soNhan = soNhan;
    }

    public int getSoLuongLoi() {
        return soLuongLoi;
    }

    public void setSoLuongLoi(int soLuongLoi) {
        while(soLuongLoi <= 0){
            System.out.println("So loi CPU lon hon 0!");
            soLuongLoi = Integer.parseInt(sc.nextLine());
        }
        this.soLuongLoi = soLuongLoi;
    }

    public float getTanSoTurBo() {
        return tanSoTurBo;
    }

    public void setTanSoTurBo(float tanSoTurBo) {
        while(tanSoTurBo <= 0){
            System.out.println("Tan so turbo CPU lon hon 0!");
            tanSoTurBo = Float.parseFloat(sc.nextLine());
        }
        this.tanSoTurBo = tanSoTurBo;
    }

    @Override
    public float thanhTien(){
        return (float)(giaSP * 1.1f);
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
        super.nhapCauHinh();
        super.loaiLinhKien = "CPU";
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
        System.out.println("Tong tien phai tra: " + thanhTien() + " VND");
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
