package com.demetrius.projetoFuji.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private int taskPoints;
	private Date startDate;
	private Date endDate;
	private int status;
	
	
	public Task() {
	}
	
	public Task(Long id, String title, String description, int taskPoints, Date startDate, Date endDate, int status)
	{
		this.id = id;
		this.title = title;
		this.description = description;
		this.taskPoints = taskPoints;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getTaskPoints() {
		return taskPoints;
	}
	
	public void setTaskPoints(int taskPoints) {
		this.taskPoints = taskPoints;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getClassif() {
		return status;
	}

	public void setClassif(int status) {
		this.status = status;
	}

	
}
