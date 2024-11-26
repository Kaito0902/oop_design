package HoaDon;

import KhachHang.KhachHang;
import NhanVien.NhanVien;
import SanPham.SanPham;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import static main_project.oop_project.qlhd;

public class HoaDonDoiTraHang extends HoaDon {
    private HoaDonBanHang hoaDonGoc;
    private ChiTietHoaDonDoiTra[] dsChiTiet = new ChiTietHoaDonDoiTra[0];
    private int soLuongChiTiet = 0;
    private double tongGiaTri; // tong so tien hoan tra
    private String ghiChu; 
    private double tienHoanTra; // Số tiền hoàn trả sau khi trừ %
    private double tiLeTru; // Tỷ lệ phần trăm trừ vào số tiền hoàn trả
    static Scanner scanner = new Scanner(System.in);

    public HoaDonDoiTraHang() {
    }

    public HoaDonDoiTraHang(String maHoaDon, LocalDate ngayLapHoaDon, NhanVien nhanVienLapHoaDon, KhachHang khachHang, HoaDonBanHang hoaDonGoc, ChiTietHoaDonDoiTra[] dsChiTiet, int soLuongChiTiet, double tongGiaTri, String ghiChu, double tienHoanTra, double tiLeTru) {
        super(maHoaDon, ngayLapHoaDon, nhanVienLapHoaDon, khachHang);
        this.hoaDonGoc = hoaDonGoc;
        this.dsChiTiet = dsChiTiet;
        this.soLuongChiTiet = soLuongChiTiet;
        this.tongGiaTri = tongGiaTri;
        this.ghiChu = ghiChu;
        this.tienHoanTra = tienHoanTra;
        this.tiLeTru = tiLeTru;
    }


    public HoaDon getHoaDonGoc() {
        return hoaDonGoc;
    }

    public ChiTietHoaDonDoiTra[] getDsChiTiet() {
        return dsChiTiet;
    }

    public void setDsChiTiet(ChiTietHoaDonDoiTra[] dsChiTiet) {
        this.dsChiTiet = dsChiTiet;
    }

    public int getSoLuongChiTiet() {
        return soLuongChiTiet;
    }

    public void setSoLuongChiTiet(int soLuongChiTiet) {
        while (soLuongChiTiet > hoaDonGoc.getSoLuongChiTiet()) {
            System.out.println("So luong da lon hon hoa don goc.");
            System.out.println("Nhap lai so luong chi tiet: ");
            soLuongChiTiet = Integer.parseInt(scanner.nextLine());
        }
        this.soLuongChiTiet = soLuongChiTiet;
    }

    public double getTongGiaTri() {
        return tongGiaTri;
    }

    public void setTongGiaTri(double tongGiaTri) {
        this.tongGiaTri = tongGiaTri;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public double getTienHoanTra() {
        return tienHoanTra;
    }

    public void setTienHoanTra(double tienHoanTra) {
        this.tienHoanTra = tienHoanTra;
    }

    public double getTiLeTru() {
        return tiLeTru;
    }

    public void setTiLeTru(double tiLeTru) {
        this.tiLeTru = tiLeTru;
    }

    public void setHoaDonGoc(HoaDonBanHang hoaDonGoc) {
        while (hoaDonGoc == null) {
            System.out.println("Khong tim thay hoa don goc.");
            System.out.println("Nhap lai ma hoa don goc: ");
            HoaDon hd = qlhd.timKiemHoaDonTheoMa(scanner.nextLine());
            hoaDonGoc = (HoaDonBanHang) hd;
        }
        this.hoaDonGoc = hoaDonGoc;
    }

    // Nhập thông tin hóa đơn đổi trả
    @Override
    public void input() {
        super.input();

        System.out.println("Nhap ma hoa don goc: ");
        HoaDon hd = qlhd.timKiemHoaDonTheoMa(scanner.nextLine());
        HoaDonBanHang hdGoc = (HoaDonBanHang) hd;
        setHoaDonGoc(hdGoc);

        System.out.println("Danh sach san pham trong hoa don goc:");
        for (int i = 0; i < hdGoc.getSoLuongChiTiet(); i++)
        {
            System.out.printf("%d. %s (So luong: %d)\n", i + 1, hdGoc.getChiTietHoaDonBanHangList()[i].getSanPham().getTenSP(), hdGoc.getChiTietHoaDonBanHangList()[i].getSoLuong());
        }

        System.out.print("Nhap so luong chi tiet doi tra: ");
        setSoLuongChiTiet(scanner.nextInt());

        for (int i = 0; i < soLuongChiTiet; i++) {
            System.out.print("Chon san pham doi tra (nhap so thu tu): ");
            int stt = Integer.parseInt(scanner.nextLine());

            if (stt < 1 || stt > hdGoc.getSoLuongChiTiet()) {
                System.out.println("So thu tu khong hop le.");
                i--; // Nhập lại sản phẩm
                continue;
            }

            ChiTietHoaDonBanHang ctGoc = hdGoc.getChiTietHoaDonBanHangList()[stt - 1];
            SanPham spDoiTra = ctGoc.getSanPham();

            System.out.print("Nhap so luong doi tra: ");
            int soLuong = Integer.parseInt(scanner.nextLine());

            if (soLuong > ctGoc.getSoLuong()) {
                System.out.println("So luong doi tra vuot qua so luong mua.");
                i--;
                continue;
            }

            System.out.print("Nhap ly do doi tra: ");
            String lyDo = scanner.nextLine();

            System.out.print("Nhap tinh trang san pham (Moi/Cu/Hong): ");
            String tinhTrang = scanner.nextLine();

            ChiTietHoaDonDoiTra chiTietDoiTra = new ChiTietHoaDonDoiTra(i + 1,spDoiTra, soLuong, lyDo, tinhTrang);
            themChiTiet(chiTietDoiTra);

        }

        System.out.print("Nhap ty le tru (%): ");
        this.tiLeTru = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhap ghi chu: ");
        this.ghiChu = scanner.nextLine();
        tinhTongGiaTri();

    }

    public void themChiTiet(ChiTietHoaDonDoiTra chiTietHoaDonDoiTra) {
        ChiTietHoaDonDoiTra[] newdsChiTiet = Arrays.copyOf(dsChiTiet, soLuongChiTiet + 1);
        newdsChiTiet[soLuongChiTiet] = chiTietHoaDonDoiTra;
        dsChiTiet = newdsChiTiet;
        soLuongChiTiet++;
    }

    // Tính tổng giá trị hoàn trả và áp dụng tỷ lệ trừ
    private void tinhTongGiaTri() {
        this.tongGiaTri = 0;
        for (int i = 0; i < soLuongChiTiet; i++) {
            this.tongGiaTri += dsChiTiet[i].getThanhTien();
        }
        this.tienHoanTra = this.tongGiaTri * (1 - tiLeTru / 100);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(",").append(hoaDonGoc.toString());
        for (int i = 0; i < soLuongChiTiet; i++) {
            builder.append(",").append(dsChiTiet[i].toString());
        }
        builder.append(",").append(tongGiaTri)
               .append(",").append(tiLeTru)
               .append(",").append(tienHoanTra)
               .append(",").append(ghiChu);
        return builder.toString();
    }
}
