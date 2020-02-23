package com.psl.bean;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Assignment {
	private int rollNumber;
	private String subject;
	private java.util.Date submissionDate;
	private int marksObtained;
	private int numberOfSubmissions;
	
	SimpleDateFormat format= new SimpleDateFormat("dd:MM:yyyy");
	@Override
	public String toString() {
		return "Assignment [rollNumber=" + rollNumber + ", subject=" + subject
				+ ", submissionDate=" + format.format(submissionDate) + ", marksObtained="
				+ marksObtained + "]";
	}
	public Assignment(int rollNumber, String subject, Date submissionDate,
			int marksObtained, int numberOfSubmissions) {
		super();
		this.rollNumber = rollNumber;
		this.subject = subject;
		this.submissionDate = submissionDate;
		this.marksObtained = marksObtained;
		this.numberOfSubmissions = numberOfSubmissions;
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}	
	public java.util.Date getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(java.util.Date submissionDate) {
		this.submissionDate = submissionDate;
	}
	public int getMarksObtained() {
		return marksObtained;
	}
	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}
	public int getNumberOfSubmissions() {
		return numberOfSubmissions;
	}
	public void setNumberOfSubmissions(int numberOfSubmissions) {
		this.numberOfSubmissions = numberOfSubmissions;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
}