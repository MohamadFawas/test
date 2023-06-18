package com.sgic.semita.utils;

public class EndPointURI {
  private static final String BASE_API_PATH = "/api/v1/";
  public static final String ID = "/{id}";
  /*
   * Module: Designation || Author: Keerthana || Date: 16-04-2023
   */
  public static final String DESIGNATION = BASE_API_PATH + "designation";
  public static final String DESIGNATIONS = BASE_API_PATH + "designations";
  public static final String DESIGNATION_BY_ID = DESIGNATION + ID;
  
  
  public static final String PRIORITY = BASE_API_PATH + "priority";
  public static final String PRIORITYS = BASE_API_PATH + "prioritys";
  public static final String PRIORITY_BY_ID = PRIORITY + ID;
  
  
  public static final String EMPLOYEE = BASE_API_PATH + "employee";
  public static final String EMPLOYEES = BASE_API_PATH + "employees";
  public static final String EMPLOYEE_BY_ID = EMPLOYEE + ID;
  public static final String EMPLOYEE_DESIGNATION_BY_ID = EMPLOYEE + "/designation"+ID;
}
