package ChucNang;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static main_project.oop_project.qlkh;
import static main_project.oop_project.qlnv;


public class ChuanHoaDuLieu {
    static Scanner scanner = new Scanner(System.in);
    // chuan hoa ten(chu cai viet hoa dau moi tu)
    public static String chuanHoaTen(String ten) {
        ten = ten.trim().replace("\\s+", " ");
        String[] words = ten.split(" ");
        StringBuilder chuanHoa = new StringBuilder();
        for (String word : words) {
            chuanHoa.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1).toLowerCase()).append(" ");
        }
        return chuanHoa.toString().trim();
    }

    public static String chuanHoaEmail(String email) {
        while (true) {
            email = email.trim().replaceAll("\\s+", "");
            if (!email.contains(" ") // Không có dấu cách
                    && email.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$") // Định dạng hợp lệ
                    && !email.startsWith(".") && !email.endsWith(".") // Không bắt đầu/kết thúc bằng '.'
                    && !email.startsWith("@") && !email.endsWith("@") // Không bắt đầu/kết thúc bằng '@'
                    && email.indexOf('@') < email.lastIndexOf('.')) { // '@' nằm trước '.'
                return email; // Trả về email hợp lệ
            } else {
                System.out.println("Email khong hop le! Vui long nhap lai:");
                email = scanner.nextLine(); // Yêu cầu nhập lại
            }
        }
    }

    // chuan hoa so dien thoai theo dinh dang (0xxxxxxxxx)
    public static String chuanHoaSoDienThoainv(String sdt) {
        while (true) {
            // Loại bỏ tất cả ký tự không phải số
            sdt = sdt.replaceAll("\\D", "");

            // Kiểm tra số điện thoại có đúng định dạng
            if (sdt.length() == 10 && sdt.charAt(0) == '0') {
                // Kiểm tra số điện thoại đã tồn tại hay chưa
                if (qlnv.timKiemNhanVien(sdt) != null) {
                    System.out.println("So dien thoai da ton tai! Vui long nhap so khac:");
                    sdt = scanner.nextLine(); // Nhập lại số điện thoại mới
                    continue;
                }
                return sdt; // Nếu hợp lệ và không trùng, trả về
            } else {
                System.out.println("So dien thoai khong hop le! Yeu cau nhap so dien thoai 10 chu so, bat dau bang so 0.");
                sdt = scanner.nextLine(); // Nhập lại số điện thoại mới
            }
        }
    }

    // chuan hoa so dien thoai danh cho khach hang
    public static String chuanHoaSoDienThoaikh(String sdt) {
        while (true) {
            // Loại bỏ tất cả ký tự không phải số
            sdt = sdt.replaceAll("\\D", "");

            // Kiểm tra số điện thoại có đúng định dạng
            if (sdt.length() == 10 && sdt.charAt(0) == '0') {
                // Kiểm tra số điện thoại đã tồn tại hay chưa
                if (qlkh.timkiemKhachHangTheoSdt(sdt) != null) {
                    System.out.println("So dien thoai da ton tai! Vui long nhap so khac:");
                    sdt = scanner.nextLine(); // Nhập lại số điện thoại mới
                    continue;
                }
                return sdt; // Nếu hợp lệ và không trùng, trả về
            } else {
                System.out.println("So dien thoai khong hop le! Yeu cau nhap so dien thoai 10 chu so, bat dau bang so 0.");
                sdt = scanner.nextLine(); // Nhập lại số điện thoại mới
            }
        }
    }

    // chuan hoa gioi tinh (Nam,Nu,Khac)
    public static String chuanHoaGioiTinh (String gioiTinh) {
        while (true) {
            gioiTinh = gioiTinh.trim().toLowerCase();

            if (gioiTinh.equals("nam")) {
                return "Nam";
            } else if (gioiTinh.equals("nu")) {
                return "Nu";
            } else if (gioiTinh.equals("khac")) {
                return "Khac";
            } else {
                System.out.println("Gioi tinh khong hop le! Vui long nhap lai:");
                gioiTinh = scanner.nextLine();
            }
        }
    }

    //chuan hoa ngaySinh localdate
    public static LocalDate chuanHoaNgayThangNam(String ngay) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return LocalDate.parse(ngay, formatter);
        } catch (Exception e) {
            System.out.println("Ngay sinh khong hop le! Vui long nhap lai");
            return null;
        }
    }

    public static int chuanHoaSoLieu(int soLieu){
        while (soLieu <= 0) {
            System.out.println("Nhap du lieu khong hop le.");
            System.out.println("Vui long nhap lai: ");
            soLieu = Integer.parseInt(scanner.nextLine());
        }
        return soLieu;
    }

    public static double chuanHoaSoLieu(double soLieu){
        while (soLieu < 0) {
            System.out.println("Nhap du lieu khong hop le.");
            System.out.println("Vui long nhap lai: ");
            soLieu = Integer.parseInt(scanner.nextLine());
        }
        return soLieu;
    }

}