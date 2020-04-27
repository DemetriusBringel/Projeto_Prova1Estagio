package com.demetrius.projetoFuji.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demetrius.projetoFuji.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> 
{
	Optional<Department> findDepartamentoByName(String name);
	Optional<Department> findDepartamentoById(Long id);
}
