package com.baglam.api.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baglam.api.entity.AllObjectsModel;
import com.baglam.api.entity.Employee;
import com.baglam.api.entity.Position;
import com.baglam.api.entity.Project;
import com.baglam.api.entity.Skill;
import com.baglam.api.repository.EmployeeRepository;
import com.baglam.api.repository.PositionRepository;
import com.baglam.api.repository.ProjectRepository;
import com.baglam.api.repository.SkillRepository;

@RestController
@RequestMapping("/api")
public class WelcomeController {

	@Autowired
	private ProjectRepository projectRepo;

	@Autowired
	private EmployeeRepository employeeRepo;

	@Autowired
	private SkillRepository skillRepo;

	@Autowired
	private PositionRepository positionRepo;

	@GetMapping
	public AllObjectsModel getAll() {
		AllObjectsModel objectsModel = new AllObjectsModel();
		List<Project> projects = 
				  StreamSupport.stream(projectRepo.findAll().spliterator(), false)
				    .collect(Collectors.toList());
		List<Employee> employees = 
				  StreamSupport.stream(employeeRepo.findAll().spliterator(), false)
				    .collect(Collectors.toList());
		List<Skill> skills = 
				  StreamSupport.stream(skillRepo.findAll().spliterator(), false)
				    .collect(Collectors.toList());
		List<Position> positions = 
				  StreamSupport.stream(positionRepo.findAll().spliterator(), false)
				    .collect(Collectors.toList());
		objectsModel.setProjects(projects);
		objectsModel.setEmployees(employees);
		objectsModel.setSkills(skills);
		objectsModel.setPositions(positions);
		return objectsModel;
	}
}
