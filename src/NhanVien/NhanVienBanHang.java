package NhanVien;

import java.time.LocalDate;

import static ChucNang.ChucNangMenu.menuBHSP;
import static ChucNang.ChucNangMenu.menuGD;
import static main_project.oop_project.qlnp;
import static main_project.oop_project.qlnv;

public class NhanVienBanHang extends NhanVien implements ThuongDoanhThu{
    private double doanhThu;
    private int soLuongGiaoDich;

    public NhanVienBanHang() {
    }

    public NhanVienBanHang(String maNhanVien, String tenNhanVien, String soDienThoai, String email, LocalDate namSinh, String gioiTinh, String chucVu, LocalDate ngayVaoLam, double heSoLuong, int ngayPhepConLai, double luong, String matKhau, boolean isdelete, double doanhThu, int soLuongGiaoDich) {
        super(maNhanVien, tenNhanVien, soDienThoai, email, namSinh, gioiTinh, chucVu, ngayVaoLam, heSoLuong, ngayPhepConLai, luong, matKhau, isdelete);
        this.doanhThu = doanhThu;
        this.soLuongGiaoDich = soLuongGiaoDich;
    }

    public double getDoanhThu() {
        return doanhThu;
    }

    public int getSoLuongGiaoDich() {
        return soLuongGiaoDich;
    }

    public void setDoanhThu(double doanhThu) {
        this.doanhThu = doanhThu;
    }

    public void setSoLuongGiaoDich(int soLuongGiaoDich) {
        this.soLuongGiaoDich = soLuongGiaoDich;
    }

    @Override
    public void input() {
        super.input();
        chucVu ="Nhan vien ban hang";
        doanhThu = 0.0;
        soLuongGiaoDich = 0;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-10.2f %-10d", doanhThu, soLuongGiaoDich);
    }

    @Override
    public double heSoPhuCap() {
        return soLuongGiaoDich*0.01;
    }

    @Override
    public double thuongDoanhThu() {
        if (doanhThu < 2000)
        {
            return doanhThu*0.03;
        }
        else if (doanhThu < 4000)
        {
            return doanhThu*0.05;
        }
        else {
            return doanhThu*0.07;
        }
    }

    @Override
    public double tinhLuong() {
        return luongCoBan*heSoLuong + luongCoBan*heSoPhuCap() + thuongDoanhThu();
    }

    @Override
    public void menunv() {
        boolean kt = true;
        int lc;
        while (kt) {
            System.out.println("===================================");
            System.out.println("|\t     MENU CHINH       \t|");
            System.out.println("===================================");
            System.out.printf("| %-31s|\n", "1. Quan ly san pham");
            System.out.printf("| %-31s|\n", "2. Quan ly khach hang va hoa don");
            System.out.printf("| %-31s|\n", "3. Thong ke doanh so");
            System.out.printf("| %-31s|\n", "4. Xem thong tin ban than");
            System.out.printf("| %-31s|\n", "5. Xin nghi phep");
            System.out.printf("| %-31s|\n", "6. Doi mat khau");
            System.out.printf("| %-31s|\n", "7. Dang xuat");
            System.out.println("===================================");
            System.out.print("Nhap lua chon: ");
            lc = Integer.parseInt(sc.nextLine());
            switch (lc) {
                case 1: {
                    menuBHSP();
                    break;
                }
                case 2: {
                    menuGD();
                    break;
                }
                case 3: {
                    //thongke
                    break;
                }
                case 4: {
                    output();
                    break;
                }
                case 5: {
                    NghiPhep nghiPhep = new NghiPhep();
                    nghiPhep.input();
                    qlnp.themDonNghiPhep(nghiPhep);
                    qlnp.ghiVaoFileDSNP();
                    break;
                }
                case 6: {
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
                case 7: {
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
