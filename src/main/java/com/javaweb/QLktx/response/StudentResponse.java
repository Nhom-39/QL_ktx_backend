package com.javaweb.QLktx.response;

import com.javaweb.QLktx.models.Student;

public class StudentResponse {
	private Student student;
	private String message;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
