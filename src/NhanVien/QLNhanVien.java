package NhanVien;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class QLNhanVien {
    NhanVien[] dsNhanVien = new NhanVien[0];
    int soLuong = 0;
    static Scanner sc = new Scanner(System.in);
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
                            String.valueOf(nvbh.getNamSinh()),
                            nvbh.getGioiTinh(),
                            nvbh.getChucVu(),
                            String.valueOf(nvbh.getNamVaoLam()),
                            String.valueOf(nvbh.getHeSoLuong()),
                            String.valueOf(nvbh.getNgayPhepConLai()),
                            String.valueOf(nvbh.luong),
                            nvbh.matKhau,
                            String.valueOf(nvbh.isdelete),
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
                            String.valueOf(nvkt.getNamSinh()),
                            nvkt.getGioiTinh(),
                            nvkt.getChucVu(),
                            String.valueOf(nvkt.getNamVaoLam()),
                            String.valueOf(nvkt.getHeSoLuong()),
                            String.valueOf(nvkt.getNgayPhepConLai()),
                            String.valueOf(nvkt.luong),
                            nvkt.matKhau,
                            String.valueOf(nvkt.isdelete),
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
                            String.valueOf(nvql.getNamSinh()),
                            nvql.getGioiTinh(),
                            nvql.getChucVu(),
                            String.valueOf(nvql.getNamVaoLam()),
                            String.valueOf(nvql.getHeSoLuong()),
                            String.valueOf(nvql.getNgayPhepConLai()),
                            String.valueOf(nvql.luong),
                            nvql.matKhau,
                            String.valueOf(nvql.isdelete),
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
                    int namSinh = Integer.parseInt(data[4]);
                    String gioiTinh = data[5];
                    String chucVu = data[6];
                    int namVaoLam = Integer.parseInt(data[7]);
                    double heSoLuong = Double.parseDouble(data[8]);
                    int ngayPhepConLai = Integer.parseInt(data[9]);
                    double luong = Double.parseDouble(data[10]);
                    String matKhau = data[11];
                    boolean isdelete = Boolean.parseBoolean(data[12]);

                    switch (chucVu) {
                        case "Nhan vien ban hang" -> {
                            double doanhThu = Double.parseDouble(data[13]);
                            int soLuongGiaoDich = Integer.parseInt(data[14]);
                            NhanVien nvbh = new NhanVienBanHang(maNhanVien, tenNhanVien, soDienThoai, email, namSinh, gioiTinh, chucVu, namVaoLam, heSoLuong, ngayPhepConLai, luong, matKhau, isdelete, doanhThu, soLuongGiaoDich);
                            themNV(nvbh);
                        }
                        case "Nhan vien ky thuat" -> {
                            String[] kyNangChuyenMon = data[13].split(";");
                            int soLuuTruBaoHanh = Integer.parseInt(data[14]);
                            NhanVien nvkt = new NhanVienKyThuat(maNhanVien, tenNhanVien, soDienThoai, email, namSinh, gioiTinh, chucVu, namVaoLam, heSoLuong, ngayPhepConLai, luong, matKhau, isdelete, kyNangChuyenMon, soLuuTruBaoHanh);
                            themNV(nvkt);
                        }
                        case "Nhan vien quan ly" -> {
                            double chiSoHieuSuat = Double.parseDouble(data[13]);
                            NhanVienQuanLy nvql = new NhanVienQuanLy(maNhanVien, tenNhanVien, soDienThoai, email, namSinh, gioiTinh, chucVu, namVaoLam, heSoLuong, ngayPhepConLai, luong, matKhau, isdelete, chiSoHieuSuat);
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
            if (ds.isdelete) {
                ds.output();
            }
        }
    }

    public NhanVien suaThongTinNV(String manv) {
        for (NhanVien nv : dsNhanVien) {
            if (nv.maNhanVien.equals(manv)) {
                int lc;
                boolean ktra = true;
                while (ktra) {
                    System.out.println("1. Sua ten nhan vien");
                    System.out.println("2. Sua so dien thoai");
                    System.out.println("3. Sua email");
                    System.out.println("4. Sua nam sinh");
                    System.out.println("5. Sua chuc vu");
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
                            System.out.println("Nhap nam sinh moi: ");
                            nv.setNamSinh(Integer.parseInt(sc.nextLine()));
                            System.out.println("Da sua nam sinh.");
                            break;
                        }
                        case 5: {
                            System.out.println("Nhap chuc vu moi: ");
                            nv.setChucVu(sc.nextLine());
                            System.out.println("Da sua chuc vu.");
                            break;
                        }
                        case 6: {
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
                return nv;
            }
        }
        return null;
    }

    public void xoa1NV(String manv) {
        boolean ktra = false;
        for (NhanVien nv : dsNhanVien) {
            if (nv.maNhanVien.equals(manv)) {
                nv.isdelete = false;
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


}
