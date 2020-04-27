package com.demetrius.projetoFuji.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.demetrius.projetoFuji.model.Person;
import com.demetrius.projetoFuji.repository.PersonRepository;
import com.demetrius.projetoFuji.service.dto.PersonDTO;

@Service
public class PersonService
{
	@Autowired
	private PersonRepository personRepository;
	
	
	public PersonDTO getDepartamentoById(Long id) throws NotFoundException {
		Optional<Person> person = personRepository.findById(id);
		
		if(!person.isPresent()) {
			throw new NotFoundException();
		}
	
		return new PersonDTO(person.get());
	}
	
	public List<Person> listar(){
		return personRepository.findAll();
	}

	public Person consultaById(Long id) {
		return personRepository.findById(id).get();				
	}
	

	public Person salvar(Person pessoa) {
		return personRepository.save(pessoa);
	}
	
	public Person update(Person pessoa) {
		if(pessoa!=null) {
			return personRepository.save(pessoa);
		}
		
			throw new RuntimeException("O ID deve ser informado");
		}
	
	public void deletarById(Long id) {
		personRepository.deleteById(id);
	}
}
