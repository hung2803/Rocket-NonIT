import java.util.Scanner;

public class CanBo extends Truongdaihoc {
	private String department;
	private int workingTime;
	private Position position;

	public void input() {
		super.input();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Phong ban: ");
		department = scanner.nextLine();

		System.out.println("Thoi gian lam viec: ");
		workingTime = scanner.nextInt();

		System.out.println("Chuc Vu : 1--departmentHead  2--viceHead  3--staff ");
		switch (scanner.nextInt()) {
		case 1:
			position = Position.departmentHead;
			break;
		case 2:
			position = Position.viceHead;
			break;
		case 3:
			position = Position.staff;
			break;
		}
	}

	public void print() {
		super.print();
		setSalary();
		setAllowance();
		System.out.println("Phong ban: " + department);
		System.out.println("Thoi gian lam viec: " + workingTime);
		System.out.println("Chuc Vu: " + position);
		System.out.println("Salary: " + salary);
		System.out.println("Tien phu cap: " + allowance);
	}

	@Override
	public void setSalary() {
		salary = salaryMultiplier * 730 + allowance + workingTime * 30;
	}

	enum Position {
		departmentHead, viceHead, staff;
	}

	@Override
	public void setAllowance() {
		if (position == Position.departmentHead) {
			allowance = 2000;
		} else if (position == Position.viceHead) {
			allowance = 1000;
		} else {
			allowance = 500;
		}

	}

	public String getDepartment() {
		return department;
	}
	
	

}