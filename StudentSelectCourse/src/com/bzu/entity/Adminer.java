package com.bzu.entity;

public class Adminer {

	private int id;
	
	private String username;
	
	private String password;
	
	private String name;
	
	
	

	@Override
	public String toString() {
		return "Adminer [id=" + id + ", name=" + name + ", password="
				+ password + ", username=" + username + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
