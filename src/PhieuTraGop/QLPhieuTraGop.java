package PhieuTraGop;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class QLPhieuTraGop {
    PhieuTraGop[] dsPhieuTraGop = new PhieuTraGop[0];
    int soLuongPhieu = 0;
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void themPhieuTraGop(PhieuTraGop phieuTraGop) {
        PhieuTraGop[] newdsPhieuTraGop = Arrays.copyOf(dsPhieuTraGop, soLuongPhieu + 1);
        newdsPhieuTraGop[soLuongPhieu] = phieuTraGop;
        dsPhieuTraGop = newdsPhieuTraGop;
        soLuongPhieu++;
    }

    public void xuatDsPhieuTraGop() {
        for (PhieuTraGop ph : dsPhieuTraGop) {
            ph.output();
        }
    }

    public void thanhToanKyTraGop(String maPhieu) {
        boolean timThay = false;
        for (PhieuTraGop ph : dsPhieuTraGop) {
            if (ph.getMaPhieuTraGop().equals(maPhieu)) {
                timThay = true;
                ph.thanhToanKy();
            }
        }
        if (!timThay) {
            System.out.println("Khong tim thay phieu tra gop.");
        }
    }

    public void ghiVaoFileDSPTG() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/PhieuTraGop/danhSachPhieuTraGop.txt"))) {
            for (PhieuTraGop ph : dsPhieuTraGop) {
                writer.write(String.join(",",
                        ph.getMaPhieuTraGop(),
                        ph.getHoaDon().getMaHoaDon(),
                        String.valueOf(ph.getSoTienTraTruoc()),
                        String.valueOf(ph.getSoTienConLai()),
                        String.valueOf(ph.getSoKyTraGop()),
                        String.valueOf(ph.getSoTienMoiKy()),
                        ph.getNgayBatDau().format(formatter),
                        ph.getNgayKetThuc().format(formatter),
                        String.valueOf(ph.getSoKyDaTra())
                ));
                writer.newLine();
                for (KyTraGop ky : ph.getLichSuTraGop()) {
                    writer.write(String.join(",",
                            String.valueOf(ky.getKyThu()),
                            ky.getNgayTra().format(formatter),
                            String.valueOf(ky.getSoTien())
                    ));
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    public void docTuFileDSPTG() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/PhieuTraGop/danhSachPhieuTraGop.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                String maPhieuTraGop = data[0];
                String maHoaDon = data[1];
                double soTienTraTruoc = Double.parseDouble(data[2]);
                double soTienConLai = Double.parseDouble(data[3]);
                int soKyTraGop = Integer.parseInt(data[4]);
                double soTienMoiKy = Double.parseDouble(data[5]);
                LocalDate ngayBatDau = LocalDate.parse(data[6], formatter);
                LocalDate ngayKetThuc = LocalDate.parse(data[7], formatter);
                int soKyDaTra = Integer.parseInt(data[8]);
                PhieuTraGop ph = new PhieuTraGop(maPhieuTraGop, maHoaDon, soTienTraTruoc, soTienConLai, soKyTraGop, soTienMoiKy, ngayBatDau, ngayKetThuc, new KyTraGop[0], soKyDaTra);

                for (int i = 0; i < soKyDaTra; i++) {
                    if ((line = reader.readLine()) != null) {
                        String[] kyData = line.split(",");

                        int kyThu = Integer.parseInt(kyData[0]);
                        LocalDate ngayTra = LocalDate.parse(kyData[1], formatter);
                        double soTien = Double.parseDouble(kyData[2]);

                        KyTraGop kyTraGop = new KyTraGop(kyThu, ngayTra, soTien);
                        ph.themKyTraGop(kyTraGop);
                    }
                }
                themPhieuTraGop(ph);
            }
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Loi xu ly du lieu: " + e.getMessage());
        }
    }

}
