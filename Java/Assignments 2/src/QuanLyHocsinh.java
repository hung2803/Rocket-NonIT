import java.time.LocalDate;
import java.util.Random;

public class QuanLyHocsinh {
	public static void main(String[] args) {
		// ex1. Tạo tên của sinh viên:
		// a. Tạo 1 array có chứa 7 họ của sinh viên (tên của sinh viên không
		// chứa dấu)

		String[] ho = new String[7];

		ho[0] = "Dinh";
		ho[1] = "Trieu";
		ho[2] = "Ngo";
		ho[3] = "Tran";
		ho[4] = "Lang";
		ho[5] = "Luong";
		ho[6] = "Hoang";

		// b. Tạo 1 array có chứa 7 tên đệm của sinh viên (tên đệm của sinh viên
		// không chứa dấu)

		String[] dem = new String[7];

		dem[0] = "thanh";
		dem[1] = "ha";
		dem[2] = "hai";
		dem[3] = "lo";
		dem[4] = "hanh";
		dem[5] = "nhung";
		dem[6] = "hoang";

		// c. Tạo 1 array có chứa 7 tên của sinh viên (tên của sinh viên không
		// chứa dấu)

		String[] ten = new String[7];

		ten[0] = "Duc";
		ten[1] = "Chung";
		ten[2] = "Bao";
		ten[3] = "Chi";
		ten[4] = "Danh";
		ten[5] = "Duong";
		ten[6] = "Giang";

		// Tạo 10 tên đầy đủ của sinh viên (bao gồm 1 họ, 1 tên đệm và 1 tên) và
		// đặt chúng vào trong 1 array mới.
		// (Các tên phải khác nhau từng đôi một).
		String[] hoVaTen = new String[10];
		Random random = new Random();
		int ho_number;
		int ten_number;
		int dem_number;

		for (int i = 0; i < 10; i++) {
			ho_number = random.nextInt(7);
			ten_number = random.nextInt(7);
			dem_number = random.nextInt(7);
			hoVaTen[i] = ho[ho_number] + " " + dem[dem_number] + " " + ten[ten_number];
		}

		// ex2: Tạo ID của sinh viên: Tạo 10 ID của sinh viên. ID bao gồm “SV” +
		// 3 số và ID của mỗi sinh viên là duy nhất.

		String[] ID = new String[10];
		int ID_Number;
		for (int i = 0; i < 10; i++) {
			ID_Number = random.nextInt(9999999 - 1000000 + 1) + 1000000;
			ID[i] = "SV" + " " + ID_Number;
		}

		// ex3: Tạo 10 ngày sinh của sinh viên nằm trong khoảng 01/02/1991 và
		// 31/12/1991. Ngày sinh của mỗi sinh viên là duy nhất.
		LocalDate[] ngaySinh = new LocalDate[10];
		for (int i = 0; i < 10; i++) {
			int minDay = (int) LocalDate.of(1991, 02, 01).toEpochDay();
			int maxDay = (int) LocalDate.of(1991, 12, 30).toEpochDay();
			long randomDay = minDay + random.nextInt(maxDay - minDay);

			LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);

			ngaySinh[i] = randomBirthDate;

		}
		// In thông tin của tất cả các sinh viên lên màn hình, bao gồm: Id, tên
		// đẩy đủ, ngày sinh
		for (int i = 0; i < 10; i++) {
			System.out.println(ID[i] + " " + hoVaTen[i] + " " + ngaySinh[i]);
		}

	}
}
