package com.theironyard.projectvote.models;

import javax.persistence.*;

@Entity
public class ProjectCategory {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String name;
	private String icon;
	
	public ProjectCategory() {}
	
	public ProjectCategory(String name, String icon) {
		this.name = name;
		this.icon = icon;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
}
