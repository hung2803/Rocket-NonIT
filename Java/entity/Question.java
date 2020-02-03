package com.vti.TestingSystem.entity;

public class Question {

	private Short idQuestion;
	private String title;
	private Short categoryId;
	private String author;
	private boolean status;
	private Short levelId;

	public Question(Short idQuestion, String title, Short categoryId, String author, boolean status, Short levelId) {
		this.idQuestion = idQuestion;
		this.title = title;
		this.categoryId = categoryId;
		this.author = author;
		this.status = status;
		this.levelId = levelId;
	}

	public Short getIdQuestion() {
		return idQuestion;
	}

	public Question setIdQuestion(Short idQuestion) {
		this.idQuestion = idQuestion;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Question setTitle(String title) {
		this.title = title;
		return this;
	}

	public Short getCategoryId() {
		return categoryId;
	}

	public Question setCategoryId(Short categoryId) {
		this.categoryId = categoryId;
		return this;
	}

	public String getAuthor() {
		return author;
	}

	public Question setAuthor(String author) {
		this.author = author;
		return this;
	}

	public boolean isStatus() {
		return status;
	}

	public Question setStatus(boolean status) {
		this.status = status;
		return this;
	}

	public Short getLevelId() {
		return levelId;
	}

	public Question setLevelId(Short levelId) {
		this.levelId = levelId;
		return this;
	}

}
