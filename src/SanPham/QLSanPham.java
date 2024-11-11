package SanPham;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
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

    PhanCung[] cacLinhKien = new PhanCung[4];
    public void nhapDanhSach1(){
        CPU sp1 = new CPU(24, 32, 6.2f, "", "i9-14900KS", 18500000, 1, 0.5f, "xanh", "Intel", "CPU", "Intel Core i9 14900KS");
        GPU sp2 = new GPU(24, "GDDR6X", 2610, 16384, "Co", "", "NVIDIA GeForce RTX 4090", 59990000, 2, 0.5f, "den", "Nvidia", "GPU", "ASUS ROG Strix LC GeForce");
        RAM sp3 = new RAM(16, "OK", "", "RAM", 1000000, 1, 0.2f, "den", "Asus", "RAM", "okok");
        ManHinh sp4 = new ManHinh("4K", "15.6 inches", "Phang", "OLED", 144, "", "Man Hinh", 2000000, 1, 3, "hong", "Acer", "ASUS ProArt PA24US", "Day");
        BoNho sp5 = new BoNho(512, "SSD", "", "SamSung 980 Pro", 1990000, 1, 1.2f, "den", "SamSung", "Bo Nho", "MZ-V8P500BW");
        
        cacLinhKien[0] = sp1;
        cacLinhKien[1] = sp2;
        cacLinhKien[2] = sp3;
        cacLinhKien[3] = sp5;

        Laptop sp6 = new Laptop("15.6 inches", "Gaming", 3.5f, "", "Lenovo LOQ", 28990000, 2, 2.4f, "xam",
        "Lenovo", "Lenovo LOQ 15IRX9 83DV00D5VN", "Laptop", "Win 11", "Co", cacLinhKien);
        
        themSanPham(sp1);
        themSanPham(sp2);
        themSanPham(sp3);
        themSanPham(sp4);
        themSanPham(sp5);
        themSanPham(sp6);
    }

    public void menu()
    {
        int choiceMenu = 1;

        while(choiceMenu != 0)
        {
            System.out.println("1. Nhap danh sach san pham.");
            System.out.println("2. Xuat danh sach san pham.");
            System.out.println("3. Them moi k san pham.");
            System.out.println("4. Doc du lieu tu file.");
            System.out.println("5. Nhap du lieu vao file.");
            System.out.println("6. Sua phan tu theo ma");
            System.out.println("7. Xoa phan tu theo ma.");
            System.out.println("8. Tim kiem san pham.");
            System.out.println("0. Thoat.");
            choiceMenu = Integer.parseInt(sc.nextLine());

            switch(choiceMenu) 
            {
                case 1:
                    nhapDanhSach1();
                    break;

                case 2:
                    xuatDanhSach();
                    break;
                    
                case 3:
                    themKSanPham();
                    break;

                case 4:
                    docTuFile();
                    break;

                case 5:
                    nhapVaoFile();
                    // try {
                    //     String file = "C:\\Đăng\\Study\\Visual Studio Code\\Java\\Đồ Án\\oop_design\\src\\SanPham\\DanhSachSanPham.txt";
                    //     BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    //     writer.write("Hello");
                    //     writer.newLine();
                    //     writer.write("Hi");
                    //     writer.close();
                    // } catch (IOException e) {
                    //     System.out.println("ok");
                    // }
                    break;

                case 6:
                    System.out.println("Nhap ma san pham muon sua: ");
                    suaPhanTuTheoMa(sc.nextLine());
                    break;

                case 7:
                    System.out.println("Nhap ma san pham muon xoa: ");
                    xoaPhanTuTheoMa(sc.nextLine());
                    break;

                case 8:
                    System.out.println("Hay nhap ma hoac ten san pham ban muon tim: ");
                    String timSP = sc.nextLine();
                    if(timKiem(timSP) != null)
                        timKiem(timSP).xuat();
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
        for(SanPham i:ds){
            i.xuat();
            System.out.println();
        }
    }

    public void themKSanPham(){

    }

    public void docTuFile()
    {
        String file = "C:\\Đăng\\Study\\Visual Studio Code\\Java\\Đồ Án\\oop_design\\src\\SanPham\\DanhSachSanPham.txt";
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            reader.readLine();
            String line;
            while((line = reader.readLine()) != null){

            }
            reader.close();
        } 
        
        catch(IOException e){
            System.out.println("Khong doc duoc file.");
        }
    }

    // public void nhapSanPhamVaoFile(String file, SanPham sp){
    //     try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
    //         writer.write(String.join(",",
    //         sp.getMaSP(),
    //         sp.getTenSP(),
    //         String.valueOf(sp.getGiaSP()),
    //         String.valueOf(sp.getThoiGianBaoHanhSP()),
    //         String.valueOf(sp.getTrongLuongSP()),
    //         sp.getMauSacSP())
    //         );
    //         writer.close();
    //     }

    //     catch(IOException e){
    //         System.out.println("Khong ghi duoc file1");
    //     }
    // }

    public void nhapLinhKienVaoFile(String file, SanPham sp, PhanCung cacLinhKien){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            if(cacLinhKien instanceof CPU cpu){
                writer.write(String.join(",",
                String.valueOf(cpu.getSoNhan()),
                String.valueOf(cpu.getSoLuongLoi()),
                String.valueOf(cpu.getTanSoTurBo())
                ));
                writer.close();
            }

            else if(cacLinhKien instanceof GPU gpu){
                writer.write(String.join(",",
                String.valueOf(gpu.getDungLuongVRAM()),
                gpu.getLoaiVRAM(),
                String.valueOf(gpu.getTocDoXungNhip()),
                String.valueOf(gpu.getSoNhanCUDA()),
                gpu.getCoRayTracing()
                ));
                writer.close();
            }

            else if(cacLinhKien instanceof RAM ram){
                writer.write(String.join(",",
                String.valueOf(ram.getDungLuongRAM()),
                ram.getLoaiRAM()
                ));
                writer.close();
            }

            else if(cacLinhKien instanceof BoNho boNho){
                writer.write(String.join(",",
                String.valueOf(boNho.getDungLuongBoNho()),
                boNho.getLoaiBoNho()
                ));
                writer.close();
            }
            writer.close();
        }
        catch(IOException e){
            System.out.println("Khong ghi duoc file1");
        }
    }

    public void nhapVaoFile()
    {
        String file = "C:\\Đăng\\Study\\Visual Studio Code\\Java\\Đồ Án\\oop_design\\src\\SanPham\\DanhSachSanPham.txt";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            for(SanPham sp:ds){
                writer.write(String.join(",",
                sp.getMaSP(),
                sp.getTenSP(),
                String.valueOf(sp.getGiaSP()),
                String.valueOf(sp.getThoiGianBaoHanhSP()),
                String.valueOf(sp.getTrongLuongSP()),
                sp.getMauSacSP(),
                ""
                ));

                if(sp instanceof Desktop desktop){
                    writer.write(String.join(",",
                    desktop.getCasePC(),
                    desktop.getTanNhiet(),
                    ""
                    ));
                    for(PhanCung i:desktop.cacLinhKien){
                        writer.write(String.join(",", 
                            i.getLoaiLinhKien(),
                            i.getNhaSanXuat(),
                            i.getModel(),
                            ""
                        ));

                        if(i instanceof CPU cpu){
                            writer.write(String.join(",",
                            String.valueOf(cpu.getSoNhan()),
                            String.valueOf(cpu.getSoLuongLoi()),
                            String.valueOf(cpu.getTanSoTurBo()),
                            ""
                            ));
                        }
            
                        else if(i instanceof GPU gpu){
                            writer.write(String.join(",",
                            String.valueOf(gpu.getDungLuongVRAM()),
                            gpu.getLoaiVRAM(),
                            String.valueOf(gpu.getTocDoXungNhip()),
                            String.valueOf(gpu.getSoNhanCUDA()),
                            gpu.getCoRayTracing(),
                            ""
                            ));
                        }
            
                        else if(i instanceof RAM ram){
                            writer.write(String.join(",",
                            String.valueOf(ram.getDungLuongRAM()),
                            ram.getLoaiRAM(),
                            ""
                            ));
                        }
            
                        else if(i instanceof BoNho boNho){
                            writer.write(String.join(",",
                            String.valueOf(boNho.getDungLuongBoNho()),
                            boNho.getLoaiBoNho()
                            ));
                        }
                    }
                    writer.newLine();
                }

                else if(sp instanceof Laptop laptop){
                    writer.write(String.join(",",
                    laptop.getKichThuocManHinh(),
                    String.valueOf(laptop.getThoiLuongPin()),
                    laptop.getLoaiLaptop(),
                    ""
                    ));

                    for(PhanCung i:laptop.cacLinhKien){
                        writer.write(String.join(",", 
                        i.getLoaiLinhKien(),
                        i.getNhaSanXuat(),
                        i.getModel(),
                        ""
                        ));
                        if(i instanceof CPU cpu){
                            writer.write(String.join(",",
                            String.valueOf(cpu.getSoNhan()),
                            String.valueOf(cpu.getSoLuongLoi()),
                            String.valueOf(cpu.getTanSoTurBo()),
                            ""
                            ));
                        }
            
                        else if(i instanceof GPU gpu){
                            writer.write(String.join(",",
                            String.valueOf(gpu.getDungLuongVRAM()),
                            gpu.getLoaiVRAM(),
                            String.valueOf(gpu.getTocDoXungNhip()),
                            String.valueOf(gpu.getSoNhanCUDA()),
                            gpu.getCoRayTracing(),
                            ""
                            ));
                        }
            
                        else if(i instanceof RAM ram){
                            writer.write(String.join(",",
                            String.valueOf(ram.getDungLuongRAM()),
                            ram.getLoaiRAM(),
                            ""
                            ));
                        }
            
                        else if(i instanceof BoNho boNho){
                            writer.write(String.join(",",
                            String.valueOf(boNho.getDungLuongBoNho()),
                            boNho.getLoaiBoNho()
                            ));
                        }
                    }
                    writer.newLine();
                }

                else if(sp instanceof CPU cpu){
                    writer.write(String.join(",",
                    String.valueOf(cpu.getSoNhan()),
                    String.valueOf(cpu.getSoLuongLoi()),
                    String.valueOf(cpu.getTanSoTurBo())
                    ));
                    writer.newLine();
                }

                else if(sp instanceof GPU gpu){
                    writer.write(String.join(",",
                    String.valueOf(gpu.getDungLuongVRAM()),
                    gpu.getLoaiVRAM(),
                    String.valueOf(gpu.getTocDoXungNhip()),
                    String.valueOf(gpu.getSoNhanCUDA()),
                    gpu.getCoRayTracing()
                    ));
                    writer.newLine();

                }

                else if(sp instanceof RAM ram){
                    writer.write(String.join(",",
                    String.valueOf(ram.getDungLuongRAM()),
                    ram.getLoaiRAM()
                    ));
                    writer.newLine();

                }

                else if(sp instanceof BoNho boNho){
                    writer.write(String.join(",",
                    String.valueOf(boNho.getDungLuongBoNho()),
                    boNho.getLoaiBoNho()
                    ));
                    writer.newLine();

                }

                else if(sp instanceof Chuot chuot){
                    writer.write(String.join(",",
                    String.valueOf(chuot.getdPI()),
                    String.valueOf(chuot.getSoLanBam()),
                    chuot.getDenLED(),
                    chuot.getLoaiChuot()
                    ));
                    writer.newLine();

                }

                else if(sp instanceof ManHinh manHinh){
                    writer.write(String.join(",",
                    manHinh.getKieuManHinh(),
                    manHinh.getKichThuoc(),
                    String.valueOf(manHinh.getTanSoQuet()),
                    manHinh.getTamNen(),
                    manHinh.getDoPhanGiai()
                    ));
                    writer.newLine();

                }

                else if(sp instanceof BanPhim banPhim){
                    writer.write(String.join(",",
                    banPhim.getKichThuoc(),
                    banPhim.getDenLED(),
                    banPhim.getSwitchBP()
                    ));
                    writer.newLine();

                } 
            }
            writer.close();
            System.out.println("Da nhap vao file.");
        } 
        catch (IOException e){
            System.out.println("Khong nhap duoc file.");
        }
    }

    public void suaPhanTuTheoMa(String maSP)
    {
        for(var sp:ds){
            if(sp.maSP.equals(maSP)){
                sp.nhap();
                sp.maSP = maSP;
                System.out.println("Da sua thong tin san pham co ma: " + maSP);
                return;
                }
            }
        System.out.println("Khong tim thay san pham.");
    }

    public void xoaPhanTuTheoMa(String maSP)
    {
        for(SanPham sp:ds){
            if(sp.maSP.equals(maSP)){
                SanPham[] newDs = Arrays.copyOf(this.ds, this.ds.length - 1);
                for(int i = 0, j = 0; i < ds.length; i++)
                    if(!ds[i].maSP.equals(maSP))
                        newDs[j++] = ds[i];
                ds = newDs;
                System.out.println("Da xoa san phan co ma: " + maSP);
                return;
            }
        }
        System.out.println("Khong tim thay san pham.");
    }

    public SanPham timKiem(String timSP)
    {
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
