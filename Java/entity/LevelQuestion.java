package com.vti.TestingSystem.entity;

public class LevelQuestion {
	private Short id;
	private String level;

	public LevelQuestion(Short id, String level) {
		this.id = id;
		this.level = level;
	}

	public Short getId() {
		return id;
	}

	public LevelQuestion setId(Short id) {
		this.id = id;
		return this;
	}

	public String getLevel() {
		return level;
	}

	public LevelQuestion setLevel(String level) {
		this.level = level;
		return this;
	}

}
