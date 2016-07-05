package com.bzu.entity;

import java.util.HashSet;
import java.util.Set;

public class Course {
	
	private int id;
	
	private String name;
	
	private int lessonTime;
	
	private int lessonHour;
	
	private int lessonPoints;
	
	private int version;
	
	private Set<Student> students=new HashSet<Student>();
	
	

	@Override
	public String toString() {
		return "Course [id=" + id + ", lessonHour=" + lessonHour
				+ ", lessonPoints=" + lessonPoints + ", lessonTime="
				+ lessonTime + ", name=" + name + "]";
	}

	public Course() {
		super();
	}

	public Course(String name, int lessonTime, int lessonHour, int lessonPoints) {
		super();
		this.name = name;
		this.lessonTime = lessonTime;
		this.lessonHour = lessonHour;
		this.lessonPoints = lessonPoints;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLessonTime() {
		return lessonTime;
	}

	public void setLessonTime(int lessonTime) {
		this.lessonTime = lessonTime;
	}

	public int getLessonHour() {
		return lessonHour;
	}

	public void setLessonHour(int lessonHour) {
		this.lessonHour = lessonHour;
	}

	public int getLessonPoints() {
		return lessonPoints;
	}

	public void setLessonPoints(int lessonPoints) {
		this.lessonPoints = lessonPoints;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	

}
