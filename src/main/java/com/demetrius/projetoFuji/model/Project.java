package com.demetrius.projetoFuji.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Project
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int minSalay;
	private int maxSalary;
	
	@ManyToMany
	private List<Task> task = new ArrayList<Task>();
	
	@OneToOne
	private Person person;
	
	public Project() {
	}

	public Project(Long id, String name, int minSalay, int maxSalary, Person person) {
		this.id = id;
		this.name = name;
		this.minSalay = minSalay;
		this.maxSalary = maxSalary;
		this.person = person;
	}


	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getProjectName() {
		return name;
	}
	
	public void setProjectName(String name) {
		this.name = name;
	}
	

	public int getMinSalary() {
		return minSalay;
	}
	
	public void setMinSalary(int minSalay) {
		this.minSalay = minSalay;
	}
	
	public int getMaxSalary() {
		return maxSalary;
	}
	
	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}

	public Person getPerson() {
		return person;
	}

	public List<Task> getTask() {
		return task;
	}
}
