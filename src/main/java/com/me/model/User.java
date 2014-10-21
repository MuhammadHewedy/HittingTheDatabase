package com.me.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class User {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String password;

	public User() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password
				+ "]";
	}
}
