package com.theironyard.projectvote.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.theironyard.projectvote.models.Project;
import com.theironyard.projectvote.models.ProjectCategory;
import com.theironyard.projectvote.repositories.ProjectRepository;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins="*", methods=RequestMethod.GET)
public class ProjectApiController {
	
	private ProjectRepository repository;
	
	public ProjectApiController(ProjectRepository repository) {
		this.repository = repository;
	}

	@GetMapping("")
	public List<ProjectViewModel> index() {
		return repository.findAll(new Sort("category.name", "name"))
				.stream()
				.map(p -> new ProjectViewModel(p))
				.collect(Collectors.toList());
	}
	
	public static class ProjectViewModel {
		private Project project;
		
		public ProjectViewModel(Project project) {
			this.project = project;
		}
		
		public String getCreatorFirstName() {
			return project.getCreator().getFirstName();
		}
		
		public String getCreatorLastName() {
			return project.getCreator().getLastName();
		}
		
		public ProjectCategory getCategory() {
			return project.getCategory();
		}
		
		public String getName() {
			return project.getName();
		}
		
		public Long getId() {
			return project.getId();
		}
		
		public String getDescription() {
			return project.getDescription();
		}
	}
	
}
