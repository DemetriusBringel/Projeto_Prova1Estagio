package com.demetrius.projetoFuji.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demetrius.projetoFuji.model.Task;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long>
{
	Optional<Task> findTaskByTitle(String title);
	Optional<Task> findTaskById(Long id);
	
	@Query("select a from Task a where a.startDate <= :startDate and a.endDate <=:endDate and a.status <=:status")
    List<Task> findByStartDateAndEndDateAndStatusBetween (@Param("startDate")Date startDate,@Param("endDate")Date endDate,@Param("status")int status);
	
	@Query("select a from Task a where a.startDate <= :startDate and a.endDate <=:endDate")
    List<Task> findByStartDateAndEndDateBetween (@Param("startDate")Date startDate,@Param("endDate")Date endDate);
	
}
