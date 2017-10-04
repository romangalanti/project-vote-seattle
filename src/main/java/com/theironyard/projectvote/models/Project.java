package com.theironyard.projectvote.models;

import java.util.List;

import javax.persistence.*;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private ProjectCategory category;
	
	@ManyToOne
	private Student creator;
	
	private String name;
	private String description;
	
	@ManyToMany
	private List<Project> votes;
	
	public Project() {}
	
	public Project(ProjectCategory category, Student creator, String name, String description) {
		this.category = category;
		this.creator = creator;
		this.name = name;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProjectCategory getCategory() {
		return category;
	}

	public void setCategory(ProjectCategory category) {
		this.category = category;
	}

	public Student getCreator() {
		return creator;
	}

	public void setCreator(Student creator) {
		this.creator = creator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Project> getVotes() {
		return votes;
	}

	public void setVotes(List<Project> votes) {
		this.votes = votes;
	}

	
}
