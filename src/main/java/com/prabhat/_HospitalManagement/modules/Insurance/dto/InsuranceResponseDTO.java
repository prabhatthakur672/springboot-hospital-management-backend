package com.prabhat._HospitalManagement.modules.Insurance.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
public class InsuranceResponseDTO {

    private Long id;
    private String policyNumber;
    private String provider;
    private LocalDate validUntil;
    private LocalDateTime createdAt;
}
