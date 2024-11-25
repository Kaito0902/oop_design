package ChuoiCungCap;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class QLNhaCungCap {
    private NhaCungCap[] ds;
    static Scanner sc = new Scanner(System.in);

    public QLNhaCungCap(){
    }

    public QLNhaCungCap(NhaCungCap[] ds) {
        this.ds = ds;
    }

    public void themNCC(NhaCungCap ncc) {
        NhaCungCap[] newDs = Arrays.copyOf(ds, ds.length + 1);
        newDs[this.ds.length] = ncc;
        this.ds = newDs;
    }

    public void menu() {
        int choiceMenu = 1;
        while(choiceMenu != 0)
        {
            System.out.println("1. Nhap danh sach nha cung cap.");
            System.out.println("2. Xuat danh sach nha cung cap.");
            System.out.println("3. Doc du lieu tu file.");
            System.out.println("4. Nhap du lieu vao file.");
            System.out.println("5. Sua phan tu theo ma");
            System.out.println("6. Xoa phan tu theo ma.");
            System.out.println("7. Tim kiem nha cung cap.");
            System.out.println("0. Thoat.");
            choiceMenu = Integer.parseInt(sc.nextLine());

            switch (choiceMenu) {
                case 1:
                    nhapDanhSach();
                    break;
                case 2:
                    xuatDanhSach();
                    break;
                case 3:
                    docTuFile();
                    break;
                case 4:
                    nhapVaoFile();
                    break;
                case 5:
                    System.out.println("Nhap ma nha cung cap muon sua");
                    suaPhanTuTheoMa(sc.nextLine());
                    break;
                case 6:
                    System.out.println("Nhap ma nha cung cap muon xoa");
                    xoaPhanTuTheoMa(sc.nextLine());
                    break;
                case 7:
                    System.out.println("Hay nhap ma hoac ten nha cung cap ban muon tim: ");
                    String timNCC = sc.nextLine();
                    if(timKiem(timNCC) != null)
                        timKiem(timNCC).xuat();
                    break;
                case 0:
                    System.out.println("Hen gap lai.");
                    break;
                default:
                    throw new AssertionError();
            }
        }
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
        for(NhaCungCap i:ds)
            if(i.isNotDeleted){
                i.xuat();
                System.out.println();
            }
    }

    public void suaPhanTuTheoMa(String maNCC)
    {
        for(NhaCungCap ncc:ds){
            if(ncc.maNCC.equals(maNCC) && ncc.isNotDeleted == true){
                ncc.nhap();
                ncc.maNCC = maNCC;
                NhaCungCap.soLuongNCC--;
                System.out.println("Da sua thong tin nha cung cap co ma: " + maNCC);
                return;
                }
            }
        System.out.println("Khong tim thay san pham.");
    }

    public void xoaPhanTuTheoMa(String maNCC)
    {
        for(NhaCungCap ncc:ds){
            if(ncc.maNCC.equals(maNCC) && ncc.isNotDeleted == true){
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
                if(ncc.maNCC.equals(timNCC) && ncc.isNotDeleted == true) 
                    return ncc;
        }
        else{
            for(NhaCungCap ncc:ds)
                if (ncc.tenNCC.toLowerCase().contains(timNCC.toLowerCase()) && ncc.isNotDeleted == true) 
                    return ncc;  
        }
        return null;
    }

    public void nhapVaoFile()
    {
        String file = "C:\\Đăng\\Study\\Visual Studio Code\\Java\\Đồ Án\\oop_design\\src\\ChuoiCungCap\\DanhSachNhaCungCap.txt";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            for(NhaCungCap ncc:ds){
                writer.write(String.join(",",
                ncc.getMaNCC(),
                ncc.getTenNCC(),
                ncc.getDiaChi(),
                ncc.getEmail(),
                ncc.getMaSoThue(),
                String.valueOf(ncc.getNgayHopTac()),
                String.valueOf(ncc.isNotDeleted())
                ));
            writer.newLine();
            writer.close();
            System.out.println("Da nhap vao file.");
            } 
        }
        catch (IOException e){
            System.out.println("Khong nhap duoc file.");
        }
    }

    public void docTuFile() 
    {
        String file = "C:\\Đăng\\Study\\Visual Studio Code\\Java\\Đồ Án\\oop_design\\src\\ChuoiCungCap\\DanhSachNhaCungCap.txt";
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
                    LocalDate ngayHopTac = LocalDate.parse(data[5]);
                    boolean isNotDelete = Boolean.parseBoolean(data[6]);

                    NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, diaChi, email, maSoThue, ngayHopTac, isNotDelete);
                    themNCC(ncc);
                }
            }
            reader.close();
            System.out.println("Da doc file.");
        } 
        catch(IOException e){
            System.out.println("Khong doc duoc file.");
        }
    }

}