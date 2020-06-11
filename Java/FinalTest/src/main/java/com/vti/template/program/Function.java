package com.vti.template.program;

import java.util.Scanner;

import com.vti.template.controller.UserController;
import com.vti.template.dto.LoginInformationDto;
import com.vti.template.form.LoginForm;
import com.vti.template.form.UserForm;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NTHung
 * @create_date: Jan 6, 2020
 * @version: 1.0
 * @modifer: NTHung
 * @modifer_date: Jan 6, 2020
 */

public class Function {
	private UserController userController;
	private Scanner scanner;

	public Function() {
		userController = new UserController();
		scanner = new Scanner(System.in);
	}

	public void registerCandidate() {
		// register Experience
		System.out.println("*************REGISTER USER***************");
		while (true) {

			// input firstName
			System.out.println("Input FirstName: ");
			String firstName = scanner.nextLine();
			// input lastName
			System.out.println("Input LastName: ");
			String lastName = scanner.nextLine();

			// input email
			System.out.println("Input email: ");
			String email = scanner.nextLine();

			// input password
			System.out.println("Input Password: ");
			String password = scanner.nextLine();

			// phone
			System.out.println("Input Phone");
			String phone = scanner.nextLine();

			UserForm userForm = userController.registerUser(form);
		}
	}
}
