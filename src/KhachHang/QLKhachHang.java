package KhachHang;
import java.util.Arrays;
import java.util.Scanner;
public class QLKhachHang {
    private KhachHang dskh[] = new KhachHang[0];
    static Scanner scanner = new Scanner(System.in);
    
    //non-parameted
    public QLKhachHang() {
    }

    public QLKhachHang(KhachHang[] dskh) {
        this.dskh = dskh;
    }

    void themKH(KhachHang kh)  {
        KhachHang[] newkh = Arrays.copyOf(this.dskh, this.dskh.length+1);
        newkh[this.dskh.length] = kh;
        this.dskh = newkh;
    }

    public void xuatdskh() {
        for ( var i : dskh )
            i.output();
    }

    public void menu() {
        
    }
}
