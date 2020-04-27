package com.demetrius.projetoFuji.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demetrius.projetoFuji.model.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long>  {
}
