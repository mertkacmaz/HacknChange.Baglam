package com.baglam.api.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "position_id")
	private Position position;

	@Column(name = "point")
	private double point;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "employee_skill", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "skill_id"))
	private List<Skill> skills;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,CascadeType.REFRESH })
	@JoinTable(name = "project_employee", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
	private List<Project> projects;

	public void setPosition(Position position) {
		this.position = position;
		if (position != null)
			position.addEmployee(this);
	}

	public void add(Skill skill) {
		if (skills == null) {
			skills = new ArrayList<Skill>();
		}
		for (Skill s : skills) {
			if (s.getName().equals(skill.getName()) && s.getLevel() == skill.getLevel())
				return;
		}
		skills.add(skill);
	}

	public void add(Project project) {
		if (projects == null) {
			projects = new ArrayList<Project>();
		}
		for (Project p : projects) {
			if (p.getName().equals(project.getName()))
				return;
		}
		projects.add(project);
	}

	public Employee(String name, double point) {
		this.name = name;
		this.point = point;
	}

}
