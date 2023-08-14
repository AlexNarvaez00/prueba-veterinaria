package com.disruting.app.domain.entity;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

/**
 * Patient
 */
@Entity
@Table(name = "patients")
@Getter
@Setter
public class Patient {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotBlank
  @Pattern(regexp = "^[a-zA-Z]+$")
  @Column(name = "name", nullable = false, length = 50)
  private String name;

  @Max(value = 3)
  @Positive
  @Column(name = "type", nullable = false)
  private int type;

  /**
   * Propietario
   */
  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnore
  private Owner owner;

  public Patient() {
    super();
  }

  public Patient(String name, int type, Owner owner) {
    this.name = name;
    this.type = type;
    this.owner = owner;
  }
}
