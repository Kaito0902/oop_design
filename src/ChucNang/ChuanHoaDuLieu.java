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

    public String chuanHoaEmail(String email) {
        while (true) {
            email = email.trim().replaceAll("\\s+", "");
            if (!email.contains(" ") // Không có dấu cách
            && email.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$") // Định dạng hợp lệ
            && !email.startsWith(".") && !email.endsWith(".") // Không bắt đầu/kết thúc bằng '.'
            && !email.startsWith("@") && !email.endsWith("@") // Không bắt đầu/kết thúc bằng '@'
            && email.indexOf('@') < email.lastIndexOf('.')) { // '@' nằm trước '.'
            return email; // Trả về email hợp lệ
        } else {
            System.out.println("Email không hợp lệ! Vui lòng nhập lại:");
            email = scanner.nextLine(); // Yêu cầu nhập lại
        }
        }
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