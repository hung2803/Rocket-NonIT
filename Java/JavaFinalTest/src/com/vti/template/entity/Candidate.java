package com.vti.template.entity;

/**
 * This class is Candidate.
 * 
 * @Description: .
 * @author: NTHung
 * @create_date: Jan 6, 2020
 * @version: 1.0
 * @modifer: NTHung
 * @modifer_date: Jan 6, 2020
 */

public class Candidate {
	protected String firstName;
	protected String lastName;
	protected String phone;
	protected String email;
	protected String password;
	protected int idRole;

	/**
	 * @return the firstName.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the phone.
	 */
	public String getPhone() {
		return phone;
	}

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

	/**
	 * @return the idRole.
	 */
	public int getIdRole() {
		return idRole;
	}

	public Candidate(String firstName, String lastName, String phone, String email, String password, int idRole) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.idRole = idRole;
	}

	public Candidate() {
	}

}
