package HoaDon;

import java.util.Arrays;
import java.util.Scanner;

import SanPham.SanPham;

public class QLHoaDon {
    HoaDon [] dshd = new HoaDon[0];
    static Scanner sc = new Scanner(System.in);

    public void themHD(HoaDon hd){
        HoaDon[] newdshd = Arrays.copyOf(dshd, dshd.length+1);
        newdshd[dshd.length]= hd;
        dshd = newdshd;
    }


    public void xuatdshd(){
        for(HoaDon x :dshd){
            x.xuat();
        }
    }

    //tìm kiếm theo tên khach hang
    public void timKiemHoaDon() {
        System.out.print("Nhập tên khách hàng cần tìm: ");
        String tenKhachHang = sc.nextLine();
        boolean found = false;

        for (HoaDon hd : dshd) {
            if (hd != null && hd.khachHang.equalsIgnoreCase(tenKhachHang)) {
                System.out.println("Hóa đơn tìm thấy: " + hd);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy hóa đơn cho khách hàng có tên: " + tenKhachHang);
        }
    }

    //sap xep theo ten gia tien tăng dan
    public void sapXep() {
        Arrays.sort(dshd, (hd1, hd2) -> {
            if (hd1 == null) return 1;
            if (hd2 == null) return -1;
            return Double.compare(hd2.tongSoTien, hd1.tongSoTien); // So sánh theo giá tiền giảm dần
        });
        System.out.println("Danh sách hóa đơn đã được sắp xếp theo giá tiền (giảm dần).");
    }
    

    public void laySLHoaDon() {
        int count = 0;
        for (HoaDon hd : dshd) {
            if (hd != null) count++;
        }
        System.out.println("Số lượng hóa đơn hiện tại: " + count);
    }

    

    public void menu(){
        boolean kt = true;
        int choice;
        do{
        System.out.println("===================================");
        System.out.println("|\t        MENU CHINH         \t|");
        System.out.println("===================================");
        System.out.printf("| %-31s|\n", "1. Them hoa don");
        System.out.printf("| %-31s|\n", "2. Xuat danh sach hoa don");
        System.out.printf("| %-31s|\n", "3. Tim kiem 1 kh");
        System.out.printf("| %-31s|\n", "4. Sap xep dshd theo gia tien ");
        System.out.printf("| %-31s|\n", "5. Lay so luong hoa don");
        System.out.printf("| %-31s|\n", "0. Thoat chuong trinh");
        System.out.println("===================================");
        System.out.print("Nhap lua chon: ");
        choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                HoaDon a =new HoaDon();
                a.input();
                themHD(a); 
                break;
        
            case 2:
                System.out.println("Danh sach hoa don");
                xuatdshd();
                break;
            
            case 3:
                timKiemHoaDon();
                break;

            case 4:
                sapXep();
                break;
            case 5:
                laySLHoaDon();
                break;
            case 0:
                kt= false;
                System.out.println("Da thoat");
            default:
                System.out.println("Cu phap khong hop le");
            
                
        }
    
    
    }
        while(kt);

    }





}
