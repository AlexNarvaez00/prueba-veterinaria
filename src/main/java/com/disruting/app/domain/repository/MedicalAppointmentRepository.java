package com.disruting.app.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.disruting.app.domain.entity.MedicalAppointment;

/**
 * MedicalAppointmentRepository
 */
public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, Long>{ 
}
