package com.vti.TestingSystem.entity;

import java.util.Date;

public class Group {
	private Short idGroup;
	private String name;
	private String author;
	private Date createTime;

	public Group(Short id, String name, String author, Date createTime) {
		this.idGroup = id;
		this.name = name;
		this.author = author;
		this.createTime = createTime;
	}

	public Short getId() {
		return idGroup;
	}

	public Group setId(Short id) {
		this.idGroup = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Group setName(String name) {
		this.name = name;
		return this;
	}

	public String getAuthor() {
		return author;
	}

	public Group setAuthor(String author) {
		this.author = author;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Group setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

}
