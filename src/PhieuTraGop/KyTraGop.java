package PhieuTraGop;

import java.time.LocalDate;
import java.util.Scanner;

public class KyTraGop {
    private int kyThu;
    private LocalDate ngayTra;
    private double soTien;
    static Scanner sc = new Scanner(System.in);

    public KyTraGop() {
    }

    public KyTraGop(int kyThu, LocalDate ngayTra, double soTien) {
        this.kyThu = kyThu;
        this.ngayTra = ngayTra;
        this.soTien = soTien;
    }

    public int getKyThu() {
        return kyThu;
    }

    public void setKyThu(int kyThu) {
        this.kyThu = kyThu;
    }

    public LocalDate getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(LocalDate ngayTra) {
        this.ngayTra = ngayTra;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    @Override
    public String toString() {
        return String.format("Kỳ %d: Ngày trả: %s, Số tiền: %.2f VND",
                kyThu, ngayTra, soTien);
    }
}
