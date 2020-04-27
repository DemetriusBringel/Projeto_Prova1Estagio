package com.demetrius.projetoFuji.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class History
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date startDate;
	private Date endDate;
	
	@OneToOne
	private Person manager;
	
	@OneToOne
	private Project project;
	
	@OneToOne
	private Department department;
	
	
	
	public History() {
	}
	
	public History(Long id, Date startDate, Date endDate, Person manager, Department department,
			Project project) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.manager = manager;
		this.department = department;
		this.project = project;
	}

	public Long getId() {
		return id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public Person getManager() {
		return manager;
	}

	public Department getDepartment() {
		return department;
	}

	public Project getProject() {
		return project;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setManager(Person manager) {
		this.manager = manager;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
