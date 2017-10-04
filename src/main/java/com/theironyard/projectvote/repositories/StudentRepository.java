package com.theironyard.projectvote.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theironyard.projectvote.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	Student findByFirstNameAndLastName(String firstName, String lastName);
	
}
