package com.demetrius.projetoFuji.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.demetrius.projetoFuji.model.Project;
import com.demetrius.projetoFuji.repository.ProjectRepository;
import com.demetrius.projetoFuji.service.dto.ProjectDTO;


@Service
public class ProjectService
{
	@Autowired
	private ProjectRepository projectRepository;
	
	
	public ProjectDTO getDepartmentById(Long id) throws NotFoundException {
		Optional<Project> project = projectRepository.findById(id);
		
		if(!project.isPresent()) {
			throw new NotFoundException();
		}
	
		return new ProjectDTO(project.get());
	}

	
	public ProjectDTO getDepartamentoByNome(String name) throws NotFoundException{
		
		Optional<Project> project = projectRepository.findProjetoByName(name);
		
		if(!project.isPresent()) {
			throw new NotFoundException();
		}
	
		return new ProjectDTO(project.get());
	}
	
	public List<Project> listar(){
		return projectRepository.findAll();
	}

	public Project consultaById(Long id) {
		return projectRepository.findById(id).get();				
	}
	

	public Project salvar(Project project) {
		return projectRepository.save(project);
	}
	
	
	public Project update(Project project) {
		if(project!=null) {
			return projectRepository.save(project);
		}
		
			throw new RuntimeException("O ID deve ser informado");
		}
	
	public void deletarById(Long id) {
		projectRepository.deleteById(id);
	}
}
