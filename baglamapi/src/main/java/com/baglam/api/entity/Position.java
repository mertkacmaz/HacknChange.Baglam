package com.baglam.api.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "position")
@NoArgsConstructor
@Data
public class Position {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "position", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	private List<Employee> employees;

	public void addEmployee(Employee employee) {
		if (employees == null) {
			employees = new ArrayList<Employee>();
		}
		employees.add(employee);
	}

	public Position(String name) {
		this.name = name;
	}

}