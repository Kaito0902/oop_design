package SanPham;

public class SanPham implements Comparable<SanPham> {
    public final String sanPham = null;
    private String maSanPham;
    private String tenSanPham;
    private DanhMuc danhMuc;
    private String thuongHieu;
    private double giaBan;
    public static int soLuongTon;
    public static int giaSP;

    public SanPham(String maSanPham, String tenSanPham, DanhMuc danhMuc, String thuongHieu, double giaBan, int soLuongTon) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.danhMuc = danhMuc;
        this.thuongHieu = thuongHieu;
        this.giaBan = giaBan;
        this.soLuongTon = soLuongTon;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "maSanPham='" + maSanPham + '\'' +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", danhMuc='" + danhMuc + '\'' +
                ", thuongHieu='" + thuongHieu + '\'' +
                ", giaBan=" + giaBan +
                ", soLuongTon=" + soLuongTon +
                '}';
    }


    @Override
    public int compareTo(SanPham o) {
        return 0;
    }

    public void input() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'input'");
    }
}
