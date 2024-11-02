package NhanVien;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class QLNhanVien {
    NhanVien[] dsnv = new NhanVien[0];
    static Scanner sc = new Scanner(System.in);

    public NhanVien dangNhap(String soDienThoai, String maKhau) {
        for (NhanVien nv : dsnv) {
            if (nv.dangNhap(soDienThoai, maKhau)) {
                return nv;
            }
        }
        return null;
    }

    public void menuTheoNhanVien(NhanVien nhanVien) {
        nhanVien.menunv();
    }


    public void ghiVaoFileDSNV() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\ACER\\IdeaProjects\\oop_project\\src\\NhanVien\\danhSachNhanVien.txt"))) {
            for (NhanVien nv : dsnv) {
                if (nv instanceof NhanVienBanHang nvbh) {
                    writer.write(String.join(",",
                            nvbh.getMaNhanVien(),
                            nvbh.getTenNhanVien(),
                            nvbh.getSoDienThoai(),
                            nvbh.getEmail(),
                            String.valueOf(nvbh.getNamSinh()),
                            nvbh.getChucVu(),
                            nvbh.matKhau,
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
                            nvkt.getChucVu(),
                            nvkt.matKhau,
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
                            nvql.getChucVu(),
                            nvql.matKhau,
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

                    if (chucVu.equals("Nhan vien ban hang")) {
                        double doanhThu = Double.parseDouble(data[12]);
                        int soLuongGiaoDich = Integer.parseInt(data[13]);
                        NhanVien nvbh = new NhanVienBanHang(maNhanVien, tenNhanVien, soDienThoai, email, namSinh, gioiTinh, chucVu, namVaoLam, heSoLuong, ngayPhepConLai, luong, matKhau, doanhThu, soLuongGiaoDich);
                        themNV(nvbh);
                    } else if (chucVu.equals("Nhan vien ky thuat")) {
                        String[] kyNangChuyenMon = data[12].split(";");
                        int soLuuTruBaoHanh = Integer.parseInt(data[13]);
                        NhanVien nvkt = new NhanVienKyThuat(maNhanVien, tenNhanVien, soDienThoai, email, namSinh, gioiTinh, chucVu, namVaoLam, heSoLuong, ngayPhepConLai, luong, matKhau, kyNangChuyenMon, soLuuTruBaoHanh);
                        themNV(nvkt);
                    } else if (chucVu.equals("Nhan vien quan ly")) {
                        double chiSoHieuSuat = Double.parseDouble(data[12]);
                        NhanVienQuanLy nvql = new NhanVienQuanLy(maNhanVien, tenNhanVien, soDienThoai, email, namSinh, gioiTinh, chucVu, namVaoLam, heSoLuong, ngayPhepConLai, luong, matKhau, chiSoHieuSuat);
                        themNV(nvql);
                    } else {
                        System.out.println("Dữ liệu không hợp lệ cho nhân viên: " + line);
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
        NhanVien[] newNhanVien = Arrays.copyOf(this.dsnv, this.dsnv.length + 1);
        newNhanVien[this.dsnv.length] = nhanVien;
        this.dsnv = newNhanVien;
    }

    public void xuatDanhSachNV() {
        for (NhanVien ds : dsnv) {
            ds.output();
        }
    }

    public NhanVien suaThongTinNV(String manv) {
        for (NhanVien nv : dsnv) {
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
        for (NhanVien nv : dsnv) {
            if (nv.maNhanVien.equals(manv)) {
                ktra = true;
                break;
            }
        }

        if (ktra) {
            NhanVien[] newdsnv = Arrays.copyOf(this.dsnv, this.dsnv.length - 1);
            int index = 0;
            for (int i = 0; i < dsnv.length; i++) {
                if (!dsnv[i].maNhanVien.equals(manv)) {
                    newdsnv[index++] = dsnv[i];
                }
            }
            dsnv = newdsnv;
            System.out.println("Da xoa nhan vien co ma: " + manv);
        } else {
            System.out.println("Khong tim thay nhan vien co ma: " + manv);
        }
    }

    public NhanVien timKiemNhanVien(String name) {
        for (NhanVien nv : dsnv) {
            if (nv.getTenNhanVien().toLowerCase().contains(name.toLowerCase())) {
                return nv;
            }
        }
        return null;
    }


    public void sapXepDSNV() {
        for (int i = 0; i < dsnv.length - 1; i++) {
            for (int j = i + 1; j < dsnv.length; j++) {
                if (dsnv[j].getTenNhanVien().compareTo(dsnv[i].getTenNhanVien()) < 0) {
                    NhanVien temp = dsnv[i];
                    dsnv[i] = dsnv[j];
                    dsnv[j] = temp;
                }
            }
        }
    }


}
