package com.demetrius.projectFuji.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demetrius.projetoFuji.model.History;
import com.demetrius.projetoFuji.service.HistoryService;

@RestController
@RequestMapping("/api")
public class HistoryController
{
	@Autowired
	private HistoryService historyService;
	
	@PostMapping("/projetohistory")
	public ResponseEntity<History> salvar(@RequestBody @Valid History history) {
		return ResponseEntity.ok(historyService.salvar(history));
	}
	
	@GetMapping("/projetohistory")
	public ResponseEntity<List<History>> listar(){
	     return ResponseEntity.ok(historyService.listar());
	}
	
	@GetMapping("/projetohistory/{id}")
	public ResponseEntity<History> consultaPorId(@PathVariable Long id) {
		return ResponseEntity.ok(historyService.consultaById(id));
	}
	
	@PutMapping("/projetohistory")
	public ResponseEntity<History> update(@RequestBody @Valid History history) {
		return ResponseEntity.ok(historyService.update(history));
	}
	
	@DeleteMapping("/projetohistory/{id}")
	public ResponseEntity<History> deletarPorId(@PathVariable Long id) {
		try {
			historyService.deletarById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
