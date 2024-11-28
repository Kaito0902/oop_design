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
                    int soLuongXuat = Integer.parseInt(data[7]);
                    int soLuongTonKho = Integer.parseInt(data[8]);
                    boolean isNotDeleted = Boolean.parseBoolean(data[9]);
                    String loaiSP = data[10];

                    if("Desktop".equals(loaiSP)){
                        String nhaSanXuat = data[11];
                        String model = data[12];
                        String heDieuHanh = data[13];
                        String coCardRoi = data[14];
                        String casePC = data[15];
                        String tanNhiet = data[16];

                        String loaiLinhKien1 = data[17];
                        String nhaSanXuat1 = data[18];
                        String model1 = data[19];
                        int soNhan = Integer.parseInt(data[20]);
                        int soLuongLoi = Integer.parseInt(data[21]);
                        float tanSoTurBo = Float.parseFloat(data[22]);

                        CPU cpu = new CPU("", "",0, "", 0, "", 0, 0, 0, true, loaiLinhKien1, nhaSanXuat1, model1, soNhan, soLuongLoi, tanSoTurBo);
                        SanPham.soLuongSP--;

                        String loaiLinhKien2 = data[23];
                        String nhaSanXuat2 = data[24];
                        String model2 = data[25];
                        int dungLuongVRAM = Integer.parseInt(data[26]);
                        String loaiVRAM = data[27];
                        float tocDoXungNhip = Float.parseFloat(data[28]);
                        int soNhanCUDA = Integer.parseInt(data[29]);
                        String rayTracing = data[30];

                        GPU gpu = new GPU("", "", 0, "", 0, "",0, 0, 0, true, loaiLinhKien2, nhaSanXuat2, model2, dungLuongVRAM, loaiVRAM, tocDoXungNhip, soNhanCUDA, rayTracing);
                        SanPham.soLuongSP--;

                        String loaiLinhKien3 = data[31];
                        String nhaSanXuat3 = data[32];
                        String model3 = data[33];
                        int dungLuongRAM = Integer.parseInt(data[34]);
                        String loaiRAM = data[35];

                        RAM ram = new RAM("", "", 0, "", 0, "", 0, 0, 0, true, loaiLinhKien3, nhaSanXuat3, model3, dungLuongRAM, loaiRAM);
                        SanPham.soLuongSP--;

                        String loaiLinhKien4 = data[36];
                        String nhaSanXuat4 = data[37];
                        String model4 = data[38];
                        int dungLuongBoNho = Integer.parseInt(data[39]);
                        String loaiBoNho = data[40];

                        BoNho boNho = new BoNho("", "", 0, "", 0, "", 0, 0, 0, true, loaiLinhKien4, nhaSanXuat4, model4, dungLuongBoNho, loaiBoNho);
                        SanPham.soLuongSP--;

                        PhanCung[] cacLinhKien = new PhanCung[4];
                        cacLinhKien[0] = cpu;
                        cacLinhKien[1] = gpu;
                        cacLinhKien[2] = ram;
                        cacLinhKien[3] = boNho;

                        Desktop desktop = new  Desktop(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, soLuongNhap, soLuongXuat, soLuongTonKho, isNotDeleted , loaiSP, nhaSanXuat, model, heDieuHanh, coCardRoi, cacLinhKien,casePC,tanNhiet);
                        themSanPham(desktop);
                    }

                    else if("Laptop".equals(loaiSP)){
                        String nhaSanXuat = data[11];
                        String model = data[12];
                        String heDieuHanh = data[13];
                        String coCardRoi = data[14];
                        String kichThuocManHinh = data[15];
                        float thoiLuongPin = Float.parseFloat(data[16]);
                        String loaiLaptop = data[17];

                        String loaiLinhKien1 = data[18];
                        String nhaSanXuat1 = data[19];
                        String model1 = data[20];
                        int soNhan = Integer.parseInt(data[21]);
                        int soLuongLoi = Integer.parseInt(data[22]);
                        float tanSoTurBo = Float.parseFloat(data[23]);

                        CPU cpu = new CPU("", "", 0, "", 0, "", 0, 0, 0, true, loaiLinhKien1, nhaSanXuat1, model1, soNhan, soLuongLoi, tanSoTurBo);
                        SanPham.soLuongSP--;

                        String loaiLinhKien2 = data[24];
                        String nhaSanXuat2 = data[25];
                        String model2 = data[26];
                        int dungLuongVRAM = Integer.parseInt(data[27]);
                        String loaiVRAM = data[28];
                        float tocDoXungNhip = Float.parseFloat(data[29]);
                        int soNhanCUDA = Integer.parseInt(data[30]);
                        String rayTracing = data[31];

                        GPU gpu = new GPU("", "", 0, "", 0, "", 0, 0, 0, true, loaiLinhKien2, nhaSanXuat2, model2, dungLuongVRAM, loaiVRAM, tocDoXungNhip, soNhanCUDA, rayTracing);
                        SanPham.soLuongSP--;

                        String loaiLinhKien3 = data[32];
                        String nhaSanXuat3 = data[33];
                        String model3 = data[34];
                        int dungLuongRAM = Integer.parseInt(data[35]);
                        String loaiRAM = data[36];

                        RAM ram = new RAM("", "", 0, "", 0, "", 0, 0, 0, true, loaiLinhKien3, nhaSanXuat3, model3, dungLuongRAM, loaiRAM);
                        SanPham.soLuongSP--;

                        String loaiLinhKien4 = data[37];
                        String nhaSanXuat4 = data[38];
                        String model4 = data[39];
                        int dungLuongBoNho = Integer.parseInt(data[40]);
                        String loaiBoNho = data[41];

                        BoNho boNho = new BoNho("", "", 0, "", 0, "", 0, 0, 0, true, loaiLinhKien4, nhaSanXuat4, model4, dungLuongBoNho, loaiBoNho);
                        SanPham.soLuongSP--;

                        PhanCung[] cacLinhKien = new PhanCung[4];
                        cacLinhKien[0] = cpu;
                        cacLinhKien[1] = gpu;
                        cacLinhKien[2] = ram;
                        cacLinhKien[3] = boNho;

                        Laptop laptop = new Laptop(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, soLuongNhap, soLuongXuat, soLuongTonKho, isNotDeleted, loaiSP, nhaSanXuat, model, heDieuHanh, coCardRoi, cacLinhKien, kichThuocManHinh, thoiLuongPin, loaiLaptop);
                        themSanPham(laptop);
                    }

                    else if("CPU".equals(loaiSP)){
                        String nhaSanXuat = data[11];
                        String model = data[12];
                        int soNhan = Integer.parseInt(data[13]);
                        int soLuongLoi = Integer.parseInt(data[14]);
                        float tanSoTurBo = Float.parseFloat(data[15]);

                        CPU cpu = new CPU(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, soLuongNhap, soLuongXuat, soLuongTonKho, isNotDeleted,loaiSP, nhaSanXuat, model, soNhan, soLuongLoi, tanSoTurBo);
                        themSanPham(cpu);
                    }

                    else if("GPU".equals(loaiSP)){
                        String nhaSanXuat = data[11];
                        String model = data[12];
                        int dungLuongVRAM = Integer.parseInt(data[13]);
                        String loaiVRAM = data[14];
                        float tocDoXungNhip = Float.parseFloat(data[15]);
                        int soNhanCUDA = Integer.parseInt(data[16]);
                        String rayTracing = data[17];
                        GPU gpu = new GPU(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, soLuongNhap, soLuongXuat, soLuongTonKho, isNotDeleted, loaiSP, nhaSanXuat, model, dungLuongVRAM, loaiVRAM, tocDoXungNhip, soNhanCUDA, rayTracing);
                        themSanPham(gpu);
                    }

                    else if("RAM".equals(loaiSP)){
                        String nhaSanXuat = data[11];
                        String model = data[12];
                        int dungLuongRAM = Integer.parseInt(data[13]);
                        String loaiRAM = data[14];
                        RAM ram = new RAM(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, soLuongNhap, soLuongXuat, soLuongTonKho, isNotDeleted, loaiSP, nhaSanXuat, model, dungLuongRAM, loaiRAM);
                        themSanPham(ram);
                    }

                    else if("Bo Nho".equals(loaiSP)){
                        String nhaSanXuat = data[11];
                        String model = data[12];
                        int dungLuongBoNho = Integer.parseInt(data[13]);
                        String loaiBoNho = data[14];

                        BoNho boNho = new BoNho(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, soLuongNhap, soLuongXuat, soLuongTonKho, isNotDeleted, loaiSP, nhaSanXuat, model, dungLuongBoNho, loaiBoNho);
                        themSanPham(boNho);
                    }

                    else if("Chuot".equals(loaiSP)){
                        String nhaSanXuat = data[11];
                        String phuongThucKetNoi = data[12];
                        int dPI = Integer.parseInt(data[13]);
                        String denLED = data[14];

                        Chuot chuot = new Chuot(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, soLuongNhap, soLuongXuat, soLuongTonKho, isNotDeleted, loaiSP, nhaSanXuat, phuongThucKetNoi, dPI, denLED);
                        themSanPham(chuot);
                    }

                    else if("Man Hinh".equals(loaiSP)){
                        String nhaSanXuat = data[11];
                        String phuongThucKetNoi = data[12];
                        String kieuManHinh = data[13];
                        String kichThuoc = data[14];
                        int tanSoQuet = Integer.parseInt(data[15]);
                        String tamNen = data[16];
                        String doPhanGiai = data[17];

                        ManHinh manHinh = new ManHinh(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, soLuongNhap, soLuongXuat, soLuongTonKho, isNotDeleted, loaiSP, nhaSanXuat, phuongThucKetNoi, kieuManHinh, kichThuoc, tamNen, doPhanGiai, tanSoQuet);
                        themSanPham(manHinh);
                    }

                    else if("Ban Phim".equals(loaiSP)){
                        String nhaSanXuat = data[11];
                        String phuongThucKetNoi = data[12];
                        String denLED = data[13];
                        String switchBP = data[14];
                        BanPhim banPhim = new BanPhim(maSP, tenSP, giaSP, thoiGianBaoHanhSP, trongLuongSP, mauSacSP, soLuongNhap, soLuongXuat, soLuongTonKho, isNotDeleted, loaiSP, nhaSanXuat, phuongThucKetNoi, denLED, switchBP);
                        themSanPham(banPhim);
                    }
                }
            }
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
                String.valueOf(sp.getSoLuongXuat()),
                String.valueOf(sp.getSoLuongTonKho()),
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
        }
        catch (IOException e){
            System.out.println("Khong nhap duoc file.");
        }
    }

    public void suaPhanTuTheoMa(String maSP)
    {
        for(var sp:ds){
            if(sp.maSP.equals(maSP) && sp.isNotDeleted){
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
            if(sp.maSP.equals(maSP) && sp.isNotDeleted){
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
                if(sp.maSP.equals(timSP) && sp.isNotDeleted)
                    return sp;
        }
        else{
            for(SanPham sp:ds)
                if (sp.tenSP.toLowerCase().contains(timSP.toLowerCase()) && sp.isNotDeleted)
                    return sp;  
        }
        return null;
    }

    public void nhapSanPhamTuDonDatHang(String maSP, int soLuong){
        for(SanPham sp:ds){
            if(sp.maSP.equals(maSP) && sp.isNotDeleted){
                sp.soLuongNhap += soLuong;
            }
        }
    }

    public SanPham nhapSanPham() {
        while (true) {
            System.out.println("Ban muon nhap loai san pham nao: ");
            System.out.println("May Tinh - Phan Cung - Thiet Bi Ngoai Vi");
            String choiceSP = sc.nextLine();

            if (choiceSP.equalsIgnoreCase("May Tinh")) {
                while (true) {
                    System.out.println("Ban muon nhap loai may tinh nao: ");
                    System.out.println("Desktop - Laptop");
                    String choiceMT = sc.nextLine();

                    if (choiceMT.equalsIgnoreCase("Desktop")) {
                        Desktop desktop = new Desktop();
                        desktop.loaiMayTinh = "Desktop";
                        desktop.nhap();
//                        themSanPham(desktop);
                        return desktop;
                    } else if (choiceMT.equalsIgnoreCase("Laptop")) {
                        Laptop laptop = new Laptop();
                        laptop.loaiMayTinh = "Laptop";
                        laptop.nhap();
//                        themSanPham(laptop);
                        return laptop;
                    } else {
                        System.out.println("Loai may tinh khong ton tai. Vui long nhap lai.");
                    }
                }
            } else if (choiceSP.equalsIgnoreCase("Phan Cung")) {
                while (true) {
                    System.out.println("Ban muon nhap loai linh kien nao: ");
                    System.out.println("CPU - GPU - RAM - Bo Nho");
                    String choicePC = sc.nextLine();

                    if (choicePC.equalsIgnoreCase("CPU")) {
                        CPU cpu = new CPU();
                        cpu.loaiLinhKien = "CPU";
                        cpu.nhap();
//                        themSanPham(cpu);
                        return cpu;
                    } else if (choicePC.equalsIgnoreCase("GPU")) {
                        GPU gpu = new GPU();
                        gpu.loaiLinhKien = "GPU";
                        gpu.nhap();
//                        themSanPham(gpu);
                        return gpu;
                    } else if (choicePC.equalsIgnoreCase("RAM")) {
                        RAM ram = new RAM();
                        ram.loaiLinhKien = "RAM";
                        ram.nhap();
//                        themSanPham(ram);
                        return ram;
                    } else if (choicePC.equalsIgnoreCase("Bo Nho")) {
                        BoNho boNho = new BoNho();
                        boNho.loaiLinhKien = "Bo Nho";
                        boNho.nhap();
//                        themSanPham(boNho);
                        return boNho;
                    } else {
                        System.out.println("Loai linh kien khong ton tai. Vui long nhap lai.");
                    }
                }
            } else if (choiceSP.equalsIgnoreCase("Thiet Bi Ngoai Vi")) {
                while (true) {
                    System.out.println("Ban muon nhap thiet bi nao: ");
                    System.out.println("Chuot - Man Hinh - Ban Phim");
                    String choiceTB = sc.nextLine();

                    if (choiceTB.equalsIgnoreCase("Chuot")) {
                        Chuot chuot = new Chuot();
                        chuot.loaiThietBi = "Chuot";
                        chuot.nhap();
//                        themSanPham(chuot);
                        return chuot;
                    } else if (choiceTB.equalsIgnoreCase("Man Hinh")) {
                        ManHinh manHinh = new ManHinh();
                        manHinh.loaiThietBi = "Man Hinh";
                        manHinh.nhap();
//                        themSanPham(manHinh);
                        return manHinh;
                    } else if (choiceTB.equalsIgnoreCase("Ban Phim")) {
                        BanPhim banPhim = new BanPhim();
                        banPhim.loaiThietBi = "Ban Phim";
                        banPhim.nhap();
//                        themSanPham(banPhim);
                        return banPhim;
                    } else {
                        System.out.println("Loai thiet bi khong ton tai. Vui long nhap lai.");
                    }
                }
            } else {
                System.out.println("Loai san pham khong ton tai. Vui long nhap lai.");
            }
        }
    }
}
