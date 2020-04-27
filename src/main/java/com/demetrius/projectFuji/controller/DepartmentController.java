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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demetrius.projetoFuji.model.Department;
import com.demetrius.projetoFuji.service.DepartmentService;
import com.demetrius.projetoFuji.service.dto.DepartmentDTO;

@RestController
@RequestMapping("/api")
public class DepartmentController
{
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/department")
	public ResponseEntity<Department> salvar(@RequestBody @Valid Department department) {
		return ResponseEntity.ok(departmentService.salvar(department));
	}
	
	@GetMapping("/department")
	public ResponseEntity<List<Department>> listar(){
	     return ResponseEntity.ok(departmentService.listar());

	    }
	
	@GetMapping("/department/{id}")
	public ResponseEntity<Department> consultaById(@PathVariable Long id) {
		return ResponseEntity.ok(departmentService.consultaById(id));
	}
	
	@GetMapping("/department/name/{name}")
	public ResponseEntity<DepartmentDTO> buscaByName(@PathVariable String name) throws NotFoundException{
		
		return ResponseEntity.ok(departmentService.getDepartamentoByName(name));

	}
	
	@PutMapping("/department")
	public ResponseEntity<Department> update(@RequestBody @Valid Department department) {
		return ResponseEntity.ok(departmentService.update(department));
	}
	
	@DeleteMapping("/department/{id}")
	public ResponseEntity<Department> deletarById(@PathVariable Long id) {
		try {
			departmentService.deletarById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
