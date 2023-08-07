package com.disruting.app.domain.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Owner
 */
@Entity
@Table(name = "owners")
public class Owner {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "name", nullable = false, length = 50)
  private String name;

  @Column(name = "first_name", nullable = false, length = 50)
  private String first_name;

  @Column(name = "last_name", nullable = false, length = 50)
  private String last_name;

  @Column(name = "phone", nullable = true, length = 15)
  private String phone;

  @OneToMany(mappedBy = "owner")
  private List<Patient> patients;

  public Owner(String name, String first_name, String last_name, String phone) {
    this.name = name;
    this.first_name = first_name;
    this.last_name = last_name;
    this.phone = phone;
  }

}
