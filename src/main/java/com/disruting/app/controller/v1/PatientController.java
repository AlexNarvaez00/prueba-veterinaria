package com.disruting.app.controller.v1;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.disruting.app.domain.entity.*;
import com.disruting.app.domain.repository.PatientRepository;

/**
 * PatientController
 */
@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

  @Autowired
  private PatientRepository repo;

  @GetMapping("")
  public Iterable<Patient> getAllPatients() {
    return repo.findAll();
  }

  @PostMapping("/create")
  public Patient createNewPatient(Patient newPatient) {
    return repo.save(newPatient);
  }
  
  @DeleteMapping("/{id}")
  public void deletePatient(@PathVariable(name = "id") UUID id) {
    this.repo.deleteById(id);
  }


}
