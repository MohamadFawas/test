package com.sgic.semita.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sgic.semita.common.response.BasicResponse;
import com.sgic.semita.common.response.ContentResponse;
import com.sgic.semita.common.response.ValidationFailureResponse;
import com.sgic.semita.entities.Designation;
import com.sgic.semita.enums.RestApiResponseStatus;
import com.sgic.semita.request.dto.DesignationRequestDto;
import com.sgic.semita.services.DesignationService;
import com.sgic.semita.utils.Constants;
import com.sgic.semita.utils.EndPointURI;
import com.sgic.semita.utils.ValidationFailureResponseCode;

@CrossOrigin
@RestController
public class DesignationController {
  @Autowired
  private DesignationService designationService;

  @Autowired
  private ValidationFailureResponseCode validationFailureResponseCode;

  /*
   * Description: Create designation API || Author: Keerthana || Date: 16-04-2023
   */
  @PostMapping(value = EndPointURI.DESIGNATION)
  public ResponseEntity<Object> createDesignation(
      @RequestBody DesignationRequestDto designationRequestDto) {
    if (designationService.isDesignationExists(designationRequestDto.getName())) {
      return new ResponseEntity<>(
          new ValidationFailureResponse(Constants.DESIGNATION_ALREADY_EXISTS,
              validationFailureResponseCode.getDesignationAlreadyExists()),
          HttpStatus.BAD_REQUEST);
    }
    Designation designation = new Designation();
    BeanUtils.copyProperties(designationRequestDto, designation);
    designationService.saveDesignation(designation);
    return new ResponseEntity<>(
        new BasicResponse(RestApiResponseStatus.OK, Constants.ADD_DESIGNATION_SUCCESS),
        HttpStatus.OK);
  }

  /*
   * Description: Get all designation API || Author: Keerthana || Date: 16-04-2023
   */
  @GetMapping(value = EndPointURI.DESIGNATIONS)
  public ResponseEntity<Object> getAllDesignations() {
    return new ResponseEntity<>(new ContentResponse<>(Constants.DESIGNATIONS,
        designationService.getAllDesignation(), RestApiResponseStatus.OK), null, HttpStatus.OK);
  }

  /*
   * Description: Get designation by id API || Author: Keerthana || Date: 16-04-2023
   */
  @GetMapping(value = EndPointURI.DESIGNATION_BY_ID)
  public ResponseEntity<Object> getDesignationById(@PathVariable Long id) {
    if (!designationService.existByDesignation(id)) {
      return new ResponseEntity<>(new ValidationFailureResponse(Constants.DESIGNATION_NOT_EXISTS,
          validationFailureResponseCode.getDesignationNotExists()), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(new ContentResponse<>(Constants.DESIGNATION,
        designationService.getDesignationById(id), RestApiResponseStatus.OK), null, HttpStatus.OK);
  }

  /*
   * Description: Update designation API || Author: Keerthana || Date: 16-04-2023
   */
  @PutMapping(value = EndPointURI.DESIGNATION)
  public ResponseEntity<Object> updateDesignation(
      @RequestBody DesignationRequestDto designationRequestDto) {
    if (designationService.existByDesignation(designationRequestDto.getId())) {
      if (designationService.isUpdatedDesignationNameExist(designationRequestDto.getId(),
          designationRequestDto.getName())) {
        return new ResponseEntity<>(
            new ValidationFailureResponse(Constants.DESIGNATION_ALREADY_EXISTS,
                validationFailureResponseCode.getDesignationAlreadyExists()),
            HttpStatus.BAD_REQUEST);
      }
      Designation designation = new Designation();
      BeanUtils.copyProperties(designationRequestDto, designation);
      designationService.saveDesignation(designation);
      return new ResponseEntity<>(
          new BasicResponse(RestApiResponseStatus.OK, Constants.UPDATE_DESIGNATION_SUCCESS),
          HttpStatus.OK);
    }
    return new ResponseEntity<>(new ValidationFailureResponse(Constants.DESIGNATION_NOT_EXISTS,
        validationFailureResponseCode.getDesignationNotExists()), HttpStatus.BAD_REQUEST);
  }

  /*
   * Description: Delete designation API || Author: Keerthana || Date: 17-03-2023
   */
  @DeleteMapping(value = EndPointURI.DESIGNATION_BY_ID)
  public ResponseEntity<Object> deleteDesignation(@PathVariable Long id) {
    if (designationService.existByDesignation(id)) {
      designationService.deleteDesignation(id);
      return new ResponseEntity<>(
          new BasicResponse(RestApiResponseStatus.OK, Constants.DELETE_DESIGNATION_SUCCESS),
          HttpStatus.OK);
    }
    return new ResponseEntity<>(new ValidationFailureResponse(Constants.DESIGNATION_NOT_EXISTS,
        validationFailureResponseCode.getDesignationNotExists()), HttpStatus.BAD_REQUEST);
  }
}
