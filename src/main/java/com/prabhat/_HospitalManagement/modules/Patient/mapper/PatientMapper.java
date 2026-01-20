package com.prabhat._HospitalManagement.modules.Patient.mapper;

import com.prabhat._HospitalManagement.modules.Patient.dto.PatientRequestDTO;
import com.prabhat._HospitalManagement.modules.Patient.dto.PatientResponseDTO;
import com.prabhat._HospitalManagement.modules.Patient.entity.Patient;

public class PatientMapper {

    public static Patient toEntity(PatientRequestDTO dto) {
        Patient patient = new Patient();
        patient.setName(dto.getName());
        patient.setBirthDate(dto.getBirthDate());
        patient.setGender(dto.getGender());
        patient.setEmail(dto.getEmail());
        patient.setBloodGroup(dto.getBloodGroup());
        return patient;
    }

    public static PatientResponseDTO toDTO(Patient patient) {
        return PatientResponseDTO.builder()
                .id(patient.getId())
                .name(patient.getName())
                .birthDate(patient.getBirthDate())
                .gender(patient.getGender())
                .email(patient.getEmail())
                .bloodGroup(patient.getBloodGroup())
                .createdAt(patient.getCreatedAt())
                .build();
    }
}
