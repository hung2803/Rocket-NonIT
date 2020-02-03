package com.vti.TestingSystem.entity;

import java.util.Date;

public class User {
	private Short idUser;
	private String account;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private Date dateOfBirth;
	private String address;
	private String phone;
	private String gender;
	private String role;
	private Short idDepartment;
	private boolean status;

	public User(Short id, String account, String password, String firstName, String lastName, String email,
			Date dateOfBirth, String address, String phone, String gender, String role, Short idDepartment,
			boolean status) {
		this.idUser = id;
		this.account = account;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
		this.role = role;
		this.idDepartment = idDepartment;
		this.status = status;
	}

	public Short getId() {
		return idUser;
	}

	public User setId(Short id) {
		this.idUser = id;
		return this;
	}

	public String getAccount() {
		return account;
	}

	public User setAccount(String account) {
		this.account = account;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public User setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public User setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public User setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public User setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public User setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getGender() {
		return gender;
	}

	public User setGender(String gender) {
		this.gender = gender;
		return this;
	}

	public String getRole() {
		return role;
	}

	public User setRole(String role) {
		this.role = role;
		return this;
	}

	public Short getIdDepartment() {
		return idDepartment;
	}

	public User setIdDepartment(Short idDepartment) {
		this.idDepartment = idDepartment;
		return this;
	}

	public User isStatus() {
		return this;
	}

	public User setStatus(boolean status) {
		this.status = status;
		return this;
	}

}
