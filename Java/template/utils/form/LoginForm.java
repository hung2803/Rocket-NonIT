package com.vti.template.utils.form;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NTHung
 * @create_date: Dec 26, 2019
 * @version: 1.0
 * @modifer: NTHung
 * @modifer_date: Dec 26, 2019
 */

public class LoginForm {
	private String email;
	private String password;

	/**
	 * @return the email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the password.
	 */
	public String getPassword() {
		return password;
	}

	public LoginForm(String email, String password) {
		this.email = email;
		this.password = password;
	}

}
