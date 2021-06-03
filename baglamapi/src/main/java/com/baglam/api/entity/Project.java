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
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "project")
@NoArgsConstructor
@Data
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

//	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "project_skill", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "skill_id"))
	private List<Skill> skills;

//	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "project_employee", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "employee_id"))
	private List<Employee> employees;

	@Column(name = "due_date")
	private long dueDate;

	@Column(name = "completed")
	private boolean completed;

	public Project(String name, long dueDate, boolean completed) {
		this.name = name;
		this.dueDate = dueDate;
		this.completed = completed;
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

	public void add(Employee employee) {
		if (employees == null) {
			employees = new ArrayList<Employee>();
		}
		for (Employee e : employees) {
			if (e.getName().equals(employee.getName()))
				return;
		}
		employees.add(employee);
	}

}