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

import com.disruting.app.domain.entity.Owner;
import com.disruting.app.domain.repository.OwnerRepository;
import com.disruting.app.exception.NotFound.OwnerNotFoundException;

import jakarta.validation.Valid;

/**
 * OwnerController
 */
@RestController
@RequestMapping("/api/v1/owners")
public class OwnerController {

  @Autowired
  private OwnerRepository repo;

  @GetMapping("")
  public Page<Owner> getAllOwners(@RequestParam(required = false, defaultValue = "0") int page) {
    PageRequest pageable = PageRequest.of(page, 10);
    return repo.findAll(pageable);
  }

  @GetMapping("/{id}")
  public Owner getOneOwner(@PathVariable("id") UUID id) {
    return this.repo.findById(id).orElseThrow(() -> new OwnerNotFoundException(id));
  }

  @PostMapping("/create")
  public Owner createOwner(@RequestBody @Valid Owner record) {
    return repo.save(record);
  }

  @DeleteMapping("/{id}")
  public void deleteOwner(@PathVariable(name = "id") UUID id) {
    this.repo.deleteById(id);
  }

}
