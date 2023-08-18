package com.disruting.app.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.disruting.app.config.Cors;
import com.disruting.app.domain.entity.MedicalAppointment;
import com.disruting.app.domain.repository.MedicalAppointmentRepository;
import com.disruting.app.exception.NotFound.MedicalAppointmentNotFoundException;

import jakarta.validation.Valid;

/**
 * MedicalAppointmentController
 */
@RestController
@CrossOrigin(origins = {Cors.FRONT_END})
@RequestMapping("/api/v1/MedicalAppointments")
public class MedicalAppointmentController {

  @Autowired
  private MedicalAppointmentRepository repo;

  @GetMapping("")
  public Page<MedicalAppointment> getAllMedicalAppointments(@RequestParam(required = false, defaultValue = "0") int page) {
    PageRequest pageable = PageRequest.of(page, 10);
    return repo.findAll(pageable);
  }

  @GetMapping("/{id}")
  public MedicalAppointment getOneMedicalAppointments(@PathVariable("id") Long id) {
    return this.repo.findById(id).orElseThrow(() -> new MedicalAppointmentNotFoundException(id));
  }

  @PostMapping("/create")
  public MedicalAppointment createMedApp(@RequestBody @Valid MedicalAppointment newRecord) {
    return repo.save(newRecord);
  }

  /**
   * @param UUID id Ide de la cita medica
   */
  @DeleteMapping("/{id}")
  public void name(@PathVariable(name = "id") Long id) {
    this.repo.deleteById(id);
  }

}
