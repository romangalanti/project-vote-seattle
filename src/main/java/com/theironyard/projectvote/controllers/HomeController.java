package com.theironyard.projectvote.controllers;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.theironyard.projectvote.repositories.StudentRepository;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private StudentRepository students;
	
	public HomeController(StudentRepository students) {
		this.students = students;
	}

	@GetMapping("")
	public String index() {
		return "redirect:/index.html";
	}
	
	@GetMapping("votes")
	public ModelAndView reports() {
		ModelAndView mv = new ModelAndView("reports/reports");
		mv.addObject("students", students.findAll(new Sort("lastName", "firstName")));
		return mv;
	}
	
}
