package com.vti.template.utils.form;

import com.vti.template.entity.User;

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

public class CreateForm {
	private String fullName;
	private String email;
	private String password;
	private int age;
	private String phoneNumber;
	private String address;
	private String role;

	/**
	 * Constructor for class CreateForm.
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Dec 25, 2019
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Dec 25, 2019
	 * @param email
	 * @param password
	 * @param age
	 * @param phoneNumber
	 * @param address
	 * @param role
	 */
	public CreateForm(String fullName, String email, String password, int age, String phoneNumber, String address,
			String role) {
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.role = role;
	}

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
	 * @return the password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the age.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return the phoneNumber.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @return the address.
	 */
	public String getAddress() {
		return address;
	}

	public String getRole() {
		return role;
	}

	public User toEntityCreate() {
		return new User(this.fullName, this.email, this.password, this.age, this.phoneNumber, this.address, this.role);
	}
}
