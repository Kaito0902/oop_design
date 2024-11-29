package DoanhThu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import static main_project.oop_project.qlhd;
// import static main_project.oop_project.qldt;

import HoaDon.HoaDon;
import HoaDon.QLHoaDon;
import HoaDon.HoaDonBanHang;


public class ChiTietDoanhThu extends DoanhThu{
    private LocalDate ngayThangNam;
    private double doanhThuNgay;
    private double doanhThuThang;
    private double doanhThuNam;

    public ChiTietDoanhThu(double tongDoanhThu,String khoangThoiGian,LocalDate ngayThangNam,int doanhThuNgay, int doanhThuThang,int doanhThuNam ){
        super(tongDoanhThu, khoangThoiGian);
        this.ngayThangNam = ngayThangNam;
        this.doanhThuNgay = doanhThuNgay;
        this.doanhThuThang = doanhThuThang;
        this.doanhThuNam = doanhThuNam;
    }

    public LocalDate getNgayThangNam() {
        return ngayThangNam;
    }

    public void setNgayThangNam(LocalDate ngayThangNam) {
        this.ngayThangNam = ngayThangNam;
    }

    public double getDoanhThuNgay() {
        return doanhThuNgay;
    }

    public void setDoanhThuNgay(double doanhThuNgay) {
        this.doanhThuNgay = doanhThuNgay;
    }

    public double getDoanhThuThang() {
        return doanhThuThang;
    }

    public void setDoanhThuThang(double doanhThuThang) {
        this.doanhThuThang = doanhThuThang;
    }

    public double getDoanhThuNam() {
        return doanhThuNam;
    }
    public void thongKe_DoanhThuNgay(QLHoaDon qlHoaDon){
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    
    System.out.print("Nhap ngay muon thong ke (dd/MM/yyyy): ");
    String ngayNhap = sc.nextLine();  
    LocalDate ngayThangNam = LocalDate.parse(ngayNhap, formatter);

        HoaDon[] dshd = qlHoaDon.dshd;
        double tongDoanhThuNgay = 0;
        boolean found = false;
        System.out.println("|                         THONG KE DOANH THU THEO NGAY                    |");
        System.out.println("===========================================================================");
        System.out.printf("%-15s %-20s %-30s %-20s\n", "Ngay", "Ma hoa don", "Nhan vien lap hoa don", "Tong so tien");
        System.out.println("===========================================================================");
        
        for(HoaDon hd : dshd){
            if(hd instanceof HoaDonBanHang && hd.getNgayLapHoaDon().equals(ngayThangNam)){
                found = true;
                HoaDonBanHang hdbh = (HoaDonBanHang) hd;
                tongDoanhThuNgay +=hdbh.getTongTien();
                System.out.printf("%-15s %-20s %-30s %-20.2f\n", ngayThangNam, hd.getMaHoaDon(), hd.getNhanVienLapHoaDon(),hdbh.getTongTien());
            }
        }
        if (!found) {
            System.out.println("Khong co hoa don nao duoc lap vao ngay"+ngayThangNam);
        }else{
        System.out.println("===========================================================================");
        System.out.printf("%-65s %-20.2f\n", "Tong doanh thu trong ngay: ", tongDoanhThuNgay);
        }
        System.out.println("===========================================================================");
    }

    public void thongKe_DoanhThuThang(QLHoaDon qlHoaDon){
        HoaDon[] dshd = qlHoaDon.dshd;
        double tongDoanhThuThang = 0;
        int soHoaDon = 0;
        boolean found = false;
        int thang = ngayThangNam.getMonthValue();
        int nam = ngayThangNam.getYear();
        System.out.println("|                         THONG KE DOANH THU THEO THANG                   |");
        System.out.println("===========================================================================");
        System.out.printf("-10s %-15s %-20s %-50s %-20s\n", "Thang","So hoa don", "Ngay hoa don","Tong tien moi hoa don","Tong doanh thu" );
        System.out.println("===========================================================================");

        StringBuilder ngayHoaDon = new StringBuilder();
        StringBuilder tongTienMoiHoaDon = new StringBuilder();

        for(HoaDon hd : dshd){
            if(hd instanceof HoaDonBanHang && hd.getNgayLapHoaDon().getMonthValue() == thang && hd.getNgayLapHoaDon().getYear() == nam){
                found = true;
                HoaDonBanHang hdbh = (HoaDonBanHang) hd;
                soHoaDon++;
                tongDoanhThuThang += hdbh.getTongTien();

                //Luu ngay hoa don va tong tien
                ngayHoaDon.append(hd.getNgayLapHoaDon().getDayOfMonth()).append("/").append(thang).append(", ");
                tongTienMoiHoaDon.append(String.format("%.2f trieu", hdbh.getTongTien()/1_000_000)).append(", ");

            }
        }
        if (!found) {
            System.out.println("Khong co hoa don nao duoc lap trong thang");
        }else{
            if(ngayHoaDon.length()> 0)ngayHoaDon.setLength(ngayHoaDon.length()-2);
            if (tongTienMoiHoaDon.length() > 0) tongTienMoiHoaDon.setLength(tongTienMoiHoaDon.length() - 2);

            System.out.printf("%-10s %-20s %-50s %-20.2f\n", "Thang " + thang,soHoaDon ,ngayHoaDon.toString(), tongTienMoiHoaDon.toString(), tongDoanhThuThang);
            System.out.println("===========================================================================");
            System.out.printf("%-65s %-20.2f\n", "Tong doanh thu trong thang: ", tongDoanhThuThang);
            System.out.println("===========================================================================");
        }
    }

