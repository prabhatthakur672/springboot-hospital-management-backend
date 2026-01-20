package com.prabhat._HospitalManagement.modules.Department.repository;

import com.prabhat._HospitalManagement.modules.Department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}