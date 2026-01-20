package com.prabhat._HospitalManagement.modules.Patient.dto;

import com.prabhat._HospitalManagement.modules.Patient.entity.BloodGroupType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
public class PatientResponseDTO {

    private Long id;
    private String name;
    private LocalDate birthDate;
    private String gender;
    private String email;
    private BloodGroupType bloodGroup;
    private LocalDateTime createdAt;
}
