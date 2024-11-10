package SanPham;

import java.util.Arrays;

public abstract class MayTinh extends SanPham{
    protected String nhaSanXuat;
    protected String model;
    protected String loaiMayTinh;
    protected String heDieuHanh;
    protected String coCardRoi;
    protected PhanCung[] cacLinhKien;

    public MayTinh()
    {

    }

    public MayTinh(String maSP, String tenSP, float giaSP, int thoiGianBaoHanhSP, float trongLuongSP, String mauSacSP,
            String nhaSanXuat, String model, String loaiMayTinh, String heDieuHanh, String coCardRoi,
            PhanCung[] cacLinhKien) {
        super(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP);
        this.nhaSanXuat = nhaSanXuat;
        this.model = model;
        this.loaiMayTinh = loaiMayTinh;
        this.heDieuHanh = heDieuHanh;
        this.coCardRoi = coCardRoi;
        this.cacLinhKien = cacLinhKien;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLoaiMayTinh() {
        return loaiMayTinh;
    }

    public void setLoaiMayTinh(String loaiMayTinh) {
        this.loaiMayTinh = loaiMayTinh;
    }

    public String getHeDieuHanh() {
        return heDieuHanh;
    }

    public void setHeDieuHanh(String heDieuHanh) {
        this.heDieuHanh = heDieuHanh;
    }

    public String getCoCardRoi() {
        return coCardRoi;
    }

    public void setCoCardRoi(String coCardRoi) {
        this.coCardRoi = coCardRoi;
    }

    public PhanCung[] getCacLinhKien() {
        return cacLinhKien;
    }

    public void setCacLinhKien(PhanCung[] cacLinhKien) {
        this.cacLinhKien = cacLinhKien;
    }

    public void themPhanCung(PhanCung phanCung) 
    {
        PhanCung[] newCacLinhKien = Arrays.copyOf(this.cacLinhKien, this.cacLinhKien.length + 1);
        newCacLinhKien[this.cacLinhKien.length] = phanCung;
        this.cacLinhKien = newCacLinhKien;
    }

    @Override
    public void nhap()
    {
        super.nhap();
        System.out.println("Nhap nha san xuat: ");
        setNhaSanXuat(sc.nextLine());
        System.out.println("Nhap model san pham: ");
        setModel(sc.nextLine());
        System.out.println("Nhap he dieu hanh: ");
        setHeDieuHanh(sc.nextLine());
        System.out.println("Co card roi khong: ");
        setCoCardRoi(sc.nextLine());

        System.out.println("Nhap cau hinh may tinh: ");
        this.cacLinhKien = new PhanCung[0];

        System.out.println("CPU: ");
        CPU cpu = new CPU();
        cpu.nhapCauHinh();
        themPhanCung(cpu);

        System.out.println("GPU: ");
        GPU gpu = new GPU();
        gpu.nhapCauHinh();
        themPhanCung(gpu);

        System.out.println("RAM: ");
        RAM ram = new RAM();
        ram.nhapCauHinh();
        themPhanCung(ram);
    
        System.out.println("Bo Nho: ");
        BoNho boNho = new BoNho();
        boNho.nhapCauHinh();
        themPhanCung(boNho);
    }

    @Override
    public void xuat(){
        super.xuat();
        System.out.println("Loai may tinh: " + loaiMayTinh);
        System.out.println("Nha san xuat may tinh: " + nhaSanXuat);
        System.out.println("Model may tinh: " + model);
        System.out.println("He dieu hanh may tinh: " + heDieuHanh);
        System.out.println("May tinh " + coCardRoi + " card roi");
    }
}
