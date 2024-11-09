package SanPham;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class QLSanPham{
    private SanPham[] ds;
    static Scanner sc = new Scanner(System.in);

    public QLSanPham()
    {

    }

    public QLSanPham(SanPham[] ds) 
    {
        this.ds = ds;
    }

    public void themSanPham(SanPham sp)
    {
        SanPham[] newDS = Arrays.copyOf(ds, ds.length + 1);
        newDS[this.ds.length] = sp;
        this.ds = newDS;
    }

    public void menu()
    {
        int choiceMenu = 1;

        while(choiceMenu != 0)
        {
            System.out.println("1. Nhap danh sach san pham.");
            System.out.println("2. Xuat danh sach san pham.");
            System.out.println("3. Doc du lieu tu file.");
            System.out.println("4. Nhap du lieu vao file.");
            System.out.println("5. Sua phan tu theo ma");
            System.out.println("6. Xoa phan tu theo ma.");
            System.out.println("7. Tim kiem san pham.");
            System.out.println("0. Thoat.");
            choiceMenu = Integer.parseInt(sc.nextLine());

            switch(choiceMenu) 
            {
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
                    //suaPhanTuTheoMa();
                    break;

                case 6:
                    //xoaPhanTuTheoMa();
                    break;

                case 7:
                    timKiem();
                    break;

                default:
                    throw new AssertionError();
                }
        }
    }
    
    public void nhapDanhSach()
    {
        System.out.println("Nhap so luong san pham: ");
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++)
        {
            System.out.println("Ban muon nhap loai san pham nao: ");
            System.out.println("May Tinh - Phan Cung - Thiet Bi Ngoai Vi");
            String choiceSP = sc.nextLine();
            if(choiceSP.equalsIgnoreCase("May Tinh"))
            {
                System.out.println("Ban muon nhap loai may tinh nao: ");
                System.out.println("Desktop - Laptop");
                String choiceMT = sc.nextLine();
                if(choiceMT.equalsIgnoreCase("Desktop"))
                {
                    Desktop desktop = new Desktop();
                    desktop.loaiMayTinh = "Desktop";
                    desktop.nhap();
                    themSanPham(desktop);
                }

                else if(choiceMT.equalsIgnoreCase("Laptop"))
                {
                    Laptop laptop = new Laptop();
                    laptop.loaiMayTinh = "Laptop";
                    laptop.nhap();
                    themSanPham(laptop);
                }

                else
                {
                    System.out.println("San pham khong ton tai.");
                }
            }

            else if(choiceSP.equalsIgnoreCase("Phan Cung"))
            {
                System.out.println("Ban muon nhap loai linh kien nao: ");
                System.out.println("CPU - GPU - RAM - Bo Nho");
                String choicePC = sc.nextLine();

                if(choicePC.equalsIgnoreCase("CPU"))
                {
                    CPU cpu = new CPU();
                    cpu.loaiLinhKien = "CPU";
                    cpu.nhap();
                    themSanPham(cpu);
                }

                else if(choicePC.equalsIgnoreCase("GPU"))
                {
                    GPU gpu = new GPU();
                    gpu.loaiLinhKien = "GPU";
                    gpu.nhap();
                    themSanPham(gpu);
                }

                else if(choicePC.equalsIgnoreCase("RAM"))
                {
                    RAM ram = new RAM();
                    ram.loaiLinhKien = "RAM";
                    ram.nhap();
                    themSanPham(ram);
                }

                else if(choicePC.equalsIgnoreCase("Bo Nho"))
                {
                    BoNho boNho = new BoNho();
                    boNho.loaiLinhKien = "Bo Nho";
                    boNho.nhap();
                    themSanPham(boNho);
                }
                
                else
                {
                    System.out.println("San pham khong ton tai.");
                }
            }

            else if(choiceSP.equalsIgnoreCase("Thiet Bi Ngoai Vi"))
            {
                System.out.println("Ban muon nhap thiet bi nao: ");
                System.out.println("Chuot - Man Hinh - Ban Phim");
                String choiceTB = sc.nextLine();

                if(choiceTB.equalsIgnoreCase("Chuot"))
                {
                    Chuot chuot = new Chuot();
                    chuot.loaiThietBi = "Chuot";
                    chuot.nhap();
                    themSanPham(chuot);
                }

                else if(choiceTB.equalsIgnoreCase("Man Hinh"))
                {
                    ManHinh manHinh = new ManHinh();
                    manHinh.loaiThietBi = "Man Hinh";
                    manHinh.nhap();
                    themSanPham(manHinh);
                }

                else if(choiceTB.equalsIgnoreCase("Ban Phim"))
                {
                    BanPhim banPhim = new BanPhim();
                    banPhim.loaiThietBi = "Ban Phim";
                    banPhim.nhap();
                    themSanPham(banPhim);
                }
                
                else
                {
                    System.out.println("San pham khong ton tai.");
                }
            }

            else
            {
                System.out.println("San pham khong ton tai.");
            }
        }
    }

    public void xuatDanhSach()
    {
        for(var i:ds)
            i.xuat();
    }

    public void docTuFile()
    {
        
    }

    public void nhapSanPhamVaoFile(String file, SanPham sp){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(String.join(",",
            sp.getMaSP(),
            sp.getTenSP(),
            String.valueOf(sp.getGiaSP()),
            String.valueOf(sp.getThoiGianBaoHanhSP()),
            String.valueOf(sp.getTrongLuongSP()),
            sp.getMauSacSP())
            );
        } 
        catch(IOException e){
            System.out.println("Khong ghi duoc file");
        }
    }

    public void nhapVaoFile()
    {

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("DanhSach.txt"));
            for(SanPham sp:ds){

                if(sp instanceof Desktop desktop){
                    nhapSanPhamVaoFile("DanhSach.txt", desktop);
                    writer.write(String.join(",",
                    desktop.getCasePC(),
                    desktop.getTanNhiet())
                    );
                    writer.newLine();
                }

                else if(sp instanceof Laptop laptop){
                    nhapSanPhamVaoFile("DanhSach.txt", laptop);
                    writer.write(String.join(",",
                    laptop.getKichThuocManHinh(),
                    String.valueOf(laptop.getThoiLuongPin()),
                    laptop.getLoaiLaptop())
                    );
                    writer.newLine();
                }

                // else if(sp instanceof CPU cpu){

                // }

                // else if(sp instanceof GPU gpu){

                // }

                // else if(sp instanceof RAM ram){

                // }

                // else if(sp instanceof BoNho boNho){

                // }

                // else if(sp instanceof Chuot chuot){

                // }

                // else if(sp instanceof ManHinh manHinh){

                // }

                // else if(sp instanceof BanPhim banPhim){

                // } 

                writer.close();
            }
            
        } 
        catch (IOException e){
            System.out.println("Khong ghi duoc file");
        }
    }

    public SanPham suaPhanTuTheoMa(String maSP)
    {
        for(var sp:ds){
            if(sp.maSP.equals(maSP)){


                }
                return sp;
            }
        
        return null;
    }

    public void xoaPhanTuTheoMa(String maSP)
    {
        for(var sp:ds){
            if(sp.maSP.equals(maSP)){
                SanPham[] newDs = Arrays.copyOf(this.ds, this.ds.length - 1);
                for(int i = 0, j = 0; i < ds.length; i++)
                    if(!sp.maSP.equals(maSP))
                        newDs[j++] = ds[i];
                ds = newDs;
                System.out.println("Da xoa san phan co ma: " + maSP);
                return;
            }
        }
        System.out.println("Khong tim thay san pham");
    }

    public SanPham timKiem()
    {
        System.out.println("Hay nhap ma hoac ten san pham ban muon tim: ");
        String timSP = sc.nextLine();
        if(timSP.startsWith("#sp")){
            for(SanPham sp:ds)
                if(sp.maSP.equals(timSP)) 
                    return sp;
        }
        else{
            for(SanPham sp:ds)
                if (sp.tenSP.toLowerCase().contains(timSP.toLowerCase())) 
                    return sp;  
        }
        return null;
    }
}
