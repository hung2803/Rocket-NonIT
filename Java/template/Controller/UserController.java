package com.vti.template.Controller;

import java.util.List;

import com.vti.template.Dto.UserDto;
import com.vti.template.Dto.UserLoginInformationDto;
import com.vti.template.service.UserSevice;
import com.vti.template.service.UserSeviceImpl;
import com.vti.template.utils.form.CreateForm;
import com.vti.template.utils.form.LoginForm;
import com.vti.template.utils.validate.ValidateForm;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NTHung
 * @create_date: Dec 24, 2019
 * @version: 1.0
 * @modifer: NTHung
 * @modifer_date: Dec 24, 2019
 */

public class UserController {

	private UserSevice service;
	private ValidateForm validate;

	/**
	 * Constructor for class UserController.
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Dec 25, 2019
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Dec 25, 2019
	 */
	public UserController() {
		service = new UserSeviceImpl();
		validate = new ValidateForm();
	}

	/**
	 * This method is create form.
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Dec 25, 2019
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Dec 25, 2019
	 * @param form
	 * @return
	 */
	public boolean createForm(CreateForm form) {
		if (validate.isValidateCreateForm(form)) {
			return service.createUser(form);
		}
		return false;
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
	 * @param form
	 * @return
	 */
	public UserLoginInformationDto login(LoginForm form) {
		if (validate.isValidateLoginForm(form)) {
			return service.login(form);
		}
		return null;
	}

	/**
	 * This method is block User .
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Dec 26, 2019
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Dec 26, 2019
	 * @param email
	 */
	public void blockUser(String email) {
		if (validate.isValidateBlockForm(email)) {
			service.blockUser(email);
		}
	}

	public List<UserDto> getAllStudentOrderBy(String column) {
		return service.getAllStudentOrderBy(column);
	}
}
