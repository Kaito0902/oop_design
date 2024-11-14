package KhachHang;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import HoaDon.QLHoaDon;

public class QLKhachHang {
    private KhachHang dskh[] = new KhachHang[0];
    static Scanner scanner = new Scanner(System.in);

    //them khach hang
    void themKH(KhachHang kh)  {
        KhachHang[] newkh = Arrays.copyOf(this.dskh, this.dskh.length+1);
        newkh[this.dskh.length] = kh;
        this.dskh = newkh;
    }

    //xuat khach hang
    public void xuatdskh() {
        for ( var i : dskh )
            i.output();
    }

    //xoa 1 KH
    public void xoa1KH(String maKH) {
        boolean ktra = false;
        for (KhachHang kh : dskh) {
            if (kh.maKhachHang.equals(maKH)) {
                ktra = true;
                break;
            }
        }
        if (ktra) {
            KhachHang newdskh[] = Arrays.copyOf(this.dskh, this.dskh.length-1);
            int index = 0;
            for (int i = 0; i < dskh.length; i++) {
                if (!dskh[i].maKhachHang.equals(maKH)) {
                    newdskh[index++] = dskh[i];
                }
            }
            dskh = newdskh;
            System.out.println("Da xoa khach hang co ma: " + maKH);
        } else {
            System.out.println("Khong tim thay khach hang co ma: " + maKH);
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

    //writetofile
    public void ghiVaoFileDSKH() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Admin\\java1\\KhachHang\\text.txt"))){
            for ( KhachHang kh : dskh )
                if ( kh instanceof CaNhan cn ) {
                    writer.write(String.join(",",
                    cn.getMaKhachHang(),
                    cn.getHoTen(),
                    cn.getGioiTinh(),
                    cn.getNgaySinh(),
                    cn.getDiaChi(),
                    cn.getSdt(),
                    cn.getEmail(),
                    cn.getLoaiKhachHang(),
                    String.valueOf(cn.getTichDiem()),
                    String.valueOf(cn.tinhUuDai())
                    ));
                    writer.newLine();
                }
                else if ( kh instanceof SinhVien sv ) {
                    writer.write(String.join(",",
                    sv.getMaKhachHang(),
                    sv.getHoTen(),
                    sv.getGioiTinh(),
                    sv.getNgaySinh(),
                    sv.getDiaChi(),
                    sv.getSdt(),
                    sv.getEmail(),
                    sv.getLoaiKhachHang(),
                    String.valueOf(sv.getTichDiem()),
                    String.valueOf(sv.getDiemTB()),
                    String.valueOf(sv.tinhUuDai())
                    ));
                    writer.newLine();
                }
                else if ( kh instanceof Vip vip ) {
                    writer.write(String.join(",",
                    vip.getMaKhachHang(),
                    vip.getHoTen(),
                    vip.getGioiTinh(),
                    vip.getNgaySinh(),
                    vip.getDiaChi(),
                    vip.getSdt(),
                    vip.getEmail(),
                    vip.getLoaiKhachHang(),
                    String.valueOf(vip.getTichDiem()),
                    String.valueOf(vip.getHeSo()),
                    String.valueOf(vip.tinhUuDai()),
                    String.valueOf(vip.laiSuatTraGop())
                    ));
                    writer.newLine();
                }
                else {
                    DoiTacDoanhNghiep dt = (DoiTacDoanhNghiep) kh;
                    writer.write(String.join(",",
                    dt.getMaKhachHang(),
                    dt.getHoTen(),
                    dt.getGioiTinh(),
                    dt.getNgaySinh(),
                    dt.getDiaChi(),
                    dt.getSdt(),
                    dt.getEmail(),
                    dt.getLoaiKhachHang(),
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
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Admin\\java1\\KhachHang\\text.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if ( data.length > 0 ) {
                    String maKhachHang = data[0];
                    String tenKhachHang = data[1];
                    String gioiTinh = data[2];
                    String namSinh = data[3];
                    String diaChi = data[4];
                    String soDienThoai = data[5];
                    String eMail = data[6];
                    String loaiKhachHang = data[7];
                    int tichDiem = Integer.parseInt(data[8]);

                    switch (loaiKhachHang) {
                        case "Binh Thuong" ->{
                            KhachHang caNhan = new CaNhan(tenKhachHang, gioiTinh, namSinh, diaChi, soDienThoai, eMail, maKhachHang, loaiKhachHang, tichDiem);
                            themKH(caNhan);
                        }
                        case "Uu dai" -> {
                            double diemTB = Double.parseDouble(data[9]);
                            KhachHang sinhVien = new SinhVien(tenKhachHang, gioiTinh, namSinh, diaChi, soDienThoai, eMail, maKhachHang, loaiKhachHang, tichDiem, diemTB);
                            themKH(sinhVien);
                        }
                        case "Than Thiet" -> {
                            int heSo = Integer.parseInt(data[9]);
                            KhachHang vip = new Vip(tenKhachHang, gioiTinh, namSinh, diaChi, soDienThoai, eMail, maKhachHang, loaiKhachHang, tichDiem, heSo);
                            themKH(vip);
                        }
                        case "Tiem Nang" -> {
                            String tenCongTy = data[9];
                            KhachHang dt = new DoiTacDoanhNghiep(tenKhachHang, gioiTinh, namSinh, diaChi, soDienThoai, eMail, maKhachHang, loaiKhachHang, tichDiem, tenCongTy);
                            themKH(dt);
                        }
                    
                        default -> System.out.println("Dữ liệu không hợp lệ cho nhân viên: " + line);
                    }

                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Lỗi đọc hoặc định dạng số trong dữ liệu: " + e.getMessage());
        }
    }

    //menu
    public void menu(QLHoaDon qlhd) {
        int choice;
        do {
            System.out.println("===================================");
            System.out.println("|\t        MENU CHINH         \t|");
            System.out.println("===================================");
            System.out.printf("| %-31s|\n", "1. Them 1 kh");
            System.out.printf("| %-31s|\n", "2. Xuat danh sach kh");
            System.out.printf("| %-31s|\n", "3. Xoa 1 kh");
            System.out.printf("| %-31s|\n", "4. Tim kiem 1 kh");
            System.out.printf("| %-31s|\n", "5. Sap xep dskh");
            System.out.printf("| %-31s|\n", "6. Xuat danh sach khVip");
            System.out.printf("| %-31s|\n", "7. Tim khach hang mua nhieu tien nhat");
            System.out.printf("| %-31s|\n", "8. Sua thongtin khach hang"); 
            System.out.printf("| %-31s|\n", "9. Lay sl khach hang"); 
            System.out.printf("| %-31s|\n", "10. Doc tu file"); 
            System.out.printf("| %-31s|\n", "0. Thoat chuong trinh");
            System.out.println("===================================");
            System.out.print("Nhap lua chon: ");

            
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    String chon;
                    System.out.println("a. Them khcanhan.");
                    System.out.println("b. Them khsv.");
                    System.out.println("c. Them khdoitac.");
                    System.out.println("d. Them khvip.");
                    System.out.println("Nhap lua chon: ");
                    chon = scanner.nextLine();
                    switch (chon) {
                        case "a":
                            KhachHang x = new CaNhan();
                            x.input(qlhd);
                            themKH(x);
                            ghiVaoFileDSKH();
                            break;
                        case "b":
                            KhachHang y = new SinhVien();
                            y.input(qlhd);
                            themKH(y);
                            ghiVaoFileDSKH();
                            break;
                        case "c":
                            KhachHang z = new DoiTacDoanhNghiep();
                            z.input(qlhd);
                            themKH(z);
                            ghiVaoFileDSKH();
                            break;
                        case "d":
                            KhachHang w = new Vip();
                            w.input(qlhd);
                            themKH(w);
                            ghiVaoFileDSKH();
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!!!");
                    }
                    break;
                case 2:
                    if (dskh.length == 0)
                        System.out.println("DANH SACH TRONG.");
                    else {
                        System.out.println("===================================");
                        System.out.println("|\t      DANH SACH HOA DON      \t|");
                        System.out.println("===================================");
                        xuatdskh();
                    } 
                    break;
                case 3:
                    System.out.println("Nhap ma kh muon xoa:");
                    String ma = scanner.nextLine();
                    xoa1KH(ma);
                    break;
                case 4:
                    String chon1;
                    System.out.println("a. Tim theo ma.");
                    System.out.println("b. Tim theo sdt.");
                    System.out.println("Nhap lua chon: ");
                    chon1 = scanner.nextLine();
                    switch (chon1) {
                        case "a":
                            System.out.println("Nhap ma kh muon tim:");
                            String ma1 = scanner.nextLine();
                            KhachHang kh1 = timkiemKhachHangTheoMa(ma1);
                            if ( kh1 != null)
                                kh1.output();
                            else 
                                System.out.println("khong tim thay khach hang co ma: " + ma1);
                            break;
                        case "b":
                            System.out.println("Nhap sdt kh muon tim:");
                            String ma2 = scanner.nextLine();
                            KhachHang kh2 = timkiemKhachHangTheoSdt(ma2);
                            if ( kh2 != null )
                                kh2.output();
                        else 
                            System.out.println("Khong tim thay khach hang theo sdt: " + ma2);
                            break;
                        default:
                            System.out.println("nhap sai lua chon");
                            break;
                    }   
                    break;
                case 5:
                    sapxep();
                    System.out.println("Da sap xep danh sach!!!!");
                    break;
                case 10:
                    docTuFileDSKH();
                    break;
                case 0:
                    System.out.println("Da thoat chuong trinh!!!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!!!!");
            } 
        }  while (choice != 0);
    }
}
