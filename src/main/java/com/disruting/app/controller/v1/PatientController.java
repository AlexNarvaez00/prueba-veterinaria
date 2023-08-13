package com.disruting.app.controller.v1;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.disruting.app.domain.entity.*;
import com.disruting.app.domain.repository.PatientRepository;
import com.disruting.app.exception.NotFound.PatientNotFoundException;

import jakarta.validation.Valid;

/**
 * PatientController
 */
@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

  @Autowired
  private PatientRepository repo;

  @GetMapping("")
  public Page<Patient> getAllPatients(@RequestParam(required = false, defaultValue = "0") int page) {
    PageRequest pageable = PageRequest.of(page, 10);
    return repo.findAll(pageable);
  }

  @GetMapping("/{id}")
  public Patient getOnePatient(@PathVariable("id") UUID id) {
    return this.repo.findById(id).orElseThrow(()->new PatientNotFoundException(id) );
  }

  @PostMapping("/create")
  public Patient createNewPatient(@RequestBody @Valid Patient newPatient) {
    return repo.save(newPatient);
  }
  
  @DeleteMapping("/{id}")
  public void deletePatient(@PathVariable(name = "id") UUID id) {
    this.repo.deleteById(id);
  }


}
