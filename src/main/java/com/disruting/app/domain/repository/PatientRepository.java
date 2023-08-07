package com.disruting.app.domain.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.disruting.app.domain.entity.Patient;

/**
 * PatientRepository
 */
public interface PatientRepository extends CrudRepository<Patient, UUID>{
}
