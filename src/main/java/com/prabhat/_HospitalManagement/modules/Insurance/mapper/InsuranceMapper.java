package com.prabhat._HospitalManagement.modules.Insurance.mapper;

import com.prabhat._HospitalManagement.modules.Insurance.dto.InsuranceRequestDTO;
import com.prabhat._HospitalManagement.modules.Insurance.dto.InsuranceResponseDTO;
import com.prabhat._HospitalManagement.modules.Insurance.entity.Insurance;

public class InsuranceMapper {

    public static Insurance toEntity(InsuranceRequestDTO dto) {
        Insurance insurance = new Insurance();
        insurance.setPolicyNumber(dto.getPolicyNumber());
        insurance.setProvider(dto.getProvider());
        insurance.setValidUntil(dto.getValidUntil());
        return insurance;
    }

    public static InsuranceResponseDTO toDTO(Insurance insurance) {
        return InsuranceResponseDTO.builder()
                .id(insurance.getId())
                .policyNumber(insurance.getPolicyNumber())
                .provider(insurance.getProvider())
                .validUntil(insurance.getValidUntil())
                .createdAt(insurance.getCreatedAt())
                .build();
    }
}
