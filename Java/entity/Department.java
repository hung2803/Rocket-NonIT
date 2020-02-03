package com.vti.TestingSystem.entity;

public class Department {
	private Short idDepartment;
	private String name;

	public Department(Short idDepartment, String name) {
		this.idDepartment = idDepartment;
		this.name = name;
	}

	public Short getIdDepartment() {
		return idDepartment;
	}

	public Department setIdDepartment(Short idDepartment) {
		this.idDepartment = idDepartment;
		return this;
	}

	public String getName() {
		return name;
	}

	public Department setName(String name) {
		this.name = name;
		return this;
	}

}
