package com.disruting.app.domain.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Patient
 */
@Entity
@Table(name = "patients")
public class Patient {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "name", nullable = false, length = 50)
  private String name;

  @Column(name = "type", nullable = false)
  private int type;
  
  /**
   * Propietario 
   */
  @ManyToOne
  private Owner owner;

  public Patient(String name, int type, Owner owner) {
    this.name = name;
    this.type = type;
    this.owner= owner;
  }
  //fecah de nacimiento
  // owner_id string [ref: > public.owners.id]
}
