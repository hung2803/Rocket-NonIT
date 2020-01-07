package com.vti.template.dto;

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

public class CandidateDto {

	String firstName;
	String lastName;
	String phone;
	String email;
	String password;
	String expInYear;
	String proSkill;

	enum role {
		ExperienceCandidate, FresherCandidate
	};

	enum GraduationRank {
		Excellence, Good, Fair, Poor
	}

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
	 * @return the expInYear.
	 */
	public String getExpInYear() {
		return expInYear;
	}

	/**
	 * @return the proSkill.
	 */
	public String getProSkill() {
		return proSkill;
	}

	public CandidateDto(String firstName, String lastName, String phone, String email, String password,
			String expInYear, String proSkill) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.expInYear = expInYear;
		this.proSkill = proSkill;
	}

}
