package PhieuTraGop;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class KyTraGop {
    private int kyThu;
    private LocalDate ngayTra;
    private double soTien;
    static Scanner sc = new Scanner(System.in);
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static NumberFormat fm = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

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
        return String.format("Ky %d: Ngay tra: %s, So tien: %s VND",
                kyThu, ngayTra, fm.format(soTien).replace("₫", ""));
    }
}
