package com.theironyard.projectvote.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.theironyard.projectvote.models.Student;
import com.theironyard.projectvote.repositories.StudentRepository;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins="*", methods=RequestMethod.GET)
public class StudentApiController {

	private StudentRepository repository;
	
	public StudentApiController(StudentRepository repository) {
		this.repository = repository;
	}

	@GetMapping("")
	public List<StudentViewModel> index() {
		return repository.findAll(new Sort("lastName", "firstName"))
				.stream()
				.map(s -> new StudentViewModel(s))
				.collect(Collectors.toList());
	}
	
	public static class StudentViewModel {
		private Student student;
		
		public StudentViewModel(Student student) {
			this.student = student;
		}
		
		public String getFirstName() {
			return student.getFirstName();
		}
		
		public String getLastName() {
			return student.getLastName();
		}
		
		public Long getId() {
			return student.getId();
		}
		
		public Long getFirstId() {
			if (student.getFirst() != null) {
				return student.getFirst().getId();
			}
			return null;
		}
		
		public Long getSecondId() {
			if (student.getSecond() != null) {
				return student.getSecond().getId();
			}
			return null;
		}
		
		public Long getThirdId() {
			if (student.getThird() != null) {
				return student.getThird().getId();
			}
			return null;
		}
	}
	
}
