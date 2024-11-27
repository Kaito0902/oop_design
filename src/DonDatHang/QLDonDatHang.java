package DonDatHang;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

import static DonDatHang.DonDatHang.loaiTrangThai;

public class QLDonDatHang {
    DonDatHang[] dsddh = new DonDatHang[0];
    int soLuongDonDatHang;
    static Scanner sc = new Scanner(System.in);
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public void themDDH(DonDatHang ddh) {
        DonDatHang[] newdsddh = Arrays.copyOf(dsddh, soLuongDonDatHang + 1);
        newdsddh[soLuongDonDatHang] = ddh;
        dsddh = newdsddh;
        soLuongDonDatHang++;
    }

    public void xuatDDH() {
        for (DonDatHang i : dsddh) {
            i.xuat();
        }
    }

    public DonDatHang timDonDatHang(String maDonDatHang) {
        for (DonDatHang ds : dsddh) {
            if (ds.getMaDonDatHang().equals(maDonDatHang)) {
                return ds;
            }
        }
        return null;
    }

    public void capNhatTrangThaiDonDatHang(String maDonDatHang) {
        boolean timThay = false;
        for (DonDatHang ds : dsddh){
            if (ds.getMaDonDatHang().equals(maDonDatHang) && ds.getTrangThai().equals(loaiTrangThai[0])){
                timThay = true;
                int lc;
                boolean ktra = true;
                while (ktra) {
                    System.out.println("1. Da giao den");
                    System.out.println("2. Huy don");
                    System.out.println("Nhap lua chon: ");
                    lc = Integer.parseInt(sc.nextLine());
                    switch (lc) {
                        case 1: {
                            LocalDate today = LocalDate.now();
                            if (ds.getNgayNhanHang().isBefore(today)) {
                                ds.setTrangThai(loaiTrangThai[3]);
                                System.out.println("Giao Som.");
                            } else if (ds.getNgayNhanHang().isAfter(today)) {
                                ds.setTrangThai(loaiTrangThai[1]);
                                System.out.println("Da hoan thanh.");
                            } else if (ds.getNgayNhanHang().isEqual(today)) {
                                ds.setTrangThai(loaiTrangThai[4]);
                                System.out.println("Giao muon.");
                            }
                            ktra = false;
                            break;
                        }
                        case 2: {
                            ds.setTrangThai(loaiTrangThai[2]);
                            ktra = false;
                            break;
                        }
                        default: {
                            System.out.println("Lua chon khong hop le.");
                            System.out.println("Vui long nhap lai.");
                        }
                    }
                }
            }
        }
        if (!timThay) {
            System.out.println("Khong tim thay don dat hang co ma " + maDonDatHang);
        }
    }




    public void ghiVaoFileDSDDH() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\ACER\\IdeaProjects\\oop_project\\src\\DonDatHang\\DanhSachDonDatHang.txt"))) {
            for (DonDatHang ddh : dsddh) {
                writer.write(String.join(",",
                        ddh.getMaDonDatHang(),
                        String.valueOf(ddh.getNgayDatHang().format(formatter)),
                        String.valueOf(ddh.getNgayNhanHang().format(formatter)),
                        ddh.getNhaCungCap().getMaNCC(),
                        ddh.getNhaCungCap().getTenNCC(),
                        String.valueOf(ddh.getTongTien()),
                        ddh.getHinhThucGiaoHang(),
                        ddh.getTrangThai()
                ));
                writer.newLine();
                for (ChiTietDonDatHang ct : ddh.getDschiTietDonDatHang()) {
                    writer.write(String.join(",",
                            "ChiTietDonDatHang",
                            String.valueOf(ct.getSoThuTu()),
                            ct.getSanPham().getMaSP(),
                            ct.getSanPham().getTenSP(),
                            String.valueOf(ct.getSoLuong()),
                            String.valueOf(ct.getThanhTien())
                    ));
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Loi ghi file " + e.getMessage());
        }

    }

    public void docTuFileDSDDH() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ACER\\IdeaProjects\\oop_project\\src\\DonDatHang\\DanhSachDonDatHang.txt"))) {
            String line;
            DonDatHang ddh = null;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].startsWith("DDH")) {
                    //bo data4
                    String maDonDatHang = data[0];
                    LocalDate ngayDatHang = LocalDate.parse(data[1], formatter);
                    LocalDate ngayNhanHang = LocalDate.parse(data[2], formatter);
                    String maNhaCungCap = data[3];
                    String tenNhaCungCap = data[4];
                    double tongTien = Double.parseDouble(data[5]);
                    String hinhThucGiaoHang = data[6];
                    String trangThai = data[7];
                    ddh = new DonDatHang(maDonDatHang, ngayDatHang, ngayNhanHang, maNhaCungCap, new ChiTietDonDatHang[0], 0, tongTien, hinhThucGiaoHang, trangThai);
                    themDDH(ddh);

                } else if (data[0].equals("ChiTietDonDatHang") && ddh != null) {
                    //bo data3
                    int stt = Integer.parseInt(data[1]);
                    String maSP = data[2];
                    String tenSP = data[3];
                    int soLuong = Integer.parseInt(data[4]);
                    double thanhTien = Double.parseDouble(data[5]);
                    ChiTietDonDatHang ct = new ChiTietDonDatHang(stt, maSP, soLuong, thanhTien);
                    ddh.themChiTiet(ct);
                    ddh.setSoLuongChiTiet(ddh.getDschiTietDonDatHang().length);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }

}
