package com.demetrius.projectFuji.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.demetrius.projetoFuji.model.Department;



public class DepartmentDTO
{
	private Long id;
	private String depName;
	
	public DepartmentDTO(Department department) {
		
		this.id=department.getId();
		this.depName=department.getName();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNomeDepartamento() {
		return depName;
	}

	
	public static List<DepartmentDTO> converter(List<Department> departamento){
		return departamento.stream().map(DepartmentDTO::new).collect(Collectors.toList());
	}
}
