package NhanVien;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static main_project.oop_project.qlnv;

public class NghiPhep {
    private NhanVien nhanVien;
    private int soNgayNghi;
    private LocalDate ngayBatDau;
    private String lyDo;
    private String trangThaiDon;
    static String[] loaiTrangThai = {"Cho phe duyet", "Da phe duyet", "Bi tu choi"};
    static Scanner sc = new Scanner(System.in);
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public NghiPhep() {
    }

    public NghiPhep(String manhanvien, String tenNhanVien, int soNgayNghi, LocalDate ngayBatDau, String lyDo, String trangThaiDon) {
        this.nhanVien = qlnv.timKiemNhanVienTheoMa(manhanvien);
        this.soNgayNghi = soNgayNghi;
        this.ngayBatDau = ngayBatDau;
        this.lyDo = lyDo;
        this.trangThaiDon = trangThaiDon;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public int getSoNgayNghi() {
        return soNgayNghi;
    }

    public void setSoNgayNghi(int soNgayNghi) {
        while (soNgayNghi > getNhanVien().getNgayPhepConLai()) {
            int ngayNghiDu = soNgayNghi - getNhanVien().getNgayPhepConLai();
            System.out.println("Ban khong con ngay nghi phep nam.");
            System.out.println("Neu nghi phep ban se khong nhan duoc luong ngay.");
            System.out.println("So ngay khong nhan luong la " + ngayNghiDu + " ngay.");
            System.out.println("(Y/N): ");
            String lc = sc.nextLine();
            if (lc.equalsIgnoreCase("y")) {
                this.soNgayNghi = soNgayNghi;
                break;
            }
            else if (lc.equalsIgnoreCase("n")){
                System.out.println("Nhap so ngay muon nghi phep: ");
                this.soNgayNghi = Integer.parseInt(sc.nextLine());
            }
            else {
                System.out.println("Lua chon khong hop le.");
            }
        }
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public String getTrangThaiDon() {
        return trangThaiDon;
    }

    public void setTrangThaiDon(String trangThaiDon) {
        this.trangThaiDon = trangThaiDon;
    }

    public void input() {
        setNhanVien(qlnv.nguoiDangNhap());

        System.out.println("Nhap so ngay muon nghi phep: ");
        int ngayNghi = Integer.parseInt(sc.nextLine());
        setSoNgayNghi(ngayNghi);

        System.out.println("Nhập ngày bắt đầu nghỉ phép (dd/MM/yyyy): ");
        String ngayBatDauString = sc.nextLine();
        LocalDate ngayBatDau = LocalDate.parse(ngayBatDauString, formatter);
        setNgayBatDau(ngayBatDau);

        System.out.println("Nhap ly do muon nghi phep: ");
        setLyDo(sc.nextLine());

        setTrangThaiDon(loaiTrangThai[0]);
    }

    @Override
    public String toString() {
        return String.format("%-10s %-18s %-10d %-15s %-25s %-15s", nhanVien.maNhanVien, nhanVien.tenNhanVien, soNgayNghi, ngayBatDau.format(formatter), lyDo, trangThaiDon);
    }

    public void output() {
        System.out.println(toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NghiPhep nghiPhep = (NghiPhep) obj;
        return nhanVien.maNhanVien.equals(nghiPhep.nhanVien.maNhanVien) && ngayBatDau.equals(nghiPhep.ngayBatDau);
    }

    @Override
    public int hashCode() {
        return (nhanVien.maNhanVien + ngayBatDau.toString()).hashCode();
    }

    public void xuatDonNghiPhep() {
        System.out.println("DON XIN NGHI PHEP");
        System.out.println("Kinh gui: Ban quan ly");
        System.out.println("Toi ten la: " + getNhanVien().getTenNhanVien());
        System.out.println("Chuc vu: " + getNhanVien().getChucVu());
        System.out.println("Toi gui don nay xin phep nghi " + getSoNgayNghi() + " ngay, nghi tu ngay: " + getNgayBatDau().format(formatter));
        System.out.println("Ly do: " + getLyDo());
        System.out.println("Toi cam ket hoan thanh cong viec truoc khi nghi phep va ban giao cong viec cho nguoi thay the.");
        System.out.println("Mong nhan duoc su chap thuan cua quan ly. Xin chan thanh cam on.");
        System.out.println("Xac nhan cua nhan vien: ");
        System.out.println(getNhanVien().getTenNhanVien());
        LocalDate today = LocalDate.now();
        System.out.println(today.format(formatter));
    }




}
