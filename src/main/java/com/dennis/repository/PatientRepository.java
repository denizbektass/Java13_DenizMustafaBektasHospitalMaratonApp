package com.dennis.repository;

import com.dennis.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findOptionalByDoctorId(Long id);
}
