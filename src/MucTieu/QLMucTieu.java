package MucTieu;

import java.io.*;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import DonDatHang.DonDatHang;

public class QLMucTieu {
    MucTieuDoanhThu[] dsMuctieu = new MucTieuDoanhThu[0];
    int soLuong = 0;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");

    
  

    public void themMucTieu(MucTieuDoanhThu mucTieuDoanhThu){
        MucTieuDoanhThu[] newds = Arrays.copyOf(dsMuctieu, soLuong + 1);
        newds[soLuong] = mucTieuDoanhThu;
        dsMuctieu = newds;
    }

    public MucTieuDoanhThu[] getDsMucTieu() {
        return dsMuctieu;
    }

    public MucTieuDoanhThu timMucTieu(YearMonth thangNam) {
        for (MucTieuDoanhThu mucTieu : dsMuctieu) {
            if (mucTieu.getThangNam().equals(thangNam)) {
                return mucTieu;
            }
        }
        return null;
    }

    public void ghiVaoFileDSMT() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/MucTieu/DanhSachMucTieuDoanhThu.txt"))){
            for (MucTieuDoanhThu ds : dsMuctieu){
                writer.write(String.join(",",
                        ds.getThangNam().format(formatter),
                        String.valueOf(ds.getDoanhThu())
                ));
                writer.newLine();
            }

        }catch (IOException e){
            System.out.println("Loi ghi vao file: " + e.getMessage());
        }
    }

    public void docTuFileDSMT() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/MucTieu/DanhSachMucTieuDoanhThu.txt"))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] data = line.split(",");
                if (data.length > 0) {
                    MucTieuDoanhThu mt = new MucTieuDoanhThu(YearMonth.parse(data[0], formatter), Double.parseDouble(data[1]));
                    themMucTieu(mt);
                }
            }
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

}
