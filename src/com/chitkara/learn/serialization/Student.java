package com.chitkara.learn.serialization;

import java.io.Serializable;

public class Student implements Serializable, Comparable<Student> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -123L;
	private int rollNo;
	private transient String name;
	private float cgpa;

	public Student() {

	}

	public Student(int rollNo, String name, float cgpa) {
		this.rollNo = rollNo;
		this.name = name;
		this.cgpa = cgpa;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getCgpa() {
		return cgpa;
	}

	public void setCgpa(float cgpa) {
		this.cgpa = cgpa;
	}

	@Override
	public int compareTo(Student o) {
		if(this.rollNo>o.rollNo) return +1;
		if(this.rollNo<o.rollNo) return -1;
		return 0;
	}
}
