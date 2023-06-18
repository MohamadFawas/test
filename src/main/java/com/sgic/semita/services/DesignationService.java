package com.sgic.semita.services;

import java.util.List;
import com.sgic.semita.entities.Designation;

public interface DesignationService {
  public void saveDesignation(Designation designation);

  public List<Designation> getAllDesignation();

  public boolean isDesignationExists(String name);

  public Designation getDesignationById(Long id);

  public boolean existByDesignation(Long id);

  public boolean isUpdatedDesignationNameExist(Long id, String name);

  public void deleteDesignation(Long id);
}
