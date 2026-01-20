package com.prabhat._HospitalManagement.modules.Doctor.repository;

import com.prabhat._HospitalManagement.modules.Doctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}