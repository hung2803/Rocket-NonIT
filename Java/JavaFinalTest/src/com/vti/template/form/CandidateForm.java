package com.vti.template.form;

import com.vti.template.entity.Candidate;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NTHung
 * @create_date: Jan 7, 2020
 * @version: 1.0
 * @modifer: NTHung
 * @modifer_date: Jan 7, 2020
 */

public class CandidateForm {
	protected String firstName;
	protected String lastName;
	protected String phone;
	protected String email;
	protected String password;
	protected String roleName;

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
	 * @return the idrole.
	 */
	public String getRole() {
		return roleName;
	}

	public CandidateForm(String firstName, String lastName, String phone, String email, String password,
			String roleName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.roleName = roleName;
	}

	public Candidate toEntityCreate() {
		int idRole = 0;
		if (roleName.equals("ExperienceCandidate")) {
			idRole = 1;
		} else {
			idRole = 2;
		}
		return new Candidate(this.firstName, this.lastName, this.email, this.password, this.phone, idRole);
	}
}
