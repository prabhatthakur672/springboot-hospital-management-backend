package com.prabhat._HospitalManagement.modules.Department.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DepartmentResponseDTO {

    private Long id;
    private String name;
    private String headDoctorName;
}
