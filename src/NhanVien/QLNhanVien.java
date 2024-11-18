package NhanVien;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class QLNhanVien {
    NhanVien[] dsNhanVien = new NhanVien[0];
    int soLuong = 0;
    static Scanner sc = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private NhanVien nguoiDangNhap;

    public NhanVien dangNhap(String soDienThoai, String maKhau) {
        for (NhanVien nv : dsNhanVien) {
            if (nv.dangNhap(soDienThoai, maKhau)) {
                nguoiDangNhap = nv;
                return nv;
            }
        }
        return null;
    }

    public NhanVien nguoiDangNhap() {
        return nguoiDangNhap;
    }

    public void menuTheoNhanVien(NhanVien nhanVien) {
        nhanVien.menunv();
    }


    public void ghiVaoFileDSNV() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\ACER\\IdeaProjects\\oop_project\\src\\NhanVien\\danhSachNhanVien.txt"))) {
            for (NhanVien nv : dsNhanVien) {
                if (nv instanceof NhanVienBanHang nvbh) {
                    writer.write(String.join(",",
                            nvbh.getMaNhanVien(),
                            nvbh.getTenNhanVien(),
                            nvbh.getSoDienThoai(),
                            nvbh.getEmail(),
                            String.valueOf(nvbh.getSinhNhat().format(formatter)),
                            nvbh.getGioiTinh(),
                            nvbh.getChucVu(),
                            String.valueOf(nvbh.getNgayVaoLam().format(formatter)),
                            String.valueOf(nvbh.getHeSoLuong()),
                            String.valueOf(nvbh.getNgayPhepConLai()),
                            String.valueOf(nvbh.luong),
                            nvbh.matKhau,
                            String.valueOf(nvbh.isnotdelete),
                            String.valueOf(nvbh.getDoanhThu()),
                            String.valueOf(nvbh.getSoLuongGiaoDich())
                    ));
                    writer.newLine();
                }
                else if (nv instanceof NhanVienKyThuat nvkt) {
                    String kyNang = String.join(";", nvkt.getKyNangChuyenMon());
                    writer.write(String.join(",",
                            nvkt.getMaNhanVien(),
                            nvkt.getTenNhanVien(),
                            nvkt.getSoDienThoai(),
                            nvkt.getEmail(),
                            String.valueOf(nvkt.getSinhNhat().format(formatter)),
                            nvkt.getGioiTinh(),
                            nvkt.getChucVu(),
                            String.valueOf(nvkt.getNgayVaoLam().format(formatter)),
                            String.valueOf(nvkt.getHeSoLuong()),
                            String.valueOf(nvkt.getNgayPhepConLai()),
                            String.valueOf(nvkt.luong),
                            nvkt.matKhau,
                            String.valueOf(nvkt.isnotdelete),
                            kyNang,
                            String.valueOf(nvkt.getSoLuuTruBaoHanh())
                    ));
                    writer.newLine();
                }
                else {
                    NhanVienQuanLy nvql = (NhanVienQuanLy) nv;
                    writer.write(String.join(",",
                            nvql.getMaNhanVien(),
                            nvql.getTenNhanVien(),
                            nvql.getSoDienThoai(),
                            nvql.getEmail(),
                            String.valueOf(nvql.getSinhNhat().format(formatter)),
                            nvql.getGioiTinh(),
                            nvql.getChucVu(),
                            String.valueOf(nvql.getNgayVaoLam().format(formatter)),
                            String.valueOf(nvql.getHeSoLuong()),
                            String.valueOf(nvql.getNgayPhepConLai()),
                            String.valueOf(nvql.luong),
                            nvql.matKhau,
                            String.valueOf(nvql.isnotdelete),
                            String.valueOf(nvql.getChiSoHieuSuat())
                    ));
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    public void docTuFileDSNV() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ACER\\IdeaProjects\\oop_project\\src\\NhanVien\\danhSachNhanVien.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length > 0) {
                    String maNhanVien = data[0];
                    String tenNhanVien = data[1];
                    String soDienThoai = data[2];
                    String email = data[3];
                    LocalDate sinhNhat = LocalDate.parse(data[4], formatter);
                    String gioiTinh = data[5];
                    String chucVu = data[6];
                    LocalDate ngayVaoLam = LocalDate.parse(data[7], formatter);
                    double heSoLuong = Double.parseDouble(data[8]);
                    int ngayPhepConLai = Integer.parseInt(data[9]);
                    double luong = Double.parseDouble(data[10]);
                    String matKhau = data[11];
                    boolean isdelete = Boolean.parseBoolean(data[12]);

                    switch (chucVu) {
                        case "Nhan vien ban hang" -> {
                            double doanhThu = Double.parseDouble(data[13]);
                            int soLuongGiaoDich = Integer.parseInt(data[14]);
                            NhanVien nvbh = new NhanVienBanHang(maNhanVien, tenNhanVien, soDienThoai, email, sinhNhat, gioiTinh, chucVu, ngayVaoLam, heSoLuong, ngayPhepConLai, luong, matKhau, isdelete, doanhThu, soLuongGiaoDich);
                            themNV(nvbh);
                        }
                        case "Nhan vien ky thuat" -> {
                            String[] kyNangChuyenMon = data[13].split(";");
                            int soLuuTruBaoHanh = Integer.parseInt(data[14]);
                            NhanVien nvkt = new NhanVienKyThuat(maNhanVien, tenNhanVien, soDienThoai, email, sinhNhat, gioiTinh, chucVu, ngayVaoLam, heSoLuong, ngayPhepConLai, luong, matKhau, isdelete, kyNangChuyenMon, soLuuTruBaoHanh);
                            themNV(nvkt);
                        }
                        case "Nhan vien quan ly" -> {
                            double chiSoHieuSuat = Double.parseDouble(data[13]);
                            NhanVienQuanLy nvql = new NhanVienQuanLy(maNhanVien, tenNhanVien, soDienThoai, email, sinhNhat, gioiTinh, chucVu, ngayVaoLam, heSoLuong, ngayPhepConLai, luong, matKhau, isdelete, chiSoHieuSuat);
                            themNV(nvql);
                        }
                        default -> System.out.println("Dữ liệu không hợp lệ cho nhân viên: " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi định dạng số trong dữ liệu: " + e.getMessage());
        }
    }


    public void themNV(NhanVien nhanVien) {
        NhanVien[] newNhanVien = Arrays.copyOf(dsNhanVien, soLuong + 1);
        newNhanVien[soLuong] = nhanVien;
        dsNhanVien = newNhanVien;
        soLuong++;
    }

    public void xuatDanhSachNV() {
        for (NhanVien ds : dsNhanVien) {
            if (ds.isnotdelete) {
                ds.output();
            }
        }
    }

    public void suaThongTinNV(String manv) {
        boolean timThay = false;
        for (NhanVien nv : dsNhanVien) {
            if (nv.maNhanVien.equals(manv) && nv.isnotdelete) {
                int lc;
                boolean ktra = true;
                timThay = true;
                while (ktra) {
                    nv.output();
                    System.out.println("1. Sua ten nhan vien");
                    System.out.println("2. Sua so dien thoai");
                    System.out.println("3. Sua email");
                    System.out.println("4. Sua ngay thang nam sinh");
                    System.out.println("5. Sua he so luong");
                    System.out.println("6. Thoat");
                    System.out.println("Nhap lua chon muon sua: ");
                    lc = Integer.parseInt(sc.nextLine());
                    switch (lc) {
                        case 1: {
                            System.out.println("Nhap ten moi: ");
                            nv.setTenNhanVien(sc.nextLine());
                            System.out.println("Da sua ten.");
                            break;
                        }
                        case 2: {
                            System.out.println("Nhap so dien thoai moi: ");
                            nv.setSoDienThoai(sc.nextLine());
                            System.out.println("Da sua so dien thoai.");
                            break;
                        }
                        case 3: {
                            System.out.println("Nhap email moi: ");
                            nv.setEmail(sc.nextLine());
                            System.out.println("Da sua email.");
                            break;
                        }
                        case 4: {
                            System.out.println("Nhap ngay sinh moi: ");
                            String ngaySinh = sc.nextLine();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate sinhNhat = LocalDate.parse(ngaySinh, formatter);
                            nv.setSinhNhat(sinhNhat);
                            System.out.println("Da sua nam sinh.");
                            break;
                        }
                        case 5: {
                            System.out.println("Nhap he so luong moi: ");
                            nv.setHeSoLuong(Double.parseDouble(sc.nextLine()));
                            System.out.println("Da sua he so luong.");
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
        }
        if (!timThay) {
            System.out.println("Khong tim thay ma nhan vien voi ma " + manv);
        }
    }

    public void xoa1NV(String manv) {
        boolean ktra = false;
        for (NhanVien nv : dsNhanVien) {
            if (nv.maNhanVien.equals(manv)) {
                nv.isnotdelete = false;
                System.out.println("Da xoa nhan vien");
                ktra = true;
            }
        }
        if (!ktra) {
            System.out.println("Khong tim thay nhan vien co ma: " + manv);
        }
    }

    public NhanVien timKiemNhanVien(String name) {
        for (NhanVien nv : dsNhanVien) {
            if (nv.getTenNhanVien().toLowerCase().contains(name.toLowerCase())) {
                return nv;
            }
        }
        return null;
    }

    public NhanVien timKiemNhanVienTheoMa(String ma) {
        for (NhanVien nv : dsNhanVien) {
            if (nv.getMaNhanVien().toLowerCase().contains(ma.toLowerCase())) {
                return nv;
            }
        }
        return null;
    }


    public void sapXepDSNV() {
        for (int i = 0; i < dsNhanVien.length - 1; i++) {
            for (int j = i + 1; j < dsNhanVien.length; j++) {
                if (dsNhanVien[j].getTenNhanVien().compareTo(dsNhanVien[i].getTenNhanVien()) < 0) {
                    NhanVien temp = dsNhanVien[i];
                    dsNhanVien[i] = dsNhanVien[j];
                    dsNhanVien[j] = temp;
                }
            }
        }
    }


    public void thongKeNVBH() {
        System.out.println("|                                NHAN VIEN BAN HANG                               |");
        System.out.println("====================================================================================");
        System.out.printf("%-10s %-20s %-20s %-15s %-15s\n", "Ma NV", "Ten NV", "So luong giao dich", "Doanh thu", "Luong");
        System.out.println("------------------------------------------------------------------------------------");

        for (NhanVien nv : dsNhanVien) {
            if (nv instanceof NhanVienBanHang nvbh) {
                System.out.printf("%-10s %-20s %-20d %-15.2f %-15.2f\n",
                        nvbh.getMaNhanVien(),
                        nvbh.getTenNhanVien(),
                        nvbh.getSoLuongGiaoDich(),
                        nvbh.getDoanhThu(),
                        nvbh.tinhLuong()
                );
            }
        }

        System.out.println("====================================================================================");
    }

    public void thongKeNVKT(){
        System.out.println("|                         NHAN VIEN KY THUAT                              |");
        System.out.println("===========================================================================");
        System.out.printf("%-10s %-20s %-20s %-15s\n","Ma NV","Ten NV", "So luong bao hanh" ,"Luong" );
        System.out.println("---------------------------------------------------------------------------");
        for(NhanVien nv : dsNhanVien){
            if(nv instanceof NhanVienKyThuat nvkt){
                System.out.printf("%-10s %-20s %-20d %-15.2f\n",
                        nvkt.getMaNhanVien(),
                        nvkt.getTenNhanVien(),
                        nvkt.getSoLuuTruBaoHanh(),
                        nvkt.tinhLuong()
                );
            }
        }
        System.out.println("===========================================================================");

    }

    public void thongKeNVQL(){
        System.out.println("|                         NHAN VIEN QUAN LY                               |");
        System.out.println("===========================================================================");
        System.out.printf("%-10s %-20s %-20s %-15s\n","Ma NV","Ten NV", "Chi so hieu suat" ,"Luong" );
        System.out.println("---------------------------------------------------------------------------");
        for(NhanVien nv : dsNhanVien){
            if (nv instanceof NhanVienQuanLy nvql) {
                System.out.printf("%-10s %-20s %-20.2f %-15.2f\n",
                        nvql.getMaNhanVien(),
                        nvql.getTenNhanVien(),
                        nvql.getChiSoHieuSuat(),
                        nvql.tinhLuong()
                );
            }
        }
        System.out.println("===========================================================================");
    }


}



