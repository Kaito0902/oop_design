package HoaDon;

import KhachHang.KhachHang;
import SanPham.SanPham;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class QLHoaDon {
    HoaDon[] dshd = new HoaDon[0];
    static Scanner sc = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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
                            System.out.println(ct.getSanPham().getMaSP() + " " + ct.getSanPham().getTenSP() + " Con han bao hanh");
                        } else {
                            System.out.println(ct.getSanPham().getMaSP() + " " + ct.getSanPham().getTenSP() + " Het han bao hanh");
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


    //sx

    // Lấy số lượng hóa đơn hiện tại
    public void laySLHoaDon() {
        System.out.println("So luong hoa don hien tai: " + dshd.length);
    }

    public void ghiVaoFileDSHD() {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("src/HoaDon/DanhSachHoaDon.txt"))) {
            for (HoaDon hd : dshd) {
                if (hd instanceof HoaDonBanHang hdbh) {
                    writer.write(String.join(",",
                            hdbh.getMaHoaDon(),
                            String.valueOf(hdbh.getNgayLapHoaDon().format(formatter)),
                            hdbh.getNhanVienLapHoaDon().getMaNhanVien(),
                            hdbh.getNhanVienLapHoaDon().getTenNhanVien(),
                            hdbh.getKhachHang().getMaKhachHang(),
                            hdbh.getKhachHang().getHoTen(),
                            hdbh.getLoaiHoaDon(),
                            hdbh.getKhuyenMai().getMaKhuyenMai(),
                            String.valueOf(hdbh.getTienThue()),
                            String.valueOf(hdbh.getChietKhau()),
                            hdbh.getPhuongThucThanhToan(),
                            String.valueOf(hdbh.getTongTien())));
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
                        hd = new HoaDonBanHang(maHoaDon, ngayLapHoaDon, maNhanVien, maKhachHang, loaiHoaDon, new ChiTietHoaDonBanHang[0], 0, maKhuyenMai, tienThue, chietKhau, phuongThucThanhToan, tongTien);
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

    public void tinhTongTien() {
        for (HoaDon ds : dshd) {
            if (ds instanceof HoaDonBanHang) {

            }
        }
    }

//     Tính tổng số tiền của khách hàng theo mã
//    public double getTongSoTien(String maKhachHang) {
//        return Arrays.stream(dshd)
//                .filter(hd -> hd != null && hd.getmaKhachHang().equals(maKhachHang))
//                .mapToDouble(HoaDon::getTongSoTien)
//                .sum();
//    }

}
