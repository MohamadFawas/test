package com.sgic.semita.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.semita.entities.Employee;
import com.sgic.semita.repositories.EmployeeRepository;
import com.sgic.semita.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

  
  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public void saveEmployee(Employee employee) {
    employeeRepository.save(employee);
    
  }

  @Override
  public List<Employee> getAllEmployee() {
    return employeeRepository.findAll();
  }

  @Override
  public boolean isEmployeeExists(String email) {
    return employeeRepository.existsByEmailIgnoreCase(email);

  }

  @Override
  public boolean isEmployeeExists1(String contactNumber) {
    return employeeRepository.existsByContactNumberIgnoreCase(contactNumber);
  }

  @Override
  public Employee getEmployeeById(Long id) {
    return employeeRepository.findById(id).get();
  }

  @Override
  public boolean existByEmployee(Long id) {
    return employeeRepository.existsById(id);
  }

  @Override
  public boolean isUpdatedEmployeeNameExist(Long id, String email) {
    if ((!getEmployeeById(id).getEmail().equalsIgnoreCase(email)) && (isEmployeeExists(email))) {
      return true;
    }
    return false;
  }

 

  @Override
  public void deleteEmployee(Long id) {
    employeeRepository.deleteById(id);
    
  }
  
  
  public List<Employee> getAllEmployeeByDesignationId(Long id){
    return employeeRepository.findByDesignationId(id);
    
  }
}
