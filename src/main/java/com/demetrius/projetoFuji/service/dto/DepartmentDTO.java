package com.demetrius.projetoFuji.service.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.demetrius.projetoFuji.model.Department;


public class DepartmentDTO
{
	private Long id;
	private String name;
	
	public DepartmentDTO(Department department)
	{	
		this.id=department.getId();
		this.name=department.getName();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public static List<DepartmentDTO> converter(List<Department> department){
		return department.stream().map(DepartmentDTO::new).collect(Collectors.toList());
	}
}
