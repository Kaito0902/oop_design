package SanPham;

public abstract class ThietBiNgoaiVi extends SanPham{
    protected String loaiThietBi;
    protected String nhaSanXuat;
    protected String phuongThucKetNoi;

    public ThietBiNgoaiVi()
    {

    }

    public ThietBiNgoaiVi(String maSP, String tenSP, float giaSP, int thoiGianBaoHanhSP, float trongLuongSP, String mauSacSP, int soLuongNhap, int soLuongXuat, int soLuongTonKho, boolean isNotDeleted, String loaiThietBi, String nhaSanXuat, String phuongThucKetNoi) {
        super(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, soLuongNhap, soLuongXuat, soLuongTonKho, isNotDeleted);
        this.loaiThietBi = loaiThietBi;
        this.nhaSanXuat = nhaSanXuat;
        this.phuongThucKetNoi = phuongThucKetNoi;
    }

    public String getLoaiThietBi()
    {
        return loaiThietBi;
    }

    public void setLoaiThietBi(String loaiThietBi) 
    {
        this.loaiThietBi = loaiThietBi;
    }

    public String getPhuongThucKetNoi() 
    {
        return phuongThucKetNoi;
    }

    public void setPhuongThucKetNoi(String phuongThucKetNoi) 
    {
        this.phuongThucKetNoi = phuongThucKetNoi;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }
    
    @Override
    public void nhap()
    {
        super.nhap();
        System.out.println("Nhap nha san xuat: ");
        setNhaSanXuat(sc.nextLine());
        System.out.println("Nhap phuong thuc ket noi: ");
        setPhuongThucKetNoi(sc.nextLine());
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-15s %-15s %-15s", nhaSanXuat, loaiThietBi, phuongThucKetNoi);
    }

    @Override
    public void xuat(){
        super.xuat();
        System.out.println("Loai thiet bi: " + loaiThietBi);
        System.out.println("Nha san xuat thiet bi: " + nhaSanXuat);
        System.out.println("Phuong thuc ket noi cua thiet bi: " + phuongThucKetNoi);
    }
}

