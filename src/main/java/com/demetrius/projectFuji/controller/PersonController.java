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

import com.demetrius.projetoFuji.model.Person;
import com.demetrius.projetoFuji.service.PersonService;


@RestController
@RequestMapping("/api")
public class PersonController
{
	@Autowired
	private PersonService personService;
	
	@PostMapping("/person")
	public ResponseEntity<Person> salvar(@RequestBody @Valid Person person) {
		return ResponseEntity.ok(personService.salvar(person));
	}
	
	@GetMapping("/person")
	public ResponseEntity<List<Person>> listar(){
	     return ResponseEntity.ok(personService.listar());
	    }
	
	@GetMapping("/person/{id}")
	public ResponseEntity<Person> consultaById(@PathVariable Long id) {
		return ResponseEntity.ok(personService.consultaById(id));
	}
	
	@PutMapping("/person")
	public ResponseEntity<Person> update(@RequestBody @Valid Person person) {
		return ResponseEntity.ok(personService.update(person));
	}
	
	@DeleteMapping("/person/{id}")
	public ResponseEntity<Person> deletarById(@PathVariable Long id) {
		try {
			personService.deletarById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
