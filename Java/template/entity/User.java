package com.vti.template.entity;

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

public class User {
	private int ID;
	private String fullname;
	private String email;
	private String password;
	private int age;
	private String phoneNumber;
	private String address;
	private String role;

	/**
	 * 
	 * Constructor for class User.
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Dec 24, 2019
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Dec 24, 2019
	 * @param iD
	 * @param email
	 * @param password
	 * @param age
	 * @param phoneNumber
	 * @param address
	 * @param role
	 */
	public User(String fullName, String email, String password, int age, String phoneNumber, String address,
			String role) {
		this.fullname = fullName;
		this.email = email;
		this.password = password;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.role = role;
	}

	public User(String fullName, String email, int age, String address) {
		this.fullname = fullName;
		this.email = email;
		this.address = address;
		this.age = age;
		
	}

	/**
	 * @return the iD.
	 */
	public int getID() {
		return ID;
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

	/**
	 * @return the role.
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @return the fullname.
	 */
	public String getFullname() {
		return fullname;
	}

}