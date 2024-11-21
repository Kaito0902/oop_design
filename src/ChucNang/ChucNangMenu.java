package ChucNang;

import BaoHanh.BaoHanhSanPham;
import NhanVien.NhanVien;
import NhanVien.NhanVienBanHang;
import NhanVien.NhanVienKyThuat;
import NhanVien.NhanVienQuanLy;
import SanPham.SanPham;

import java.util.Scanner;

import static main_project.oop_project.qlnv;
import static main_project.oop_project.qlsp;
import static main_project.oop_project.qlbh;
import static main_project.oop_project.qlnp;

public class ChucNangMenu {

    static Scanner sc = new Scanner(System.in);

    public static void menuBHSP() {
        boolean ktra = true;
        int chon;
        while (ktra) {
            System.out.println("===================================");
            System.out.println("|\t     MENU SAN PHAM       \t|");
            System.out.println("===================================");
            System.out.printf("| %-34s|\n", "1. Xuat danh sach san pham");
            System.out.printf("| %-34s|\n", "2. Tim kiem san pham");
            System.out.printf("| %-34s|\n", "3. Thoat                     |");
            System.out.println("===================================");
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1: {
                    qlsp.xuatDanhSach();
                    break;
                }
                case 2: {
                    System.out.println("Nhap san pham muon tim kiem: ");
                    String timKiem = sc.nextLine();
                    SanPham sp = qlsp.timKiem(timKiem);
                    if (sp != null) {
                        sp.xuat();
                    }
                    else {
                        System.out.println("Khong tim thay san pham.");
                    }
                    break;
                }
                case 3: {
                    ktra = false;
                    break;
                }
                default: {
                    System.out.println("Lua chon khong hop le");
                    System.out.println("Vui long lua chon lai");
                }
            }
        }
    }

    public static void menuGD() {
        boolean ktra = true;
        int chon;
        while (ktra) {
            System.out.println("===============================================");
            System.out.println("|\t          MENU GIAO DICH            \t|");
            System.out.println("===============================================");
            System.out.printf("| %-45s|\n", "1. Nhap thong tin khach hang moi");
            System.out.printf("| %-45s|\n", "2. Xuat danh sach khach hang");
            System.out.printf("| %-45s|\n", "3. Sua thong tin khach hang theo ma");
            System.out.printf("| %-45s|\n", "4. Xoa khach hang theo ma");
            System.out.printf("| %-45s|\n", "5. Tim kiem khach hang theo so dien thoai");
            System.out.printf("| %-45s|\n", "6. Tao hoa don moi");
            System.out.printf("| %-45s|\n", "7. Xuat danh sach hoa don");
            System.out.printf("| %-45s|\n", "8. Sua hoa don theo ma");
            System.out.printf("| %-45s|\n", "9. Xoa hoa don theo ma");
            System.out.printf("| %-45s|\n", "10. Tim kiem hoa don theo ma");
            System.out.printf("| %-45s|\n", "11. Thoat");
            System.out.println("===============================================");
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1: {
                    //nhap
                    break;
                }
                case 2: {
                    //xuat
                    break;
                }
                case 3: {
                    //sua
                    break;
                }
                case 4: {
                    //xoa
                    break;
                }
                case 5: {
                    //tk
                    break;
                }
                case 6: {
                    //tao
                    break;
                }
                case 7: {
                    //xuatds
                    break;
                }
                case 8: {
                    //suahd
                    break;
                }
                case 9: {
                    //xoahd
                    break;
                }
                case 10: {
                    //tim
                    break;
                }
                case 11: {
                    ktra = false;
                    break;
                }
                default: {
                    System.out.println("Lua chon khong hop le");
                    System.out.println("Vui long lua chon lai");
                }
            }
        }
    }

    public static void menuSP() {
        boolean ktra = true;
        int chon;
        while (ktra) {
            System.out.println("===================================");
            System.out.println("|\t     MENU SAN PHAM       \t|");
            System.out.println("===================================");
            System.out.printf("| %-34s|\n", "1. Nhap danh sach san pham moi");
            System.out.printf("| %-34s|\n", "2. Xuat danh sach san pham");
            System.out.printf("| %-34s|\n", "3. Sua thong tin san pham theo ma");
            System.out.printf("| %-34s|\n", "4. Xoa san pham theo ma");
            System.out.printf("| %-34s|\n", "5. Tim kiem san pham");
            System.out.printf("| %-34s|\n", "6. Thoat                     |");
            System.out.println("===================================");
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1: {
                    qlsp.nhapDanhSach();
                    break;
                }
                case 2: {
                    qlsp.xuatDanhSach();
                    break;
                }
                case 3: {
                    System.out.println("Nhap ma san pham muon sua: ");
                    qlsp.suaPhanTuTheoMa(sc.nextLine());
                    break;
                }
                case 4: {
//                    qlsp.xoaPhanTuTheoMa();
                    break;
                }
                case 5: {
                    System.out.println("Nhap san pham muon tim kiem: ");
                    String timKiem = sc.nextLine();
                    SanPham sp = qlsp.timKiem(timKiem);
                    if (sp != null) {
                        sp.xuat();
                    }
                    else {
                        System.out.println("Khong tim thay san pham.");
                    }
                    break;
                }
                case 6: {
                    ktra = false;
                    break;
                }
                default: {
                    System.out.println("Lua chon khong hop le");
                    System.out.println("Vui long lua chon lai");
                }
            }
        }
    }

    public static void menuDDH() {
        boolean ktra = true;
        int chon;
        while (ktra) {
            System.out.println("==========================================");
            System.out.println("|\t    MENU DON DAT HANG       \t|");
            System.out.println("==========================================");
            System.out.printf("| %-40s|\n", "1. Nhap danh sach don dat hang moi");
            System.out.printf("| %-40s|\n", "2. Xuat danh sach don dat hang");
            System.out.printf("| %-40s|\n", "3. Sua don nhap theo ma");
            System.out.printf("| %-40s|\n", "4. Xoa don nhap theo ma");
            System.out.printf("| %-40s|\n", "5. Tim kiem don nhap theo ma");
            System.out.printf("| %-40s|\n", "6. Thoat");
            System.out.println("==========================================");
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1: {
                    //nhap
                    break;
                }
                case 2: {
                    //xuat
                    break;
                }
                case 3: {
                    //sua
                    break;
                }
                case 4: {
                    //xoa
                    break;
                }
                case 5: {
                    //tk
                    break;
                }
                case 6: {
                    ktra = false;
                    break;
                }
                default: {
                    System.out.println("Lua chon khong hop le");
                    System.out.println("Vui long lua chon lai");
                }
            }
        }
    }

    public static void menuBH() {
        boolean ktra = true;
        int chon;
        while (ktra) {
            System.out.println("==========================================");
            System.out.println("|\t    MENU BAO HANH       \t|");
            System.out.println("==========================================");
            System.out.printf("| %-40s|\n", "1. Tim kiem khach hang theo so dien thoai");
            System.out.printf("| %-40s|\n", "2. Xem danh sach bao hanh");
            System.out.printf("| %-40s|\n", "3. Them yeu cau bao hanh");
            System.out.printf("| %-40s|\n", "4. Cap nhat trang thai bao hanh");
            System.out.printf("| %-40s|\n", "5. Thoat");
            System.out.println("==========================================");
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1: {
                    //tk
                    break;
                }
                case 2: {
                    qlbh.xuatDanhSachBaoHang();
                    break;
                }
                case 3: {
                    BaoHanhSanPham x = new BaoHanhSanPham();
                    x.input();
                    qlbh.themBaoHanh(x);
                    break;
                }
                case 4: {
                    System.out.println("Nhap ma bao hanh muon cap nhat trang thai.");
                    qlbh.capNhatTrangThaiBaoHanh(sc.nextLine());
                    break;
                }
                case 5: {
                    ktra = false;
                    break;
                }
                default: {
                    System.out.println("Lua chon khong hop le");
                    System.out.println("Vui long lua chon lai");
                }
            }
        }
    }

    public static void menuNV() {
        boolean ktra = true;
        int chon;
        while (ktra) {
            qlnv.ghiVaoFileDSNV();
            qlnp.ghiVaoFileDSNP();
            System.out.println("=====================================");
            System.out.println("|\t        MENU NHAN VIEN         \t|");
            System.out.println("=====================================");
            System.out.printf("| %-34s|\n", "1. Them danh sach nhan vien");
            System.out.printf("| %-34s|\n", "2. Xuat danh sach nhan vien");
            System.out.printf("| %-34s|\n", "3. Sua thong tin nhan vien theo ma");
            System.out.printf("| %-34s|\n", "4. Xoa nhan vien theo ma");
            System.out.printf("| %-34s|\n", "5. Tim kiem nhan vien");
            System.out.printf("| %-34s|\n", "6. Xuat danh sach nghi phep");
            System.out.printf("| %-34s|\n", "7. Duyet don nghi phep");
            System.out.printf("| %-34s|\n", "8. Thoat                     ");
            System.out.println("=====================================");
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1: {
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
                                i--;
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    qlnv.xuatDanhSachNV();
                    break;
                }
                case 3: {
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
                case 4: {
                    System.out.println("Nhap ma nhan vien muon xoa: ");
                    qlnv.xoa1NV(sc.nextLine());
                    break;
                }
                case 5: {
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
                case 6: {
                    System.out.println("DANH SACH DON XIN NGHI");
                    qlnp.xuatDanhSach();
                    break;
                }
                case 7: {
                    qlnp.pheDuyetDon(qlnv.nguoiDangNhap());
                    break;
                }
                case 8: {
                    ktra = false;
                    break;
                }
                default: {
                    System.out.println("Lua chon khong hop le");
                    System.out.println("Vui long lua chon lai");
                }
            }
        }
    }

    public static void menuCCC() {
        boolean ktra = true;
        int chon;
        while (ktra) {
            System.out.println("===================================");
            System.out.println("|\t     MENU CHUOI CUNG CAP       \t|");
            System.out.println("===================================");
            System.out.printf("| %-34s|\n", "1. Them nha cung cap moi");
            System.out.printf("| %-34s|\n", "2. Xuat danh sach nha cung cap");
            System.out.printf("| %-34s|\n", "3. Sua thong tin nha cung cap theo ma");
            System.out.printf("| %-34s|\n", "4. Xoa nha cung cap theo ma");
            System.out.printf("| %-34s|\n", "5. Tim kiem nha cung cap");
            System.out.printf("| %-34s|\n", "6. Thoat                     |");
            System.out.println("===================================");
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1: {
                    //nhap
                    break;
                }
                case 2: {
                    //xuat
                    break;
                }
                case 3: {
                    //sua
                    break;
                }
                case 4: {
                    //xoa
                    break;
                }
                case 5: {
                    //tk
                    break;
                }
                case 6: {
                    ktra = false;
                    break;
                }
                default: {
                    System.out.println("Lua chon khong hop le");
                    System.out.println("Vui long lua chon lai");
                }
            }
        }
    }

    public static void menuTK() {
        boolean ktra = true;
        int chon;
        while (ktra) {
            System.out.println("===================================");
            System.out.println("|\t     MENU THONG KE       \t|");
            System.out.println("===================================");
            System.out.printf("| %-34s|\n", "1. Xem thong ke doanh thu");
            System.out.printf("| %-34s|\n", "2. Xem thong ke san pham");
            System.out.printf("| %-34s|\n", "3. Xem thong ke kho");
            System.out.printf("| %-34s|\n", "4. Xem thong nhan vien");
            System.out.printf("| %-34s|\n", "5. Thoat                     |");
            System.out.println("===================================");
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1: {
                    //dt
                    break;
                }
                case 2: {
                    //sp
                    break;
                }
                case 3: {
                    //kho
                    break;
                }
                case 4: {
                    System.out.println("1.Thong ke nhan vien ban hang");
                    System.out.println("2.Thong ke nhan vien ky thuat");
                    System.out.println("3.Thong ke nhan vien quan ly");
                    System.out.println("Nhap lua chon: ");
                    int lc = Integer.parseInt(sc.nextLine());
                    switch (lc) {
                        case 1: {
                            qlnv.thongKeNVBH();
                            break;
                        }
                        case 2: {
                            qlnv.thongKeNVKT();
                            break;
                        }
                        case 3: {
                            qlnv.thongKeNVQL();
                            break;
                        }
                        default: {
                            System.out.println("Lua chon khong hop le");
                            System.out.println("Vui long lua chon lai");
                        }
                    }
                    break;
                }
                case 5: {
                    ktra = false;
                    break;
                }
                default: {
                    System.out.println("Lua chon khong hop le");
                    System.out.println("Vui long lua chon lai");
                }
            }
        }
    }


}