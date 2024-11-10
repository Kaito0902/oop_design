package NhanVien;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static NhanVien.NghiPhep.loaiTrangThai;
import static NhanVien.NghiPhep.sc;

public class QLNghiPhep {
    NghiPhep[] dsNghiPhep = new NghiPhep[0];
    int soLuong = 0;

    public void themDonNghiPhep(NghiPhep nghiPhep) {
        for (int i = 0; i < soLuong; i++) {
            if (dsNghiPhep[i].equals(nghiPhep)) {
                System.out.println("Yeu cau nghi phep da ton tai.");
                return;
            }
        }
        NghiPhep[] newdsNghiPhep = Arrays.copyOf(dsNghiPhep, soLuong + 1);
        newdsNghiPhep[soLuong] = nghiPhep;
        dsNghiPhep = newdsNghiPhep;
        soLuong++;
    }

    public void xuatDanhSach() {
        for(NghiPhep ds : dsNghiPhep) {
            ds.output();
        }
    }

    public void pheDuyetDon(NhanVien nguoiPheDuyet) {

        for (NghiPhep ds : dsNghiPhep) {
            if (ds.getTrangThaiDon().equals(loaiTrangThai[0])) {

                boolean ktra = true;
                while (ktra){
                    ds.xuatDonNghiPhep();
                    if (ds.getNhanVien().getMaNhanVien().equals(nguoiPheDuyet.getMaNhanVien())) {
                        System.out.println("Chu y: KHONG THE TU DUYET DON CUA BAN THAN.");
                        ktra = false;
                        break;
                    }
                    System.out.println("1.Phe duyet don xin nghi");
                    System.out.println("2.Tu choi phe duyet don");
                    System.out.println("3.Bo qua, xem don ke tiep");
                    System.out.println("Nhap lua chon: ");
                    int lc = Integer.parseInt(sc.nextLine());
                    switch (lc) {
                        case 1: {
                            ds.setTrangThaiDon(loaiTrangThai[lc]);
                            ds.getNhanVien().nghiPhep(ds.getSoNgayNghi());
                            System.out.println("Da duyet don");
                            ktra = false;
                            break;
                        }
                        case 2: {
                            ds.setTrangThaiDon(loaiTrangThai[lc]);
                            System.out.println("Da tu choi duyet don");
                            ktra = false;
                            break;
                        }
                        case 3: {
                            ktra = false;
                            break;
                        }
                        default: {
                            System.out.println("Lua chon khong hop le.");
                        }
                    }
                }
            }
        }

    }

    public void ghiVaoFileDSNP() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\ACER\\IdeaProjects\\oop_project\\src\\NhanVien\\danhSachDonNghiPhep"))){
            for (NghiPhep ds : dsNghiPhep) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                writer.write(String.join(",",
                        ds.getNhanVien().maNhanVien,
                        ds.getNhanVien().tenNhanVien,
                        String.valueOf(ds.getSoNgayNghi()),
                        String.valueOf(ds.getNgayBatDau().format(formatter)),
                        ds.getLyDo(),
                        ds.getTrangThaiDon()));
                writer.newLine();
            }
        }  catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    public void docTuFileDSNP() {
        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ACER\\IdeaProjects\\oop_project\\src\\NhanVien\\danhSachDonNghiPhep"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length > 0) {
                    String maNhanVien = data[0];
                    String tenNhanVien = data[1];
                    int soNgayNghi = Integer.parseInt(data[2]);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate ngayBatDau = LocalDate.parse(data[3], formatter);
                    String lyDo = data[4];
                    String trangThai = data[5];
                    NghiPhep nghiPhep = new NghiPhep(maNhanVien, tenNhanVien, soNgayNghi, ngayBatDau, lyDo, trangThai);
                    themDonNghiPhep(nghiPhep);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi định dạng số trong dữ liệu: " + e.getMessage());
        }
    }

}
