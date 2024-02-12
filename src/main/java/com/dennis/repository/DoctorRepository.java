package com.dennis.repository;

import com.dennis.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findOptionalByFirstNameAndLastName(String doctorFirstName, String doctorLastName);
}
