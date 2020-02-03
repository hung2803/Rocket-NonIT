package com.vti.TestingSystem.entity;

public class QuestionCategory {
	private Short id;
	private String name;
	private Short categoryId;

	public QuestionCategory(Short id, String name, Short categoryId) {
		this.id = id;
		this.name = name;
		this.categoryId = categoryId;
	}

	public Short getId() {
		return id;
	}

	public QuestionCategory setId(Short id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public QuestionCategory setName(String name) {
		this.name = name;
		return this;
	}

	public Short getCategoryId() {
		return categoryId;
	}

	public QuestionCategory setCategoryId(Short categoryId) {
		this.categoryId = categoryId;
		return this;
	}

}
