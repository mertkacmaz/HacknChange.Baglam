package com.baglam.api.entity;

import java.util.List;

import lombok.Data;

@Data
public class AllObjectsModel {

	private List<Project> projects;
	private List<Employee> employees;
	private List<Skill> skills;
	private List<Position> positions;
}
