package com.demetrius.projectFuji.controller.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.demetrius.projetoFuji.model.Task;


public class TaskDTO
{
	private Long id;
	private String title;
	private String description;
	private int taskPoints;
	private int status; 
	private Date startDate;
	private Date endDate;
	
	public TaskDTO(Task task)
	{
		
		this.id = task.getId();
		this.title = task.getTitle();
		this.description = task.getDescription();
		this.taskPoints = task.getTaskPoints();
		this.status = task.getClassif();
		this.startDate = task.getStartDate();
		this.endDate = task.getEndDate();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public int getTaskPoints() {
		return taskPoints;
	}

	public int getClassif() {
		return status;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTaskPoints(int taskPoints) {
		this.taskPoints = taskPoints;
	}

	public void setClassif(int status) {
		this.status = status;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public static List<TaskDTO> converter(List<Task> task){
		return task.stream().map(TaskDTO::new).collect(Collectors.toList());
	}

}
