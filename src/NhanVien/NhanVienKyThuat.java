package NhanVien;

import java.util.Arrays;

import static ChucNang.ChucNangMenu.*;
import static main_project.oop_project.qlnp;

public class NhanVienKyThuat extends NhanVien{
    private String[] kyNangChuyenMon = new String[0];
    private int soLuuTruBaoHanh;

    public NhanVienKyThuat() {
    }

    public NhanVienKyThuat(String maNhanVien, String tenNhanVien, String soDienThoai, String email, int namSinh, String gioiTinh, String chucVu, int namVaoLam, double heSoLuong, int ngayPhepConLai, double luong, String matKhau, boolean isdelete, String[] kyNangChuyenMon, int soLuuTruBaoHanh) {
        super(maNhanVien, tenNhanVien, soDienThoai, email, namSinh, gioiTinh, chucVu, namVaoLam, heSoLuong, ngayPhepConLai, luong, matKhau, isdelete);
        this.kyNangChuyenMon = kyNangChuyenMon;
        this.soLuuTruBaoHanh = soLuuTruBaoHanh;
    }

    public String[] getKyNangChuyenMon() {
        return kyNangChuyenMon;
    }

    public int getSoLuuTruBaoHanh() {
        return soLuuTruBaoHanh;
    }

    public void setKyNangChuyenMon(String[] kyNangChuyenMon) {
        this.kyNangChuyenMon = kyNangChuyenMon;
    }

    public void setSoLuuTruBaoHanh(int soLuuTruBaoHanh) {
        this.soLuuTruBaoHanh = soLuuTruBaoHanh;
    }

    @Override
    public void input() {
        super.input();
        chucVu = "Nhan vien ky thuat";

        int sl;
        do {
            System.out.println("Nhap so ky nang chuyen mon (1 - 10): ");
            sl = Integer.parseInt(sc.nextLine());
            if (sl < 1 || sl > 10) {
                System.out.println("So ky nang chuyen mon phai tu 1 den 10. Vui long nhap lai.");
            }
        } while (sl < 1 || sl > 10);

        kyNangChuyenMon = new String[sl];

        for (int i = 0; i < sl; i++) {
            System.out.println("Nhap ky nang thu " + (i + 1) + ": ");
            kyNangChuyenMon[i] = sc.nextLine();
        }

        soLuuTruBaoHanh = 0;
    }


    @Override
    public String toString() {
        return super.toString() + String.format("%-30s %-5d", Arrays.toString(kyNangChuyenMon), soLuuTruBaoHanh);
    }

    @Override
    public double heSoPhuCap() {
        return kyNangChuyenMon.length*0.02 + soLuuTruBaoHanh*0.01;
    }

    @Override
    public double tinhLuong() {
        return luongCoBan*heSoLuong + luongCoBan*heSoPhuCap();
    }

    @Override
    public void menunv() {
        boolean kt = true;
        int lc;
        while (kt) {
            System.out.println("=============================");
            System.out.println("|\t     MENU CHINH       \t|");
            System.out.println("=============================");
            System.out.printf("| %-30s |\n", "1. Quan ly san pham");
            System.out.printf("| %-30s |\n", "2. Quan ly don dat hang");
            System.out.printf("| %-30s |\n", "3. Bao hanh va sua chua");
            System.out.printf("| %-30s |\n", "4. Thong ke san pham");
            System.out.printf("| %-30s |\n", "5. Xem thong tin ban than");
            System.out.printf("| %-30s |\n", "6. Xin nghi phep");
            System.out.printf("| %-30s |\n", "7. Doi mat khau");
            System.out.printf("| %-30s |\n", "8. Dang xuat");
            System.out.println("=============================");
            System.out.print("Nhap lua chon: ");
            lc = Integer.parseInt(sc.nextLine());
            switch (lc) {
                case 1: {
                    menuSP();
                    break;
                }
                case 2: {
                    menuDDH();
                    break;
                }
                case 3: {
                    menuBH();
                    break;
                }
                case 4: {
                    //thongkesp
                    break;
                }
                case 5: {
                    output();
                    break;
                }
                case 6: {
                    NghiPhep nghiPhep = new NghiPhep();
                    nghiPhep.input();
                    qlnp.themDonNghiPhep(nghiPhep);
                    break;
                }
                case 7: {
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
                case 8: {
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
