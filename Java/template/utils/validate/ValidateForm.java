package com.vti.template.utils.validate;

import com.vti.template.utils.form.CreateForm;
import com.vti.template.utils.form.LoginForm;

/**
 * This class is validate form.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Dec 24, 2019
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Dec 24, 2019
 */
public class ValidateForm {

	/**
	 * This method validate create form .
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
	public boolean isValidateCreateForm(CreateForm form) {

		if (null == form) {
			return false;
		}

		if (!Validate.isFullName(form.getFullName())) {
			return false;
		}

		if (!Validate.isEmail(form.getEmail())) {
			return false;
		}

		if (!Validate.isPassword(form.getPassword())) {
			return false;
		}

		if (!Validate.isAge(form.getAge())) {
			return false;
		}

		if (!Validate.isPhone(form.getPhoneNumber())) {
			return false;
		}

		if (!Validate.isAddress(form.getAddress())) {
			return false;
		}

		if (!Validate.isRole(form.getRole())) {
			return false;
		}

		return true;
	}

	public boolean isValidateLoginForm(LoginForm form) {
		if (!Validate.isEmail(form.getEmail())) {
			return false;
		}
		if (!Validate.isPassword(form.getPassword())) {
			return false;
		}
		return true;
	}

	public boolean isValidateBlockForm(String email) {
		if (!Validate.isEmail(email)) {
			return false;
		}
		return true;
	}

}
