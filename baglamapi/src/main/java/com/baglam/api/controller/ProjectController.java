package com.baglam.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baglam.api.entity.Project;
import com.baglam.api.repository.ProjectRepository;

//@RestController
//@RequestMapping("/api/project")
//public class ProjectController {
//
//	@Autowired
//	private ProjectRepository projectRepository;
//
//	@GetMapping()
//	public Project getAll() {
//		return new Project();
//	}
//
//	@PostMapping
//	public Project createProject(@RequestBody Project project) {
//		Project p = projectRepository.save(project);
//		return p;
//	}
//}
