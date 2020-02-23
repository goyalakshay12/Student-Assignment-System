package com.psl.bean;
public class Student {
	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", studentname="
				+ studentname + ", subject=" + subject + ", defaulter="
				+ defaulter + "]";
	}
	public Student(int rollNumber, String studentname, String subject) {
		super();
		this.rollNumber = rollNumber;
		this.studentname = studentname;
		this.subject = subject;
		this.defaulter = defaulter;
	}
	private int rollNumber;
	private String studentname;
	private String subject;
	private boolean defaulter;
	
	
	
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public boolean getDefaulter() {
		return defaulter;
	}
	public void setDefaulter(boolean defaulter) {
		this.defaulter = defaulter;
	}
	
	
}