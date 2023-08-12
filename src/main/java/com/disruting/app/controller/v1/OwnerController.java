package com.disruting.app.controller.v1;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.disruting.app.domain.entity.Owner;
import com.disruting.app.domain.repository.OwnerRepository;

/**
 * OwnerController
 */
@RestController
@RequestMapping("/api/v1/owners")
public class OwnerController {

  @Autowired
  private OwnerRepository repo;

  @GetMapping("")
  public Iterable<Owner> getAllOwners() {
    return repo.findAll();
  }

  @PostMapping("/create")
  public Owner createOwner(Owner record) {
    return repo.save(record);
  }

  @DeleteMapping("/{id}")
  public void deleteOwner(@PathVariable(name = "id") UUID id) {
    this.repo.deleteById(id);
  }

}
