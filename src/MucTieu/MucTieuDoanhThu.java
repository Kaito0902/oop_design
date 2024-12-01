package MucTieu;

import java.text.NumberFormat;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MucTieuDoanhThu {
    private YearMonth thangNam; 
    private double doanhThu;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
    static NumberFormat fm = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

    public MucTieuDoanhThu(YearMonth thangNam, double doanhThu) {
        this.thangNam = thangNam;
        this.doanhThu = doanhThu;
    }

    public YearMonth getThangNam() {
        return thangNam;
    }

    public void setThangNam(YearMonth thangNam) {
        this.thangNam = thangNam;
    }

    public double getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(double doanhThu) {
        this.doanhThu = doanhThu;
    }

    @Override
    public String toString() {
        return "Muc tieu doanh thu thang " + thangNam.format(formatter) + ": " + fm.format(doanhThu).replace("₫", "VND");
    }
}
