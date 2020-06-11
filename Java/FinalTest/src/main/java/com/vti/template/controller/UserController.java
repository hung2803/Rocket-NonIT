package com.vti.template.controller;

import java.sql.SQLException;

import com.vti.template.form.EmployeeForm;
import com.vti.template.form.ManagerForm;
import com.vti.template.form.UserForm;
import com.vti.template.service.UserServiceImpl;
import com.vti.template.service.UserSevice;

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

public class UserController {
	private UserSevice service;
 
	/**
	 * Constructor for class UserController.
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Jan 6, 2020
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Jan 6, 2020
	 */

	public UserController() {
		service = new UserServiceImpl();
	}

	public boolean registerUser(UserForm form) throws SQLException {
		if (form instanceof ManagerForm) {
			return service.registerManager((ManagerForm) form);
		} else {
			return service.registerEmployee((EmployeeForm) form);
		}
	}

}
