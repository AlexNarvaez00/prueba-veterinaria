package com.disruting.app.domain.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

  public MedicalAppointment(Owner owner, Patient patient, Veterinary veterinary, String date) {
    this.owner = owner;
    this.patient = patient;
    this.veterinary = veterinary;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    this.date = LocalDate.parse(date, formatter);
    // Timestamp.valueOf(LocalDateTime.parse(date));
  }

}
