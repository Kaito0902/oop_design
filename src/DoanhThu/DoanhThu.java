package DoanhThu;

import java.util.Scanner;

public class DoanhThu {
    protected double tongDoanhThu;
    protected String khoangThoiGian;
    public DoanhThu(){

    }
    public DoanhThu(double tongDoanhThu, String khoangThoiGian){
        this.tongDoanhThu = tongDoanhThu;
        this.khoangThoiGian = khoangThoiGian;
    }

    public void xuatDoanhThu(){
        System.out.println("Doanh thu: "+tongDoanhThu+"trong khoang");
    }
}
