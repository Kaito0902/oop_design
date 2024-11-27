package ChuoiCungCap;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class QLNhaCungCap {
    private NhaCungCap[] ds = new NhaCungCap[0];
    private int soLuong;
    static Scanner sc = new Scanner(System.in);
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void themNCC(NhaCungCap ncc) {
        NhaCungCap[] newDs = Arrays.copyOf(ds, soLuong + 1);
        newDs[soLuong] = ncc;
        this.ds = newDs;
        soLuong++;
    }

    public void nhapDanhSach()
    {
        System.out.println("Nhap so luong nha cung cap: ");
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            NhaCungCap ncc = new NhaCungCap();
            ncc.nhap();
            themNCC(ncc);
        }
    }

    public void xuatDanhSach()
    {
        for(NhaCungCap i : ds)
            if(i.isNotDeleted){
                i.xuat();
                System.out.println();
            }
    }

    public void suaPhanTuTheoMa(String maNCC)
    {
        boolean timThay = false;
        for (NhaCungCap ncc : ds) {
            if (ncc.getMaNCC().equals(maNCC) && ncc.isNotDeleted) {
                int lc;
                boolean ktra = true;
                timThay = true;
                while (ktra) {
                    ncc.xuat();
                    System.out.println("1. Sua ten nha cung cap");
                    System.out.println("2. Sua dia chi");
                    System.out.println("3. Sua email");
                    System.out.println("4. Sua ma so thue");
                    System.out.println("5. Sua ngay hop tac");
                    System.out.println("6. Thoat");
                    System.out.println("Nhap lua chon muon sua: ");
                    lc = Integer.parseInt(sc.nextLine());
                    switch (lc) {
                        case 1: {
                            System.out.println("Nhap ten nha cung cap moi: ");
                            ncc.setTenNCC(sc.nextLine());
                            System.out.println("Da sua ten.");
                            break;
                        }
                        case 2: {
                            System.out.println("Nhap dia chi moi: ");
                            ncc.setDiaChi(sc.nextLine());
                            System.out.println("Da sua dia chi.");
                            break;
                        }
                        case 3: {
                            System.out.println("Nhap email moi: ");
                            ncc.setEmail(sc.nextLine());
                            System.out.println("Da sua email.");
                            break;
                        }
                        case 4: {
                            System.out.println("Nhap ma so thue moi: ");
                            ncc.setMaSoThue(sc.nextLine());
                            System.out.println("Da sua ma so thue.");
                            break;
                        }
                        case 5: {
                            System.out.println("Nhap ngay hop tac moi: ");
                            ncc.setNgayHopTac(sc.nextLine());
                            System.out.println("Da sua ngay hop tac.");
                            break;
                        }
                        case 6: {
                            ktra = false;
                            break;
                        }
                        default: {
                            System.out.println("Lua chon khong hop le.");
                            System.out.println("Vui long lua chon lai.");
                        }
                    }
                }
            }
        }
        if (!timThay) {
            System.out.println("Khong tim thay nha cung cap.");
        }
    }

    public void xoaPhanTuTheoMa(String maNCC)
    {
        for(NhaCungCap ncc : ds){
            if(ncc.maNCC.equals(maNCC) && ncc.isNotDeleted){
                ncc.isNotDeleted = false;
                System.out.println("Da xoa nha cung cap co ma: " + maNCC);
                return;
            }
        }
        System.out.println("Khong tim thay nha cung cap.");
    }

    public NhaCungCap timKiem(String timNCC)
    {
        if(timNCC.startsWith("#ncc")){
            for(NhaCungCap ncc:ds)
                if(ncc.maNCC.equals(timNCC) && ncc.isNotDeleted)
                    return ncc;
        }
        else{
            for(NhaCungCap ncc:ds)
                if (ncc.tenNCC.toLowerCase().contains(timNCC.toLowerCase()) && ncc.isNotDeleted)
                    return ncc;
        }
        return null;
    }

    public void nhapVaoFile()
    {
        String file = "C:\\Users\\ACER\\IdeaProjects\\oop_project\\src\\ChuoiCungCap\\DanhSachNhaCungCap.txt";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            for(NhaCungCap ncc:ds){
                writer.write(String.join(",",
                        ncc.getMaNCC(),
                        ncc.getTenNCC(),
                        ncc.getDiaChi(),
                        ncc.getEmail(),
                        ncc.getMaSoThue(),
                        String.valueOf(ncc.getNgayHopTac().format(formatter)),
                        String.valueOf(ncc.isNotDeleted())
                ));
                writer.newLine();
            }
        }
        catch (IOException e){
            System.out.println("Khong nhap duoc file.");
        }
    }

    public void docTuFile()
    {
        String file = "C:\\Users\\ACER\\IdeaProjects\\oop_project\\src\\ChuoiCungCap\\DanhSachNhaCungCap.txt";
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if(data.length > 0) {
                    String maNCC = data[0];
                    String tenNCC = data[1];
                    String diaChi = data[2];
                    String email = data[3];
                    String maSoThue = data[4];
                    LocalDate ngayHopTac = LocalDate.parse(data[5], formatter);
                    boolean isNotDelete = Boolean.parseBoolean(data[6]);

                    NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, diaChi, email, maSoThue, ngayHopTac, isNotDelete);
                    themNCC(ncc);
                }
            }
        }
        catch(IOException e){
            System.out.println("Khong doc duoc file.");
        }
    }

}