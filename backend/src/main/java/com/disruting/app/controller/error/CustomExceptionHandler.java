package com.disruting.app.controller.error;

import java.util.ArrayList;
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
    List<ErrorModel> errorModels = proceessFieldError(e);

    return ErrorResponse.builder().type("VALIDATION").errors(errorModels).build();
  }

  public List<ErrorModel> proceessFieldError(MethodArgumentNotValidException e) {
    List<ErrorModel> validationsErrorModels = new ArrayList<>();

    for (FieldError errorField : e.getBindingResult().getFieldErrors()) {

      String code = errorField.getCode();
      String source = errorField.getObjectName() + "/" + errorField.getField();
      String detail = errorField.getField() + " " + errorField.getDefaultMessage();

      validationsErrorModels.add(ErrorModel.builder().code(code).source(source).detail(detail).build());
    }

    return validationsErrorModels;
  }

}
