package SanPham;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class QLSanPham{
    private SanPham[] ds = new SanPham[0];
    private int soLuong = 0;
    static Scanner sc = new Scanner(System.in);

    public void themSanPham(SanPham sp)
    {
        SanPham[] newDS = Arrays.copyOf(ds, soLuong + 1);
        newDS[soLuong] = sp;
        ds = newDS;
        soLuong++;
    }

    public void nhapDanhSach1(){
        CPU sp1 = new CPU("#sp001", "i9-14900KS", 18500000, "6 thang", 0.5f, "xanh", true, "CPU", "Intel", "Intel Core i9 14900KS", 32, 24, 6.2f);
        GPU sp2 = new GPU("#sp002", "NVIDIA GeForce RTX 4090", 59990000, "1 nam", 0.5f, "den", true, "GPU", "Nvidia", "ASUS ROG Strix LC GeForce", 24, "GDDR6X", 2610, 16384, "Co");
        RAM sp3 = new RAM("#sp003", "T-Group T-Force Delta", 1190000, "6 thang", 0.2f, "den", true, "RAM", "TeamGroup", "T-Group T-Force Delta 1x16GB 3600", 16, "DDR4-3600");
        BoNho sp4 = new BoNho("#sp004", "SamSung 980 Pro", 1990000, "6 thang", 1.2f, "den", true, "Bo Nho", "SamSung", "MZ-V8P500BW", 512, "SSD");
        Chuot sp5 = new Chuot("#sp005", "Logitech G502 X Plus", 3290000, "2 nam", 0.1f, "trang", true, "Chuot", "Logitech", "Khong Day", 25000, "RGB Light Sync");
        BanPhim sp6 = new BanPhim("#sp006", "Razer Huntsman V3 Pro TKL", 5345000, "2 nam", 0.5f, "den", true, "Ban Phim", "Razer", "Co Day", "Razer Chroma™ RGB", "Razer Analog Optical Switch Gen-2");
        ManHinh sp7 = new ManHinh("#sp007", "ASUS ProArt PA24US", 2000000, "2 nam", 3, "hong", true, "Man Hinh", "Acer", "Day", "Phang", "15.6 inches", "OLED", "4K", 144);
        
        PhanCung[] cacLinhKien = new PhanCung[4];
        cacLinhKien[0] = sp1;
        cacLinhKien[1] = sp2;
        cacLinhKien[2] = sp3;
        cacLinhKien[3] = sp4;

        Desktop sp8 = new Desktop("#sp008", "GVN x ASUS Advanced Ai", 140000000, "3 nam", 10, "den", true, "Desktop", "Asus", "GVN x ASUS Advanced Ai", "Win 11", "Co", cacLinhKien, "ASUS ROG Hyperion GR701", "ASUS ROG STRIX LC III 360 ARGB LCD");
        Laptop sp9 = new Laptop("#sp009", "Lenovo LOQ", 28990000, "2 nam", 2.4f, "xam", true, "Laptop", "Lenovo", "Lenovo LOQ 15IRX9 83DV00D5VN", "Win 11", "Co", cacLinhKien, "15.6 inches", 3.5f, "Gaming");
         
        themSanPham(sp1);
        themSanPham(sp2);
        themSanPham(sp3);
        themSanPham(sp4);
        themSanPham(sp5);
        themSanPham(sp6);
        themSanPham(sp7);
        themSanPham(sp8);
        themSanPham(sp9);
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
                    System.out.println("Nhap ma san pham muon sua: ");
                    suaPhanTuTheoMa(sc.nextLine());
                    break;

                case 6:
                    System.out.println("Nhap ma san pham muon xoa: ");
                    xoaPhanTuTheoMa(sc.nextLine());
                    break;

                case 7:
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
            System.out.println("1. May Tinh - 2. Phan Cung - 3. Thiet Bi Ngoai Vi");
            int choiceSP = Integer.parseInt(sc.nextLine());
            switch (choiceSP){
                case 1:
                    System.out.println("Ban muon nhap loai may tinh nao: ");
                    System.out.println("1. Desktop - 2. Laptop");
                    int choiceMT = Integer.parseInt(sc.nextLine());
                    switch (choiceMT){
                        case 1:
                            Desktop desktop = new Desktop();
                            desktop.loaiMayTinh = "Desktop";
                            desktop.nhap();
                            themSanPham(desktop);
                            break;
                        case 2:
                            Laptop laptop = new Laptop();
                            laptop.loaiMayTinh = "Laptop";
                            laptop.nhap();
                            themSanPham(laptop);
                            break;
                        default:
                            throw new AssertionError();
                    }
                    break;
                case 2:
                    System.out.println("Ban muon nhap loai linh kien nao: ");
                    System.out.println("1. CPU - 2. GPU - 3. RAM - 4. Bo Nho");
                    int choicePC = Integer.parseInt(sc.nextLine());
                    switch (choicePC){
                        case 1:
                            CPU cpu = new CPU();
                            cpu.loaiLinhKien = "CPU";
                            cpu.nhap();
                            themSanPham(cpu);
                            break;
                        case 2:
                            GPU gpu = new GPU();
                            gpu.loaiLinhKien = "GPU";
                            gpu.nhap();
                            themSanPham(gpu);
                            break;
                        case 3:
                            RAM ram = new RAM();
                            ram.loaiLinhKien = "RAM";
                            ram.nhap();
                            themSanPham(ram);
                            break;
                        case 4:
                            BoNho boNho = new BoNho();
                            boNho.loaiLinhKien = "Bo Nho";
                            boNho.nhap();
                            themSanPham(boNho);
                            break;
                        default:
                            throw new AssertionError();
                    }
                    break;
                case 3:
                    System.out.println("Ban muon nhap thiet bi nao: ");
                    System.out.println("1. Chuot - 2. Man Hinh - 3. Ban Phim");
                    int choiceTB = Integer.parseInt(sc.nextLine());
                    switch (choiceTB){
                        case 1:
                            Chuot chuot = new Chuot();
                            chuot.loaiThietBi = "Chuot";
                            chuot.nhap();
                            themSanPham(chuot);
                            break;
                        case 2:
                            ManHinh manHinh = new ManHinh();
                            manHinh.loaiThietBi = "Man Hinh";
                            manHinh.nhap();
                            themSanPham(manHinh);
                            break;
                        case 3:
                            BanPhim banPhim = new BanPhim();
                            banPhim.loaiThietBi = "Ban Phim";
                            banPhim.nhap();
                            themSanPham(banPhim);
                            break;
                        default:
                            throw new AssertionError();
                    }
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    public void xuatDanhSach()
    {
        for(SanPham i:ds)
            if(i.isNotDeleted){
                i.xuat();
                System.out.println();
            }
    }

    public void docTuFile()
    {
        String file = "C:\\Users\\ACER\\IdeaProjects\\oop_project\\src\\SanPham\\DanhSachSanPham.txt";
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while((line = reader.readLine()) != null){
                String[] data = line.split(",");
                if(data.length > 0){
                    String maSP = data[0];
                    String tenSP = data[1];
                    float giaSP = Float.parseFloat(data[2]);
                    String thoiGianBaoHanhSP = data[3];
                    float trongLuongSP = Float.parseFloat(data[4]);
                    String mauSacSP = data[5];
                    int soLuongNhap = Integer.parseInt(data[6]);
                    boolean isNotDeleted = Boolean.parseBoolean(data[7]);
                    String loaiSP = data[8];

                    if("Desktop".equals(loaiSP)){
                        String nhaSanXuat = data[9];
                        String model = data[10];
                        String heDieuHanh = data[11];
                        String coCardRoi = data[12];
                        String casePC = data[13];
                        String tanNhiet = data[14];

                        String loaiLinhKien1 = data[15];
                        String nhaSanXuat1 = data[16];
                        String model1 = data[17];
                        int soNhan = Integer.parseInt(data[18]);
                        int soLuongLoi = Integer.parseInt(data[19]);
                        float tanSoTurBo = Float.parseFloat(data[20]);

                        CPU cpu = new CPU("", "", 0, "", 0, "", 0, true, loaiLinhKien1, nhaSanXuat1, model1, soLuongLoi, soNhan, tanSoTurBo);
                        SanPham.soLuongSP--;

                        String loaiLinhKien2 = data[21];
                        String nhaSanXuat2 = data[22];
                        String model2 = data[23];
                        int dungLuongVRAM = Integer.parseInt(data[24]);
                        String loaiVRAM = data[25];
                        float tocDoXungNhip = Float.parseFloat(data[26]);
                        int soNhanCUDA = Integer.parseInt(data[27]);
                        String rayTracing = data[28];

                        GPU gpu = new GPU("", "", 0, "", 0, "", 0, true, loaiLinhKien2, nhaSanXuat2, model2, dungLuongVRAM, loaiVRAM, tocDoXungNhip, soNhanCUDA, rayTracing);
                        SanPham.soLuongSP--;

                        String loaiLinhKien3 = data[29];
                        String nhaSanXuat3 = data[30];
                        String model3 = data[31];
                        int dungLuongRAM = Integer.parseInt(data[32]);
                        String loaiRAM = data[33];

                        RAM ram = new RAM("", "", 0, "", 0, "", 0, true, loaiLinhKien3, nhaSanXuat3, model3, dungLuongRAM, loaiRAM);
                        SanPham.soLuongSP--;

                        String loaiLinhKien4 = data[34];
                        String nhaSanXuat4 = data[35];
                        String model4 = data[36];
                        int dungLuongBoNho = Integer.parseInt(data[37]);
                        String loaiBoNho = data[38];

                        BoNho boNho = new BoNho("", "", 0, "", 0, "", 0, true, loaiLinhKien4, nhaSanXuat4, model4, dungLuongBoNho, loaiBoNho);
                        SanPham.soLuongSP--;

                        PhanCung[] cacLinhKien = new PhanCung[4];
                        cacLinhKien[0] = cpu;
                        cacLinhKien[1] = gpu;
                        cacLinhKien[2] = ram;
                        cacLinhKien[3] = boNho;

                        Desktop desktop = new  Desktop(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, soLuongNhap, isNotDeleted , loaiSP, nhaSanXuat, model, heDieuHanh, coCardRoi, cacLinhKien,casePC,tanNhiet);
                        themSanPham(desktop);
                    }

                    else if("Laptop".equals(loaiSP)){
                        String nhaSanXuat = data[9];
                        String model = data[10];
                        String heDieuHanh = data[11];
                        String coCardRoi = data[12];
                        String kichThuocManHinh = data[13];
                        float thoiLuongPin = Float.parseFloat(data[14]);
                        String loaiLaptop = data[15];

                        String loaiLinhKien1 = data[16];
                        String nhaSanXuat1 = data[17];
                        String model1 = data[18];
                        int soNhan = Integer.parseInt(data[19]);
                        int soLuongLoi = Integer.parseInt(data[20]);
                        float tanSoTurBo = Float.parseFloat(data[21]);

                        CPU cpu = new CPU("", "", 0, "", 0, "", 0, true, loaiLinhKien1, nhaSanXuat1, model1, soLuongLoi, soNhan, tanSoTurBo);
                        SanPham.soLuongSP--;

                        String loaiLinhKien2 = data[22];
                        String nhaSanXuat2 = data[23];
                        String model2 = data[24];
                        int dungLuongVRAM = Integer.parseInt(data[25]);
                        String loaiVRAM = data[26];
                        float tocDoXungNhip = Float.parseFloat(data[27]);
                        int soNhanCUDA = Integer.parseInt(data[28]);
                        String rayTracing = data[29];

                        GPU gpu = new GPU("", "", 0, "", 0, "", 0, true, loaiLinhKien2, nhaSanXuat2, model2, dungLuongVRAM, loaiVRAM, tocDoXungNhip, soNhanCUDA, rayTracing);
                        SanPham.soLuongSP--;

                        String loaiLinhKien3 = data[30];
                        String nhaSanXuat3 = data[31];
                        String model3 = data[32];
                        int dungLuongRAM = Integer.parseInt(data[33]);
                        String loaiRAM = data[34];

                        RAM ram = new RAM("", "", 0, "", 0, "", 0, true, loaiLinhKien3, nhaSanXuat3, model3, dungLuongRAM, loaiRAM);
                        SanPham.soLuongSP--;

                        String loaiLinhKien4 = data[35];
                        String nhaSanXuat4 = data[36];
                        String model4 = data[37];
                        int dungLuongBoNho = Integer.parseInt(data[38]);
                        String loaiBoNho = data[39];

                        BoNho boNho = new BoNho("", "", 0, "", 0, "", 0, true, loaiLinhKien4, nhaSanXuat4, model4, dungLuongBoNho, loaiBoNho);
                        SanPham.soLuongSP--;

                        PhanCung[] cacLinhKien = new PhanCung[4];
                        cacLinhKien[0] = cpu;
                        cacLinhKien[1] = gpu;
                        cacLinhKien[2] = ram;
                        cacLinhKien[3] = boNho;

                        Laptop laptop = new Laptop(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, soLuongNhap, isNotDeleted, loaiSP, nhaSanXuat, model, heDieuHanh, coCardRoi, cacLinhKien, kichThuocManHinh, thoiLuongPin, loaiLaptop);
                        themSanPham(laptop);
                    }

                    else if("CPU".equals(loaiSP)){
                        String nhaSanXuat = data[9];
                        String model = data[10];
                        int soNhan = Integer.parseInt(data[11]);
                        int soLuongLoi = Integer.parseInt(data[12]);
                        float tanSoTurBo = Float.parseFloat(data[13]);

                        CPU cpu = new CPU(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, soLuongNhap, isNotDeleted,loaiSP, nhaSanXuat, model, soNhan, soLuongLoi, tanSoTurBo);
                        themSanPham(cpu);
                    }

                    else if("GPU".equals(loaiSP)){
                        String nhaSanXuat = data[9];
                        String model = data[10];
                        int dungLuongVRAM = Integer.parseInt(data[11]);
                        String loaiVRAM = data[12];
                        float tocDoXungNhip = Float.parseFloat(data[13]);
                        int soNhanCUDA = Integer.parseInt(data[14]);
                        String rayTracing = data[15];
                        GPU gpu = new GPU(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, soLuongNhap, isNotDeleted, loaiSP, nhaSanXuat, model, dungLuongVRAM, loaiVRAM, tocDoXungNhip, soNhanCUDA, rayTracing);
                        themSanPham(gpu);
                    }

                    else if("RAM".equals(loaiSP)){
                        String nhaSanXuat = data[9];
                        String model = data[10];
                        int dungLuongRAM = Integer.parseInt(data[11]);
                        String loaiRAM = data[12];
                        RAM ram = new RAM(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, soLuongNhap, isNotDeleted, loaiSP, nhaSanXuat, model, dungLuongRAM, loaiRAM);
                        themSanPham(ram);
                    }

                    else if("Bo Nho".equals(loaiSP)){
                        String nhaSanXuat = data[9];
                        String model = data[10];
                        int dungLuongBoNho = Integer.parseInt(data[11]);
                        String loaiBoNho = data[12];

                        BoNho boNho = new BoNho(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, soLuongNhap, isNotDeleted, loaiSP, nhaSanXuat, model, dungLuongBoNho, loaiBoNho);
                        themSanPham(boNho);
                    }

                    else if("Chuot".equals(loaiSP)){
                        String nhaSanXuat = data[9];
                        String phuongThucKetNoi = data[10];
                        int dPI = Integer.parseInt(data[11]);
                        String denLED = data[12];

                        Chuot chuot = new Chuot(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, soLuongNhap, isNotDeleted, loaiSP, nhaSanXuat, phuongThucKetNoi, dPI, denLED);
                        themSanPham(chuot);
                    }

                    else if("Man Hinh".equals(loaiSP)){
                        String nhaSanXuat = data[9];
                        String phuongThucKetNoi = data[10];
                        String kieuManHinh = data[11];
                        String kichThuoc = data[12];
                        int tanSoQuet = Integer.parseInt(data[13]);
                        String tamNen = data[14];
                        String doPhanGiai = data[15];

                        ManHinh manHinh = new ManHinh(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, soLuongNhap, isNotDeleted, loaiSP, nhaSanXuat, phuongThucKetNoi, kieuManHinh, kichThuoc, tamNen, doPhanGiai, tanSoQuet);
                        themSanPham(manHinh);
                    }

                    else if("Ban Phim".equals(loaiSP)){
                        String nhaSanXuat = data[9];
                        String phuongThucKetNoi = data[10];
                        String denLED = data[11];
                        String switchBP = data[12];
                        BanPhim banPhim = new BanPhim(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, soLuongNhap, isNotDeleted, loaiSP, nhaSanXuat, phuongThucKetNoi, denLED, switchBP);
                        themSanPham(banPhim);
                    }
                }
            }
            reader.close();
            System.out.println("Da doc file.");
        } 
        
        catch(IOException e){
            System.out.println("Khong doc duoc file.");
        }
    }

    public void nhapVaoFile()
    {
        String file = "C:\\Users\\ACER\\IdeaProjects\\oop_project\\src\\SanPham\\DanhSachSanPham.txt";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            for(SanPham sp:ds){
                writer.write(String.join(",",
                sp.getMaSP(),
                sp.getTenSP(),
                String.valueOf(sp.getGiaSP()),
                String.valueOf(sp.getThoiGianBaoHanhSP()),
                String.valueOf(sp.getTrongLuongSP()),
                sp.getMauSacSP(),
                String.valueOf(sp.getSoLuongNhap()),
                String.valueOf(sp.isNotDeleted()),
                ""
                ));

                if(sp instanceof MayTinh mayTinh){
                    writer.write(String.join(",",
                    mayTinh.getLoaiMayTinh(),
                    mayTinh.getNhaSanXuat(),
                    mayTinh.getModel(),
                    mayTinh.getHeDieuHanh(),
                    mayTinh.getCoCardRoi(),
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
                    }

                else if(sp instanceof PhanCung phanCung){
                    writer.write(String.join(",",
                        phanCung.getLoaiLinhKien(),
                        phanCung.getNhaSanXuat(),
                        phanCung.getModel(),
                        ""
                    ));

                    if(sp instanceof CPU cpu){
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
                }

                else if(sp instanceof ThietBiNgoaiVi thietBiNgoaiVi){
                    writer.write(String.join(",",
                        thietBiNgoaiVi.getLoaiThietBi(),
                        thietBiNgoaiVi.getNhaSanXuat(),
                        thietBiNgoaiVi.getPhuongThucKetNoi(),
                        ""
                    ));

                    if(sp instanceof Chuot chuot){
                        writer.write(String.join(",",
                        String.valueOf(chuot.getdPI()),
                        chuot.getDenLED()
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
                        banPhim.getDenLED(),
                        banPhim.getSwitchBP()
                        ));
                        writer.newLine();
                    } 
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
            if(sp.maSP.equals(maSP) && sp.isNotDeleted == true){
                sp.nhap();
                sp.maSP = maSP;
                SanPham.soLuongSP--;
                System.out.println("Da sua thong tin san pham co ma: " + maSP);
                return;
                }
            }
        System.out.println("Khong tim thay san pham.");
    }

    public void xoaPhanTuTheoMa(String maSP)
    {
        for(SanPham sp:ds)
            if(sp.maSP.equals(maSP) && sp.isNotDeleted == true){
                sp.isNotDeleted = false;
                System.out.println("Da xoa san phan co ma: " + maSP);
                return;
            }
        System.out.println("Khong tim thay san pham.");
    }

    // public void xoaPhanTuTheoMa(String maSP)
    // {
    //     for(SanPham sp:ds){
    //         if(sp.maSP.equals(maSP)){
    //             SanPham[] newDs = Arrays.copyOf(this.ds, this.ds.length - 1);
    //             for(int i = 0, j = 0; i < ds.length; i++)
    //                 if(!ds[i].maSP.equals(maSP))
    //                     newDs[j++] = ds[i];
    //             ds = newDs;
    //             System.out.println("Da xoa san phan co ma: " + maSP);
    //             return;
    //         }
    //     }
    //     System.out.println("Khong tim thay san pham.");
    // }

    public SanPham timKiem(String timSP)
    {
        if(timSP.startsWith("#sp")){
            for(SanPham sp:ds)
                if(sp.maSP.equals(timSP) && sp.isNotDeleted == true) 
                    return sp;
        }
        else{
            for(SanPham sp:ds)
                if (sp.tenSP.toLowerCase().contains(timSP.toLowerCase()) && sp.isNotDeleted == true) 
                    return sp;  
        }
        return null;
    }

    public void capNhatSoLuongSP(String maSP, int soLuong){
        for(SanPham sp:ds){
            if(sp.maSP.equals(maSP) && sp.isNotDeleted == true){
                SanPham.soLuongSP -= soLuong;
            }
        }
    }
}
