package com.prabhat._HospitalManagement.modules.Insurance.services;

import com.prabhat._HospitalManagement.modules.Insurance.dto.InsuranceRequestDTO;
import com.prabhat._HospitalManagement.modules.Insurance.dto.InsuranceResponseDTO;

import java.util.List;

public interface InsuranceService {

    InsuranceResponseDTO createInsurance(InsuranceRequestDTO dto);

    InsuranceResponseDTO getInsuranceById(Long id);

    InsuranceResponseDTO getInsuranceByPolicyNumber(String policyNumber);

    List<InsuranceResponseDTO> getAllInsurances();

    InsuranceResponseDTO updateInsurance(Long id, InsuranceRequestDTO dto);

    void deleteInsurance(Long id);
}




/// +++++++++++++++++++++++ Learning Purpose +++++++++++++++++

//@Service
//@RequiredArgsConstructor
//public class InsuranceService {
//    private final PatientRepository patientRepository;
//    private final InsuranceRepository insuranceRepository;
//
//    @Transactional
//    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId){
//        Patient patient = patientRepository.findById(patientId).orElseThrow(()->new EntityNotFoundException("Patient not found with id: "+ patientId));
//
//        patient.setInsurance(insurance);
//
//        insurance.setPatient(patient); // just write to main bidirectional consistency
//
//        return patient;
//    }
//}
