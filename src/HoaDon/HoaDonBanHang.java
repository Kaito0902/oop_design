package HoaDon;

import java.util.Scanner;

public class HoaDonBanHang extends HoaDon {
    private ChiTietHoaDon[] chiTietHoaDonList; // Danh sách chi tiết hóa đơn
    private int soLuongChiTiet; // Số lượng chi tiết hiện tại
    private String phuongThucThanhToan; // Phương thức thanh toán

    private final int MAX_CHI_TIET = 100; // Số lượng chi tiết tối đa
    static Scanner scanner = new Scanner(System.in);
    
    public HoaDonBanHang() {
        super();
        chiTietHoaDonList = new ChiTietHoaDon[MAX_CHI_TIET];
        soLuongChiTiet = 0;
        phuongThucThanhToan = "Chưa xác định";
    }

    // Nhập dữ liệu cho hóa đơn bán hàng
    @Override
    public void input() {
        super.input(); // Gọi phương thức nhập từ lớp cha

        System.out.print("Nhap phuong thuc thanh toan (Tien mat/Chuyen khoan): ");
        this.phuongThucThanhToan = scanner.nextLine();

        System.out.print("Nhap so luong chi tiet hoa don: ");
        int soLuong = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < soLuong; i++) {
            if (soLuongChiTiet < MAX_CHI_TIET) {
                System.out.println("Nhap chi tiet hoa don thu " + (soLuongChiTiet + 1) + ":");
                ChiTietHoaDon chiTiet = new ChiTietHoaDon();
                chiTiet.input(soLuongChiTiet + 1);
                chiTietHoaDonList[soLuongChiTiet] = chiTiet;
                soLuongChiTiet++;
            } else {
                System.out.println("Khong the them chi tiet hoa don, da dat so luong toi da.");
                break;
            }
        }
        // Cập nhật tổng số tiền
        tongSoTien = tinhTongTien();
    }

    public double tinhTongTien() {
        double tong = 0;
        for (int i = 0; i < soLuongChiTiet; i++) {
            tong += chiTietHoaDonList[i].getThanhTien();
        }
        return tong;
    }

    public ChiTietHoaDon[] getChiTietHoaDonList() {
        return chiTietHoaDonList;
    }

    public int getSoLuongChiTiet() {
        return soLuongChiTiet;
    }

    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    @Override
    public void xuat() {
        super.xuat(); // Gọi phương thức xuất từ lớp cha
        System.out.println("Phuong thuc thanh toan: " + phuongThucThanhToan);
        System.out.println("Chi tiet hoa don:");
        System.out.printf("%-10s %-20s %-10s %-15s %-15s\n", "STT", "Ten SP", "So luong", "Don gia", "Thanh tien");
        for (int i = 0; i < soLuongChiTiet; i++) {
            chiTietHoaDonList[i].xuat();
        }
        System.out.printf("Tong tien: %.2f\n", tinhTongTien());
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(",").append(phuongThucThanhToan);
        for (int i = 0; i < soLuongChiTiet; i++) {
            builder.append(",").append(chiTietHoaDonList[i].toString());
        }
        return builder.toString();
    }

    // Đọc thông tin từ chuỗi (hỗ trợ đọc file)
    @Override
    public void fromString(String data) {
        String[] parts = data.split(",", 3);
        super.fromString(parts[0] + "," + parts[1]); // Đọc thông tin cơ bản từ lớp cha
        this.phuongThucThanhToan = parts[2];

        String[] chiTietData = parts[3].split(","); // Các chi tiết ngăn cách bởi dấu phẩy
        soLuongChiTiet = 0;
        for (String chiTiet : chiTietData) {
            ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
            chiTietHoaDon.fromString(chiTiet);
            chiTietHoaDonList[soLuongChiTiet++] = chiTietHoaDon;
        }
    }
}
