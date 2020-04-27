package com.demetrius.projetoFuji.service.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.demetrius.projetoFuji.model.Project;



public class ProjectDTO
{
	private Long id;
	private String projectName;
	
	public ProjectDTO(Project project) {
		
		this.id = project.getId();
		this.projectName = project.getProjectName();
	}

	public Long getId() {
		return id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public static List<ProjectDTO> converter(List<Project> project){
		return project.stream().map(ProjectDTO::new).collect(Collectors.toList());
	}
}
