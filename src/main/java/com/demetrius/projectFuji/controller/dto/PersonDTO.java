package com.demetrius.projectFuji.controller.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.demetrius.projetoFuji.model.Person;

public class PersonDTO
{
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	
	
	public PersonDTO(Person person)
	{
		this.id = person.getId();
		this.firstName = person.getFirstName();
		this.lastName = person.getLastName();
		this.email = person.getEmail();
		this.phoneNumber = person.getPhoneNumber();
		this.hireDate = person.getHireDate();
	}
	
	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public static List<PersonDTO> converter(List<Person> person){
		return person.stream().map(PersonDTO::new).collect(Collectors.toList());
	}	
}
