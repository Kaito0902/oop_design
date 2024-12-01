package KhachHang;

import java.io.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

import HoaDon.HoaDon;
import HoaDon.HoaDonBanHang;

import static main_project.oop_project.qlhd;
import static main_project.oop_project.qlkh;

public class QLKhachHang {
    KhachHang[] dskh = new KhachHang[0];
    int soLuong = 0;
    static Scanner scanner = new Scanner(System.in);
    static NumberFormat fm = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

    //them khach hang
    public void themKH(KhachHang kh)  {
        KhachHang[] newkh = Arrays.copyOf(dskh, soLuong+1);
        newkh[soLuong] = kh;
        dskh = newkh;
        soLuong++;
    }

    //xuat khach hang
    public void xuatdskh() {
        if (dskh.length == 0) {
            System.out.println("DANH SACH KHACH HANG TRONG.");
        }
        for ( var i : dskh )
            if (i.isdelete)
                i.output();
    }

    //xuat khach hang vip
    public void xuatdskhvip() {
        for ( var i : dskh )
            if ( i instanceof KhachHangVip)
                i.output();
            else
                System.out.println("Khong co khach hang Vip!!!");
    }

    //xoa 1 KH
    public void xoa1KH(String maKH) {
        boolean ktra = false;
        for (KhachHang kh : dskh) {
            if (kh.maKhachHang.equalsIgnoreCase(maKH)) {
                kh.isdelete = false;
                ktra = true;
                System.out.println("Da xoa Kh co ma:" + maKH);
                break;
            }
        }
        if (!ktra) {
            System.out.println("Khong tim thay kh co ma: " + maKH);
        }
    }

    //timkiemKhbang ma
    public KhachHang timkiemKhachHangTheoMa(String maKH){
        for (KhachHang kh : dskh)
            if (kh.getMaKhachHang().equals(maKH))
                return kh;
        return null;
    }

    //timkiemkhbang sdt
    public KhachHang timkiemKhachHangTheoSdt(String sdt){
        for (KhachHang kh : dskh)
            if (kh.getSdt().equals(sdt))
                return kh;
        return null;
    }

    //tim khach hang co so tien cao nhat 
    public void timkiemKhachHangCoTienCaoNhat() {
        KhachHang khMax = null;
        double maxtien = 0;
        for ( KhachHang kh : dskh ){
            double max = qlhd.tinhTongTien(kh.getMaKhachHang());
            if (max > maxtien) {
                maxtien = max;
                khMax = kh;
            }
        }
        if ( khMax != null ){
            System.out.println("KH co so tien giao dich cao nhat la:");
            khMax.output();
        }
        else {
            System.out.println("Khong tim thay khach hang nao");
        }
    }
    
    //sapxepkh
    public void sapxep() {
        for ( int i = 0; i < dskh.length-1; i++ )
            for ( int j = 0; j < dskh.length; j++ )
                if ( dskh[i].getHoTen().compareTo(dskh[j].getHoTen()) < 0 ){
                    KhachHang temp = dskh[i];
                    dskh[i] = dskh[j];
                    dskh[j] = temp;
                }
        }

