package com.demetrius.projetoFuji.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demetrius.projetoFuji.model.Person;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> 
{
	
}
