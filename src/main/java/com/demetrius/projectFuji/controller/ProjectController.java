package com.demetrius.projectFuji.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.demetrius.projetoFuji.model.Project;
import com.demetrius.projetoFuji.service.ProjectService;
import com.demetrius.projetoFuji.service.dto.ProjectDTO;


public class ProjectController
{
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/project")
	public ResponseEntity<Project> salvar(@RequestBody @Valid Project project) {
		return ResponseEntity.ok(projectService.salvar(project));
	}
	
	@GetMapping("/project")
	public ResponseEntity<List<Project>> listar(){
	     return ResponseEntity.ok(projectService.listar());

	    }
	
	@GetMapping("/project/{id}")
	public ResponseEntity<Project> consultaById(@PathVariable Long id) {
		return ResponseEntity.ok(projectService.consultaById(id));
	}
	
	@GetMapping("/project/name/{name}")
	public ResponseEntity<ProjectDTO> buscaByNome(@PathVariable String name){
		ProjectDTO projetoDto = null;
		try {
			projetoDto = projectService.getDepartamentoByNome(name);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(projetoDto);
	}
	
	@PutMapping("/project")
	public ResponseEntity<Project> update(@RequestBody @Valid Project project) {
		return ResponseEntity.ok(projectService.update(project));
	}
	
	@DeleteMapping("/project/{id}")
	public ResponseEntity<Project> deletarById(@PathVariable Long id) {
		try {
			projectService.deletarById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
