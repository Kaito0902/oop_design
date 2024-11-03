package SanPham;

public abstract class ThietBiNgoaiVi extends SanPham{
    protected String nhaSanXuat;
    protected String loaiThietBi;
    protected String phuongThucKetNoi;

    public ThietBiNgoaiVi()
    {

    } 

    public ThietBiNgoaiVi(String maSP, String tenSP, float giaSP, float khuyenMaiSP, int thoiGianBaoHanhSP,
            float trongLuongSP, String mauSacSP, String nhaSanXuat, String loaiThietBi, String phuongThucKetNoi) {
        super(maSP, tenSP, giaSP, khuyenMaiSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP);
        this.nhaSanXuat = nhaSanXuat;
        this.loaiThietBi = loaiThietBi;
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
        System.out.println("Nhap loai thiet bi: ");
        setLoaiThietBi(sc.nextLine());
        System.out.println("Nhap phuong thuc ket noi: ");
        setPhuongThucKetNoi(sc.nextLine());
    }

    @Override
    public String toString() {
        return super.toString() + "ThietBiNgoaiVi [nhaSanXuat=" + nhaSanXuat + ", loaiThietBi=" + loaiThietBi + ", phuongThucKetNoi="
                + phuongThucKetNoi + "]";
    }

    @Override
    public void xuat()
    {
        System.out.println(toString());
    }
}

