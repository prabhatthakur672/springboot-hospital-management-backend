package com.prabhat._HospitalManagement.modules.Department.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DepartmentDoctorDTO {

    private Long id;
    private String name;
    private String specialization;
    private String email;
}
