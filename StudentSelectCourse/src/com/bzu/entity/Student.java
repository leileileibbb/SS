package com.bzu.entity;

import java.util.HashSet;
import java.util.Set;

public class Student {
	
	private int id;
	
	private String idCard;
	
	private String password;
	
	private String name;
	
	private int sex;
	
	private String major;
	
	private String  birthday;
	
	private String photopath;
	
	private int  version;
	
	private Set<Course> courses=new HashSet<Course>();
	

	@Override
	public String toString() {
		return "Student [birthday=" + birthday + ", courses=" + courses
				+ ", id=" + id + ", idCard=" + idCard + ", major=" + major
				+ ", name=" + name + ", password=" + password + ", sex=" + sex
				+ "]";
	}

	public Student() {
		super();
	}

	public Student(String idCard, String name, int sex, String major,
			String birthday) {
		super();
		this.idCard = idCard;
		this.name = name;
		this.sex = sex;
		this.major = major;
		this.birthday = birthday;
	}

	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhotopath() {
		return photopath;
	}

	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}
	
	

}
