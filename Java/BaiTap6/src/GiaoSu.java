
import java.util.Scanner;
import java.util.regex.Pattern;

public class GiaoSu extends Truongdaihoc implements Comparable {

	String faculty;
	AcademicDegree academicDegree;
	int monthlyTeachingTime;

	@Override
	public void input() {
		super.input();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nang Luc: ");
		faculty = scanner.nextLine();

		academicDegree = new AcademicDegree();

		System.out.println("bachelor: ");
		academicDegree.bachelor = scanner.nextLine();

		System.out.println("master: ");
		academicDegree.master = scanner.nextLine();

		System.out.println("doctor: ");
		academicDegree.doctor = scanner.nextLine();

		System.out.println("Thoi gian day hang thang: ");
		monthlyTeachingTime = scanner.nextInt();

	}

	@Override
	public void setSalary() {
		salary = salaryMultiplier * 730 + allowance + monthlyTeachingTime * 45;
	}

	@Override
	public void print() {
		super.print();
		setAllowance();
		setSalary();
		System.out.println("Nang Luc: " + faculty);
		System.out.println("Bang Cap: " + academicDegree);
		System.out.println("Thoi gian day hang thang: " + monthlyTeachingTime);
		System.out.println("Tien phu cap : " + allowance);
		System.out.println("Salary: " + salary);
	}

	@Override
	public void setAllowance() {

		if (academicDegree.doctor != null) {
			allowance = 1000;

		} else if (academicDegree.master != null) {
			allowance = 500;

		} else {
			allowance = 300;
		}
	}

	@Override
	public int compareTo(Object obj) {
		GiaoSu giaoSu = (GiaoSu) obj;

		String professionalName1 = reverseWords(fullName);
		String professionalName2 = reverseWords(giaoSu.fullName);

		return professionalName2.compareToIgnoreCase(professionalName1) * (-1);
	}

	String reverseWords(String str) {

		// Specifying the pattern to be searched
		Pattern pattern = Pattern.compile("\\s");

		// splitting String str with a pattern
		// (i.e )splitting the string whenever their
		// is whitespace and store in temp array.
		String[] temp = pattern.split(str);
		String result = "";

		// Iterate over the temp array and store
		// the string in reverse order.
		for (int i = 0; i < temp.length; i++) {
			if (i == temp.length - 1)
				result = temp[i] + result;
			else
				result = " " + temp[i] + result;
		}
		return result;
	}

}

class AcademicDegree {
	String bachelor;
	String master;
	String doctor;

	@Override
	public String toString() {
		String result = "";
		if (bachelor != null && !bachelor.isEmpty()) {
			result += "bachelor: " + bachelor + ", ";
		}
		if (master != null && !master.isEmpty()) {
			result += "master: " + master + ", ";
		}
		if (doctor != null && !doctor.isEmpty()) {
			result += "doctor: " + doctor;
		}
		return result;
	}

}
