package com.prabhat._HospitalManagement.modules.Insurance.services;

import com.prabhat._HospitalManagement.modules.Insurance.dto.InsuranceRequestDTO;
import com.prabhat._HospitalManagement.modules.Insurance.dto.InsuranceResponseDTO;
import com.prabhat._HospitalManagement.modules.Insurance.entity.Insurance;
import com.prabhat._HospitalManagement.modules.Insurance.mapper.InsuranceMapper;
import com.prabhat._HospitalManagement.modules.Insurance.repository.InsuranceRepository;
import com.prabhat._HospitalManagement.modules.Insurance.services.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {

    private final InsuranceRepository insuranceRepository;

    @Override
    public InsuranceResponseDTO createInsurance(InsuranceRequestDTO dto) {
        Insurance insurance = InsuranceMapper.toEntity(dto);
        return InsuranceMapper.toDTO(insuranceRepository.save(insurance));
    }

    @Override
    public InsuranceResponseDTO getInsuranceById(Long id) {
        Insurance insurance = insuranceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insurance not found"));
        return InsuranceMapper.toDTO(insurance);
    }

    @Override
    public InsuranceResponseDTO getInsuranceByPolicyNumber(String policyNumber) {
        Insurance insurance = insuranceRepository.findByPolicyNumber(policyNumber)
                .orElseThrow(() -> new RuntimeException("Insurance not found"));
        return InsuranceMapper.toDTO(insurance);
    }

    @Override
    public List<InsuranceResponseDTO> getAllInsurances() {
        return insuranceRepository.findAll()
                .stream()
                .map(InsuranceMapper::toDTO)
                .toList();
    }

    @Override
    public InsuranceResponseDTO updateInsurance(Long id, InsuranceRequestDTO dto) {
        Insurance insurance = insuranceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insurance not found"));

        insurance.setPolicyNumber(dto.getPolicyNumber());
        insurance.setProvider(dto.getProvider());
        insurance.setValidUntil(dto.getValidUntil());

        return InsuranceMapper.toDTO(insuranceRepository.save(insurance));
    }

    @Override
    public void deleteInsurance(Long id) {
        if (!insuranceRepository.existsById(id)) {
            throw new RuntimeException("Insurance not found");
        }
        insuranceRepository.deleteById(id);
    }
}
