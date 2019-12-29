package com.vti.template.Dto;

import com.vti.template.entity.view.UserLoginInformationView;

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

public class UserLoginInformationDto {
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

	public UserLoginInformationDto(boolean isBlock) {
		this.isBlock = isBlock;
	}

	public UserLoginInformationDto(String email, String fullName, String role) {
		this.email = email;
		this.fullName = fullName;
		this.role = role;
	}

	public UserLoginInformationDto(UserLoginInformationView user) {
		this.email = user.getEmail();
		this.fullName = user.getFullName();
		this.role = user.getRole();
	}

}
