import java.util.Scanner;

public abstract class Truongdaihoc {
	protected String fullName;
	protected float allowance;
	protected float salaryMultiplier;
	protected float salary;

	public void input() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ten Day Du: ");
		fullName = scanner.nextLine();

		System.out.println("He so luong");
		salaryMultiplier = scanner.nextInt();

	}

	public void print() {
		System.out.println("Ten Day Du: " + fullName);
		System.out.println("He so luong: " + salaryMultiplier);

	}

	public abstract void setAllowance();

	public abstract void setSalary();

}
