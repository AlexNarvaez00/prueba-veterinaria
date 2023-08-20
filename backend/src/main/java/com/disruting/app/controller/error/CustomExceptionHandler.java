package com.disruting.app.controller.error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.disruting.app.exception.ErrorModel;
import com.disruting.app.exception.ErrorResponse;

/**
 * CustomExceptionHandler
 */
@RestControllerAdvice
@Configuration
public class CustomExceptionHandler {

  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  public ErrorResponse handleException(MethodArgumentNotValidException e) {
    HashMap<String, List<ErrorModel>>  errorModels = proceessFieldError(e);
    return ErrorResponse.builder().type("VALIDATION").errors(errorModels).build();
  }

  public HashMap<String, List<ErrorModel>> proceessFieldError(MethodArgumentNotValidException e) {
    HashMap<String, List<ErrorModel>> errors = new HashMap<>();
    List<FieldError> errorsFields = e.getBindingResult().getFieldErrors();

    for (FieldError errorField : errorsFields) {
      String code = errorField.getCode();
      String detail = errorField.getDefaultMessage();

      var error = errors.get(errorField.getField());
      if (error == null) {
        error = errors.put(errorField.getField(), new ArrayList<ErrorModel>());
      }
      error.add( ErrorModel.builder().code(code).detail(detail).build()   );
    }

    return errors;
  }

}
