package ChucNang;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

    // chuan hoa so dien thoai theo dinh dang (0xxxxxxxxx)
    public static String chuanHoaSoDienThoai (String sdt) {
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
        LocalDate ngayParsed = null;

        while (ngayParsed == null) {
            try {
                // Parse ngày
                ngayParsed = LocalDate.parse(ngay, formatter);

                // Kiểm tra logic ngày
                int day = ngayParsed.getDayOfMonth();
                int month = ngayParsed.getMonthValue();
                int year = ngayParsed.getYear();

                // Số ngày tối đa của tháng
                int maxDays = YearMonth.of(year, month).lengthOfMonth();

                if (day > maxDays) {
                    throw new Exception("Ngày không hợp lệ trong tháng!");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Định dạng ngày tháng năm không hợp lệ! Vui lòng nhập lại.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if (ngayParsed == null) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Nhập lại ngày tháng năm (dd/MM/yyyy): ");
                    ngay = sc.nextLine();
                }
            }
        }

        return ngayParsed;
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