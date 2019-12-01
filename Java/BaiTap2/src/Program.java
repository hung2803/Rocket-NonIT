import java.time.LocalDate;

import java.util.Random;
import java.nio.file.DirectoryNotEmptyException;

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

			// ex2: Tạo ID của sinh viên: Tạo 10 ID của sinh viên. ID bao gồm
			// “SV” +
			// 7 số và ID của mỗi sinh viên là duy nhất.

			students[i].ID = "SV" + (random.nextInt(9999999 - 1000000 + 1) + 1000000);

			// ex3: Tạo 10 ngày sinh của sinh viên nằm trong khoảng 01/02/1991
			// và
			// 31/12/1991. Ngày sinh của mỗi sinh viên là duy nhất.

			int minDay = (int) LocalDate.of(1991, 02, 01).toEpochDay();
			int maxDay = (int) LocalDate.of(1991, 12, 30).toEpochDay();
			long randomDay = minDay + random.nextInt(maxDay - minDay);
			LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
			students[i].ngaySinh = randomBirthDate;

		}

		// Tạo điểm cho sinh viên theo 5 môn sau: phân tích yêu cầu, thiết kế
		// phần mềm, lập trình Java, Code và Unit Test, Management Tool.
		// Mỗi môn có chứa:
		// o 1 sinh viên có điểm từ 8 -> 10
		// o 3 sinh viên có điểm từ 5 -> 7
		// o 3 sinh viên có điểm từ 3 -> 4
		// o 2 sinh viên có điểm 1 hoặc 2
		// o 1 sinh viên có điểm 0

		Diem[] diems = new Diem[students.length];
		// create phanTichYeuCau
		int[] phanTichYeuCau = new int[students.length];
		phanTichYeuCau[0] = random.nextInt(10 - 8 + 1) + 8;
		phanTichYeuCau[1] = random.nextInt(7 - 5 + 1) + 5;
		phanTichYeuCau[2] = random.nextInt(7 - 5 + 1) + 5;
		phanTichYeuCau[3] = random.nextInt(7 - 5 + 1) + 5;
		phanTichYeuCau[4] = random.nextInt(4 - 3 + 1) + 3;
		phanTichYeuCau[5] = random.nextInt(4 - 3 + 1) + 3;
		phanTichYeuCau[6] = random.nextInt(4 - 3 + 1) + 3;
		phanTichYeuCau[7] = random.nextInt(2 - 1 + 1) + 1;
		phanTichYeuCau[8] = random.nextInt(2 - 1 + 1) + 1;
		phanTichYeuCau[9] = 0;

		// create thietKePhanMem
		int[] thietKePhanMem = new int[students.length];
		thietKePhanMem[0] = random.nextInt(10 - 8 + 1) + 8;
		thietKePhanMem[1] = random.nextInt(7 - 5 + 1) + 5;
		thietKePhanMem[2] = random.nextInt(7 - 5 + 1) + 5;
		thietKePhanMem[3] = random.nextInt(7 - 5 + 1) + 5;
		thietKePhanMem[4] = random.nextInt(4 - 3 + 1) + 3;
		thietKePhanMem[5] = random.nextInt(4 - 3 + 1) + 3;
		thietKePhanMem[6] = random.nextInt(4 - 3 + 1) + 3;
		thietKePhanMem[7] = random.nextInt(2 - 1 + 1) + 1;
		thietKePhanMem[8] = random.nextInt(2 - 1 + 1) + 1;
		thietKePhanMem[9] = 0;

		// create lapTrinhJava
		int[] lapTrinhJava = new int[students.length];
		lapTrinhJava[0] = random.nextInt(10 - 8 + 1) + 8;
		lapTrinhJava[1] = random.nextInt(7 - 5 + 1) + 5;
		lapTrinhJava[2] = random.nextInt(7 - 5 + 1) + 5;
		lapTrinhJava[3] = random.nextInt(7 - 5 + 1) + 5;
		lapTrinhJava[4] = random.nextInt(4 - 3 + 1) + 3;
		lapTrinhJava[5] = random.nextInt(4 - 3 + 1) + 3;
		lapTrinhJava[6] = random.nextInt(4 - 3 + 1) + 3;
		lapTrinhJava[7] = random.nextInt(2 - 1 + 1) + 1;
		lapTrinhJava[8] = random.nextInt(2 - 1 + 1) + 1;
		lapTrinhJava[9] = 0;

		// create codeVaUnitTest
		int[] codeVaUnitTest = new int[students.length];
		codeVaUnitTest[0] = random.nextInt(10 - 8 + 1) + 8;
		codeVaUnitTest[1] = random.nextInt(7 - 5 + 1) + 5;
		codeVaUnitTest[2] = random.nextInt(7 - 5 + 1) + 5;
		codeVaUnitTest[3] = random.nextInt(7 - 5 + 1) + 5;
		codeVaUnitTest[4] = random.nextInt(4 - 3 + 1) + 3;
		codeVaUnitTest[5] = random.nextInt(4 - 3 + 1) + 3;
		codeVaUnitTest[6] = random.nextInt(4 - 3 + 1) + 3;
		codeVaUnitTest[7] = random.nextInt(2 - 1 + 1) + 1;
		codeVaUnitTest[8] = random.nextInt(2 - 1 + 1) + 1;
		codeVaUnitTest[9] = 0;

		// create managementTool
		int[] managementTool = new int[students.length];
		managementTool[0] = random.nextInt(10 - 8 + 1) + 8;
		managementTool[1] = random.nextInt(7 - 5 + 1) + 5;
		managementTool[2] = random.nextInt(7 - 5 + 1) + 5;
		managementTool[3] = random.nextInt(7 - 5 + 1) + 5;
		managementTool[4] = random.nextInt(4 - 3 + 1) + 3;
		managementTool[5] = random.nextInt(4 - 3 + 1) + 3;
		managementTool[6] = random.nextInt(4 - 3 + 1) + 3;
		managementTool[7] = random.nextInt(2 - 1 + 1) + 1;
		managementTool[8] = random.nextInt(2 - 1 + 1) + 1;
		managementTool[9] = 0;

		for (int i = 0; i < diems.length; i++) {
			diems[i] = new Diem();
			diems[i].phanTichYeuCau = phanTichYeuCau[i];
			diems[i].lapTrinhJava = lapTrinhJava[i];
			diems[i].thietKePhanMem = thietKePhanMem[i];
			diems[i].codeVaUnitTest = codeVaUnitTest[i];
			diems[i].managementTool = managementTool[i];
		}

		for (int i = 0; i < diems.length; i++) {
			students[i].diem = diems[i];
		}

		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i].ID + " " + students[i].hoVaTen + " " + students[i].ngaySinh);
			System.out.println("phanTichYeuCau: " + students[i].diem.phanTichYeuCau);
			System.out.println("thietKePhanMem: " + students[i].diem.thietKePhanMem);
			System.out.println("lapTrinhJava: " + students[i].diem.lapTrinhJava);
			System.out.println("codeVaUnitTest: " + students[i].diem.codeVaUnitTest);
			System.out.println("managementTool: " + students[i].diem.managementTool);

		}

		// In thông tin của tất cả các sinh viên lên màn hình, bao gồm: Id, tên
		// đẩy đủ, ngày sinh
	}
}
