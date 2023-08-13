package com.disruting.app.exception.NotFound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * MedicalAppointmentNotFoundException
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MedicalAppointmentNotFoundException extends RuntimeException{

  public MedicalAppointmentNotFoundException(Long id){
    super("Medical Appointment Not Found: " + id);
  }
}
