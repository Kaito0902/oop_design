package PhieuTraGop;

import HoaDon.HoaDonBanHang;
import KhachHang.TraGop;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

import static main_project.oop_project.qlhd;

public class PhieuTraGop {
    private String maPhieuTraGop;
    private HoaDonBanHang hoaDon;
    private double soTienTraTruoc;
    private double soTienConLai;
    private int soKyTraGop;
    private double soTienMoiKy;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private KyTraGop[] lichSuTraGop;
    private int soKyDaTra;
    static int soLuongPhieu = 0;
    static Scanner sc = new Scanner(System.in);
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static NumberFormat fm = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

    public PhieuTraGop() {
    }

    public PhieuTraGop(String maPhieuTraGop, String maHoaDon, double soTienTraTruoc, double soTienConLai, int soKyTraGop, double soTienMoiKy, LocalDate ngayBatDau, LocalDate ngayKetThuc, KyTraGop[] lichSuTraGop, int soKyDaTra) {
        this.maPhieuTraGop = maPhieuTraGop;
        this.hoaDon = (HoaDonBanHang) qlhd.timKiemHoaDonTheoMa(maHoaDon);
        this.soTienTraTruoc = soTienTraTruoc;
        this.soTienConLai = soTienConLai;
        this.soKyTraGop = soKyTraGop;
        this.soTienMoiKy = soTienMoiKy;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.lichSuTraGop = lichSuTraGop;
        this.soKyDaTra = soKyDaTra;
        soLuongPhieu++;
    }

    public String getMaPhieuTraGop() {
        return maPhieuTraGop;
    }

    public void setMaPhieuTraGop(String maPhieuTraGop) {
        this.maPhieuTraGop = maPhieuTraGop;
    }

    public HoaDonBanHang getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDonBanHang hoaDon) {
        this.hoaDon = hoaDon;
    }

    public double getSoTienTraTruoc() {
        return soTienTraTruoc;
    }

    public void setSoTienTraTruoc(double soTienTraTruoc) {
        this.soTienTraTruoc = soTienTraTruoc;
    }

    public double getSoTienConLai() {
        return soTienConLai;
    }

    public void setSoTienConLai(double soTienConLai) {
        this.soTienConLai = soTienConLai;
    }

    public int getSoKyTraGop() {
        return soKyTraGop;
    }

    public void setSoKyTraGop(int soKyTraGop) {
        while (soKyTraGop < 3 || soKyTraGop > 12) {
            System.out.println("So ky tra gop khong phu hop.");
            System.out.println("Vui long nhap lai so ky tra gop: ");
            soKyTraGop = Integer.parseInt(sc.nextLine());
        }
        this.soKyTraGop = soKyTraGop;
    }

    public double getSoTienMoiKy() {
        return soTienMoiKy;
    }

    public void setSoTienMoiKy(double soTienMoiKy) {
        this.soTienMoiKy = soTienMoiKy;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public KyTraGop[] getLichSuTraGop() {
        return lichSuTraGop;
    }

    public void setLichSuTraGop(KyTraGop[] lichSuTraGop) {
        this.lichSuTraGop = lichSuTraGop;
    }

    public int getSoKyDaTra() {
        return soKyDaTra;
    }

    public void setSoKyDaTra(int soKyDaTra) {
        this.soKyDaTra = soKyDaTra;
    }

    public void input(HoaDonBanHang hoaDon) {

        maPhieuTraGop = "ptg" + String.format("%03d", ++soLuongPhieu);

        setHoaDon(hoaDon);

        setSoTienTraTruoc(0.2*getHoaDon().getTongTien());

        setSoTienConLai(getHoaDon().getTongTien() - soTienTraTruoc);

        System.out.println("Nhap so ky tra gop: ");
        setSoKyTraGop(Integer.parseInt(sc.nextLine()));

        TraGop khachHangTraGop = (TraGop) getHoaDon().getKhachHang();
        setSoTienMoiKy(soTienConLai / soKyTraGop + khachHangTraGop.laiSuatTraGop()*getHoaDon().getTongTien());

        setNgayBatDau(getHoaDon().getNgayLapHoaDon());

        setNgayKetThuc(ngayBatDau.plusMonths(soKyTraGop));

        lichSuTraGop = new KyTraGop[soKyTraGop];

        soKyDaTra = 0;

        System.out.println("Phieu tra gop đa đuoc tao thanh cong!");
        System.out.println(this);
    }

    public int kyTraGopHienTai() {
        LocalDate ngayHienTai = LocalDate.now();

        long soThangDaTra = ChronoUnit.MONTHS.between(ngayBatDau, ngayHienTai);

        if (soThangDaTra <= 0) {
            return 1;
        } else if (soThangDaTra >= soKyTraGop) {
            return soKyTraGop;
        } else {
            return (int) soThangDaTra + 1;
        }
    }

    public boolean daTraHet() {
        return kyTraGopHienTai() >= soKyTraGop;
    }

    @Override
    public String toString() {
        return String.format("Phieu tra gop:\n" +
                        "- Ma phieu: %s\n" +
                        "- Ma hoa don: %s\n" +
                        "- Tong so ky: %d\n" +
                        "- So tien moi ky: %s VND\n" +
                        "- Ngay bat dau: %s\n" +
                        "- Ngay ket thuc: %s\n" +
                        "- Ky tra gop hien tai: %d/%d\n" +
                        "- Da tra het: %s",
                maPhieuTraGop, hoaDon.getMaHoaDon(), soKyTraGop, fm.format(soTienMoiKy).replace("₫", ""),
                ngayBatDau.format(formatter), ngayKetThuc.format(formatter), kyTraGopHienTai(), soKyTraGop,
                daTraHet() ? "Co" : "Chua");
    }

    public void output() {
        System.out.println(toString());
        for (int i = 0; i < lichSuTraGop.length; i++){
            System.out.println(lichSuTraGop[i].toString());
        }
        System.out.println();
    }

    public void thanhToanKy() {
        int kyHienTai = kyTraGopHienTai();

        if (soKyDaTra >= soKyTraGop) {
            System.out.println("Khach hang da hoan tat tra gop.");
            return;
        }

        if (lichSuTraGop[soKyDaTra] == null) {
            KyTraGop kyTraGop = new KyTraGop(kyHienTai, LocalDate.now(), soTienMoiKy);
            lichSuTraGop[soKyDaTra] = kyTraGop;
            soKyDaTra++;
            soTienConLai -= soTienMoiKy;

            System.out.println("Thanh toan ky " + kyHienTai + " thanh con!");
            System.out.println("So tien con lai: " + soTienConLai + " VND");

            if (soTienConLai <= 0) {
                System.out.println("Khach hang da hoan tat viec thanh toan tat ca cac ky.");
            }
        } else {
            System.out.println("Ky nay da duoc thanh toan. Vui long doi den ky tiep theo.");
        }
    }

    public void themKyTraGop(KyTraGop kyTraGop) {
        KyTraGop[] newLichSu = Arrays.copyOf(lichSuTraGop, lichSuTraGop.length + 1);
        newLichSu[lichSuTraGop.length] = kyTraGop;
        lichSuTraGop = newLichSu;
    }

}
