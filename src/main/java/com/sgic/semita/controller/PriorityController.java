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
import com.sgic.semita.entities.Priority;
import com.sgic.semita.enums.RestApiResponseStatus;
import com.sgic.semita.request.dto.PriorityRequestDto;
import com.sgic.semita.services.PriorityService;
import com.sgic.semita.utils.Constants;
import com.sgic.semita.utils.EndPointURI;
import com.sgic.semita.utils.ValidationFailureResponseCode;

@CrossOrigin
@RestController
public class PriorityController {

  
  @Autowired
  private PriorityService priorityService;

  @Autowired
  private ValidationFailureResponseCode validationFailureResponseCode;

  /*
   * Description: Create designation API || Author: Keerthana || Date: 16-04-2023
   */
  @PostMapping(value = EndPointURI.PRIORITY)
  public ResponseEntity<Object> createPriority(
      @RequestBody PriorityRequestDto priorityRequestDto) {
    if (priorityService.isPriorityExists(priorityRequestDto.getName())) {
      return new ResponseEntity<>(
          new ValidationFailureResponse(Constants.PRIORITY_ALREADY_EXISTS,
              validationFailureResponseCode.getPriorityAlreadyExists()),
          HttpStatus.BAD_REQUEST);
    }
    Priority priority = new Priority();
    BeanUtils.copyProperties(priorityRequestDto, priority);
    priorityService.savePriority(priority);
    return new ResponseEntity<>(
        new BasicResponse(RestApiResponseStatus.OK, Constants.ADD_PRIORITY_SUCCESS),
        HttpStatus.OK);
  }

  /*
   * Description: Get all designation API || Author: Keerthana || Date: 16-04-2023
   */
  @GetMapping(value = EndPointURI.PRIORITYS)
  public ResponseEntity<Object> getAllPrioritys() {
    return new ResponseEntity<>(new ContentResponse<>(Constants.PRIORITYS,
        priorityService.getAllPriority(), RestApiResponseStatus.OK), null, HttpStatus.OK);
  }

  /*
   * Description: Get designation by id API || Author: Keerthana || Date: 16-04-2023
   */
  @GetMapping(value = EndPointURI.PRIORITY_BY_ID)
  public ResponseEntity<Object> getPriorityById(@PathVariable Long id) {
    if (!priorityService.existByPriority(id)) {
      return new ResponseEntity<>(new ValidationFailureResponse(Constants.PRIORITY_NOT_EXISTS,
          validationFailureResponseCode.getPriorityNotExists()), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(new ContentResponse<>(Constants.PRIORITY,
        priorityService.getPriorityById(id), RestApiResponseStatus.OK), null, HttpStatus.OK);
  }

  /*
   * Description: Update designation API || Author: Keerthana || Date: 16-04-2023
   */
  @PutMapping(value = EndPointURI.PRIORITY)
  public ResponseEntity<Object> updatePriority(
      @RequestBody PriorityRequestDto priorityRequestDto) {
    if (priorityService.existByPriority(priorityRequestDto.getId())) {
      if (priorityService.isUpdatedPriorityNameExist(priorityRequestDto.getId(),
          priorityRequestDto.getName())) {
        return new ResponseEntity<>(
            new ValidationFailureResponse(Constants.PRIORITY_ALREADY_EXISTS,
                validationFailureResponseCode.getDesignationAlreadyExists()),
            HttpStatus.BAD_REQUEST);
      }
      Priority priority = new Priority();
      BeanUtils.copyProperties(priorityRequestDto, priority);
      priorityService.savePriority(priority);
      return new ResponseEntity<>(
          new BasicResponse(RestApiResponseStatus.OK, Constants.UPDATE_PRIORITY_SUCCESS),
          HttpStatus.OK);
    }
    return new ResponseEntity<>(new ValidationFailureResponse(Constants.PRIORITY_NOT_EXISTS,
        validationFailureResponseCode.getPriorityNotExists()), HttpStatus.BAD_REQUEST);
  }

  /*
   * Description: Delete designation API || Author: Keerthana || Date: 17-03-2023
   */
  @DeleteMapping(value = EndPointURI.PRIORITY_BY_ID)
  public ResponseEntity<Object> deletePriority(@PathVariable Long id) {
    if (priorityService.existByPriority(id)) {
      priorityService.deletePriority(id);
      return new ResponseEntity<>(
          new BasicResponse(RestApiResponseStatus.OK, Constants.DELETE_PRIORITY_SUCCESS),
          HttpStatus.OK);
    }
    return new ResponseEntity<>(new ValidationFailureResponse(Constants.PRIORITY_NOT_EXISTS,
        validationFailureResponseCode.getDesignationNotExists()), HttpStatus.BAD_REQUEST);
  }
  
  
}
