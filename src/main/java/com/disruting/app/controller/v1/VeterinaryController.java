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
import com.disruting.app.domain.repository.VeterinaryRepository;

/**
 * @author Narvaez Ruiz Alexis
 *         VeterinaryController
 */
@RestController
@RequestMapping("/api/v1/veterinaries")
public class VeterinaryController {

  @Autowired
  private VeterinaryRepository repo;

  @GetMapping("")
  public Iterable<Veterinary> getAllVeterianries() {
    return repo.findAll();
  }

  @PostMapping("/create")
  public Veterinary createNewVeterinary(Veterinary newVeterinary) {
    return repo.save(newVeterinary);
  }

  @DeleteMapping("/{id}")
  public void deleteVeterinary(@PathVariable(name = "id") UUID id) {
    repo.deleteById(id);
  }
}
