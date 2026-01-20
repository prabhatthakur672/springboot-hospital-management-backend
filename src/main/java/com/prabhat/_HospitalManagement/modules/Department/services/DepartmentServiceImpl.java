package com.prabhat._HospitalManagement.modules.Department.services;

import com.prabhat._HospitalManagement.modules.Department.dto.DepartmentDoctorDTO;
import com.prabhat._HospitalManagement.modules.Department.dto.DepartmentRequestDTO;
import com.prabhat._HospitalManagement.modules.Department.dto.DepartmentResponseDTO;
import com.prabhat._HospitalManagement.modules.Department.entity.Department;
import com.prabhat._HospitalManagement.modules.Department.mapper.DepartmentMapper;
import com.prabhat._HospitalManagement.modules.Department.repository.DepartmentRepository;
import com.prabhat._HospitalManagement.modules.Doctor.entity.Doctor;
import com.prabhat._HospitalManagement.modules.Doctor.repository.DoctorRepository;
import com.prabhat._HospitalManagement.modules.Department.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DoctorRepository doctorRepository;

    @Override
    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO dto) {
        Department department = new Department();
        department.setName(dto.getName());
        return DepartmentMapper.toDTO(departmentRepository.save(department));
    }

    @Override
    public DepartmentResponseDTO getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        return DepartmentMapper.toDTO(department);
    }

    @Override
    public List<DepartmentResponseDTO> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(DepartmentMapper::toDTO)
                .toList();
    }

    @Override
    public DepartmentResponseDTO updateDepartment(Long id, DepartmentRequestDTO dto) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        department.setName(dto.getName());
        return DepartmentMapper.toDTO(departmentRepository.save(department));
    }

    @Override
    public void deleteDepartment(Long id) {
        if (!departmentRepository.existsById(id)) {
            throw new RuntimeException("Department not found");
        }
        departmentRepository.deleteById(id);
    }

    @Override
    public void addDoctorToDepartment(Long departmentId, Long doctorId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        department.getDoctors().add(doctor);
        departmentRepository.save(department);
    }

    @Override
    public void removeDoctorFromDepartment(Long departmentId, Long doctorId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        department.getDoctors()
                .removeIf(doc -> doc.getId().equals(doctorId));

        departmentRepository.save(department);
    }

    @Override
    public void assignHeadDoctor(Long departmentId, Long doctorId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        department.setHeadDoctor(doctor);
        departmentRepository.save(department);
    }

    @Override
    public List<DepartmentDoctorDTO> getDepartmentDoctors(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        return department.getDoctors()
                .stream()
                .map(DepartmentMapper::toDoctorDTO)
                .toList();
    }

    @Override
    public DepartmentDoctorDTO getHeadDoctor(Long departmentId) {

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        Doctor headDoctor = department.getHeadDoctor();

        if (headDoctor == null) {
            throw new RuntimeException("Head doctor not assigned to this department");
        }

        return DepartmentMapper.toDoctorDTO(headDoctor);
    }

}
