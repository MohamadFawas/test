package com.sgic.semita.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.semita.entities.Designation;
import com.sgic.semita.repositories.DesignationRepository;
import com.sgic.semita.services.DesignationService;

@Service
public class DesignationServiceImpl implements DesignationService {

  @Autowired
  private DesignationRepository designationRepository;

  @Override
  public void saveDesignation(Designation designation) {
    designationRepository.save(designation);
  }

  @Override
  public List<Designation> getAllDesignation() {
    return designationRepository.findAll();
  }

  @Override
  public boolean isDesignationExists(String name) {
    return designationRepository.existsByNameIgnoreCase(name);
  }

  @Override
  public Designation getDesignationById(Long id) {
    return designationRepository.findById(id).get();
  }

  @Override
  public boolean existByDesignation(Long id) {
    return designationRepository.existsById(id);
  }

  @Override
  public boolean isUpdatedDesignationNameExist(Long id, String name) {
    if ((!getDesignationById(id).getName().equalsIgnoreCase(name)) && (isDesignationExists(name))) {
      return true;
    }
    return false;
  }

  @Override
  public void deleteDesignation(Long id) {
    designationRepository.deleteById(id);
  }
}
