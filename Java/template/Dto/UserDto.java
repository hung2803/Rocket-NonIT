package com.vti.template.Dto;

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

public class UserDto {
	private int id;
	private String fullName;
	private String email;
	private String password;
	private int age;
	private String phoneNumber;
	private String address;
	private String role;

	/**
	 * 
	 * Constructor for class UserDto.
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Dec 24, 2019
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Dec 24, 2019
	 * @param user
	 */
	public UserDto(User user) {
		this.id = user.getID();
		this.fullName = user.getFullname();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.age = user.getAge();
		this.phoneNumber = user.getPhoneNumber();
		this.address = user.getAddress();
		this.role = user.getRole();
	}

	/**
	 * 
	 * Constructor for class UserDto.
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Dec 24, 2019
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Dec 24, 2019
	 * @param id
	 * @param email
	 * @param password
	 * @param age
	 * @param phoneNumber
	 * @param address
	 * @param role
	 */
	public UserDto(int id, String fullName, String email, String password, int age, String phoneNumber, String address,
			String role) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public int getAge() {
		return age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	/**
	 * @return the fullName.
	 */
	public String getFullName() {
		return fullName;
	}

	public String getRole() {
		return role;
	}

	public String toString() {
		String result = " ";
		if (fullName != null && !fullName.trim().isEmpty()) {
			result += "fullName: " + fullName + " ";
		}

		result += "age: " + age + " ";
		if (address != null && !address.trim().isEmpty()) {
			result += "Address: " + address + " ";
		}
		return result;
	}
}