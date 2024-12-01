package HoaDon;

import java.time.LocalDate;
import java.util.Arrays;

import KhachHang.KhachHangDoiTacDoanhNghiep;
import KhachHang.KhachHangVip;
import KhuyenMai.KhuyenMai;
import NhanVien.NhanVienBanHang;
import PhieuTraGop.PhieuTraGop;

import static ChucNang.ChuanHoaDuLieu.chuanHoaSoLieu;
import static main_project.oop_project.*;

public class HoaDonBanHang extends HoaDon {
    private ChiTietHoaDonBanHang[] chiTietHoaDonBanHangList = new ChiTietHoaDonBanHang[0]; // Danh sách chi tiết hóa đơn
    private int soLuongChiTiet = 0;
    private KhuyenMai khuyenMai; // Chương trình khuyến mãi
    private double tienThue;
    private double chietKhau;
    private String phuongThucThanhToan; 
    private double tongTien; // Tổng tiền của hóa đơn
    private boolean traGop;

    // Constructor mặc định
    public HoaDonBanHang() {
    }

    // constructor day du tham so
    public HoaDonBanHang(String maHoaDon, LocalDate ngayLapHoaDon, String maNhanVienLapHoaDon, String maKhachHang, String loaiHoaDon, ChiTietHoaDonBanHang[] chiTietHoaDonBanHangList, int soLuongChiTiet, String maKhuyenMai, double tienThue, double chietKhau, String phuongThucThanhToan, double tongTien, boolean traGop) {
        super(maHoaDon, ngayLapHoaDon, maNhanVienLapHoaDon, maKhachHang, loaiHoaDon);
        this.chiTietHoaDonBanHangList = chiTietHoaDonBanHangList;
        this.soLuongChiTiet = soLuongChiTiet;
        if (!maKhuyenMai.equals("KHONGAPMA")){
            this.khuyenMai = qlkm.timKhuyenMai(maKhuyenMai);
        } else {
            this.khuyenMai = null;
        }
        this.tienThue = tienThue;
        this.chietKhau = chietKhau;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.tongTien = tongTien;
        this.traGop = traGop;
    }

    public ChiTietHoaDonBanHang[] getChiTietHoaDonBanHangList() {
        return chiTietHoaDonBanHangList;
    }

    public int getSoLuongChiTiet() {
        return soLuongChiTiet;
    }

    public KhuyenMai getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(KhuyenMai khuyenMai) {
        do {
            while (khuyenMai == null) {
                System.out.println("Khuyen mai khong phu hop.");
                System.out.println("Vui long nhap lai ma khuyen mai: ");
                khuyenMai = qlkm.timKhuyenMai(scanner.nextLine());
            }
            if (getNgayLapHoaDon().isBefore(khuyenMai.getNgayBatDau()) ||
                    getNgayLapHoaDon().isAfter(khuyenMai.getNgayKetThuc())) {
                System.out.println("Ngay lap hoa don khong nam trong thoi gian khuyen mai.");
                System.out.println("Vui long nhap lai ma khuyen mai: ");
                khuyenMai = null;
            }

        } while (khuyenMai == null ||
                getNgayLapHoaDon().isBefore(khuyenMai.getNgayBatDau()) ||
                getNgayLapHoaDon().isAfter(khuyenMai.getNgayKetThuc()));

        this.khuyenMai = khuyenMai;
    }


    public double getTienThue() {
        return tienThue;
    }

    public void setTienThue(double tienThue) {
        this.tienThue = chuanHoaSoLieu(tienThue);
    }

    public double getChietKhau() {
        return chietKhau;
    }

    public void setChietKhau(double chietKhau) {
        this.chietKhau = chuanHoaSoLieu(chietKhau);
    }

    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setChiTietHoaDonBanHangList(ChiTietHoaDonBanHang[] chiTietHoaDonBanHangList) {
        this.chiTietHoaDonBanHangList = chiTietHoaDonBanHangList;
    }

    public boolean isTraGop() {
        return traGop;
    }

    public void setTraGop(boolean traGop) {
        this.traGop = traGop;
    }

