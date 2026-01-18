package com.prabhat._HospitalManagement.repository;

import com.prabhat._HospitalManagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}