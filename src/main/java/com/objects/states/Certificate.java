package com.objects.states;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate {
	
	private String course;
	private String duartion;
	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Certificate(String course, String duartion) {
		super();
		this.course = course;
		this.duartion = duartion;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getDuartion() {
		return duartion;
	}
	public void setDuartion(String duartion) {
		this.duartion = duartion;
	}
	
	

}
