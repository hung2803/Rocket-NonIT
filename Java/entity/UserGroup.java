package com.vti.TestingSystem.entity;

public class UserGroup {
	private Short id;
	private Short idGroup;
	private Short idUser;

	public UserGroup(Short id, Short idGroup, Short idUser) {
		this.id = id;
		this.idGroup = idGroup;
		this.idUser = idUser;
	}

	public Short getId() {
		return id;
	}

	public UserGroup setId(Short id) {
		this.id = id;
		return this;
	}

	public Short getIdGroup() {
		return idGroup;
	}

	public UserGroup setIdGroup(Short idGroup) {
		this.idGroup = idGroup;
		return this;
	}

	public Short getIdUser() {
		return idUser;
	}

	public UserGroup setIdUser(Short idUser) {
		this.idUser = idUser;
		return this;
	}

}
