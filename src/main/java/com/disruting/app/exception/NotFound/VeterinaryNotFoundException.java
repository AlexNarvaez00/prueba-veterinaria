package com.disruting.app.exception.NotFound;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * VeterinaryNotFoundException
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class VeterinaryNotFoundException extends RuntimeException {

  public VeterinaryNotFoundException(UUID id) {
    super("Veterinary Not Found: " + id.toString());
  }
}
