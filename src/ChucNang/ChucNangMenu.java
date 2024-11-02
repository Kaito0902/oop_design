package ChucNang;

import NhanVien.NhanVien;
import NhanVien.NhanVienBanHang;
import NhanVien.QLNhanVien;
import NhanVien.NhanVienKyThuat;
import NhanVien.NhanVienQuanLy;

import java.util.Scanner;

public class ChucNangMenu {
    private static QLNhanVien qlnv;
    static Scanner sc = new Scanner(System.in);

    public ChucNangMenu(QLNhanVien qlnv) {
        ChucNangMenu.qlnv = qlnv;
    }

    public static void menuBHSP() {
        boolean ktra = true;
        String chon;
        while (ktra) {
            System.out.println("===================================");
            System.out.println("|\t     MENU SAN PHAM       \t|");
            System.out.println("===================================");
            System.out.printf("| %-34s|\n", "a. Xuat danh sach san pham");
            System.out.printf("| %-34s|\n", "b. Tim kiem san pham");
            System.out.printf("| %-34s|\n", "c. Thoat                     |");
            System.out.println("===================================");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextLine();
            switch (chon) {
                case "a": {
                    //lenh
                    break;
                }
                case "b": {
                    //lenhtim
                    break;
                }
                case "c": {
                    //lenhtimten
                    break;
                }
                case "d": {
                    ktra = false;
                    break;
                }
                default: {
                    System.out.println("Lua chon khong hop le");
                    System.out.println("Vui long lua chon lai");
                    break;
                }
            }
        }
    }

    public static void menuGD() {
        boolean ktra = true;
        String chon;
        while (ktra) {

            System.out.println("===============================================");
            System.out.println("|\t          MENU GIAO DICH            \t|");
            System.out.println("===============================================");
            System.out.printf("| %-45s|\n", "a. Nhap thong tin khach hang moi");
            System.out.printf("| %-45s|\n", "b. Xuat danh sach khach hang");
            System.out.printf("| %-45s|\n", "c. Sua thong tin khach hang theo ma");
            System.out.printf("| %-45s|\n", "d. Xoa khach hang theo ma");
            System.out.printf("| %-45s|\n", "e. Tim kiem khach hang theo so dien thoai");
            System.out.printf("| %-45s|\n", "f. Tao hoa don moi");
            System.out.printf("| %-45s|\n", "g. Xuat danh sach hoa don");
            System.out.printf("| %-45s|\n", "h. Sua hoa don theo ma");
            System.out.printf("| %-45s|\n", "i. Xoa hoa don theo ma");
            System.out.printf("| %-45s|\n", "j. Tim kiem hoa don theo ma");
            System.out.printf("| %-45s|\n", "k. Thoat");
            System.out.println("===============================================");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextLine();
            switch (chon) {
                case "a": {
                    //nhap
                    break;
                }
                case "b": {
                    //xuat
                    break;
                }
                case "c": {
                    //sua
                    break;
                }
                case "d": {
                    //xoa
                    break;
                }
                case "e": {
                    //tk
                    break;
                }
                case "f": {
                    //tao
                    break;
                }
                case "g": {
                    //xuatds
                    break;
                }
                case "h": {
                    //suahd
                    break;
                }
                case "i": {
                    //xoahd
                    break;
                }
                case "j": {
                    //tim
                    break;
                }
                case "k": {
                    ktra = false;
                    break;
                }
                default: {
                    System.out.println("Lua chon khong hop le");
                    System.out.println("Vui long lua chon lai");
                    break;
                }
            }
        }
    }

    public static void menuSP() {
        boolean ktra = true;
        String chon;
        while (ktra) {
            System.out.println("===================================");
            System.out.println("|\t     MENU SAN PHAM       \t|");
            System.out.println("===================================");
            System.out.printf("| %-34s|\n", "a. Nhap danh sach san pham moi");
            System.out.printf("| %-34s|\n", "b. Xuat danh sach san pham");
            System.out.printf("| %-34s|\n", "c. Sua thong tin san pham theo ma");
            System.out.printf("| %-34s|\n", "d. Xoa san pham theo ma");
            System.out.printf("| %-34s|\n", "e. Tim kiem san pham");
            System.out.printf("| %-34s|\n", "f. Thoat                     |");
            System.out.println("===================================");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextLine();
            switch (chon) {
                case "a": {
                    //nhap
                    break;
                }
                case "b": {
                    //xuat
                    break;
                }
                case "c": {
                    //sua
                    break;
                }
                case "d": {
                    //xoa
                    break;
                }
                case "e": {
                    //tk
                    break;
                }
                case "f": {
                    ktra = false;
                    break;
                }
                default: {
                    System.out.println("Lua chon khong hop le");
                    System.out.println("Vui long lua chon lai");
                    break;
                }
            }
        }
    }

