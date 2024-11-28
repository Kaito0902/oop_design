package HoaDon;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

import KhachHang.KhachHang;
import KhuyenMai.KhuyenMai;
import NhanVien.NhanVien;
import NhanVien.NhanVienBanHang;
import NhanVien.NhanVienKyThuat;
import NhanVien.NhanVienQuanLy;
import SanPham.SanPham;

public class QLHoaDon {
    private HoaDon[] dshd = new HoaDon[0];
    private static final Scanner sc = new Scanner(System.in);
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
            if (hd != null) {
                // System.out.println(hd instanceof HoaDonBanHang ? "Loai hoa don:
                // HoaDonBanHang" : "Loai hoa don: HoaDonDoiTraHang");
                hd.xuat();
            }
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

    // Tìm kiếm hóa đơn theo tên khách hàng
    // public void timKiemHoaDon() {
    // System.out.print("Nhap ten khach hang can tim: ");
    // String tenKhachHang = sc.nextLine();
    // boolean found = false;
    // for (HoaDon hd : dshd) {
    // if (hd != null && hd.getKhachHang().equalsIgnoreCase(tenKhachHang)) {
    // System.out.println("Hoa don tim thay:");
    // hd.xuat();
    // found = true;
    // }
    // }
    // if (!found) {
    // System.out.println("Khong tim thay hoa don cua khach hang: " + tenKhachHang);
    // }
    // }

    // Sắp xếp danh sách hóa đơn theo tổng tiền giảm dần
    // public void sapXep() {
    // Arrays.sort(dshd, (hd1, hd2) -> {
    // if (hd1 == null) return 1;
    // if (hd2 == null) return -1;
    // return Double.compare(hd2.getTongSoTien(), hd1.getTongSoTien());
    // });
    // System.out.println("Danh sach hoa don da sap xep theo tong tien (giam
    // dan).");
    // }

    // Lấy số lượng hóa đơn hiện tại
    public void laySLHoaDon() {
        System.out.println("So luong hoa don hien tai: " + dshd.length);
    }

  

    public void tinhTongTien() {
        for (HoaDon ds : dshd) {
            if (ds instanceof HoaDonBanHang) {

            }
        }
    }

    // Tính tổng số tiền của khách hàng theo mã
    // public double getTongSoTien(String maKhachHang) {
    // return Arrays.stream(dshd)
    // .filter(hd -> hd != null && hd.getmaKhachHang().equals(maKhachHang))
    // .mapToDouble(HoaDon::getTongSoTien)
    // .sum();
    // }
    

    public void ghiVaoFileDSHD() {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("C:\\Users\\ACER\\IdeaProjects\\oop_project\\src\\NhanVien\\DanhSachHoaDon.txt"))) {
            for (HoaDon hd : dshd) {
                if (hd instanceof HoaDonBanHang hdbh) {
                    writer.write(String.join(",",
                            hdbh.getMaHoaDon(),
                            String.valueOf(hdbh.getNgayLapHoaDon().format(formatter)),
                            hdbh.nhanVienLapHoaDon.getTenNhanVien(),
                            hdbh.khachHang.getHoTen(),
                            hdbh.getLoaiHoaDon(),
                            hdbh.KhuyenMai.getKhuyenMai,
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
                    }
                } else {
                    HoaDonDoiTraHang htdth = (HoaDonDoiTraHang) hd;
                    writer.write(String.join(",",
                            htdth.getMaHoaDon(),
                            String.valueOf(htdth.getNgayLapHoaDon().format(formatter)),
                            htdth.nhanVienLapHoaDon.getTenNhanVien(),
                            htdth.khachHang.getHoTen(),
                            htdth.getLoaiHoaDon(),
                            String.valueOf(htdth.getTongGiaTri()),
                            htdth.getGhiChu(),
                            String.valueOf(htdth.getTienHoanTra()),
                            String.valueOf(htdth.getTiLeTru())));
                    writer.newLine();  
                    for(ChiTietHoaDonDoiTra ctdt : htdth.getDsChiTiet()){
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
                    }
                }
               
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    public void docTuFileDSHD() {
    try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ACER\\IdeaProjects\\oop_project\\src\\NhanVien\\DanhSachHoaDon.txt"))) {
        String line;
        HoaDon hd = null;

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");

            if (data[4].equals("HoaDonBanHang")) { 
                String maHoaDon = data[0];
                LocalDate ngayLapHoaDon = LocalDate.parse(data[1], formatter);
                String tenNhanVien = data[2];
                String tenKhachHang = data[3];
                String loaiHoaDon = data[4];
                String tenKhuyenMai = data[5];
                double tienThue = Double.parseDouble(data[6]);
                double chietKhau = Double.parseDouble(data[7]);
                String phuongThucThanhToan = data[8];
                double tongTien = Double.parseDouble(data[9]);       
                hd = new HoaDonBanHang(maHoaDon, ngayLapHoaDon, tenNhanVien,tenKhachHang, loaiHoaDon, new chiTietHoaDonBanHangList[0], 0, tenKhuyenMai, tienThue, chietKhau, phuongThucThanhToan, tongTien);
                themHD(hd);
            } else if (data[4].equals("HoaDonDoiTraHang")) {
                String maHoaDon = data[0];
                LocalDate ngayLapHoaDon = LocalDate.parse(data[1], formatter);
                String tenNhanVien = data[2];
                String tenKhachHang = data[3];
                String loaiHoaDon = data[4];
                double tongGiaTri = Double.parseDouble(data[5]);
                String ghiChu = data[6];
                double tienHoanTra = Double.parseDouble(data[7]);
                double tiLeTru = Double.parseDouble(data[8]);
                
                hd = new HoaDonDoiTraHang(maHoaDon, ngayLapHoaDon,tenNhanVien,tenKhachHang, loaiHoaDon, new dsChiTiet[0], 0, tongGiaTri, ghiChu, tienHoanTra, tiLeTru);
                themHD(hd);
            } else if (data[0].equals("ChiTietHoaDonBanHang") && hd instanceof HoaDonBanHang hdbh) {
                int stt = Integer.parseInt(data[1]);
                String maSP = data[2];
                String tenSP = data[3];
                int soLuong = Integer.parseInt(data[4]);
                double thanhTien = Double.parseDouble(data[5]);

                ChiTietHoaDonBanHang ctbh = new ChiTietHoaDonBanHang(stt, maSP, soLuong, thanhTien);
                hdbh.themChiTietHoaDonBanHang(ctbh);

            } else if (data[0].equals("ChiTietHoaDonDoiTraHang") && hd instanceof HoaDonDoiTraHang htdth) {
                // Đọc chi tiết của hóa đơn đổi trả hàng
                int stt = Integer.parseInt(data[1]);
                String maSP = data[2];
                String tenSP = data[3];
                int soLuong = Integer.parseInt(data[4]);
                String lyDo = data[5];
                String tinhTrang = data[6];
                double thanhTien = Double.parseDouble(data[7]);

                ChiTietHoaDonDoiTra ctdt = new ChiTietHoaDonDoiTra(stt, maSP, soLuong, lyDo, tinhTrang, thanhTien);
                htdth.themChiTiet(ctdt);
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

}
