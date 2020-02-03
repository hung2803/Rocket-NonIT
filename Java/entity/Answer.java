package com.vti.TestingSystem.entity;

public class Answer {
	private Short id;
	private Short idQuestion;
	private String key;

	public Answer(Short id, Short idQuestion, String key) {
		this.id = id;
		this.idQuestion = idQuestion;
		this.key = key;
	}

	public Short getId() {
		return id;
	}

	public Answer setId(Short id) {
		this.id = id;
		return this;
	}

	public Short getIdQuestion() {
		return idQuestion;
	}

	public Answer setIdQuestion(Short idQuestion) {
		this.idQuestion = idQuestion;
		return this;
	}

	public String getKey() {
		return key;
	}

	public Answer setKey(String key) {
		this.key = key;
		return this;
	}

}
