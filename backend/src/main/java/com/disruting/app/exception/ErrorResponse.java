package com.disruting.app.exception;

import java.util.List;
import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ErrorResponse
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
  private String type;
  private HashMap<String,List<ErrorModel>> errors;
  //private List<ErrorModel> errors;
}
