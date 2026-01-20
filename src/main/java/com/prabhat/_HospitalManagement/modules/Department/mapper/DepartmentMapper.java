package com.prabhat._HospitalManagement.modules.Department.mapper;

import com.prabhat._HospitalManagement.modules.Department.dto.DepartmentDoctorDTO;
import com.prabhat._HospitalManagement.modules.Department.dto.DepartmentResponseDTO;
import com.prabhat._HospitalManagement.modules.Department.entity.Department;
import com.prabhat._HospitalManagement.modules.Doctor.entity.Doctor;

public class DepartmentMapper {

    public static DepartmentResponseDTO toDTO(Department department) {
        return DepartmentResponseDTO.builder()
                .id(department.getId())
                .name(department.getName())
                .headDoctorName(
                        department.getHeadDoctor() != null
                                ? department.getHeadDoctor().getName()
                                : null
                )
                .build();
    }

    public static DepartmentDoctorDTO toDoctorDTO(Doctor doctor) {
        return DepartmentDoctorDTO.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .specialization(doctor.getSpecialization())
                .email(doctor.getEmail())
                .build();
    }
}
