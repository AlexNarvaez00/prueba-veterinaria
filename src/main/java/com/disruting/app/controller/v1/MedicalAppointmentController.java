package com.disruting.app.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.disruting.app.domain.entity.MedicalAppointment;
import com.disruting.app.domain.repository.MedicalAppointmentRepository;

/**
 * MedicalAppointmentController
 */
@RestController
@RequestMapping("/api/v1/MedicalAppointments")
public class MedicalAppointmentController {
  
  @Autowired
  private MedicalAppointmentRepository repo;

  @GetMapping
  public Iterable getAllMedicalAppointments() {
    return repo.findAll();
  }

  @PostMapping
  public MedicalAppointment createMedApp(MedicalAppointment newRecord) {
    return repo.save(newRecord);
  }
  
}


