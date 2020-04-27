package com.demetrius.projetoFuji.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.demetrius.projetoFuji.model.Task;
import com.demetrius.projetoFuji.repository.TaskRepository;
import com.demetrius.projetoFuji.service.dto.TaskDTO;


@Service
public class TaskService
{
	@Autowired
	private TaskRepository taskRepository;
	
	
	public TaskDTO getDepartamentoById(Long id) throws NotFoundException {
		Optional<Task> task = taskRepository.findById(id);
		
		if(!task.isPresent()) {
			throw new NotFoundException();
		}
	
		return new TaskDTO(task.get());
	}
	

	public TaskDTO getDepartamentoByNome(String title) throws NotFoundException{
		
		Optional<Task> task = taskRepository.findTaskByTitle(title);
		
		if(!task.isPresent()) {
			throw new NotFoundException();
		}
	
		return new TaskDTO(task.get());
	}
	
	public List<Task> listar(){
		return taskRepository.findAll();
	}

	public Task consultaById(Long id) {
		return taskRepository.findById(id).get();				
	}
	

	public Task salvar(Task task) {
		return taskRepository.save(task);
	}
	
	
	public Task update(Task task) {
		if(task!=null) {
			return taskRepository.save(task);
		}
		
			throw new RuntimeException("O ID deve ser informado");
		}
	
	public void deletarById(Long id) {
		taskRepository.deleteById(id);
	}

	public List<Task> getTaskBetweenDates(Date startDate, Date endDate)  {
		 
		List<Task> task = taskRepository.findByStartDateAndEndDateBetween(startDate, endDate);
		return task;
		
	}
	
	public List<Task> getTaskBetweenDatesAndStatus(Date startDate, Date endDate, int status)  {
		 
		List<Task> task = taskRepository.findByStartDateAndEndDateAndStatusBetween(startDate, endDate,status);
		return task;
		
	}

}
