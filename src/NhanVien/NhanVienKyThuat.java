package NhanVien;

import java.util.Arrays;

import static ChucNang.ChucNangMenu.*;

public class NhanVienKyThuat extends NhanVien{
    private String[] kyNangChuyenMon;
    private int soLuuTruBaoHanh;

    public NhanVienKyThuat() {
    }

    public NhanVienKyThuat(String maNhanVien, String tenNhanVien, String soDienThoai, String email, int namSinh, String gioiTinh, String chucVu, int namVaoLam, double heSoLuong, int ngayPhepConLai, double luong, String matKhau, String[] kyNangChuyenMon, int soLuuTruBaoHanh) {
        super(maNhanVien, tenNhanVien, soDienThoai, email, namSinh, gioiTinh, chucVu, namVaoLam, heSoLuong, ngayPhepConLai, luong, matKhau);
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
        kyNangChuyenMon = new String[10];
        System.out.println("Nhap so ky nang chuyen mon: ");
        int sl = Integer.parseInt(sc.nextLine());
        while (sl > 10) {
            System.out.println("So ky nang chuyen mon khong the vuot qua 10. Vui long nhap lai.");
            sl = Integer.parseInt(sc.nextLine());
        }
        for (int i = 0; i < sl; i++)
        {
            System.out.println("Nhap ky nang thu " + (i + 1) + ": ");
            kyNangChuyenMon[i] = sc.nextLine();
        }
        soLuuTruBaoHanh = 0;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-30s %-10d", Arrays.toString(kyNangChuyenMon), soLuuTruBaoHanh);
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
                    System.out.println("Nhap so ngay muon nghi phep: ");
                    int ngayNghi = Integer.parseInt(sc.nextLine());
                    nghiPhep(ngayNghi);
                    System.out.println("Nhap ngay bat dau nghi: ");
                    int ngayBD = Integer.parseInt(sc.nextLine());
                    System.out.println("Nhap thang: ");
                    int thangBD = Integer.parseInt(sc.nextLine());
                    System.out.println("Nhap ly do muon nghi phep: ");
                    String lyDo = sc.nextLine();
                    // dua vao danh sach nghi
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
