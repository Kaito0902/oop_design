package HoaDon;

import KhachHang.KhachHang;
import SanPham.SanPham;
import NhanVien.NhanVien;
import DonDatHang.DonDatHang;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

import static main_project.oop_project.qlddh;
import static main_project.oop_project.qlnv;

public class QLHoaDon {
    HoaDon[] dshd = new HoaDon[0];
    static Scanner sc = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public HoaDon[] getDshd() {
        return dshd;
    }

    // Thêm hóa đơn mới
    public void themHD(HoaDon hd) {
        dshd = Arrays.copyOf(dshd, dshd.length + 1);
        dshd[dshd.length - 1] = hd;
    }

    // Xuất danh sách hóa đơn
    public void xuatdshd() {
        if (dshd.length == 0) {
            System.out.println("Danh sach hoa don trong!");
            return;
        }
        for (HoaDon hd : dshd) {
            hd.xuat();
            System.out.println();
        }
    }

    // tìm kiếm hóa đơn theo mã
    public HoaDon timKiemHoaDonTheoMa(String maHoaDon) {
        for (HoaDon hd : dshd) {
            if (hd != null && hd.getMaHoaDon().equals(maHoaDon)) {
                return hd;
            }
        }
        return null;
    }

    public void timKiemHoaDon(String soDienThoai) {
        boolean found = false;
        for (HoaDon hd : dshd) {
            if (hd.getKhachHang().getSdt().equals(soDienThoai)) {
                found = true;
                hd.xuat();
            }
        }
        if (!found) {
            System.out.println("Khong tim thay hoa don cua khach hang: ");
        }
    }

    public SanPham timSanPhamTrongHoaDon(String soDienThoai, String maSanPham) {
        for (HoaDon hd : dshd) {
            if (hd instanceof  HoaDonBanHang hdbh && hd.getKhachHang().getSdt().equals(soDienThoai)) {
                for (ChiTietHoaDonBanHang ct : hdbh.getChiTietHoaDonBanHangList()) {
                    if (ct.getSanPham().getMaSP().equals(maSanPham) && tinhThoiHan(ct.getSanPham().getThoiGianBaoHanhSP(), hd.getNgayLapHoaDon())) {
                        return ct.getSanPham();
                    }
                }
            }
        }
        return null;
    }

    public void HienSanPhamBaoHanh(KhachHang kh) {
        for (HoaDon hd : dshd) {
            if (hd.getKhachHang().equals(kh)) {
                if (hd instanceof HoaDonBanHang hdbh) {
                    for (ChiTietHoaDonBanHang ct : hdbh.getChiTietHoaDonBanHangList()) {
                        boolean conBaoHanh = tinhThoiHan(ct.getSanPham().getThoiGianBaoHanhSP(), hd.getNgayLapHoaDon());
                        if (conBaoHanh) {
                            System.out.printf("%-8s %-25s %-15s\n",ct.getSanPham().getMaSP(), ct.getSanPham().getTenSP(), " Con han bao hanh");
                        } else {
                            System.out.printf("%-8s %-25s %-15s",ct.getSanPham().getMaSP(), ct.getSanPham().getTenSP(), " Het han bao hanh");
                        }
                    }
                }
            }
        }
    }


    public boolean tinhThoiHan(int tgianBaoHanhSP, LocalDate ngayMuaSP) {
        LocalDate ngayHetHan = ngayMuaSP.plusMonths(tgianBaoHanhSP);
        LocalDate today = LocalDate.now();
        return today.isBefore(ngayHetHan);
    }

    // Lấy số lượng hóa đơn hiện tại
    public void laySLHoaDon() {
        System.out.println("So luong hoa don hien tai: " + dshd.length);
    }

