package HoaDon;

import java.time.LocalDate;
import java.util.Scanner;

public class QLKhuyenMai {
    private KhuyenMai[] danhSachKhuyenMai;
    private int soLuongKhuyenMai;

    public QLKhuyenMai(int kichThuocBanDau) {
        danhSachKhuyenMai = new KhuyenMai[kichThuocBanDau];
        soLuongKhuyenMai = 0;
    }

    public void themKhuyenMai(KhuyenMai km) {
        if (soLuongKhuyenMai == danhSachKhuyenMai.length) {
            tangKichThuocMang();
        }
        danhSachKhuyenMai[soLuongKhuyenMai] = km;
        soLuongKhuyenMai++;
    }

    // Tăng kích thước mảng khi mảng đầy
    private void tangKichThuocMang() {
        int kichThuocMoi = danhSachKhuyenMai.length * 2;
        KhuyenMai[] mangMoi = new KhuyenMai[kichThuocMoi];
        for (int i = 0; i < danhSachKhuyenMai.length; i++) {
            mangMoi[i] = danhSachKhuyenMai[i];
        }
        danhSachKhuyenMai = mangMoi;
    }

    public KhuyenMai timKhuyenMai(String maKhuyenMai) {
        for (int i = 0; i < soLuongKhuyenMai; i++) {
            if (danhSachKhuyenMai[i].getMaKhuyenMai().equals(maKhuyenMai)) {
                return danhSachKhuyenMai[i];
            }
        }
        return null; // Không tìm thấy khuyến mãi với mã này
    }

    public void hienThiDanhSachKhuyenMai() {
        if (soLuongKhuyenMai == 0) {
            System.out.println("Không có khuyến mãi nào trong danh sách.");
        } else {
            for (int i = 0; i < soLuongKhuyenMai; i++) {
                System.out.println(danhSachKhuyenMai[i]);
            }
        }
    }

    public void nhapKhuyenMaiMoi() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã khuyến mãi: ");
        String maKhuyenMai = sc.nextLine();
        System.out.print("Nhập tên khuyến mãi: ");
        String tenKhuyenMai = sc.nextLine();
        System.out.print("Nhập ngày bắt đầu (YYYY-MM-DD): ");
        LocalDate ngayBatDau = LocalDate.parse(sc.nextLine());
        System.out.print("Nhập ngày kết thúc (YYYY-MM-DD): ");
        LocalDate ngayKetThuc = LocalDate.parse(sc.nextLine());
        System.out.print("Nhập điều kiện áp dụng: ");
        String dieuKienApDung = sc.nextLine();
        System.out.print("Nhập sản phẩm áp dụng: ");
        String sanPhamApDung = sc.nextLine();
        System.out.print("Nhập tổng khuyến mãi (%): ");
        double tongKhuyenMai = sc.nextDouble();

        KhuyenMai km = new KhuyenMai(maKhuyenMai, tenKhuyenMai, ngayBatDau, ngayKetThuc, dieuKienApDung, sanPhamApDung, tongKhuyenMai);
        themKhuyenMai(km);
        System.out.println("Thêm khuyến mãi thành công.");
    }
}
