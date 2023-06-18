package com.sgic.semita.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sgic.semita.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	boolean existsByEmailIgnoreCase(String email);
	boolean existsByContactNumberIgnoreCase(String contactNumber);
	public List<Employee> findByDesignationId(Long desinationId);
	
	
}
