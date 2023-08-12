package com.disruting.app.controller.v1;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping("")
  public Iterable<MedicalAppointment> getAllMedicalAppointments() {
    return repo.findAll();
  }

  @PostMapping("/create")
  public MedicalAppointment createMedApp(MedicalAppointment newRecord) {
    return repo.save(newRecord);
  }

  /**
   * @param UUID id Ide de la cita medica
   */
  @DeleteMapping("/{id}")
  public void name(@PathVariable(name = "id") UUID id) {
    this.repo.deleteById(id);
  }

}
