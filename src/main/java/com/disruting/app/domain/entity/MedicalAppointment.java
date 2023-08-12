package com.disruting.app.domain.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * MedicalAppointment
 */
@Entity
@Table(name = "medical_appointments")
@Getter
@Setter
public class MedicalAppointment {

  @Id
  private Long id;

  /**
   * Propietario
   */
  @ManyToOne
  private Owner owner;

  /**
   * Paciente
   */
  @ManyToOne
  private Patient patient;
 
  /**
   * Veterianio
   */
  @ManyToOne
  private Veterinary veterinary;

  @Column(name = "date")
  private LocalDate date;
  // "date" date
  public MedicalAppointment(){}

}
