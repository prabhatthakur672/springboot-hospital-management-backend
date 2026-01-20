package com.prabhat._HospitalManagement.modules.Patient.dto;

import com.prabhat._HospitalManagement.modules.Patient.entity.BloodGroupType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PatientRequestDTO {

    private String name;
    private LocalDate birthDate;
    private String gender;
    private String email;
    private BloodGroupType bloodGroup;
}
