package com.prabhat._HospitalManagement.modules.Department.services;

import com.prabhat._HospitalManagement.modules.Department.dto.DepartmentDoctorDTO;
import com.prabhat._HospitalManagement.modules.Department.dto.DepartmentRequestDTO;
import com.prabhat._HospitalManagement.modules.Department.dto.DepartmentResponseDTO;

import java.util.List;

public interface DepartmentService {

    DepartmentResponseDTO createDepartment(DepartmentRequestDTO dto);

    DepartmentResponseDTO getDepartmentById(Long id);

    List<DepartmentResponseDTO> getAllDepartments();

    DepartmentResponseDTO updateDepartment(Long id, DepartmentRequestDTO dto);

    void deleteDepartment(Long id);

    void addDoctorToDepartment(Long departmentId, Long doctorId);

    void removeDoctorFromDepartment(Long departmentId, Long doctorId);

    void assignHeadDoctor(Long departmentId, Long doctorId);

    List<DepartmentDoctorDTO> getDepartmentDoctors(Long departmentId);

    DepartmentDoctorDTO getHeadDoctor(Long departmentId);

}
