package KhachHang;
import java.util.Arrays;
import java.util.Scanner;

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


    //menu
    public void menu() {
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
            System.out.printf("| %-31s|\n", "6. Tim khach hang mua nhieu tien nhat");
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
                            x.input();
                            themKH(x);
                            break;
                        case "b":
                            KhachHang y = new SinhVien();
                            y.input();
                            themKH(y);
                            break;
                        case "c":
                            KhachHang z = new DoiTacDoanhNghiep();
                            z.input();
                            themKH(z);
                            break;
                        case "d":
                            KhachHang w = new Vip();
                            w.input();
                            themKH(w);
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
                                System.out.println("khong tim thay khach hang co ma:" + ma1);
                            break;
                        case "b":
                            System.out.println("Nhap sdt kh muon tim:");
                            String ma2 = scanner.nextLine();
                            KhachHang kh2 = timkiemKhachHangTheoSdt(ma2);
                            if ( kh2 != null )
                                kh2.output();
                            else
                                System.out.println("Khong tim thay khach hang theo sdt" + ma2);
                            break;
                        default:
                            System.out.println("nhap sai lua chon");
                            break;
                    }
                    break;
                case 5:
                    sapxep();
                    System.out.println("Da sap xep danh sach");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!!!");
            }
        }  while (choice != 0);
    }
}