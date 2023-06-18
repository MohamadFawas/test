package com.sgic.semita.services;

import java.util.List;
import com.sgic.semita.entities.Employee;

public interface EmployeeService {

  
  public void saveEmployee(Employee employee);

  public List<Employee> getAllEmployee();

  public boolean isEmployeeExists(String email);
  public boolean isEmployeeExists1(String contactNumber);

  public Employee getEmployeeById(Long id);

  public boolean existByEmployee(Long id);

  public boolean isUpdatedEmployeeNameExist(Long id, String email);
  

  public void deleteEmployee(Long id);
  
  public List<Employee> getAllEmployeeByDesignationId(Long id);
}