    public void thongKe_DoanhThuNam(QLHoaDon qlHoaDon){
        HoaDon[] dshd = qlHoaDon.dshd;
        double[] doanhThuThang = new double[12];
        double tongDoanhThuNam = 0;
        int nam = ngayThangNam.getYear();
        boolean found = false;
        System.out.println("|                         THONG KE DOANH THU THEO NAM                   |");
        System.out.println("==========================================================================================");
        System.out.printf("%-10s %-15s %-20s\n", "Nam", "Thang", "Tong doanh thu");
        System.out.println("==========================================================================================");
        
        for (HoaDon hd : dshd) {
            if (hd instanceof HoaDonBanHang && hd.getNgayLapHoaDon().getYear() == nam) {
                found = true;
                HoaDonBanHang hdbh = (HoaDonBanHang) hd;
                int month = hd.getNgayLapHoaDon().getMonthValue() - 1; 
                doanhThuThang[month] += hdbh.getTongTien();
            }
        }

        for (int i = 0; i < 12; i++) {
            if (doanhThuThang[i] > 0) {
                double doanhThuTrieu = doanhThuThang[i] / 1_000_000; 
                tongDoanhThuNam += doanhThuThang[i];
                System.out.printf("%-10d %-15s %-20.2f trieu\n", nam, "Thang " + (i + 1), doanhThuTrieu);
            }
        }
        if (!found) {
            System.out.println("Khong co hoa don nao duoc lap trong nam " + nam);
        } else {
            double tongDoanhThuTrieu = tongDoanhThuNam / 1_000_000;
            System.out.println("==========================================================================================");
            System.out.printf("%-25s %-20.2f trieu \n", "Tong doanh thu ca nam:", tongDoanhThuTrieu);
            System.out.println("==========================================================================================");
        }
    }
    public void tiLeTangTruongTheoThang(int nam) {
        double[] doanhThuThang = new double[12];
        boolean found = false;
    
        // Tính doanh thu từng tháng
        for (HoaDon hd : dshd) {
            if (hd instanceof HoaDonBanHang && hd.getNgayLapHoaDon().getYear() == nam) {
                found = true;
                HoaDonBanHang hdbh = (HoaDonBanHang) hd;
                int month = hdbh.getNgayLapHoaDon().getMonthValue() - 1;
                doanhThuThang[month] += hdbh.getTongTien();
            }
        }
    
        if (!found) {
            System.out.println("Không có hóa đơn nào được lập trong năm " + nam);
            return;
        }
    
        System.out.println("|                      TỶ LỆ TĂNG TRƯỞNG DOANH THU THEO THÁNG                     |");
        System.out.println("==========================================================================================");
        System.out.printf("%-10s %-15s %-15s %-20s\n", "Năm", "Tháng", "Tháng Trước", "Tỷ lệ tăng trưởng (%)");
        System.out.println("==========================================================================================");
    
        for (int i = 1; i < 12; i++) { // Bắt đầu từ tháng 2 để so sánh với tháng 1
            if (doanhThuThang[i] > 0 && doanhThuThang[i - 1] > 0) {
                double tiLeTangTruong = ((doanhThuThang[i] - doanhThuThang[i - 1]) / doanhThuThang[i - 1]) * 100;
                System.out.printf("%-10d %-15s %-15s %-20.2f\n", nam, "Tháng " + (i + 1), "Tháng " + i, tiLeTangTruong);
            }
        }
    
        System.out.println("==========================================================================================");
    }
    
}

