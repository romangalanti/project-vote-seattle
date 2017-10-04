package com.theironyard.projectvote.models;

import javax.persistence.*;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String firstName;
	private String lastName;
	
	public Student() {}
	
	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@ManyToOne
	private Project first;
	
	@ManyToOne
	private Project second;
	
	@ManyToOne
	private Project third;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Project getFirst() {
		return first;
	}

	public void setFirst(Project first) {
		this.first = first;
	}

	public Project getSecond() {
		return second;
	}

	public void setSecond(Project second) {
		this.second = second;
	}

	public Project getThird() {
		return third;
	}

	public void setThird(Project third) {
		this.third = third;
	}
	
}
