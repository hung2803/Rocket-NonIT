package com.vti.TestingSystem.entity;

public class TestingCategory {
	private Short idCategory;
	private String name;

	public TestingCategory(Short idCategory, String name) {

		this.idCategory = idCategory;
		this.name = name;
	}

	public Short getIdCategory() {
		return idCategory;
	}

	public TestingCategory setIdCategory(Short idCategory) {
		this.idCategory = idCategory;
		return this;
	}

	public String getName() {
		return name;
	}

	public TestingCategory setName(String name) {
		this.name = name;
		return this;
	}

}
