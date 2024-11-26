package DonDatHang;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;


public class QLDonDatHang {
    DonDatHang[] dsddh = new DonDatHang[0];
    int soLuongDonDatHang;
    static Scanner sc = new Scanner(System.in);

    public void themDDH(DonDatHang ddh) {
        DonDatHang[] newdsddh = Arrays.copyOf(dsddh, soLuongDonDatHang + 1);
        newdsddh[soLuongDonDatHang] = ddh;
        dsddh = newdsddh;
        soLuongDonDatHang++;
    }

    public void xuatDDH() {
        for (DonDatHang i : dsddh) {
            i.xuat();
        }
    }


    // Phuong thuc ghi danh sach don dat hang vao file
    public void ghiVaoFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\ADMIN\\oop_design\\src\\DonDatHang\\danhSachDonDatHang.txt"))) {
            for (DonDatHang ddh : dsddh) {
                writer.write(ddh.toString());
                writer.newLine();
            }
            System.out.println("Ghi file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    // Phuong thuc doc danh sach don dat hang tu file
    public void docTuFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ADMIN\\oop_design\\src\\DonDatHang\\danhSachDonDatHang.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 12) {
                   
                    String maDonDatHang = data[0];
                    LocalDate ngayDatHang = LocalDate.parse(data[1]);
                    LocalDate ngayGiaoHang = LocalDate.parse(data[2]);
                    String sanPham =  data[3];
                    double tongTien = Double.parseDouble(data[4]);
                    double soLuong = Double.parseDouble(data[5]);
                    String nhaCungCap =  data[6];
                    String hinhThucGiaoHang = data[7];
                    Double doanhThuDonDatHang = Double.parseDouble(data[8]);
                   
//                    DonDatHang ddh = new DonDatHang(maDonDatHang, ngayDatHang, ngayGiaoHang, sanPham, tongTien, soLuong, nhaCungCap, hinhThucGiaoHang, doanhThuDonDatHang);
//                    themDDH(ddh);
                }
            }
            System.out.println("Doc file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Loi dinh dang so trong du lieu: " + e.getMessage());
        }
    }

}
