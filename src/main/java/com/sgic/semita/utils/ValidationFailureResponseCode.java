package com.sgic.semita.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:validationmessage.properties")
public class ValidationFailureResponseCode {
	/*
	 * Module: Designation || Author: Keerthana || Date: 16-04-2023
	 */
	@Value("${validation.designation.alreadyexists}")
	private String designationAlreadyExists;

	@Value("${validation.designation.notexists}")
	private String designationNotExists;

	public String getDesignationAlreadyExists() {
		return designationAlreadyExists;
	}

	public void setDesignationAlreadyExists(String designationAlreadyExists) {
		this.designationAlreadyExists = designationAlreadyExists;
	}

	public String getDesignationNotExists() {
		return designationNotExists;
	}

	public void setDesignationNotExists(String designationNotExists) {
		this.designationNotExists = designationNotExists;
	}
	
	
	
	
	
	@Value("${validation.priority.alreadyexists}")
    private String priorityAlreadyExists;

    @Value("${validation.priority.notexists}")
    private String priorityNotExists;

    public String getPriorityAlreadyExists() {
      return priorityAlreadyExists;
    }

    public void setPriorityAlreadyExists(String priorityAlreadyExists) {
      this.priorityAlreadyExists = priorityAlreadyExists;
    }

    public String getPriorityNotExists() {
      return priorityNotExists;
    }

    public void setPriorityNotExists(String priorityNotExists) {
      this.priorityNotExists = priorityNotExists;
    }
    
    
    
    @Value("${validation.priority.alreadyexists}")
    private String employeeAlreadyExists;

    @Value("${validation.priority.notexists}")
    private String employeeNotExists;

    public String getEmployeeAlreadyExists() {
      return employeeAlreadyExists;
    }

    public void setEmployeeAlreadyExists(String employeeAlreadyExists) {
      this.employeeAlreadyExists = employeeAlreadyExists;
    }

    public String getEmployeeNotExists() {
      return employeeNotExists;
    }

    public void setEmployeeNotExists(String employeeNotExists) {
      this.employeeNotExists = employeeNotExists;
    }

    
    
	
}
