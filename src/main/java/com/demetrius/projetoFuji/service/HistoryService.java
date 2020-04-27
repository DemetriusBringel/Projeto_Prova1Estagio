package com.demetrius.projetoFuji.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.demetrius.projetoFuji.model.History;
import com.demetrius.projetoFuji.repository.HistoryRepository;
import com.demetrius.projetoFuji.service.dto.HistoryDTO;


@Service
public class HistoryService
{
	@Autowired
	private HistoryRepository historyRepository;
	
	public HistoryDTO getHistoryById(Long id) throws NotFoundException {
		Optional<History> history = historyRepository.findById(id);
		
		if(!history.isPresent()) {
			throw new NotFoundException();
		}
	
		return new HistoryDTO(history.get());
	}

	public List<History> listar(){
		return historyRepository.findAll();
	}

	public History consultaById(Long id) {
		return historyRepository.findById(id).get();				
	}
	

	public History salvar(History history) {
		return historyRepository.save(history);
	}
	
	
	public History update(History history) {
		if(history!=null) {
			return historyRepository.save(history);
		}
		
			throw new RuntimeException("O ID deve ser informado");
		}
	
	public void deletarById(Long id) {
		historyRepository.deleteById(id);
	}

}
