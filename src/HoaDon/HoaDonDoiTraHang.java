package HoaDon;

import NhanVien.NhanVienBanHang;
import SanPham.SanPham;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import static ChucNang.ChuanHoaDuLieu.chuanHoaSoLieu;
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

    public HoaDonDoiTraHang(String maHoaDon, LocalDate ngayLapHoaDon, String maNhanVienLapHoaDon, String maKhachHang, String loaiHoaDon, String maHoaDonGoc, ChiTietHoaDonDoiTra[] dsChiTiet, int soLuongChiTiet, double tongGiaTri, String ghiChu, double tienHoanTra, double tiLeTru) {
        super(maHoaDon, ngayLapHoaDon, maNhanVienLapHoaDon, maKhachHang, loaiHoaDon);
        this.hoaDonGoc = (HoaDonBanHang) qlhd.timKiemHoaDonTheoMa(maHoaDonGoc);
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
        while (soLuongChiTiet > hoaDonGoc.getSoLuongChiTiet() || soLuongChiTiet <= 0) {
            System.out.println("So luong da lon hon hoa don goc va lon hon 0.");
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
        this.tiLeTru = chuanHoaSoLieu(tiLeTru);
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

        setLoaiHoaDon("HoaDonDoiTraHang");

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
        setSoLuongChiTiet(Integer.parseInt(scanner.nextLine()));

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
            int soLuong = chuanHoaSoLieu(Integer.parseInt(scanner.nextLine()));

            if (soLuong > ctGoc.getSoLuong()) {
                System.out.println("So luong doi tra vuot qua so luong mua.");
                i--;
                continue;
            }

            double donGia = hdGoc.getChiTietHoaDonBanHangList()[stt - 1].getDonGia();

            System.out.print("Nhap ly do doi tra: ");
            String lyDo = scanner.nextLine();

            System.out.print("Nhap tinh trang san pham: ");
            String tinhTrang = scanner.nextLine();

            ChiTietHoaDonDoiTra chiTietDoiTra = new ChiTietHoaDonDoiTra(i + 1, spDoiTra, soLuong, lyDo, tinhTrang, donGia);
            themChiTiet(chiTietDoiTra);

            if (getNhanVienLapHoaDon() instanceof NhanVienBanHang) {
                ((NhanVienBanHang) getNhanVienLapHoaDon()).capNhatDoanhThuVaSoLuongGiaoDich(0);
            }

        }

        System.out.print("Nhap ty le tru (%): ");
        setTiLeTru(Double.parseDouble(scanner.nextLine()));

        System.out.print("Nhap ghi chu: ");
        setGhiChu(scanner.nextLine());

        tinhTongGiaTri();

        xuatPhieu();
    }

    public void themChiTiet(ChiTietHoaDonDoiTra chiTietHoaDonDoiTra) {
        ChiTietHoaDonDoiTra[] newdsChiTiet = Arrays.copyOf(dsChiTiet, soLuongChiTiet + 1);
        newdsChiTiet[soLuongChiTiet] = chiTietHoaDonDoiTra;
        dsChiTiet = newdsChiTiet;
        soLuongChiTiet++;
    }

    // Tính tổng giá trị hoàn trả và áp dụng tỷ lệ trừ
    public void tinhTongGiaTri() {
        this.tongGiaTri = 0;
        for (int i = 0; i < soLuongChiTiet; i++) {
            this.tongGiaTri += dsChiTiet[i].getThanhTien();
        }
        this.tienHoanTra = this.tongGiaTri * (1 - tiLeTru / 100);
    }

    @Override
    public String toString() {
        return super.toString()+String.format("%-15s %-15s %-10.2f %15s", fm.format(tongGiaTri).replace("₫", ""), fm.format(tienHoanTra).replace("₫", ""), tiLeTru, ghiChu);
    }

    @Override
    public void xuatPhieu() {
        System.out.println("Cua hang Dien tu J97");
        System.out.println("HOA DON BAN HANG");
        System.out.println("Thong tin khach hang");
        System.out.println("Ten khach hang: " + getKhachHang().getHoTen());
        System.out.println("So dien thoai: " + getKhachHang().getSdt());
        System.out.println("Dia chi: " + getKhachHang().getDiaChi());
        System.out.println("Thong tin hoa don goc: " + getHoaDonGoc().getMaHoaDon());
        System.out.println("Ngay mua hang: " + getHoaDonGoc().getNgayLapHoaDon().format(formatter));
        System.out.printf("%-8s %-30s %-15s %-20s %-20s %-15s %-15s\n", "STT", "Ten san pham", "So luong", "Don gia", "Thanh Tien", "Ly do", "Tinh trang");
        for (ChiTietHoaDonDoiTra ct : dsChiTiet){
            System.out.println(ct.toString());
        }
        System.out.println("Tong gia tri: " + fm.format(getTongGiaTri()).replace("₫", "VND"));
        System.out.println("Ti le khau tru: " + getTiLeTru());
        System.out.println("Tien hoan tra: " + fm.format(getTienHoanTra()).replace("₫", "VND") + " %");
        System.out.println("Ngay lap hoa don doi tra: " + getNgayLapHoaDon().format(formatter));
        System.out.println("Nhan vien xu ly: " + getNhanVienLapHoaDon().getTenNhanVien());
        System.out.println("Cam on quy khach da su dung dich vu cua J97");
    }
}
