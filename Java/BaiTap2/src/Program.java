import java.time.LocalDate;
import java.util.Random;

public class Program {
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
		Student[] students = new Student[10];
		Random random = new Random();
		int ho_number;
		int ten_number;
		int dem_number;

		for (int i = 0; i < students.length; i++) {
			students[i] = new Student();
			ho_number = random.nextInt(7);
			ten_number = random.nextInt(7);
			dem_number = random.nextInt(7);
			students[i].hoVaTen = ho[ho_number] + " " + dem[dem_number] + " " + ten[ten_number];
			
			students[i].ID = "SV"+ (random.nextInt(9999999 - 1000000 + 1) + 1000000);
			
			int minDay = (int) LocalDate.of(1991, 02, 01).toEpochDay();
			int maxDay = (int) LocalDate.of(1991, 12, 30).toEpochDay();
			long randomDay = minDay + random.nextInt(maxDay - minDay);
			LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
			students[i].ngaySinh = randomBirthDate;
		}
			// ex2: Tạo ID của sinh viên: Tạo 10 ID của sinh viên. ID bao gồm “SV” +
			// 7 số và ID của mỗi sinh viên là duy nhất.	
		
		
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i].ID +" "+students[i].hoVaTen + " "+ students[i].ngaySinh);
			
		}
		
	}
}
