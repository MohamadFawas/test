package com.sgic.semita.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sgic.semita.entities.Priority;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long>{
  boolean existsByNameIgnoreCase(String name);
 
  
}