    public static void menuDDH() {
        boolean ktra = true;
        String chon;
        while (ktra) {
            System.out.println("==========================================");
            System.out.println("|\t    MENU DON DAT HANG       \t|");
            System.out.println("==========================================");
            System.out.printf("| %-40s|\n", "a. Nhap danh sach don dat hang moi");
            System.out.printf("| %-40s|\n", "b. Xuat danh sach don dat hang");
            System.out.printf("| %-40s|\n", "c. Sua don nhap theo ma");
            System.out.printf("| %-40s|\n", "d. Xoa don nhap theo ma");
            System.out.printf("| %-40s|\n", "e. Tim kiem don nhap theo ma");
            System.out.printf("| %-40s|\n", "f. Thoat");
            System.out.println("==========================================");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextLine();
            switch (chon) {
                case "a": {
                    //nhap
                    break;
                }
                case "b": {
                    //xuat
                    break;
                }
                case "c": {
                    //sua
                    break;
                }
                case "d": {
                    //xoa
                    break;
                }
                case "e": {
                    //tk
                    break;
                }
                case "f": {
                    ktra = false;
                    break;
                }
                default: {
                    System.out.println("Lua chon khong hop le");
                    System.out.println("Vui long lua chon lai");
                    break;
                }
            }
        }
    }

    public static void menuBH() {
        boolean ktra = true;
        String chon;
        while (ktra) {
            System.out.println("==========================================");
            System.out.println("|\t    MENU BAO HANH       \t|");
            System.out.println("==========================================");
            System.out.printf("| %-40s|\n", "a. Tim kiem khach hang theo so dien thoai");
            System.out.printf("| %-40s|\n", "b. Xem danh sach bao hanh");
            System.out.printf("| %-40s|\n", "c. Them yeu cau bao hanh");
            System.out.printf("| %-40s|\n", "d. Cap nhat trang thai bao hanh");
            System.out.printf("| %-40s|\n", "e. Xoa yeu cau bao hanh");
            System.out.printf("| %-40s|\n", "f. Thoat");
            System.out.println("==========================================");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextLine();
            switch (chon) {
                case "a": {
                    //tk
                    break;
                }
                case "b": {
                    //xem
                    break;
                }
                case "c": {
                    //themm
                    break;
                }
                case "d": {
                    //capnhat
                    break;
                }
                case "e": {
                    //xoa
                    break;
                }
                case "f": {
                    ktra = false;
                    break;
                }
                default: {
                    System.out.println("Lua chon khong hop le");
                    System.out.println("Vui long lua chon lai");
                    break;
                }
            }
        }
    }

