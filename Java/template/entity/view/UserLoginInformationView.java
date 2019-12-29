package com.vti.template.entity.view;

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

public class UserLoginInformationView {

	private String email;
	private String fullName;
	private String role;
	private boolean isBlock;

	/**
	 * @return the email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the fullName.
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @return the role.
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @return the isBlock.
	 */
	public boolean isBlock() {
		return isBlock;
	}

	public UserLoginInformationView(String email, String fullName, String role, boolean isBlock) {
		this.email = email;
		this.fullName = fullName;
		this.role = role;
		this.isBlock = isBlock;
	}

}
