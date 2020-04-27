package com.demetrius.projetoFuji.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.demetrius.projetoFuji.model.Department;
import com.demetrius.projetoFuji.repository.DepartmentRepository;
import com.demetrius.projetoFuji.service.dto.DepartmentDTO;

@Service
public class DepartmentService
{	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	
	public DepartmentDTO getDepartamentoById(Long id) throws NotFoundException {
		Optional<Department> department = departmentRepository.findById(id);
		
		if(!department.isPresent()) {
			throw new NotFoundException();
		}
	
		return new DepartmentDTO(department.get());
	}

	public DepartmentDTO getDepartamentoByName(String name) throws NotFoundException{
		
		Optional<Department> department = departmentRepository.findDepartamentoByName(name);
		
		if(!department.isPresent()) {
			throw new NotFoundException();
		}
	
		return new DepartmentDTO(department.get());
	}
	
	public List<Department> listar(){
		return departmentRepository.findAll();
	}

	public Department consultaById(Long id) {
		return departmentRepository.findById(id).get();				
	}
	

	public Department salvar(Department department) {
		return departmentRepository.save(department);
	}
	
	public Department update(Department department) {
		if(department!=null) {
			return departmentRepository.save(department);
		}
		
			throw new RuntimeException("O ID deve ser informado");
		}
	
	public void deletarById(Long id) {
		departmentRepository.deleteById(id);
	}
}
