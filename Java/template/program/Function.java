package com.vti.template.program;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.vti.template.Controller.UserController;
import com.vti.template.Dto.UserDto;
import com.vti.template.Dto.UserLoginInformationDto;
import com.vti.template.utils.MessageUtil;
import com.vti.template.utils.ScannerUtil;
import com.vti.template.utils.form.CreateForm;
import com.vti.template.utils.form.LoginForm;
import com.vti.template.utils.validate.Validate;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NTHung
 * @create_date: Dec 25, 2019
 * @version: 1.0
 * @modifer: NTHung
 * @modifer_date: Dec 25, 2019
 */

public class Function {

	private UserController userController;
	private Scanner scanner;

	public Function() {
		userController = new UserController();
		scanner = new Scanner(System.in);
	}

	/**
	 * This method register .
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Dec 25, 2019
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Dec 25, 2019
	 */
	public void register() {

		// register
		CreateForm createForm = null;
		System.out.println("*************REGISTER****************");

		while (true) {

			// input fullName
			System.out.println("Input fullName: ");
			String fullName = ScannerUtil.readString(scanner, MessageUtil.VALIDATE_EMAIL_FORMAT);

			// input email
			System.out.println("Input email: ");
			String email = ScannerUtil.readString(scanner, MessageUtil.VALIDATE_EMAIL_FORMAT);

			// input password
			System.out.println("Input Password: ");
			String password = ScannerUtil.readString(scanner, MessageUtil.VALIDATE_PASSWORD_FORMAT);

			// input age
			System.out.println("Input Age");
			int age = ScannerUtil.readInt(scanner, MessageUtil.VALIDATE_AGE_FORMAT);

			// phone
			System.out.println("Input Phone");
			String phone = ScannerUtil.readString(scanner, MessageUtil.VALIDATE_PHONE_FORMAT);

			// address
			System.out.println("Input Address: ");
			String address = ScannerUtil.readString(scanner, MessageUtil.VALIDATE_ADDRESS_FORMAT);

			// input role
			String role = null;
			while (role == null) {
				System.out.println("Input Role: ");
				System.out.println("(nhap vao 1 la teacher, 2 la : student)");
				int roleInput = ScannerUtil.readInt(scanner, MessageUtil.VALIDATE_ROLE_FORMAT);
				switch (roleInput) {
				case 1:
					role = "Teacher";
					break;
				case 2:
					role = "UserLoginInformationView";
					break;
				default:
					Validate.showError("Ban chi co the nhap 1 hoac 2");
					break;
				}
			}

			createForm = new CreateForm(fullName, email, password, age, phone, address, role);
			System.out.println("nhap OK");

			boolean createResult = userController.createForm(createForm);
			if (createResult) {
				System.out.println("Create success");
				break;
			} else {
				System.out.println("Create fail! Exist User with email = " + email + "\nPlease! input again!");
			}
		}
	}

	/**
	 * This method is login.
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Dec 26, 2019
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Dec 26, 2019
	 */
	public void Login() {
		// login
		LoginForm loginForm = null;
		System.out.println("*************LOGIN****************");

		Map<String, Integer> loginCounts = new HashMap<>();
		int totalCount = 0;

		while (true) {
			// input fullName
			System.out.println("Input email: ");
			String email = ScannerUtil.readString(scanner, MessageUtil.VALIDATE_EMAIL_FORMAT);

			// input email
			System.out.println("Input password: ");
			String password = ScannerUtil.readString(scanner, MessageUtil.VALIDATE_PASSWORD_FORMAT);

			loginForm = new LoginForm(email, password);

			UserLoginInformationDto loginInformationDto = userController.login(loginForm);

			if (loginInformationDto != null) {
				if (loginInformationDto.isBlock()) {
					System.out.println("Email " + email + " is blocked");
				} else {
					// login success
					System.out.println("Login success, welcome " + loginInformationDto.getFullName());
					break;
				}
			} else {
				// login fail
				totalCount++;

				// nếu có email trong map rồi thì update count lên 1
				int updatedCount;
				if (loginCounts.containsKey(email)) {
					updatedCount = loginCounts.get(email) + 1;
				} else {
					// nếu không có email thì khởi tạo email có count = 0
					updatedCount = 0;
				}
				loginCounts.put(email, updatedCount);
				if (updatedCount == 2) {
					// block email
					System.out.println("Ban da bi block ");
					userController.blockUser(email);
					System.out.println("email: " + email + " is blocked");
				}

				switch (totalCount) {
				case 1:
					System.out.println("Dang nhap khong thanh cong ");
					break;
				case 2:
					System.out.println("Tai khoan hoac mat khau khong ton tai");
					break;
				case 3:
					System.out.println("Chuc ban may man lan sau ");
					break;
				case 4:
					System.out.println("Can than khong tao tat chuong trinh day ");
					break;
				case 5:
					System.out.println("Hen gap lai sau");
					return;
				}
			}
		}
	}

	public void ListStudent() {
		System.out.println("**********ORDER BY STUDENT************");
		System.out.println("Get All List Student and Order ");
		Scanner scanner = new Scanner(System.in);

		System.out.print("bạn muốn sắp xếp theo trường nào:\n " + "	1: FullName  \n" + "	2: Age \n" + "	3: Address");
		String column = " ";
		switch (ScannerUtil.readInt(scanner)) {
		case 1:
			column = "FullName";
			break;
		case 2:
			column = "Age";
			break;
		case 3:
			column = "Address";
			break;
		default:
			break;

		}
		if (column != null & !column.isEmpty()) {
			List<UserDto> userDto = userController.getAllStudentOrderBy(column);
			for (UserDto user : userDto) {
				System.out.println(user);

			}
		}
	}
}