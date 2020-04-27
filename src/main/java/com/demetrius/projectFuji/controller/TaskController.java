package com.demetrius.projectFuji.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.demetrius.projetoFuji.model.Task;
import com.demetrius.projetoFuji.service.TaskService;
import com.demetrius.projetoFuji.service.dto.TaskDTO;

@RestController
@RequestMapping("/api")
public class TaskController
{
	@Autowired
	private TaskService taskServices;
	
	SimpleDateFormat formatData = new SimpleDateFormat("dd-MM-yyyy");

	
	@PostMapping("/task")
	public ResponseEntity<Task> salvar(@RequestBody @Valid Task task) {
		return ResponseEntity.ok(taskServices.salvar(task));
	}
	
	@GetMapping("/task/busca/{startDate}/{endDate}")
	public ResponseEntity<List<Task>> buscaTaskBetweenDates(@PathVariable String startDate, @PathVariable String endDate) throws ParseException{
	
		return ResponseEntity.ok(taskServices.getTaskBetweenDates(formatData.parse(startDate), formatData.parse(endDate)));
	}
	
	@GetMapping("/task/busca/{startDate}/{endDate}/{status}")
	public ResponseEntity<List<Task>> getTaskBetweenDatesAndStatusAberto(@PathVariable String startDate, @PathVariable String endDate,@PathVariable int status) throws ParseException{
		
		return ResponseEntity.ok(taskServices.getTaskBetweenDatesAndStatus(formatData.parse(startDate), formatData.parse(endDate),status));
	}
	
	@GetMapping("/task")
	public ResponseEntity<List<Task>> listar(){
	     return ResponseEntity.ok(taskServices.listar());

	    }
	
	@GetMapping("/task/{id}")
	public ResponseEntity<Task> consultaById(@PathVariable Long id) {
		return ResponseEntity.ok(taskServices.consultaById(id));
	}
	
	@GetMapping("/task/nome/{nome}")
	public ResponseEntity<TaskDTO> buscaByNome(@PathVariable String nome){
		TaskDTO taskDTO = null;
		try {
			taskDTO = taskServices.getDepartamentoByNome(nome);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(taskDTO);
	}
	
	@PutMapping("/task")
	public ResponseEntity<Task> update(@RequestBody @Valid Task task) {
		return ResponseEntity.ok(taskServices.update(task));
	}
	
	@DeleteMapping("/task/{id}")
	public ResponseEntity<Task> deletarById(@PathVariable Long id) {
		try {
			taskServices.deletarById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
