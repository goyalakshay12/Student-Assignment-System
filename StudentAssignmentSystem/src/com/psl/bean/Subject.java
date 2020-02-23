package com.psl.bean;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class Subject {
	private String subjectName;
	private java.util.Date assignmentIssueDate;
	private int numberOfSubmissions = 0;
	
	
	
	
	
	public Subject(String subjectName, java.util.Date assignmentIssueDate) {
		super();
		this.subjectName = subjectName;
		this.assignmentIssueDate = assignmentIssueDate;
		this.numberOfSubmissions = numberOfSubmissions;
	}
	
	SimpleDateFormat format= new SimpleDateFormat("dd:MM:yyyy");

	@Override
	public String toString() {
		return "Subject [subjectName=" + subjectName + ", assignmentIssueDate="
				+ format.format(assignmentIssueDate) + ", numberOfSubmissions="
				+ numberOfSubmissions + "]";
	}

	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public java.util.Date getAssignmentIssueDate() {
		return assignmentIssueDate;
	}
	 
	public void setAssignmentIssueDate(Date assignmentIssueDate) {
		this.assignmentIssueDate = assignmentIssueDate;
	}
	public int getNumberOfSubmissions() {
		return numberOfSubmissions;
	}
	public void setNumberOfSubmissions(int numberOfSubmissions) {
		this.numberOfSubmissions = numberOfSubmissions;
	}
	
	
}