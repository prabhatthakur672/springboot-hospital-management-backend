package com.prabhat._HospitalManagement.modules.Insurance.repository;

import com.prabhat._HospitalManagement.modules.Insurance.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

    Optional<Insurance> findByPolicyNumber(String policyNumber);
}
