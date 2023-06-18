package com.sgic.semita.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.semita.entities.Priority;
import com.sgic.semita.repositories.PriorityRepository;
import com.sgic.semita.services.PriorityService;

@Service
public class PriorityServiceImpl implements PriorityService {
  
  @Autowired
  private PriorityRepository priorityRepository;

  @Override
  public void savePriority(Priority priority) {
    priorityRepository.save(priority);
    
  }

  @Override
  public List<Priority> getAllPriority() {
    return priorityRepository.findAll();
  }

  @Override
  public boolean isPriorityExists(String name) {
    return priorityRepository.existsByNameIgnoreCase(name);
  }

  @Override
  public boolean isPriorityExists1(String colour) {
    return priorityRepository.existsByNameIgnoreCase(colour);
  }

  @Override
  public Priority getPriorityById(Long id) {
    return priorityRepository.findById(id).get();
  }

  @Override
  public boolean existByPriority(Long id) {
    return priorityRepository.existsById(id);
  }

  @Override
  public boolean isUpdatedPriorityNameExist(Long id, String name) {
    if ((!getPriorityById(id).getName().equalsIgnoreCase(name)) && (isPriorityExists(name))) {
      return true;
    }
    return false;
  }

  @Override
  public void deletePriority(Long id) {
    priorityRepository.deleteById(id);
    
  }
  
  

}