    public static void menuNV() {
        boolean ktra = true;
        String chon;
        while (ktra) {
            System.out.println("===================================");
            System.out.println("|\t     MENU NHAN VIEN       \t|");
            System.out.println("===================================");
            System.out.printf("| %-34s|\n", "a. Them danh sach nhan vien");
            System.out.printf("| %-34s|\n", "b. Xuat danh sach nhan vien");
            System.out.printf("| %-34s|\n", "c. Sua thong tin nhan vien theo ma");
            System.out.printf("| %-34s|\n", "d. Xoa nhan vien theo ma");
            System.out.printf("| %-34s|\n", "e. Tim kiem nhan vien");
            System.out.printf("| %-34s|\n", "f. Thoat                     ");
            System.out.println("===================================");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextLine();
            switch (chon) {
                case "a": {
                    System.out.println("Nhap so luong nhan vien muon them: ");
                    int sl = Integer.parseInt(sc.nextLine());
                    int lc;
                    for (int i = 0; i < sl; i++) {
                        System.out.println("1.Them nhan vien ban hang");
                        System.out.println("2.Them nhan vien ky thuat");
                        System.out.println("3.Them nhan vien quan ly");
                        System.out.println("Nhap lua chon: ");
                        lc = Integer.parseInt(sc.nextLine());
                        switch (lc) {
                            case 1: {
                                NhanVien x = new NhanVienBanHang();
                                x.input();
                                qlnv.themNV(x);
                                System.out.println("Da them nhan vien.");
                                break;
                            }
                            case 2: {
                                NhanVien y = new NhanVienKyThuat();
                                y.input();
                                qlnv.themNV(y);
                                System.out.println("Da them nhan vien.");
                                break;
                            }
                            case 3: {
                                NhanVien z = new NhanVienQuanLy();
                                z.input();
                                qlnv.themNV(z);
                                System.out.println("Da them nhan vien.");
                                break;
                            }
                            default: {
                                System.out.println("Lua chon khong hop le.");
                                System.out.println("Vui long lua chon lai.");
                            }
                        }
                    }
                    break;
                }
                case "b": {
                    qlnv.xuatDanhSachNV();
                    break;
                }
                case "c": {
                    System.out.println("Nhap ma nhan vien muon sua thong tin: ");
                    NhanVien nv = qlnv.suaThongTinNV(sc.nextLine());
                    if (nv != null) {
                        nv.output();
                    }
                    else {
                        System.out.println("Khong tim thay nhan vien muon sua.");
                    }
                    break;
                }
                case "d": {
                    System.out.println("Nhap ma nhan vien muon xoa: ");
                    qlnv.xoa1NV(sc.nextLine());
                    break;
                }
                case "e": {
                    System.out.println("Nhap ten ban muon tim kiem: ");
                    NhanVien nv = qlnv.timKiemNhanVien(sc.nextLine());
                    if (nv != null) {
                        nv.output();
                    }
                    else {
                        System.out.println("Khong tim thay nhan vien.");
                    }
                    break;
                }
                case "f": {
                    ktra = false;
                    break;
                }
                default: {
                    System.out.println("Lua chon khong hop le");
                    System.out.println("Vui long lua chon lai");
                    break;
                }
            }
        }
    }

    public static void menuCCC() {
        boolean ktra = true;
        String chon;
        while (ktra) {
            System.out.println("===================================");
            System.out.println("|\t     MENU CHUOI CUNG CAP       \t|");
            System.out.println("===================================");
            System.out.printf("| %-34s|\n", "a. Them nha cung cap moi");
            System.out.printf("| %-34s|\n", "b. Xuat danh sach nha cung cap");
            System.out.printf("| %-34s|\n", "c. Sua thong tin nha cung cap theo ma");
            System.out.printf("| %-34s|\n", "d. Xoa nha cung cap theo ma");
            System.out.printf("| %-34s|\n", "e. Tim kiem nha cung cap");
            System.out.printf("| %-34s|\n", "f. Thoat                     |");
            System.out.println("===================================");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextLine();
            switch (chon) {
                case "a": {
                    //nhap
                    break;
                }
                case "b": {
                    //xuat
                    break;
                }
                case "c": {
                    //sua
                    break;
                }
                case "d": {
                    //xoa
                    break;
                }
                case "e": {
                    //tk
                    break;
                }
                case "f": {
                    ktra = false;
                    break;
                }
                default: {
                    System.out.println("Lua chon khong hop le");
                    System.out.println("Vui long lua chon lai");
                    break;
                }
            }
        }
    }

    public static void menuTK() {
        boolean ktra = true;
        String chon;
        while (ktra) {
            System.out.println("===================================");
            System.out.println("|\t     MENU THONG KE       \t|");
            System.out.println("===================================");
            System.out.printf("| %-34s|\n", "a. Xem thong ke doanh thu");
            System.out.printf("| %-34s|\n", "b. Xem thong ke san pham");
            System.out.printf("| %-34s|\n", "c. Xem thong ke kho");
            System.out.printf("| %-34s|\n", "d. Thoat                     |");
            System.out.println("===================================");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextLine();
            switch (chon) {
                case "a": {
                    //dt
                    break;
                }
                case "b": {
                    //sp
                    break;
                }
                case "c": {
                    //kho
                    break;
                }
                case "d": {
                    ktra = false;
                    break;
                }
                default: {
                    System.out.println("Lua chon khong hop le");
                    System.out.println("Vui long lua chon lai");
                    break;
                }
            }
        }
    }


}
