package com.prabhat._HospitalManagement.repository;

import com.prabhat._HospitalManagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    // +++++++++++ These are custom Query methods in JPA +++++++++++++++++++

    // follow nomenclature cuz hibernate generate these methods
    // if model(entity) field name is birthDate, then method name should be findByBirthDate
    Patient findByName(String name);

    Patient findByBirthDate(LocalDate birthDate);

    Patient findByNameOrEmail(String name, String email);


    // ++++++++++++++++++++ JPQL custom methods ++++++++++++++++++++
    @Query("SELECT p FROM Patient p WHERE p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate date);
}
