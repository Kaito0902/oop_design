package NhanVien;

import static ChucNang.ChucNangMenu.*;
import static main_project.oop_project.qlnp;

public class NhanVienQuanLy extends NhanVien implements ThuongDoanhThu {
    private double chiSoHieuSuat;

    public NhanVienQuanLy() {
    }

    public NhanVienQuanLy(String maNhanVien, String tenNhanVien, String soDienThoai, String email, int namSinh, String gioiTinh, String chucVu, int namVaoLam, double heSoLuong, int ngayPhepConLai, double luong, String matKhau, boolean isdelete, double chiSoHieuSuat) {
        super(maNhanVien, tenNhanVien, soDienThoai, email, namSinh, gioiTinh, chucVu, namVaoLam, heSoLuong, ngayPhepConLai, luong, matKhau, isdelete);
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

    // tinh chi so hieu suat (50%, 30%, 20%)
    // doanh thu, ty le hai long, chi phi (muc tieu/ thuc te)

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
    public void menunv() {
        boolean kt = true;
        int lc;
        while (kt) {
            System.out.println("======================================");
            System.out.println("|             MENU CHINH             |");
            System.out.println("======================================");
            System.out.printf("| %-34s |\n", "1. Quan ly nhan vien");
            System.out.printf("| %-34s |\n", "2. Quan ly khach hang va hoa don");
            System.out.printf("| %-34s |\n", "3. Quan ly san pham");
            System.out.printf("| %-34s |\n", "4. Quan ly don dat hang");
            System.out.printf("| %-34s |\n", "5. Quan ly bao hanh va sua chua");
            System.out.printf("| %-34s |\n", "6. Quan ly chuoi cung cap");
            System.out.printf("| %-34s |\n", "7. Thong ke so lieu");
            System.out.printf("| %-34s |\n", "8. Xem thong tin ban than");
            System.out.printf("| %-34s |\n", "9. Xin nghi phep");
            System.out.printf("| %-34s |\n", "10. Doi mat khau");
            System.out.printf("| %-34s |\n", "11. Dang xuat");
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
                    menuSP();
                    break;
                }
                case 4: {
                    menuDDH();
                    break;
                }
                case 5: {
                    menuBH();
                    break;
                }
                case 6: {
                    menuCCC();
                    break;
                }
                case 7: {
                    menuTK();
                    break;
                }
                case 8: {
                    output();
                    break;
                }
                case 9: {
                    NghiPhep nghiPhep = new NghiPhep();
                    nghiPhep.input();
                    qlnp.themDonNghiPhep(nghiPhep);
                    break;
                }
                case 10: {
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
                    }
                    else{
                        System.out.println("Khong the doi mat khau vi ban nhap sai nhieu lan.");
                    }
                    break;
                }
                case 11: {
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
