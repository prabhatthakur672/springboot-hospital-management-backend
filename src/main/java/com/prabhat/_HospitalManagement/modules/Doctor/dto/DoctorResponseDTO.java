package com.prabhat._HospitalManagement.modules.Doctor.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DoctorResponseDTO {

    private Long id;
    private String name;
    private String specialization;
    private String email;
}
