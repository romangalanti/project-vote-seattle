package com.theironyard.projectvote.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.theironyard.projectvote.models.*;
import com.theironyard.projectvote.repositories.*;

@RestController
@RequestMapping("/api/votes")
@CrossOrigin(origins="*", methods=RequestMethod.PUT)
public class VoteController {
	
	private StudentRepository studentRepository;
	private ProjectRepository projectRepository;
	
	public VoteController(StudentRepository studentRepository, ProjectRepository projectRepository) {
		this.studentRepository = studentRepository;
		this.projectRepository = projectRepository;
	}

	@PutMapping("")
	public boolean create(@RequestBody VoteDto vote) {
		Project project = projectRepository.findOne(vote.getProjectId());
		Student student = studentRepository.findOne(vote.getVoterId());
		if (vote.getRank() == 1) {
			student.setFirst(project);
		} else if (vote.getRank() == 2) {
			student.setSecond(project);
		} else if (vote.getRank() == 3) {
			student.setThird(project);
		}
		studentRepository.save(student);
		return true;
	}
	
}
