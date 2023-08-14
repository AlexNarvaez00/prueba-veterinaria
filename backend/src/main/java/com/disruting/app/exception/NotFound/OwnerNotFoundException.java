package com.disruting.app.exception.NotFound;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * OwnerNotFoundException
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class OwnerNotFoundException extends RuntimeException{

  public OwnerNotFoundException(UUID id){
    super("Owner Not Found: "+ id.toString());
  } 
}