    public void ghiVaoFileDSHD() {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("src/HoaDon/DanhSachHoaDon.txt"))) {
            for (HoaDon hd : dshd) {
                if (hd instanceof HoaDonBanHang hdbh) {
                    String maKhuyenMai = "";
                    if (hdbh.getKhuyenMai() != null) {
                        maKhuyenMai = hdbh.getKhuyenMai().getMaKhuyenMai();
                    }
                    else {
                        maKhuyenMai = "KHONGAPMA";
                    }
                    writer.write(String.join(",",
                            hdbh.getMaHoaDon(),
                            String.valueOf(hdbh.getNgayLapHoaDon().format(formatter)),
                            hdbh.getNhanVienLapHoaDon().getMaNhanVien(),
                            hdbh.getNhanVienLapHoaDon().getTenNhanVien(),
                            hdbh.getKhachHang().getMaKhachHang(),
                            hdbh.getKhachHang().getHoTen(),
                            hdbh.getLoaiHoaDon(),
                            maKhuyenMai,
                            String.valueOf(hdbh.getTienThue()),
                            String.valueOf(hdbh.getChietKhau()),
                            hdbh.getPhuongThucThanhToan(),
                            String.valueOf(hdbh.getTongTien()),
                            String.valueOf(hdbh.isTraGop())
                    ));
                    writer.newLine();
                    for(ChiTietHoaDonBanHang ctbh : hdbh.getChiTietHoaDonBanHangList()){
                        writer.write(String.join(",",
                                "ChiTietHoaDonBanHang",
                                String.valueOf(ctbh.getStt()),
                                ctbh.getSanPham().getMaSP(),
                                ctbh.getSanPham().getTenSP(),
                                String.valueOf(ctbh.getSoLuong()),
                                String.valueOf(ctbh.getThanhTien())
                        ));
                        writer.newLine();
                    }
                } else if (hd instanceof HoaDonDoiTraHang hddth){
                    writer.write(String.join(",",
                            hddth.getMaHoaDon(),
                            String.valueOf(hddth.getNgayLapHoaDon().format(formatter)),
                            hddth.getNhanVienLapHoaDon().getMaNhanVien(),
                            hddth.getNhanVienLapHoaDon().getTenNhanVien(),
                            hddth.getKhachHang().getMaKhachHang(),
                            hddth.getKhachHang().getHoTen(),
                            hddth.getLoaiHoaDon(),
                            hddth.getHoaDonGoc().getMaHoaDon(),
                            String.valueOf(hddth.getTongGiaTri()),
                            hddth.getGhiChu(),
                            String.valueOf(hddth.getTienHoanTra()),
                            String.valueOf(hddth.getTiLeTru())));
                    writer.newLine();
                    for(ChiTietHoaDonDoiTra ctdt : hddth.getDsChiTiet()){
                        writer.write(String.join(",",
                                "ChiTietHoaDonDoiTraHang",
                                String.valueOf(ctdt.getStt()),
                                ctdt.getSanPhamTra().getMaSP(),
                                ctdt.getSanPhamTra().getTenSP(),
                                String.valueOf(ctdt.getSoLuong()),
                                ctdt.getLyDo(),
                                ctdt.getTinhTrang(),
                                String.valueOf(ctdt.getThanhTien())
                        ));
                        writer.newLine();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public void docTuFileDSHD() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/HoaDon/DanhSachHoaDon.txt"))) {
            String line;
            HoaDon hd = null;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (data[0].startsWith("hd")){
                    if (data[6].equals("HoaDonBanHang")) {
                        String maHoaDon = data[0];
                        LocalDate ngayLapHoaDon = LocalDate.parse(data[1], formatter);
                        String maNhanVien = data[2];
                        String tenNhanVien = data[3];
                        String maKhachHang = data[4];
                        String tenKhachHang = data[5];
                        String loaiHoaDon = data[6];
                        String maKhuyenMai = data[7];
                        double tienThue = Double.parseDouble(data[8]);
                        double chietKhau = Double.parseDouble(data[9]);
                        String phuongThucThanhToan = data[10];
                        double tongTien = Double.parseDouble(data[11]);
                        boolean traGop = Boolean.parseBoolean(data[12]);
                        hd = new HoaDonBanHang(maHoaDon, ngayLapHoaDon, maNhanVien, maKhachHang, loaiHoaDon, new ChiTietHoaDonBanHang[0], 0, maKhuyenMai, tienThue, chietKhau, phuongThucThanhToan, tongTien, traGop);
                    } else if (data[6].equals("HoaDonDoiTraHang")) {
                        String maHoaDon = data[0];
                        LocalDate ngayLapHoaDon = LocalDate.parse(data[1], formatter);
                        String maNhanVien = data[2];
                        String tenNhanVien = data[3];
                        String maKhachHang = data[4];
                        String tenKhachHang = data[5];
                        String loaiHoaDon = data[6];
                        String maHoaDonGoc = data[7];
                        double tongGiaTri = Double.parseDouble(data[8]);
                        String ghiChu = data[9];
                        double tienHoanTra = Double.parseDouble(data[10]);
                        double tiLeTru = Double.parseDouble(data[11]);
                        hd = new HoaDonDoiTraHang(maHoaDon, ngayLapHoaDon, maNhanVien, maKhachHang, loaiHoaDon, maHoaDonGoc, new ChiTietHoaDonDoiTra[0], 0, tongGiaTri, ghiChu, tienHoanTra, tiLeTru);
                    }
                    themHD(hd);
                } else if (data[0].equals("ChiTietHoaDonBanHang") && hd instanceof HoaDonBanHang hdbh) {
                    int stt = Integer.parseInt(data[1]);
                    String maSP = data[2];
                    String tenSP = data[3];
                    int soLuong = Integer.parseInt(data[4]);
                    double thanhTien = Double.parseDouble(data[5]);

                    ChiTietHoaDonBanHang ctbh = new ChiTietHoaDonBanHang(stt, maSP, soLuong, thanhTien);
                    hdbh.themChiTietHoaDonBanHang(ctbh);
                    hdbh.setSoLuongChiTiet(hdbh.getChiTietHoaDonBanHangList().length);

                } else if (data[0].equals("ChiTietHoaDonDoiTraHang") && hd instanceof HoaDonDoiTraHang hddth) {
                    int stt = Integer.parseInt(data[1]);
                    String maSP = data[2];
                    String tenSP = data[3];
                    int soLuong = Integer.parseInt(data[4]);
                    String lyDo = data[5];
                    String tinhTrang = data[6];
                    double thanhTien = Double.parseDouble(data[7]);

                    ChiTietHoaDonDoiTra ctdt = new ChiTietHoaDonDoiTra(stt, maSP, soLuong, lyDo, tinhTrang, thanhTien);
                    hddth.themChiTiet(ctdt);
                    hddth.setSoLuongChiTiet(hddth.getDsChiTiet().length);
                } else {
                    System.out.println("Dong khong hop le: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Loi doc file" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Loi xu li du lieu: " + e.getMessage());
        }
    }

    public double tinhTongTien(String maKhachHang) {
        double sum = 0;
        for (HoaDon hd : dshd) {
            if (hd instanceof HoaDonBanHang hdbh) {
                if (hdbh.getKhachHang().getMaKhachHang().equals(maKhachHang)) {
                    sum += hdbh.getTongTien();
                }
            }
        }
        return sum;
    }

    public void sapXepHoaDonTheoLoai() {
        for (int i = 0; i < dshd.length - 1; i++) {
            for (int j = 0; j < dshd.length - i - 1; j++) {
                boolean isFirstDoiTra = dshd[j] instanceof HoaDonDoiTraHang;
                boolean isSecondBanHang = dshd[j + 1] instanceof HoaDonBanHang;
                if (isFirstDoiTra && isSecondBanHang) {
                    HoaDon temp = dshd[j];
                    dshd[j] = dshd[j + 1];
                    dshd[j + 1] = temp;
                }
            }
        }
        System.out.println("Sau khi sap xep: ");
        for (HoaDon hd : dshd) {
            if (hd instanceof HoaDonBanHang hdbh) {
                hdbh.xuat();
            } else if (hd instanceof HoaDonDoiTraHang hddt) {
                hddt.xuat();
            }
        }
    }

    public double tinhTongDoanhThuThangHienTai() {
        LocalDate today = LocalDate.now();
        int thangHienTai = today.getMonthValue();
        int namHienTai = today.getYear();

        double tongDoanhThu = 0;
        for (HoaDon hd : dshd) {
            if (hd instanceof HoaDonBanHang hdbh) {
                if (hdbh.getNgayLapHoaDon().getMonthValue() == thangHienTai &&
                        hdbh.getNgayLapHoaDon().getYear() == namHienTai) {
                    tongDoanhThu += hdbh.getTongTien();
                }
            }
        }
        return tongDoanhThu;
    }



    //Bui Nguyen Thinh
    public void thongKe_DoanhThuNgay() {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Nhap ngay muon thong ke (dd/MM/yyyy): ");
        String ngayNhap = sc.nextLine();
        LocalDate ngayThangNam = LocalDate.parse(ngayNhap, formatter);

        String ngayThangNamFormatted = ngayThangNam.format(formatter);


        HoaDon[] dshd = this.dshd;
        double tongDoanhThuNgay = 0;
        boolean found = false;

        System.out.println("|                         THONG KE DOANH THU THEO NGAY                       |");
        System.out.println("==============================================================================");
        System.out.printf("%-15s %-20s %-30s %-20s\n", "Ngay", "Ma hoa don", "Nhan vien lap hoa don", "Tong so tien");
        System.out.println("==============================================================================");

        for (HoaDon hd : dshd) {
            if (hd instanceof HoaDonBanHang && hd.getNgayLapHoaDon().equals(ngayThangNam)) {
                found = true;
                HoaDonBanHang hdbh = (HoaDonBanHang) hd;
                tongDoanhThuNgay += hdbh.getTongTien();
                System.out.printf("%-15s %-20s %-30s %-20.2f\n", ngayThangNam, hd.getMaHoaDon(), hd.getNhanVienLapHoaDon().getTenNhanVien(), hdbh.getTongTien());
            }
        }


        if (!found) {
            System.out.println("Khong co hoa don nao duoc lap vao ngay " + ngayThangNamFormatted);
        } else {
            System.out.println("==============================================================================");
            System.out.printf("%-65s %-20.2s\n", "Tong doanh thu trong ngay: ", tongDoanhThuNgay + "VND");
        }
        System.out.println("==============================================================================");
    }


    public void thongKe_DoanhThuThang() {
        Scanner sc = new Scanner(System.in);
        HoaDon[] dshd = this.dshd; // Lấy danh sách hóa đơn hiện tại
        double tongDoanhThuThang = 0;
        int soHoaDon = 0;
        boolean found = false;

        // Định dạng để nhập tháng/năm
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");

        // Nhập tháng/năm cần thống kê
        System.out.print("Nhap thang va nam can thong ke (MM/yyyy): ");
        String thangNamNhap = sc.nextLine();

        try {
            LocalDate ngayThangNam = LocalDate.parse("01/" + thangNamNhap, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            int thang = ngayThangNam.getMonthValue();
            int nam = ngayThangNam.getYear();

            // Dòng kẻ ngang cố định
            String separator = "=".repeat(100);
            String subSeparator = "-".repeat(100);

            // Tiêu đề bảng
            System.out.println("|                         THONG KE DOANH THU THEO THANG                   |");
            System.out.println(separator);
            System.out.printf("%-10s %-15s %25s %30s\n", "Thang", "So hoa don", "Ngay hoa don", "Tong tien moi hoa don");
            System.out.println(separator);

            for (HoaDon hd : dshd) {
                if (hd instanceof HoaDonBanHang && hd.getNgayLapHoaDon().getMonthValue() == thang && hd.getNgayLapHoaDon().getYear() == nam) {
                    found = true;
                    soHoaDon++;
                }
            }

            // Chỉ in thông tin "Tháng" và "Số hóa đơn" nếu có hóa đơn trong tháng
            if (found) {
                System.out.printf("%-10s %-15d\n", "Thang " + thang, soHoaDon);
            }


            for (HoaDon hd : dshd) {
                if (hd instanceof HoaDonBanHang hdbh && hd.getNgayLapHoaDon().getMonthValue() == thang && hd.getNgayLapHoaDon().getYear() == nam) {
                    tongDoanhThuThang += hdbh.getTongTien();
                    System.out.printf("%50s %28s\n",
                            hd.getNgayLapHoaDon().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                            String.format("%.2f VND", hdbh.getTongTien()));
                }
            }

            // Kết quả cuối cùng
            if (!found) {
                System.out.println("Khong co hoa don nao duoc lap trong thang " + thangNamNhap);
            } else {

                System.out.println(subSeparator);
                System.out.printf("%-65s %-20.2f\n", "Tong doanh thu trong thang: ", tongDoanhThuThang);
                System.out.println(subSeparator);
            }
        } catch (Exception e) {
            System.out.println("Loi: Vui long nhap thang va nam dung dinh dang (MM/yyyy).");
        }
    }

    public void thongKe_DoanhThuNam() {
        System.out.print("Nhap nam can thong ke doanh thu: ");
        int nam = sc.nextInt(); // Nhap nam tu ban phim
        double[] doanhThuThang = new double[12];
        double tongDoanhThuNam = 0;
        boolean found = false;

        System.out.println("|                          THONG KE DOANH THU THEO NAM                         |");
        System.out.println("=============================================================================================");
        System.out.printf("%-10s %-15s %-20s\n", "Nam", "Thang", "Tong doanh thu (trieu)");
        System.out.println("=============================================================================================");

        // Tong hop doanh thu theo thang
        for (HoaDon hd : dshd) {
            if (hd instanceof HoaDonBanHang hdbh && hd.getNgayLapHoaDon().getYear() == nam) {
                found = true;
                int month = hdbh.getNgayLapHoaDon().getMonthValue() - 1; // Lay thang (0-based index)
                doanhThuThang[month] += hdbh.getTongTien();
            }
        }

        // Hien thi doanh thu tung thang
        for (int i = 0; i < 12; i++) {
            if (doanhThuThang[i] > 0) {
                double doanhThu = doanhThuThang[i];
                tongDoanhThuNam += doanhThuThang[i];
                System.out.printf("%-10d %-15s %-20.2s\n", nam, "Thang " + (i + 1), doanhThu + "VND");
            }
        }

        if (!found) {
            System.out.println("Khong co hoa don nao duoc lap trong nam " + nam);
        } else {
            double tongDoanhThuTrieu = tongDoanhThuNam / 1_000_000;
            System.out.println("=============================================================================================");
            System.out.printf("%-25s %-20.2f trieu\n", "Tong doanh thu ca nam:", tongDoanhThuTrieu);
            System.out.println("=============================================================================================");
        }
    }

    public void thongKe_TiLeTangTruongThang() {
        System.out.print("Nhap nam can thong ke: ");
        int nam = sc.nextInt();

        System.out.print("Nhap thang can xem ti le tang truong (1-12): ");
        int thang = sc.nextInt();

        if (thang < 1 || thang > 12) {
            System.out.println("Thang khong hop le! Vui long nhap tu 1 den 12.");
            return;
        }

        double[] doanhThuThang = new double[12]; // Mảng lưu doanh thu theo tháng
        boolean found = false;


        for (HoaDon hd : dshd) {
            if (hd instanceof HoaDonBanHang hdbh && hd.getNgayLapHoaDon().getYear() == nam) {
                int month = hdbh.getNgayLapHoaDon().getMonthValue() - 1; // Chỉ số tháng (0-based)
                doanhThuThang[month] += hdbh.getTongTien();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong co hoa don nao trong nam " + nam);
            return;
        }


        double doanhThuThangNay = doanhThuThang[thang - 1]; // Doanh thu tháng hiện tại (index 0-based)
        double doanhThuThangTruoc = (thang > 1) ? doanhThuThang[thang - 2] : 0; // Doanh thu tháng trước (index 0-based)

        System.out.println("|                          THONG KE TI LE TANG TRUONG                              |");
        System.out.println("================================================================================");
        System.out.printf("%-25s %-25s %-20s\n", "Doanh thu thang nay", "Doanh thu thang truoc", "Ti le tang truong (%)");
        System.out.println("================================================================================");

        if (doanhThuThangTruoc > 0) {
            double tiLeTangTruong = ((doanhThuThangNay - doanhThuThangTruoc) / doanhThuThangTruoc) * 100;
            System.out.printf("%-25.2f trieu %-25.2f trieu %-20.2f\n", doanhThuThangNay / 1_000_000, doanhThuThangTruoc / 1_000_000, tiLeTangTruong);
        } else if (doanhThuThangNay > 0) {
            System.out.printf("%-25.2f %-25s %-20s\n", doanhThuThangNay / 1_000_000, "0", "Moi tang truong");
        } else {
            System.out.printf("%-25s %-25s %-20s\n", "0", "0", "Khong thay doi");
        }

        System.out.println("================================================================================");
    }

    public void thongKe_TiLeTangTruongNam() {
        System.out.print("Nhap nam can thong ke: ");
        int nam = sc.nextInt();

        double doanhThuNamNay = 0;
        double doanhThuNamTruoc = 0;
        boolean foundNamNay = false;
        boolean foundNamTruoc = false;

        // Tổng hợp doanh thu năm nay
        for (HoaDon hd : dshd) {
            if (hd instanceof HoaDonBanHang hdbh) {
                int namHoaDon = hd.getNgayLapHoaDon().getYear();

                if (namHoaDon == nam) {
                    doanhThuNamNay += hdbh.getTongTien();
                    foundNamNay = true;
                } else if (namHoaDon == nam - 1) {
                    doanhThuNamTruoc += hdbh.getTongTien();
                    foundNamTruoc = true;
                }
            }
        }

        if (!foundNamNay && !foundNamTruoc) {
            System.out.println("Khong co hoa don nao trong ca nam " + nam + " va nam " + (nam - 1));
            return;
        }

        System.out.println("|                         THONG KE TI LE TANG TRUONG NAM                       |");
        System.out.println("================================================================================");
        System.out.printf("%-25s %-25s %-20s\n", "Doanh thu nam nay", "Doanh thu nam truoc", "Ti le tang truong (%)");
        System.out.println("================================================================================");

        if (foundNamTruoc && doanhThuNamTruoc > 0) {
            double tiLeTangTruong = ((doanhThuNamNay - doanhThuNamTruoc) / doanhThuNamTruoc) * 100;
            System.out.printf("%-25.2f %-25.2f %-20.2f\n", doanhThuNamNay / 1_000_000, doanhThuNamTruoc / 1_000_000, tiLeTangTruong);
        } else if (doanhThuNamNay > 0) {
            System.out.printf("%-25.2f %-25s %-20s\n", doanhThuNamNay / 1_000_000, "0", "Moi tang truong");
        } else {
            System.out.printf("%-25s %-25s %-20s\n", "0", "0", "Khong thay doi");
        }

        System.out.println("================================================================================");
    }

    public void tinhLoiNhuanThang() {
        System.out.print("Nhap thang va nam can tinh loi nhuan (MM/YYYY): ");
        String input = sc.nextLine();

        try {
            if (!input.matches("^\\d{2}/\\d{4}$")) {
                System.out.println("Dinh dang thang/nam khong hop le. Vui long nhap lai (MM/YYYY).");
                return;
            }

            String[] parts = input.split("/");
            int thang = Integer.parseInt(parts[0]);
            int nam = Integer.parseInt(parts[1]);

            if (thang < 1 || thang > 12) {
                System.out.println("Thang khong hop le. Vui long nhap lai.");
                return;
            }

            double doanhThuThang = 0;
            double tongTienDonDatHangThang = 0;
            double tongTienHoanTraThang = 0;

            for (HoaDon hd : dshd) {
                if (hd instanceof HoaDonBanHang hdbh) {
                    if (hdbh.getNgayLapHoaDon().getMonthValue() == thang &&
                            hdbh.getNgayLapHoaDon().getYear() == nam) {
                        doanhThuThang += hdbh.getTongTien();
                    }
                }
            }

            for (DonDatHang ddh : qlddh.getDsddh()) {
                if (ddh.getNgayDatHang().getMonthValue() == thang &&
                        ddh.getNgayDatHang().getYear() == nam) {
                    tongTienDonDatHangThang += ddh.getTongTien();
                }
            }

            for (HoaDon hd : dshd) {
                if (hd instanceof HoaDonDoiTraHang hddth) {
                    if (hddth.getNgayLapHoaDon().getMonthValue() == thang &&
                            hddth.getNgayLapHoaDon().getYear() == nam) {
                        tongTienHoanTraThang += hddth.getTienHoanTra();
                    }
                }
            }

            double tongLuongNhanVien = 0;
            for (NhanVien nv : qlnv.getDsNhanVien()) {
                if (nv.isIsnotdelete()) {
                    tongLuongNhanVien += nv.getLuong();
                }
            }

            double loiNhuanThang = doanhThuThang - tongTienDonDatHangThang - tongTienHoanTraThang;

            System.out.println("---------------------------------------------------------");
            System.out.printf("%-30s %-20s\n", "Tong luong nhan vien thang", "Loi nhuan thang");
            System.out.printf("%-30.2f %-20.2f\n", tongLuongNhanVien, loiNhuanThang);
            System.out.println("---------------------------------------------------------");

        } catch (Exception e) {
            System.out.println("Dinh dang thang/nam khong hop le. Vui long nhap lai.");
        }
    }

    public void tinhLoiNhuanNam() {
        System.out.print("Nhap nam can tinh loi nhuan (YYYY): ");
        String input = sc.nextLine();

        try {
            int nam = Integer.parseInt(input);

            if (nam < 1) {
                System.out.println("Nam khong hop le. Vui long nhap lai.");
                return;
            }

            double doanhThuNam = 0;
            double tongTienDonDatHangNam = 0;
            double tongTienHoanTraNam = 0;
            double tongLuongNhanVienNam = 0;

            // Tính tổng doanh thu cả năm
            for (HoaDon hd : dshd) {
                if (hd instanceof HoaDonBanHang hdbh) {
                    if (hdbh.getNgayLapHoaDon().getYear() == nam) {
                        doanhThuNam += hdbh.getTongTien();
                    }
                }
            }

            for (DonDatHang ddh : qlddh.getDsddh()) {
                if (ddh.getNgayDatHang().getYear() == nam) {
                    tongTienDonDatHangNam += ddh.getTongTien();
                }
            }

            for (HoaDon hd : dshd) {
                if (hd instanceof HoaDonDoiTraHang hddth) {
                    if (hddth.getNgayLapHoaDon().getYear() == nam) {
                        tongTienHoanTraNam += hddth.getTienHoanTra();
                    }
                }
            }

            for (NhanVien nv : qlnv.getDsNhanVien()) {
                if (nv.isIsnotdelete()) {
                    tongLuongNhanVienNam += nv.getLuong() * 12; // Nhân lương nhân viên tháng với 12
                }
            }

            double loiNhuanNam = doanhThuNam - tongTienDonDatHangNam - tongTienHoanTraNam;

            // Hiển thị kết quả
            System.out.println("---------------------------------------------------------");
            System.out.printf("%-30s %-20s\n", "Tong luong nhan vien nam", "Loi nhuan nam");
            System.out.printf("%-30.2f %-20.2f\n", tongLuongNhanVienNam, loiNhuanNam);
            System.out.println("---------------------------------------------------------");

        } catch (Exception e) {
            System.out.println("Dinh dang nam khong hop le. Vui long nhap lai.");
        }
    }


}
