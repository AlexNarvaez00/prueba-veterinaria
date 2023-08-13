package com.disruting.app.domain.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Narvaez Ruiz Alexis
 *         Representa al veterinario
 */
@Entity
@Table(name = "veterinaries")
@Getter
@Setter
public class Veterinary {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotBlank
  @NotNull
  @Pattern(regexp = "^[a-zA-Z]+$")
  @Column(name = "name", nullable = false, length = 50)
  private String name;

  @NotBlank
  @NotNull
  @Pattern(regexp = "^[a-zA-Z]+$")
  @Column(name = "first_name", nullable = false, length = 50)
  private String first_name;

  @NotBlank
  @NotNull
  @Pattern(regexp = "^[a-zA-Z]+$")
  @Column(name = "last_name", nullable = false, length = 50)
  private String last_name;

  @NotBlank
  @NotNull
  @Column(name = "license", nullable = false, length = 15)
  private String license;

  public Veterinary() {
    super();
  }

  public Veterinary(String name, String first_name, String last_name, String license) {
    this.name = name;
    this.first_name = first_name;
    this.last_name = last_name;
    this.license = license;
  }

}
