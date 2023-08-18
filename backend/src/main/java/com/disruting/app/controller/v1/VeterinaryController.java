package com.disruting.app.controller.v1;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.disruting.app.config.Cors;
import com.disruting.app.domain.entity.*;
import com.disruting.app.domain.repository.VeterinaryRepository;
import com.disruting.app.exception.NotFound.VeterinaryNotFoundException;

import jakarta.validation.Valid;

/**
 * @author Narvaez Ruiz Alexis
 *         VeterinaryController
 */
@RestController
@RequestMapping("/api/v1/veterinaries")
@CrossOrigin(origins = { Cors.FRONT_END })
public class VeterinaryController {

  @Autowired
  private VeterinaryRepository repo;

  @GetMapping("")
  public Page<Veterinary> getAllVeterianries(@RequestParam(required = false, defaultValue = "0") int page) {
    PageRequest pageable = PageRequest.of(page, 10);
    return this.repo.findAll(pageable);
  }

  @GetMapping("/{id}")
  public Veterinary getOneVeterinary(@PathVariable("id") UUID id) {
    return this.repo.findById(id).orElseThrow(() -> new VeterinaryNotFoundException(id));
  }

  @PutMapping("/{id}")
  public void updateVeterinary(@PathVariable("id") UUID id, @RequestBody @Valid Veterinary veterinary) {
    veterinary.setId(id);
    this.repo.save(veterinary);
  }

  @PostMapping("/create")
  public Veterinary createNewVeterinary(@RequestBody @Valid Veterinary newVeterinary) {
    return this.repo.save(newVeterinary);
  }

  @DeleteMapping("/{id}")
  public void deleteVeterinary(@PathVariable(name = "id") UUID id) {
    this.repo.deleteById(id);
  }
}
