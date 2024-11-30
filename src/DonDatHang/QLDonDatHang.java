package DonDatHang;

import SanPham.SanPham;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

import static DonDatHang.DonDatHang.loaiTrangThai;
import static main_project.oop_project.qlncc;
import static main_project.oop_project.qlsp;

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

                            for (ChiTietDonDatHang ct : ds.getDschiTietDonDatHang()) {
                                SanPham timSP = qlsp.timKiem(ct.getSanPham().getMaSP());

                                if (timSP != null){
                                    qlsp.nhapSanPhamTuDonDatHang(ct.getSanPham().getMaSP(), ct.getSoLuong());
                                } else {
                                    qlsp.themSanPham(ct.getSanPham());
                                }
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


    public void suaThongTinDonDatHang(String maDonDatHang) {
        for (DonDatHang ds : dsddh) {
            if (ds.getMaDonDatHang().equals(maDonDatHang) && ds.getTrangThai().equals(loaiTrangThai[0])) {
                int lc;
                boolean ktra = true;
                while (ktra) {
                    ds.xuat();
                    System.out.println("1. Sua ngay nhan hang");
                    System.out.println("2. Sua nha cung cap");
                    System.out.println("3. Sua hinh thuc giao hang");
                    System.out.println("4. Sua chi tiet don dat hang");
                    System.out.println("5. Them chi tiet don dat hang");
                    System.out.println("Nhap lua chon: ");
                    lc = Integer.parseInt(sc.nextLine());
                    switch (lc) {
                        case 1: {
                            System.out.println("Nhap ngay nhan hang moi (dd/MM/yyyy): ");
                            ds.setNgayNhanHang(sc.nextLine());
                            System.out.println("Da sua ngay nhan hang.");
                            break;
                        }
                        case 2: {
                            System.out.println("Nhap ma nha cung cap moi: ");
                            ds.setNhaCungCap(qlncc.timKiem(sc.nextLine()));
                            System.out.println("Da sua nha cung cap.");
                            break;
                        }
                        case 3: {
                            System.out.println("Nhap hinh thuc giao hang moi: ");
                            ds.setHinhThucGiaoHang(sc.nextLine());
                            System.out.println("Da sua hinh thuc giao hang.");
                            break;
                        }
                        case 4: {
                            System.out.println("Chon stt chi tiet dat hang muon sua: ");
                            int stt = Integer.parseInt(sc.nextLine());

                            if (stt > 0 && stt <= ds.getSoLuongChiTiet()) {
                                ChiTietDonDatHang chiTiet = ds.getDschiTietDonDatHang()[stt - 1];
                                suaChiTietDonDatHang(chiTiet);
                                ds.setTongTien(ds.tinhTongTien());
                            } else {
                                System.out.println("STT khong hop le!");
                            }
                            break;
                        }
                        case 5: {
                            System.out.print("Nhap so luong chi tiet muon them: ");
                            int soLuongThem = Integer.parseInt(sc.nextLine());
                            if (soLuongThem > 0) {
                                for (int i = 0; i < soLuongThem; i++) {
                                    System.out.println("Nhap thong tin chi tiet moi thu " + (i + 1) + ":");
                                    ChiTietDonDatHang chiTietMoi = new ChiTietDonDatHang();
                                    chiTietMoi.input(ds.getSoLuongChiTiet() + i + 1);
                                    ds.themChiTiet(chiTietMoi);
                                    ds.setTongTien(ds.tinhTongTien());
                                }
                                System.out.println("Da them " + soLuongThem + " chi tiet don dat hang.");
                            } else {
                                System.out.println("So luong phai lon hon 0.");
                            }
                            break;
                        }
                        case 0: {
                            ktra = false;
                            break;
                        }
                        default: {
                            System.out.println("Lua chon khong hop le.");
                            System.out.println("Vui long lua chon lai.");
                        }
                    }
                }
            }
        }
    }

    public void suaChiTietDonDatHang(ChiTietDonDatHang chiTiet) {
        int lc;
        boolean ktra = true;
        while (ktra) {
            chiTiet.ouput();
            System.out.println("1. Sua san pham");
            System.out.println("2. Sua so luong");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            lc = Integer.parseInt(sc.nextLine());
            switch (lc) {
                case 1: {
                    while (true) {
                        System.out.println("Ban muon chon san pham co san hay san pham moi ?");
                        System.out.println("1. Chon san pham co san.");
                        System.out.println("2. Nhap san pham moi.");
                        System.out.print("Nhap lua chon: ");
                        int luaChonSP = Integer.parseInt(sc.nextLine());
                        if (luaChonSP == 1) {
                            System.out.print("Nhap ma san pham moi: ");
                            SanPham spMoi = qlsp.timKiem(sc.nextLine());
                            if (spMoi != null) {
                                chiTiet.setSanPham(spMoi);
                                chiTiet.setThanhTien(chiTiet.tinhThanhTien());
                                System.out.println("Da sua san pham.");
                                break;
                            } else {
                                System.out.println("Khong tim thay san pham");
                            }
                        } else if (luaChonSP == 2) {
                            chiTiet.setSanPham(qlsp.nhapSanPham());
                            chiTiet.setSoLuong(chiTiet.getSanPham().getSoLuongNhap());
                            System.out.println("Da sua san pham thanh mot san pham moi.");
                            break;
                        } else {
                            System.out.println("Lua chon khong hop le!");
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.print("Nhap so luong moi: ");
                    chiTiet.setSoLuong(Integer.parseInt(sc.nextLine()));
                    chiTiet.setThanhTien(chiTiet.tinhThanhTien());
                    System.out.println("Da sua so luong san pham.");
                    break;

                }
                case 0: {
                    ktra = false;
                    break;
                }
                default: {
                    System.out.println("Lua chon khong hop le!");
                    System.out.println("Vui long nhap lai.");
                }
            }
        }
    }


    public void ghiVaoFileDSDDH() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("src/DonDatHang/DanhSachDonDatHang.txt"))) {
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
        try (BufferedReader reader = new BufferedReader(new FileReader("src/DonDatHang/DanhSachDonDatHang.txt"))) {
            String line;
            DonDatHang ddh = null;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].startsWith("ddh")) {
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
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

}
