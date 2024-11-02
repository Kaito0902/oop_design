package SanPham;

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
                    suaPhanTuTheoMa();
                    break;

                case 6:
                    xoaPhanTuTheoMa();
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
                    SanPham desktop = new Desktop();
                    desktop.nhap();
                    themSanPham(desktop);
                }

                else if(choiceMT.equalsIgnoreCase("Laptop"))
                {
                    SanPham laptop = new Laptop();
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
                System.out.println("Main Board - CPU - GPU - RAM - Bo Nho");
                String choicePC = sc.nextLine();

                if(choicePC.equalsIgnoreCase("CPU"))
                {
                    SanPham cpu = new CPU();
                    cpu.nhap();
                    themSanPham(cpu);
                }

                else if(choicePC.equalsIgnoreCase("GPU"))
                {
                    SanPham gpu = new GPU();
                    gpu.nhap();
                    themSanPham(gpu);
                }

                else if(choicePC.equalsIgnoreCase("RAM"))
                {
                    SanPham ram = new RAM();
                    ram.nhap();
                    themSanPham(ram);
                }

                else if(choicePC.equalsIgnoreCase("Bo Nho"))
                {
                    SanPham boNho = new BoNho();
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
                    SanPham chuot = new Chuot();
                    chuot.nhap();
                    themSanPham(chuot);
                }

                else if(choiceTB.equalsIgnoreCase("Man Hinh"))
                {
                    SanPham manHinh = new ManHinh();
                    manHinh.nhap();
                    themSanPham(manHinh);
                }

                else if(choiceTB.equalsIgnoreCase("Ban Phim"))
                {
                    SanPham banPhim = new BanPhim();
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

    public void nhapVaoFile()
    {

    }

    public void suaPhanTuTheoMa()
    {

    }

    public void xoaPhanTuTheoMa()
    {
        
    }

    public void timKiem()
    {

    }
}
