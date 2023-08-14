package com.disruting.app.exception.NotFound;

import java.util.UUID;

/**
 * PatientNotFoundException
 */
public class PatientNotFoundException extends RuntimeException {
  public PatientNotFoundException(UUID id) {
    super("Patient Not Found: " + id.toString());
  }
}
