package NhanVien;


import MucTieu.MucTieuDoanhThu;

import java.time.LocalDate;
import java.time.YearMonth;

import static ChucNang.ChucNangMenu.*;
import static main_project.oop_project.*;

public class NhanVienQuanLy extends NhanVien implements ThuongDoanhThu {
    private double chiSoHieuSuat;

    public NhanVienQuanLy() {
    }

    public NhanVienQuanLy(String maNhanVien, String tenNhanVien, String soDienThoai, String email, LocalDate namSinh, String gioiTinh, String chucVu, LocalDate ngayVaoLam, double heSoLuong, int ngayPhepConLai, double luong, String matKhau, boolean isdelete, double chiSoHieuSuat) {
        super(maNhanVien, tenNhanVien, soDienThoai, email, namSinh, gioiTinh, chucVu, ngayVaoLam, heSoLuong, ngayPhepConLai, luong, matKhau, isdelete);
        this.chiSoHieuSuat = chiSoHieuSuat;
    }

    public double getChiSoHieuSuat() {
        return chiSoHieuSuat;
    }

    public void setChiSoHieuSuat(double chiSoHieuSuat) {
        this.chiSoHieuSuat = chiSoHieuSuat;
    }

    @Override
    public void input() {
        chucVu = "Nhan vien quan ly";
        super.input();
        chiSoHieuSuat = 0;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-15.2f", chiSoHieuSuat);
    }

    @Override
    public double heSoPhuCap() {
        return 0.1;
    }

    public double tinhChiSoHieuSuat(YearMonth thangNam, double doanhThuthucTe) {
        MucTieuDoanhThu mucTieu = qlmt.timMucTieu(thangNam);
        if (mucTieu != null && mucTieu.getDoanhThu() != 0) {
            return doanhThuthucTe / mucTieu.getDoanhThu();
        } else {
            return -1;
        }
    }

    public void capNhatChiSoHieuSuatCuoiThang() {
        LocalDate today = LocalDate.now();
        YearMonth thangNamHienTai = YearMonth.from(today);
        double doanhThuThucTe = qlhd.tinhTongDoanhThuThangHienTai();
        double chiSo = tinhChiSoHieuSuat(thangNamHienTai, doanhThuThucTe);
        if (chiSo != -1) {
            this.chiSoHieuSuat = chiSo;
        }
    }

    @Override
    public double thuongDoanhThu() {
        if (chiSoHieuSuat >= 1) {
            return 0.1;
        }
        else if (chiSoHieuSuat >= 0.8) {
            return 0;
        }
        else if (chiSoHieuSuat == 0) {
            return 0;
        }
        else {
            return -0.05;
        }
    }

    @Override
    public double tinhLuong() {
        return luongCoBan*heSoLuong + luongCoBan*heSoPhuCap() + luongCoBan*thuongDoanhThu();
    }

    @Override
    public void resetThuocTinhDauThang() {
        this.chiSoHieuSuat = 0;
    }

    @Override
    public void menunv() {
        boolean kt = true;
        int lc;
        while (kt) {
            System.out.println("======================================");
            System.out.println("|             MENU CHINH             |");
            System.out.println("======================================");
            System.out.printf("| %-34s |\n", "1. Quan ly nhan vien");
            System.out.printf("| %-34s |\n", "2. Quan ly khach hang va hoa don");
            System.out.printf("| %-34s |\n", "3. Quan ly khuyen mai");
            System.out.printf("| %-34s |\n", "4. Quan ly san pham");
            System.out.printf("| %-34s |\n", "5. Quan ly don dat hang");
            System.out.printf("| %-34s |\n", "6. Quan ly bao hanh va sua chua");
            System.out.printf("| %-34s |\n", "7. Quan ly chuoi cung cap");
            System.out.printf("| %-34s |\n", "8. Thong ke so lieu");
            System.out.printf("| %-34s |\n", "9. Xem thong tin ban than");
            System.out.printf("| %-34s |\n", "10. Xin nghi phep");
            System.out.printf("| %-34s |\n", "11. Doi mat khau");
            System.out.printf("| %-34s |\n", "12. Dang xuat");
            System.out.println("======================================");
            System.out.print("Nhap lua chon: ");
            lc = Integer.parseInt(sc.nextLine());
            switch (lc) {
                case 1: {
                    menuNV();
                    break;
                }
                case 2: {
                    menuGD();
                    break;
                }
                case 3: {
                    menuKM();
                    break;
                }
                case 4: {
                    menuSP();
                    break;
                }
                case 5: {
                    menuDDH();
                    break;
                }
                case 6: {
                    menuBH();
                    break;
                }
                case 7: {
                    menuCCC();
                    break;
                }
                case 8: {
                    menuTK();
                    break;
                }
                case 9: {
                    output();
                    break;
                }
                case 10: {
                    NghiPhep nghiPhep = new NghiPhep();
                    nghiPhep.input();
                    qlnp.themDonNghiPhep(nghiPhep);
                    qlnp.ghiVaoFileDSNP();
                    break;
                }
                case 11: {
                    System.out.println("Nhap mat khau cu: ");
                    String matKhauCu = sc.nextLine();
                    int dem = 0;
                    while (!matKhauCu.equals(matKhau)) {
                        dem++;
                        System.out.println("Mat khau sai vui long nhap lai: ");
                        matKhauCu = sc.nextLine();
                        if (dem == 5) {
                            System.out.println("Ban da nhap sai mat khau qua nhieu lan.");
                            break;
                        }
                    }
                    if (dem < 5) {
                        System.out.println("Nhap mat khau moi: ");
                        String matKhauMoi = sc.nextLine();
                        doiMatKhau(matKhauMoi);
                        qlnv.ghiVaoFileDSNV();
                    }
                    else{
                        System.out.println("Khong the doi mat khau vi ban nhap sai nhieu lan.");
                    }
                    break;
                }
                case 12: {
                    kt = false;
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
