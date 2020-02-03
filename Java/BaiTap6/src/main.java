import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<GiaoSu> giaoSus = new ArrayList<>();

		System.out.print("Ban muon nhap bao nhieu giao su: ");
		int soLuongGiaoSu = scanner.nextInt();
		for (int i = 0; i < soLuongGiaoSu; i++) {
			System.out.println("Nhap thong tin giao su thu " + (i + 1) + " :");
			GiaoSu giaosu = new GiaoSu();
			giaosu.input();
			giaoSus.add(giaosu);
		}

		for (int i = 0; i < giaoSus.size(); i++) {
			System.out.println("Thong tin giao su thu " + (i + 1) + " la:");
			giaoSus.get(i).print();
		}

		// nhap can bo:
		List<CanBo> canBos = new ArrayList<>();
		System.out.println("Ban muon nhap bao nhieu can bo: ");
		int soLuongCanBo = scanner.nextInt();

		for (int i = 0; i < soLuongCanBo; i++) {
			System.out.println("Nhap Thong Tin Can Bo thu" + (i + 1) + " :");
			CanBo canbo = new CanBo();
			canbo.input();
			canBos.add(canbo);

		}

		for (int i = 0; i < canBos.size(); i++) {
			System.out.println("Thong tin can bo thu " + (i + 1) + ": ");
			canBos.get(i).print();
		}
		// assignment 7: search by name, department
		for (int i = 0; i < 5; i++) {

			System.out.println("Ten nhan vien ban muon tim la: ");
			String employeeName = scanner.next();

			System.out.println("Ten phong ban ban muon tim la: ");
			String phongBan = scanner.next();

			IFunction function = new FunctionImpl();
			function.search(canBos, employeeName, phongBan);
		}

		// Xuất ra danh sách tất cả các giáo sư và sắp xếp theo tên của họ.
		IFunction function = new FunctionImpl();
		function.sort(giaoSus);
	}

}
