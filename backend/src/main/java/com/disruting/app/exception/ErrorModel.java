package com.disruting.app.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorModel {
  /**
   * Causa "Pattern", "Min", "Max" ....
   */
  private String code;
  /**
   * Descripcion del problema
   */
  private String detail;
  // private String source;
}
