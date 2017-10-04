package com.theironyard.projectvote.repositories;

import org.springframework.stereotype.Repository;

import com.theironyard.projectvote.models.Project;
import com.theironyard.projectvote.models.ProjectCategory;
import com.theironyard.projectvote.models.Student;

@Repository
public class SeedRepository {
	
	private ProjectRepository projects;
	private StudentRepository students;
	private ProjectCategoryRepository categories;

	public SeedRepository(ProjectRepository projects, StudentRepository students, ProjectCategoryRepository categories) {
		this.projects = projects;
		this.students = students;
		this.categories = categories;
	}
	
	public Student createIf(String firstName, String lastName) {
		Student student = this.students.findByFirstNameAndLastName(firstName, lastName);
		if (student == null) {
			student = students.save(new Student(firstName, lastName));
		}
		return student;
	}
	
	public ProjectCategory createIf(String name) {
		ProjectCategory category = this.categories.findByName(name);
		if (category == null) {
			category = categories.save(new ProjectCategory(name, ""));
		}
		return category;
	}
	
	public Project createIf(ProjectCategory category, Student creator, String name) {
		Project project = this.projects.findByName(name);
		if (project == null) {
			project = projects.save(new Project(category, creator, name, ""));
		}
		return project;
	}
	
}
