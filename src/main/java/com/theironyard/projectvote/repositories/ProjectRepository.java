package com.theironyard.projectvote.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theironyard.projectvote.models.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	Project findByName(String name);
}
