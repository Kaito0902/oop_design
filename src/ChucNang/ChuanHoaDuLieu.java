package ChucNang;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ChuanHoaDuLieu {
    static Scanner scanner = new Scanner(System.in);
    // chuan hoa ten(chu cai viet hoa dau moi tu)
    public String chuanHoaTen(String ten) {
        ten = ten.trim().replace("\\s+", " ");
        String[] words = ten.split(" ");
        StringBuilder chuanHoa = new StringBuilder();
        for (String word : words) {
            chuanHoa.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1).toLowerCase()).append(" ");
        }
        return chuanHoa.toString().trim();
    }

    // chuan hoa so dien thoai theo dinh dang (0xxxxxxxxx)
    public String chuanHoaSoDienThoai (String sdt) {
        while (true) {
            sdt = sdt.replaceAll("\\D", "");
            if (sdt.length() == 10 && sdt.charAt(0) == '0') {
                return sdt;
            } else {
                System.out.println("Số điện thoại không hợp lệ! Yêu cầu nhập số điện thoại 10 chữ số, bắt đầu bằng số 0.");
                sdt = scanner.nextLine().replace("\\D", "");
            }
        }
    }
    // chuan hoa gioi tinh (Nam,Nu,Khac)
    public String chuanHoaGioiTinh (String gioiTinh) {
        while (true) {
            gioiTinh = gioiTinh.trim().toLowerCase();

            if (gioiTinh.equals("nam")) {
                return "Nam";
            } else if (gioiTinh.equals("nu") || gioiTinh.equals("nữ")) {
                return "Nữ";
            } else if (gioiTinh.equals("khac") || gioiTinh.equals("khác")) {
                return "Khác";
            } else {
                System.out.println("Giới tính không hợp lệ! Vui lòng nhập lại:");
                gioiTinh = scanner.nextLine();
            }
        }
    }

    //chuan hoa ngaySinh localdate
    public LocalDate chuanHoaNgaySinh(String ngaySinh) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return LocalDate.parse(ngaySinh, formatter);
        } catch (Exception e) {
            System.out.println("Ngày sinh không hợp lệ! Vui lòng nhập lại (định dạng: dd/MM/yyyy):");
            return null;
        }
    }

}