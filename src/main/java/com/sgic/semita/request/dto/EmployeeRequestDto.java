package com.sgic.semita.request.dto;


public class EmployeeRequestDto {
  
  private Long id;
  private String firstName;
  private String lastName;
  private String gender;
  private Long designationId;
  private String email;
  private String contactNumber;
  private double availability;
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public String getGender() {
    return gender;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }
  public Long getDesignationId() {
    return designationId;
  }
  public void setDesignationId(Long designationId) {
    this.designationId = designationId;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getContactNumber() {
    return contactNumber;
  }
  public void setContact_number(String contactNumber) {
    this.contactNumber = contactNumber;
  }
  public double getAvailability() {
    return availability;
  }
  public void setAvailability(double availability) {
    this.availability = availability;
  }
  
  
  
  
  

}
