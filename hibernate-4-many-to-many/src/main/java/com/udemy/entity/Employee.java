package com.udemy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Integer empId;

	@Column(name = "employee_name")
	private String name;

	/*
	 * Employee entity is responsible for maintaining relationship i.e responsible
	 * for creating new table named as "emp_proj" with column names as "emp_id" and
	 * "proj_id". Attribute "joinColumns" would be name for Employee entity and
	 * "inverseJoinColumns" would be name for Project entity
	 */
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "emp_proj", joinColumns = { @JoinColumn(name = "emp_id") }, inverseJoinColumns = {
			@JoinColumn(name = "proj_id") })
	private List<Project> projects;

	public void addProject(Project project) {
		if (projects == null) {
			projects = new ArrayList<>();
		}
		projects.add(project);
	}

}
