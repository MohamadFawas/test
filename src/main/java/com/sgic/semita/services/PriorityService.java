package com.sgic.semita.services;

import java.util.List;
import com.sgic.semita.entities.Priority;

public interface PriorityService {
  
  public void savePriority(Priority priority);
  
  public List<Priority> getAllPriority();
  
  public boolean isPriorityExists(String name);
  
  public boolean isPriorityExists1(String colour);
  
  public Priority getPriorityById(Long id);

  public boolean existByPriority(Long id);
  
  public boolean isUpdatedPriorityNameExist(Long id, String name);
  
  public void deletePriority(Long id);
  
}
