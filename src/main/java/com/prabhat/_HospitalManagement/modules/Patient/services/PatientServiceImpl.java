package com.prabhat._HospitalManagement.modules.Patient.services;

import com.prabhat._HospitalManagement.modules.Insurance.entity.Insurance;
import com.prabhat._HospitalManagement.modules.Insurance.repository.InsuranceRepository;
import com.prabhat._HospitalManagement.modules.Patient.dto.PatientRequestDTO;
import com.prabhat._HospitalManagement.modules.Patient.dto.PatientResponseDTO;
import com.prabhat._HospitalManagement.modules.Patient.entity.Patient;
import com.prabhat._HospitalManagement.modules.Patient.mapper.PatientMapper;
import com.prabhat._HospitalManagement.modules.Patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final InsuranceRepository insuranceRepository;

    @Override
    public PatientResponseDTO createPatient(PatientRequestDTO dto) {
        Patient patient = PatientMapper.toEntity(dto);
        return PatientMapper.toDTO(patientRepository.save(patient));
    }

    @Override
    public PatientResponseDTO getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        return PatientMapper.toDTO(patient);
    }

    @Override
    public List<PatientResponseDTO> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(PatientMapper::toDTO)
                .toList();
    }

    @Override
    public PatientResponseDTO updatePatient(Long id, PatientRequestDTO dto) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        patient.setName(dto.getName());
        patient.setBirthDate(dto.getBirthDate());
        patient.setGender(dto.getGender());
        patient.setEmail(dto.getEmail());
        patient.setBloodGroup(dto.getBloodGroup());

        return PatientMapper.toDTO(patientRepository.save(patient));
    }

    @Override
    public void deletePatient(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new RuntimeException("Patient not found");
        }
        patientRepository.deleteById(id);
    }

    @Override
    public void assignInsurance(Long patientId, Long insuranceId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Insurance insurance = insuranceRepository.findById(insuranceId)
                .orElseThrow(() -> new RuntimeException("Insurance not found"));

        patient.setInsurance(insurance);
        patientRepository.save(patient);
    }
}
