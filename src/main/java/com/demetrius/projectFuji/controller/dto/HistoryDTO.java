package com.demetrius.projectFuji.controller.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.demetrius.projetoFuji.model.History;


public class HistoryDTO
{
	private Long id;
	private Date startDate;
	private Date endDate;
	
	public HistoryDTO(History projHistory)
	{	
		this.id=projHistory.getId();
		this.startDate=projHistory.getStartDate();
		this.endDate=projHistory.getEndDate();
	}

	public Long getId() {
		return id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public static List<HistoryDTO> converter(List<History> projHistory){
		return projHistory.stream().map(HistoryDTO::new).collect(Collectors.toList());
	}
}
