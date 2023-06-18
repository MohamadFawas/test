package com.sgic.semita.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sgic.semita.entities.Designation;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Long> {
  boolean existsByNameIgnoreCase(String name);
}
