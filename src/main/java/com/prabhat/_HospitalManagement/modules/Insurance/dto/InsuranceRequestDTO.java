package com.prabhat._HospitalManagement.modules.Insurance.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class InsuranceRequestDTO {

    private String policyNumber;
    private String provider;
    private LocalDate validUntil;
}