    public void setSoLuongChiTiet(int soLuongChiTiet) {
        this.soLuongChiTiet = soLuongChiTiet;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public void themChiTietHoaDonBanHang(ChiTietHoaDonBanHang chiTietHoaDonBanHang) {
        ChiTietHoaDonBanHang[] newdsChiTietHoaDonBanHang = Arrays.copyOf(chiTietHoaDonBanHangList, soLuongChiTiet + 1);
        newdsChiTietHoaDonBanHang[soLuongChiTiet] = chiTietHoaDonBanHang;
        chiTietHoaDonBanHangList = newdsChiTietHoaDonBanHang;
        soLuongChiTiet++;
    }

    @Override
    public void input() {
        super.input();

        setLoaiHoaDon("HoaDonBanHang");

        System.out.print("Nhap so luong chi tiet hoa don: ");
        int soLuong = chuanHoaSoLieu(Integer.parseInt(scanner.nextLine()));

        for (int i = 1; i <= soLuong; i++) {
            System.out.println("Nhap chi tiet hoa don thu " + (i) + ":");
            ChiTietHoaDonBanHang chiTiet = new ChiTietHoaDonBanHang();
            chiTiet.input(i);
            themChiTietHoaDonBanHang(chiTiet);
        }

        System.out.print("Nhap tien thue (theo %): ");
        setTienThue(Double.parseDouble(scanner.nextLine()));

        System.out.print("Nhap chiet khau (theo %): ");
        setChietKhau(Double.parseDouble(scanner.nextLine()));

        System.out.print("Nhap phuong thuc thanh toan: ");
        setPhuongThucThanhToan(scanner.nextLine());

        System.out.println("Co ap dung khuyen mai khong? (Co/Khong):");
        String apDungKhuyenMai = scanner.nextLine().trim();

        if (apDungKhuyenMai.equalsIgnoreCase("Co")) {
            System.out.println("Nhap ma khuyen mai:");
            setKhuyenMai(qlkm.timKhuyenMai(scanner.nextLine()));
        } else {
            khuyenMai = null;
        }

        tinhTongTien();

        if (getNhanVienLapHoaDon() instanceof NhanVienBanHang) {
            ((NhanVienBanHang) getNhanVienLapHoaDon()).capNhatDoanhThuVaSoLuongGiaoDich(getTongTien());
        }

        traGop();

        getKhachHang().capNhatDiemThuong(getTongTien());

        xuatPhieu();
    }

    public void suDungDiem() {
        boolean ktra = true;
        while (ktra) {
            if (getKhachHang().getTichDiem() >= 100) {
                System.out.println("Co muon su dung diem de giam gia?");
                System.out.println("1. Co");
                System.out.println("2. Khong");
                int lc = Integer.parseInt(scanner.nextLine());
                switch (lc) {
                    case 1: {
                        int tichDiem = getKhachHang().getTichDiem();
                        double giamGia = tichDiem * 500;

                        if (giamGia >= tongTien) {
                            giamGia = tongTien;
                            int diemSuDung = (int) (tongTien / 500);
                            getKhachHang().setTichDiem(tichDiem - diemSuDung);
                        } else {
                            getKhachHang().setTichDiem(0);
                        }

                        tongTien -= giamGia;
                        System.out.println("Bạn đã giảm giá " + giamGia + " đồng.");
                        System.out.println("Số tiền còn lại: " + tongTien + " đồng.");
                        ktra = false;
                        break;
                    }
                    case 2: {
                        ktra = false;
                        break;
                    }
                    default: {
                        System.out.println("Lua chon khong hop le.");
                        System.out.println("Vui long lua chon lai.");
                    }
                }
            } else {
                ktra = false;
            }
        }
    }

    public void traGop() {
        boolean ktra = true;
        while (ktra){
            if ((getKhachHang() instanceof KhachHangVip || getKhachHang() instanceof KhachHangDoiTacDoanhNghiep) && getTongTien() >= 3000000) {
                System.out.println("Co muon tra gop hay khong ?");
                System.out.println("1. Co");
                System.out.println("2. Khong");
                System.out.println("Nhap lua chon: ");
                int lc = Integer.parseInt(scanner.nextLine());
                switch (lc) {
                    case 1: {
                        PhieuTraGop phieu = new PhieuTraGop();
                        phieu.input(this);
                        qlptg.themPhieuTraGop(phieu);
                        setTraGop(true);
                        ktra = false;
                        break;
                    }
                    case 2: {
                        setTraGop(false);
                        ktra = false;
                        break;
                    }
                    default: {
                        System.out.println("Lua chon khong hop le.");
                        System.out.println("Vui long lua chon lai.");
                    }
                }
            }
            else {
                ktra = false;
            }
        }
    }

    // Phương thức tính tổng tiền hóa đơn
    public void tinhTongTien() {
        tongTien = 0;
        for (int i = 0; i < soLuongChiTiet; i++) {
            tongTien += chiTietHoaDonBanHangList[i].getThanhTien();
        }
        tongTien += tongTien * (tienThue / 100); // Thêm thuế
        tongTien -= tongTien * (chietKhau / 100); // Trừ chiết khấu
        if(khuyenMai != null){
            tongTien -= tongTien * (khuyenMai.getTongKhuyenMai() / 100); // Trừ khuyến mãi
        }
    }

    @Override
    public String toString() {
        String maKhuyenMai = (khuyenMai != null) ? khuyenMai.getMaKhuyenMai() : "KHONGAPMA";
        return super.toString() + String.format("%-12s %-8.2f %-8.2f %-15s %-10s",
                maKhuyenMai, tienThue, chietKhau,
                phuongThucThanhToan, fm.format(tongTien).replace("₫", ""));
    }

    @Override
    public void xuatPhieu() {
        System.out.println("Cua hang Dien tu J97");
        System.out.println("HOA DON BAN HANG");
        System.out.println("Thong tin khach hang");
        System.out.println("Ten khach hang: " + getKhachHang().getHoTen());
        System.out.println("So dien thoai: " + getKhachHang().getSdt());
        System.out.println("Dia chi: " + getKhachHang().getDiaChi());
        System.out.printf("%-8s %-30s %-15s %-20s %-20s\n", "STT", "Ten san pham", "So luong", "Don gia", "Thanh Tien");
        for (ChiTietHoaDonBanHang ct : chiTietHoaDonBanHangList){
            System.out.println(ct.toString());
        }
        System.out.println("Thue: " + getTienThue() + " %");
        System.out.println("Chiet khau: " + getChietKhau() + " %");
        if (getKhuyenMai() != null){
            System.out.println("Khuyen mai: " + getKhuyenMai().getTenKhuyenMai());
        }
        System.out.println("Tổng cộng: " + fm.format(getTongTien()).replace("₫", "VND"));
        System.out.println("Ngay lap hoa don: " + getNgayLapHoaDon().format(formatter));
        System.out.println("Nhan vien lap hoa don: " + getNhanVienLapHoaDon().getTenNhanVien());
        System.out.println("Cam on quy khach da mua hang tai J97!");
    }

}
