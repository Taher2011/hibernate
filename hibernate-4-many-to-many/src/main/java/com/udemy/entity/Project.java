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
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private Integer projId;

	@Column(name = "project_name")
	private String name;

	/*
	 * "mappedBy" attribute tells that Employee entity is responsible for
	 * maintaining relationship i.e responsible for creating new table named as
	 * "emp_proj" with column names as "emp_id" and "proj_id" defined in Employee
	 * entity with annotation
	 * "@JoinTable(name = "emp_proj", joinColumns = { @JoinColumn(name = "emp_id")
	 * }, inverseJoinColumns = {
	 * 
	 * @JoinColumn(name = "proj_id") })".
	 */
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "emp_proj", joinColumns = { @JoinColumn(name = "proj_id") }, inverseJoinColumns = {
			@JoinColumn(name = "emp_id") })
	private List<Employee> employees;

	public void addEmployee(Employee employee) {
		if (employees == null) {
			employees = new ArrayList<>();
		}
		employees.add(employee);
	}

}
