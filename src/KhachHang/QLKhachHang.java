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
    public void timkiemKhachHangCoTienCaoNhat(QLHoaDon qlHoaDon) {
        KhachHang khMax = null;
        double maxtien = 0;
        for ( KhachHang kh : dskh ){
            double max = qlHoaDon.getTongSoTien(kh.getSdt());
            if ( max > maxtien ) {
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

    // sua thong tin khach hang (cần sửa lại)
    public void capNhapThongTinKhachHang(String sdt, QLHoaDon qlhd) {
        KhachHang kh =timkiemKhachHangTheoSdt(sdt);
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

        // cap nhap khach hang len vip(cần sửa lại)
        public void capNhatLoaiKhachHang(QLHoaDon qlHoaDon, String sdt) {
            KhachHang kh = timkiemKhachHangTheoSdt(sdt);
            if (kh == null) {
                System.out.println("Không tìm thấy khách hàng với số điện thoại: " + sdt);
                return;
            }
            // for (int i = 0; i < dskh.length; i++) {
                // KhachHang kh = dskh[i];
                double tongSoTien = 5000000;//qlHoaDon.getTongSoTien(kh.getMaKhachHang())
                
                if (tongSoTien >= 5000000 && !(kh instanceof KhachHangVip)) {//&& kh instanceof KhachHangCaNhan

                    // KhachHang caNhan = (KhachHangCaNhan) kh;
                    // caNhan.setLoaiKhachHang("Than Thiet"); 
                    // caNhan.setTichDiem(caNhan.tinhDiemThuong(tongSoTien));
                    
                    // Nâng cấp lên khách hàng VIP
                    KhachHang vip = new KhachHangVip(
                        kh.getHoTen(), kh.getGioiTinh(), kh.getNgaySinh(), kh.getDiaChi(), kh.getSdt(),
                        kh.getEmail(), kh.getMaKhachHang(), "Than Thiet",kh.isIsdelete(), kh.getTichDiem(), 5
                    );

                    System.out.println("Cập nhật thông tin cho khách hàng " + kh.getMaKhachHang() +" sau khi nâng cấp:");
                    if (vip instanceof KhachHangVip) {
                        ((KhachHangVip) vip).inputThongTinVip();
                    }
                    for (int i = 0; i < dskh.length; i++)
                        if (dskh[i].getSdt().equalsIgnoreCase(sdt)){
                            dskh[i] = vip;
                            break;
                        }
                    System.out.println("Khach hang " + kh.getMaKhachHang() + " đã được nâng cấp lên VIP");
                } else {
                    // Giữ nguyên nếu không đạt điều kiện
                    System.out.println("Khach hang " + kh.getMaKhachHang() + " không đủ điều kiện để lên VIP");
                }
            // }
        }
        // cap nhap tu dong vip
        public void capNhatLoaiKhachHang(QLHoaDon qlHoaDon) {
            for (int i = 0; i < dskh.length; i++) {
                KhachHang kh = dskh[i];
                double tongSoTien = 5000000;//qlHoaDon.getTongSoTien(kh.getMaKhachHang())
                
                if (tongSoTien >= 5000000 && !(kh instanceof KhachHangVip)) {//&& kh instanceof KhachHangCaNhan

                    // KhachHang caNhan = (KhachHangCaNhan) kh;
                    // caNhan.setLoaiKhachHang("Than Thiet"); 
                    // caNhan.setTichDiem(caNhan.tinhDiemThuong(tongSoTien));
                    
                    int heSo = xeploaiheSo(qlHoaDon);
                    // Nâng cấp lên khách hàng VIP
                    KhachHang vip = new KhachHangVip(
                        kh.getHoTen(), kh.getGioiTinh(), kh.getNgaySinh(), kh.getDiaChi(), kh.getSdt(),
                        kh.getEmail(), kh.getMaKhachHang(), "Than Thiet",kh.isIsdelete(), kh.getTichDiem(), heSo
                    );

                    if (kh instanceof KhachHangCaNhan || kh instanceof KhachHangSinhVien) {
                        ((KhachHangVip) vip).setTraGop(false);
                    } else if (kh instanceof KhachHangDoiTacDoanhNghiep) {
                        boolean traGop = ((KhachHangDoiTacDoanhNghiep) kh).isTraGop();
                        ((KhachHangVip) vip).setTraGop(traGop);
                    } else {
                        System.out.println("Không xác định loại khách hàng, không thể thiết lập trả góp!");
                    }
                    // System.out.println("Cập nhật thông tin cho khách hàng " + kh.getMaKhachHang() +" sau khi nâng cấp:");
                    // if (vip instanceof KhachHangVip) {
                    //     ((KhachHangVip) vip).inputThongTinVip();
                    // }
                    // for (int i = 0; i < dskh.length; i++)
                    //     if (dskh[i].getSdt().equalsIgnoreCase(sdt)){
                    //         dskh[i] = vip;
                    //         break;
                    //     }
                    dskh[i] = vip;
                    System.out.println("Khach hang " + kh.getMaKhachHang() + " đã được nâng cấp lên VIP");
                } else {
                    // Giữ nguyên nếu không đạt điều kiện
                    System.out.println("Khach hang " + kh.getMaKhachHang() + " không đủ điều kiện để lên VIP");
                }
            }
        }

        public int xeploaiheSo(QLHoaDon qlHoaDon) {
            double tongSoTien = 5000000;//qlHoaDon.getTongSoTien(kh.getMaKhachHang())
            return tongSoTien >= 5000000?1:(tongSoTien>= 10000000?2:(tongSoTien >= 15000000?3:(tongSoTien>= 20000000?4:5)));
        }

    //writetofile
    public void ghiVaoFileDSKH() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Admin\\java1\\KhachHang\\DanhSachKhachHang.txt"))){
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
                    String.valueOf(vip.isTraGop()),
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
                    String.valueOf(dt.isTraGop()),
                    String.valueOf(dt.laiSuatTraGop())
                    ));
                    writer.newLine();
                }
        } catch (IOException e) {
            System.out.println("Loi ghi file:" + e.getMessage());
        }
    }

    public void docTuFileDSKH() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Admin\\java1\\KhachHang\\DanhSachKhachHang.txt"))) {
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
                    boolean isdelete = Boolean.parseBoolean(data[8]);
                    int tichDiem = Integer.parseInt(data[9]);

                    switch (loaiKhachHang) {
                        case "Binh Thuong" ->{
                            KhachHang caNhan = new KhachHangCaNhan(tenKhachHang, gioiTinh, namSinh, diaChi, soDienThoai, eMail, maKhachHang, loaiKhachHang,isdelete, tichDiem);
                            themKH(caNhan);
                        }
                        case "Uu dai" -> {
                            double diemTB = Double.parseDouble(data[10]);
                            KhachHang sinhVien = new KhachHangSinhVien(tenKhachHang, gioiTinh, namSinh, diaChi, soDienThoai, eMail, maKhachHang, loaiKhachHang,isdelete, tichDiem, diemTB);
                            themKH(sinhVien);
                        }
                        case "Than Thiet" -> {
                            int heSo = Integer.parseInt(data[10]);
                            boolean traGop = Boolean.parseBoolean(data[12]);
                            KhachHang vip = new KhachHangVip(tenKhachHang, gioiTinh, namSinh, diaChi, soDienThoai, eMail, maKhachHang, loaiKhachHang,isdelete, tichDiem, heSo);
                            ((KhachHangVip) vip).setTraGop(traGop); 
                            themKH(vip);
                        }
                        case "Tiem Nang" -> {
                            String tenCongTy = data[10];
                            boolean traGop = Boolean.parseBoolean(data[12]);
                            KhachHang dt = new KhachHangDoiTacDoanhNghiep(tenKhachHang, gioiTinh, namSinh, diaChi, soDienThoai, eMail, maKhachHang, loaiKhachHang,isdelete, tichDiem, tenCongTy);
                            ((KhachHangDoiTacDoanhNghiep) dt).setTraGop(traGop); 
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
            System.out.printf("| %-31s|\n", "11. Cập nhập khách hàng lên vip"); 
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
                    // System.out.println("d. Them khvip.");
                    System.out.println("Nhap lua chon: ");
                    chon = scanner.nextLine();
                    switch (chon) {
                        case "a":
                            KhachHang x = new KhachHangCaNhan();
                            x.input(qlhd);
                            themKH(x);
                            ghiVaoFileDSKH();
                            break;
                        case "b":
                            KhachHang y = new KhachHangSinhVien();
                            y.input(qlhd);
                            themKH(y);
                            ghiVaoFileDSKH();
                            break;
                        case "c":
                            KhachHang z = new KhachHangDoiTacDoanhNghiep();
                            z.input(qlhd);
                            themKH(z);
                            ghiVaoFileDSKH();
                            break;
                        // case "d":
                        //     KhachHang w = new KhachHangVip();
                        //     w.input(qlhd);
                        //     themKH(w);
                        //     ghiVaoFileDSKH();
                        //     break;
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
                        capNhatLoaiKhachHang(qlhd);
                        xuatdskh();
                    } 
                    break;
                case 3:
                    System.out.println("Nhap ma kh muon xoa:");
                    String ma = scanner.nextLine();
                    xoa1KH(ma);
                    ghiVaoFileDSKH();
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
                case 6:
                    if ( dskh.length == 0)
                        System.out.println("DANH SACH TRONG.");
                    else {
                        System.out.println("===================================");
                        System.out.println("|\t      DANH SACH HOA DON VIP      \t|");
                        System.out.println("===================================");
                        xuatdskhvip();
                    }
                    break;
                case 7:
                    timkiemKhachHangCoTienCaoNhat(qlhd);
                    break;
                case 8:
                    System.out.println("Nhap sdt kh muon tim:");
                    String ma2 = scanner.nextLine();
                    capNhapThongTinKhachHang(ma2, qlhd);
                    System.out.println("Da cap nhap thong tin!!!");
                    ghiVaoFileDSKH();
                    break;
                case 9:
                    System.out.println("So luong khach hang hien co la:");
                    System.out.println(dskh.length);
                    break;
                case 10:
                    docTuFileDSKH();
                    System.out.println("DA DOC DU LIEU TU FILE!!!");
                    break;
                case 11:
                    // System.out.println("Nhap sdt de tim khach hang muon nang cap:");
                    // String ma3 = scanner.nextLine();
                    if ( dskh.length > 0 ){
                        // capNhatLoaiKhachHang(qlhd,ma3);
                        capNhatLoaiKhachHang(qlhd);
                    ghiVaoFileDSKH();
                    }
                    else
                        System.out.println("Danh sach rong!!!");
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
