package com.demetrius.projetoFuji.service.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.demetrius.projetoFuji.model.Task;
import com.fasterxml.jackson.annotation.JsonFormat;


public class TaskDTO
{
	private int id;
	private String title;
	private String description;
	private int taskPoints;
	private int status; 
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date startDate;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date endDate;
	
	public TaskDTO(int id, String title, String description, int taskPoints, int status, Date startDate, Date endDate)
	{
		this.id = id;
		this.title = title;
		this.description = description;
		this.taskPoints = taskPoints;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public TaskDTO(Task task) {
	}

	public int getId() {
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

	public int getStatus() {
		return status;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setId(int id) {
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

	public void setStatus(int status) {
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
