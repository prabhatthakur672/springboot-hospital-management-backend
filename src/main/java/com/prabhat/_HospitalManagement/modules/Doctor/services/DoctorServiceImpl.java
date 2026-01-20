package com.prabhat._HospitalManagement.modules.Doctor.services;

import com.prabhat._HospitalManagement.modules.Doctor.dto.DoctorAppointmentDTO;
import com.prabhat._HospitalManagement.modules.Doctor.dto.DoctorRequestDTO;
import com.prabhat._HospitalManagement.modules.Doctor.dto.DoctorResponseDTO;
import com.prabhat._HospitalManagement.modules.Doctor.entity.Doctor;
import com.prabhat._HospitalManagement.modules.Doctor.mapper.DoctorMapper;
import com.prabhat._HospitalManagement.modules.Doctor.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public DoctorResponseDTO createDoctor(DoctorRequestDTO dto) {
        Doctor doctor = DoctorMapper.toEntity(dto);
        return DoctorMapper.toDTO(doctorRepository.save(doctor));
    }

    @Override
    public DoctorResponseDTO getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        return DoctorMapper.toDTO(doctor);
    }

    @Override
    public List<DoctorResponseDTO> getAllDoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(DoctorMapper::toDTO)
                .toList();
    }

    @Override
    public DoctorResponseDTO updateDoctor(Long id, DoctorRequestDTO dto) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        doctor.setName(dto.getName());
        doctor.setSpecialization(dto.getSpecialization());
        doctor.setEmail(dto.getEmail());

        return DoctorMapper.toDTO(doctorRepository.save(doctor));
    }

    @Override
    public void deleteDoctor(Long id) {
        if (!doctorRepository.existsById(id)) {
            throw new RuntimeException("Doctor not found");
        }
        doctorRepository.deleteById(id);
    }

    @Override
    public List<DoctorAppointmentDTO> getDoctorAppointments(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        return doctor.getAppointments()
                .stream()
                .map(DoctorMapper::toAppointmentDTO)
                .toList();
    }

    @Override
    public List<String> getDoctorDepartments(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        return doctor.getDepartments()
                .stream()
                .map(d -> d.getName())
                .toList();
    }
}
