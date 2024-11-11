package ChuoiCungCap;

import java.util.Arrays;
import java.util.Scanner;

import DonDatHang.DonDatHang;

public class QLNhaCungCap {
    NhaCungCap [] dsncc = new NhaCungCap[0];
    static Scanner sc = new Scanner(System.in);

    public void themNCC(NhaCungCap a){
        NhaCungCap[] newdsncc = Arrays.copyOf(dsncc, dsncc.length+1);
        newdsncc[dsncc.length]= a;
        dsncc = newdsncc;
    }
    public void xuatNCC(){
        for(NhaCungCap a: dsncc){
            a.xuat();
        }
    } 
    public void xoaNhaCungCap(String maNCC) {
        boolean found = false;
        for (int i = 0; i < dsncc.length; i++) {
            if (dsncc[i].maNhaCungCap.equals(maNCC)) {
                for (int j = i; j < dsncc.length - 1; j++) {
                    dsncc[j] = dsncc[j + 1];
                }
                dsncc[dsncc.length - 1] = null;
                i--;
                found = true;
                System.out.println("Da xoa nha cung cap co ma: " + maNCC);
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay nha cung cap co ma nay: " + maNCC);
        }
    }
    public void timKiemNhaCungCapTheoChiPhi(double chiPhi) {
        boolean found = false;
        for (int i = 0; i < dsncc.length; i++) {
            if (dsncc[i].chiPhiNhapHang == chiPhi) {
                System.out.println(dsncc[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong co nha cung cap co phi nhap : " + chiPhi);
        }
    }
    public void sapXepNhaCungCapTheoChiPhi() {
        for (int i = 0; i < dsncc.length - 1; i++) {
            for (int j = i + 1; j < dsncc.length; j++) {
                if (dsncc[i].chiPhiNhapHang > dsncc[j].chiPhiNhapHang) {
                    NhaCungCap temp = dsncc[i];
                    dsncc[i] = dsncc[j];
                    dsncc[j] = temp;
                }
            }
        }
        System.out.println("Danh sach nha cung cap da duoc sap xep.");
    }
    public void laySoLuongNhaCungCap() {
        int count = 0;
        for (NhaCungCap hd  : dsncc) {
            if (hd != null) count++;
        }
        System.out.println("So luong nha cung cap: " + count);
    }

    public void menu() {
        int choice;
        do {
            System.out.println("===== Quan ly nha cung cap =====");
            System.out.println("1. Them nha cung cap");
            System.out.println("2. Xuat danh sach nha cung cap");
            System.out.println("3. Xoa nha cung cap");
            System.out.println("4.Tim kiem nha cung cap theo chi phí nhap hang");
            System.out.println("5. Sap xep nha cung cap theo chi phi nhap hang");
            System.out.println("6. Lay so luong nha cung cap");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon");
            choice = sc.nextInt();
            sc.nextLine(); // Đọc dòng mới sau khi nhập số

            switch (choice) {
                case 1:
                    NhaCungCap ncc = new NhaCungCap();
                    ncc.nhap();
                    themNCC(ncc);
                    break;
                case 2:
                    xuatNCC();
                    break;
                case 3:
                    System.out.print("Nhap ma nha cung cap can xoa ");
                    String maXoa = sc.nextLine();
                    xoaNhaCungCap(maXoa);
                    break;
                case 4:
                    System.out.print("Nhập chi phí cần tìm: ");
                    double chiPhiTimKiem = sc.nextDouble();
                    timKiemNhaCungCapTheoChiPhi(chiPhiTimKiem);
                    break;
                case 5:
                    sapXepNhaCungCapTheoChiPhi();
                    break;
                case 6:
                    laySoLuongNhaCungCap();
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        } while (choice != 0);
    }
}
