import java.util.Random;

public class Assignments3 {
	public static void main(String[] args) {
		// Tạo điểm cho sinh viên theo 5 môn sau:
		// phân tích yêu cầu, thiết kế phần mềm, lập trình Java, Code và Unit
		// Test, Management Tool.
		// Mỗi môn có chứa:
		// o 1 sinh viên có điểm từ 8 --> 10
		// o 3 sinh viên có điểm từ 5 --> 7
		// o 3 sinh viên có điểm từ 3 --> 4
		// o 2 sinh viên có điểm 1 hoặc 2
		// o 1 sinh viên có điểm 0.

		Random random = new Random();
		String[] diem = new String[1];
		
		int phanTichYeuCau;
		for (int i = 0; i < 10; i++) {
			phanTichYeuCau = random.nextInt(10 - 8 + 1) + 8;
			diem[i] = diem[phanTichYeuCau];
			System.out.println(diem[i]);

		}
	}
}
