package com.sgic.semita.common.response;

import java.util.Collections;
import java.util.List;
import com.sgic.semita.enums.RestApiResponseStatus;
import com.sgic.semita.validation.ValidationFailure;

public class ValidationFailureResponse extends ApiResponse {
  private List<ValidationFailure> validationFailures;

  public ValidationFailureResponse(List<ValidationFailure> validationErrors) {
    super(RestApiResponseStatus.VALIDATION_FAILURE);
    this.validationFailures = validationErrors;
  }

  public ValidationFailureResponse(String message, String code) {
    super(RestApiResponseStatus.VALIDATION_FAILURE);
    ValidationFailure validationFailure = new ValidationFailure(message, code);
    this.validationFailures = Collections.singletonList(validationFailure);
  }

  public List<ValidationFailure> getValidationFailures() {
    return validationFailures;
  }

  public void setValidationFailures(List<ValidationFailure> validationFailures) {
    this.validationFailures = validationFailures;
  }
}
