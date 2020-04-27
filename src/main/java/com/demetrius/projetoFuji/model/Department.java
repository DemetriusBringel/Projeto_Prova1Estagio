package com.demetrius.projetoFuji.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Department
{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String name;
	
	@OneToMany
	private List<Person> person = new ArrayList<Person>();
	
	public Department() {
	}
	
	public Department(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

}
