package com.prabhat._HospitalManagement.modules.Doctor.services;

import com.prabhat._HospitalManagement.modules.Doctor.dto.DoctorAppointmentDTO;
import com.prabhat._HospitalManagement.modules.Doctor.dto.DoctorRequestDTO;
import com.prabhat._HospitalManagement.modules.Doctor.dto.DoctorResponseDTO;

import java.util.List;

public interface DoctorService {

    DoctorResponseDTO createDoctor(DoctorRequestDTO dto);

    DoctorResponseDTO getDoctorById(Long id);

    List<DoctorResponseDTO> getAllDoctors();

    DoctorResponseDTO updateDoctor(Long id, DoctorRequestDTO dto);

    void deleteDoctor(Long id);

    List<DoctorAppointmentDTO> getDoctorAppointments(Long doctorId);

    List<String> getDoctorDepartments(Long doctorId);
}