    // sua thong tin khach hang
    public void capNhapThongTinKhachHang(String sdt) {
        KhachHang kh = timkiemKhachHangTheoSdt(sdt);
        if ( kh != null) {
            System.out.println("Cap nhap thong tin khach hang co sdt: " + sdt);
            int choice;
            do {
                System.out.println("1. Sua ten khach hang");
                System.out.println("2. Sua gioi tinh");
                System.out.println("3. Sua so dien thoai");
                System.out.println("4. Sua so ngay sinh");
                System.out.println("5. Sua email");
                System.out.println("6. Sua dia chi");
                System.out.println("7. Thoat!");
                System.out.println("Nhap lua chon muon sua: ");

                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Nhap ten moi: ");
                        kh.setHoTen(scanner.nextLine());
                        System.out.println("Da sua ten");
                        break;
                    case 2:
                        System.out.println("Nhap gioi tinh moi: ");
                        kh.setGioiTinh(scanner.nextLine());
                        System.out.println("Da sua gioi tinh.");
                        break;
                    case 3:
                        System.out.println("Nhap so dien thoai moi: "); 
                        kh.setSdt(scanner.nextLine());
                        System.out.println("Da sua so dien thoai.");
                        break;
                    case 4:
                        System.out.println("Nhap ngay sinh moi: ");
                        kh.setNgaySinh(scanner.nextLine());
                        System.out.println("Da sua ngay sinh.");
                        break;
                    case 5:
                        System.out.println("Nhap email moi: ");
                        kh.setEmail(scanner.nextLine());
                        System.out.println("Da sua email.");
                        break;
                    case 6:
                        System.out.println("Nhap dia chi moi: ");
                        kh.setDiaChi(scanner.nextLine());
                        System.out.println("Da sua dia chi.");
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("Lua chon khong hop le");
                        System.out.println("Vui long lua chon lai");
                        break;
                }
            } while (choice != 7);
        } else {
            System.out.println("Khong tim thay khach hang voi sdt:" + sdt);
        }
    }

    public void capNhatLoaiKhachHang() {
        for (int i = 0; i < dskh.length; i++) {
            KhachHang kh = dskh[i];
            double tongSoTien = qlhd.tinhTongTien(kh.getMaKhachHang());

            if (tongSoTien >= 5000000 && !(kh instanceof KhachHangVip) && !(kh instanceof KhachHangDoiTacDoanhNghiep)) {
                // Tính hệ số
                int heSo = xeploaiheSo(kh);

                // Tạo đối tượng KhachHangVip mới
                KhachHang vip = new KhachHangVip(
                        kh.getHoTen(), kh.getGioiTinh(), kh.getNgaySinh(), kh.getDiaChi(), kh.getSdt(),
                        kh.getEmail(), kh.getMaKhachHang(), "Than Thiet", kh.isIsdelete(), kh.getTichDiem(), heSo
                );

                // Cập nhật lại thông tin khách hàng trong danh sách sau khi nâng cấp
                dskh[i] = vip;
            }
        }
    }

    public int xeploaiheSo(KhachHang kh) {
        double tongSoTien = qlhd.tinhTongTien(kh.getMaKhachHang());
        return tongSoTien >= 25000000 ? 5 : tongSoTien >= 20000000 ? 4 : tongSoTien >= 15000000 ? 3 : tongSoTien >= 10000000 ? 2 : 1;
    }


    public void nhapKhachHang() {
        boolean ktra = true;
        while (ktra){
            int lc;
            System.out.println("1. Them khcanhan.");
            System.out.println("2. Them khsv.");
            System.out.println("3. Them khdoitac.");
            // System.out.println("4. Them khvip.");
            System.out.println("Nhap lua chon: ");
            lc = Integer.parseInt(scanner.nextLine());
            switch (lc) {
                case 1:
                    KhachHang x = new KhachHangCaNhan();
                    x.input();
                    qlkh.themKH(x);
                    ktra = false;
                    break;
                case 2:
                    KhachHang y = new KhachHangSinhVien();
                    y.input();
                    qlkh.themKH(y);
                    ktra = false;
                    break;
                case 3:
                    KhachHang z = new KhachHangDoiTacDoanhNghiep();
                    z.input();
                    qlkh.themKH(z);
                    ktra = false;
                    break;
                // case "4":
                //     KhachHang w = new KhachHangVip();
                //     w.input();
                //     qlkh.themKH(w);
                //     break;
                default:
                    System.out.println("Lua chon khong hop le!!!");
            }
        }
    }

    //writetofile
    public void ghiVaoFileDSKH() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/KhachHang/DanhSachKhachHang.txt"))){
            for ( KhachHang kh : dskh )
                if ( kh instanceof KhachHangCaNhan cn ) {
                    writer.write(String.join(",",
                    cn.getMaKhachHang(),
                    cn.getHoTen(),
                    cn.getGioiTinh(),
                    cn.getNgaySinh(),
                    cn.getDiaChi(),
                    cn.getSdt(),
                    cn.getEmail(),
                    cn.getLoaiKhachHang(),
                    String.valueOf(cn.isdelete),
                    String.valueOf(cn.getTichDiem()),
                    String.valueOf(cn.tinhUuDai())
                    ));
                    writer.newLine();
                }
                else if ( kh instanceof KhachHangSinhVien sv ) {
                    writer.write(String.join(",",
                    sv.getMaKhachHang(),
                    sv.getHoTen(),
                    sv.getGioiTinh(),
                    sv.getNgaySinh(),
                    sv.getDiaChi(),
                    sv.getSdt(),
                    sv.getEmail(),
                    sv.getLoaiKhachHang(),
                    String.valueOf(sv.isdelete),
                    String.valueOf(sv.getTichDiem()),
                    String.valueOf(sv.getDiemTB()),
                    String.valueOf(sv.tinhUuDai())
                    ));
                    writer.newLine();
                }
                else if ( kh instanceof KhachHangVip vip ) {
                    writer.write(String.join(",",
                    vip.getMaKhachHang(),
                    vip.getHoTen(),
                    vip.getGioiTinh(),
                    vip.getNgaySinh(),
                    vip.getDiaChi(),
                    vip.getSdt(),
                    vip.getEmail(),
                    vip.getLoaiKhachHang(),
                    String.valueOf(vip.isdelete),
                    String.valueOf(vip.getTichDiem()),
                    String.valueOf(vip.getHeSo()),
                    String.valueOf(vip.tinhUuDai()),
                    String.valueOf(vip.laiSuatTraGop())
                    ));
                    writer.newLine();
                }
                else {
                    KhachHangDoiTacDoanhNghiep dt = (KhachHangDoiTacDoanhNghiep) kh;
                    writer.write(String.join(",",
                    dt.getMaKhachHang(),
                    dt.getHoTen(),
                    dt.getGioiTinh(),
                    dt.getNgaySinh(),
                    dt.getDiaChi(),
                    dt.getSdt(),
                    dt.getEmail(),
                    dt.getLoaiKhachHang(),
                    String.valueOf(dt.isdelete),
                    String.valueOf(dt.getTichDiem()),
                    dt.getTenCongTy(),
                    String.valueOf(dt.tinhUuDai()),
                    String.valueOf(dt.laiSuatTraGop())
                    ));
                    writer.newLine();
                }
        } catch (IOException e) {
            System.out.println("Loi ghi file:" + e.getMessage());
        }
    }

    public void docTuFileDSKH() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/KhachHang/DanhSachKhachHang.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length > 0) {
                    String maKhachHang = data[0];
                    String tenKhachHang = data[1];
                    String gioiTinh = data[2];
                    String namSinh = data[3];
                    String diaChi = data[4];
                    String soDienThoai = data[5];
                    String eMail = data[6];
                    String loaiKhachHang = data[7];
                    boolean isdelete = Boolean.parseBoolean(data[8]);
                    int tichDiem = Integer.parseInt(data[9]);

                    switch (loaiKhachHang) {
                        case "Binh Thuong" -> {
                            KhachHang caNhan = new KhachHangCaNhan(tenKhachHang, gioiTinh, namSinh, diaChi, soDienThoai, eMail, maKhachHang, loaiKhachHang, isdelete, tichDiem);
                            themKH(caNhan);
                        }
                        case "Uu dai" -> {
                            double diemTB = Double.parseDouble(data[10]);
                            KhachHang sinhVien = new KhachHangSinhVien(tenKhachHang, gioiTinh, namSinh, diaChi, soDienThoai, eMail, maKhachHang, loaiKhachHang, isdelete, tichDiem, diemTB);
                            themKH(sinhVien);
                        }
                        case "Than Thiet" -> {
                            int heSo = Integer.parseInt(data[10]);
                            KhachHang vip = new KhachHangVip(tenKhachHang, gioiTinh, namSinh, diaChi, soDienThoai, eMail, maKhachHang, loaiKhachHang, isdelete, tichDiem, heSo);
                            themKH(vip);
                        }
                        case "Tiem Nang" -> {
                            String tenCongTy = data[10];
                            KhachHang dt = new KhachHangDoiTacDoanhNghiep(tenKhachHang, gioiTinh, namSinh, diaChi, soDienThoai, eMail, maKhachHang, loaiKhachHang, isdelete, tichDiem, tenCongTy);
                            themKH(dt);
                        }
                        default -> System.out.println("Du lieu khong hop le cho khach hang: " + loaiKhachHang);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Loi doc tap tin: " + e.getMessage());
        }
    }


    //Bui Nguyen Thinh
    public void thongKeTongChi() {
        String title = "Chi Tieu Khach Hang";
        int totalLength = 85;
        int spaces = (totalLength - title.length()) / 2;
        System.out.println("=".repeat(totalLength));
        System.out.printf("%" + (spaces + title.length()) + "s\n", title);
        System.out.println("=".repeat(totalLength));

        System.out.printf("%-15s %-25s %-20s %-15s\n",
                "Ma khach hang",
                "Ten khach hang",
                "Loai khach hang",
                "Tong da chi");
        System.out.println("=".repeat(totalLength));

        for (KhachHang kh : dskh) {
            double tongChi = 0;

            for (HoaDon hd : qlhd.getDshd()) {
                if (hd instanceof HoaDonBanHang hdbh) {
                    if (hdbh.getKhachHang() != null &&
                            hdbh.getKhachHang().getMaKhachHang().equals(kh.getMaKhachHang())) {
                        tongChi += hdbh.getTongTien();
                    }
                }
            }

            System.out.printf("%-15s %-25s %-20s %-15s\n",
                    kh.getMaKhachHang(),
                    kh.getHoTen(),
                    kh.getLoaiKhachHang(),
                    fm.format(tongChi).replace("₫", "VND"));
        }

        System.out.println("=".repeat(totalLength));
    }


    public void thongKeTanSuatMuaHang() {
        String title = "Tan Suat Mua Hang Cua Khach Hang";
        int totalLength = 85;
        int spaces = (totalLength - title.length()) / 2;
        System.out.println("=".repeat(totalLength));
        System.out.printf("%" + (spaces + title.length()) + "s\n", title);
        System.out.println("=".repeat(totalLength));

        System.out.printf("%-15s %-25s %-20s %-15s\n",
                "Ma khach hang",
                "Ten khach hang",
                "Loai khach hang",
                "Tan suat mua");
        System.out.println("=".repeat(totalLength));

        for (KhachHang kh : dskh) {
            int tanSuatMua = 0;

            for (HoaDon hd : qlhd.getDshd()) {
                if (hd instanceof HoaDonBanHang hdbh) {
                    if (hdbh.getKhachHang() != null &&
                            hdbh.getKhachHang().getMaKhachHang().equals(kh.getMaKhachHang())) {
                        tanSuatMua++;
                    }
                }
            }

            System.out.printf("%-15s %-25s %-20s %-15d\n",
                    kh.getMaKhachHang(),
                    kh.getHoTen(),
                    kh.getLoaiKhachHang(),
                    tanSuatMua);
        }

        System.out.println("=".repeat(totalLength));
    }


}
