package ChucNang;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import KhachHang.QLKhachHang;


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

    // chuan hoa so dien thoai danh cho khach hang
    public String chuanHoaSoDienThoai(String sdt, QLKhachHang qlkh) {
        while (true) {
            // Loại bỏ tất cả ký tự không phải số
            sdt = sdt.replaceAll("\\D", "");
    
            // Kiểm tra số điện thoại có đúng định dạng
            if (sdt.length() == 10 && sdt.charAt(0) == '0') {
                // Kiểm tra số điện thoại đã tồn tại hay chưa
                if (qlkh.timkiemKhachHangTheoSdt(sdt) != null) {
                    System.out.println("Số điện thoại đã tồn tại! Vui lòng nhập số khác:");
                    sdt = scanner.nextLine(); // Nhập lại số điện thoại mới
                    continue;
                }
                return sdt; // Nếu hợp lệ và không trùng, trả về
            } else {
                System.out.println("Số điện thoại không hợp lệ! Yêu cầu nhập số điện thoại 10 chữ số, bắt đầu bằng số 0.");
                sdt = scanner.nextLine(); // Nhập lại số điện thoại mới
            }
        }
    }

    // chuan hoa gioi tinh (Nam,Nu,Khac)
    public String chuanHoaGioiTinh (String gioiTinh) {
        while (true) {
            gioiTinh = gioiTinh.trim().toLowerCase();
            
            if (gioiTinh.equals("nam")) {
                return "Nam";
            } else if (gioiTinh.equals("nu")) {
                return "Nu";
            } else if (gioiTinh.equals("khac")) {
                return "Khac";
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