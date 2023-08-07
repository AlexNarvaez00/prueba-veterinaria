package com.disruting.app.domain.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.disruting.app.domain.entity.Owner;

/**
 * OwnerRepository
 */
public interface OwnerRepository extends CrudRepository<Owner, UUID>{
}
