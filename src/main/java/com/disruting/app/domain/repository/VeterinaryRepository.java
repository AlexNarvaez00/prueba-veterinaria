package com.disruting.app.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.disruting.app.domain.entity.Veterinary;

/**
 * VeterinaryRepository
 */
public interface VeterinaryRepository extends JpaRepository<Veterinary, UUID>{ 
}
