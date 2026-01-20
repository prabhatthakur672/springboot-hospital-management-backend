package com.prabhat._HospitalManagement.modules.Insurance.controllers;

import com.prabhat._HospitalManagement.common.response.ApiResponse;
import com.prabhat._HospitalManagement.modules.Insurance.dto.InsuranceRequestDTO;
import com.prabhat._HospitalManagement.modules.Insurance.dto.InsuranceResponseDTO;
import com.prabhat._HospitalManagement.modules.Insurance.services.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/insurances")
@RequiredArgsConstructor
public class InsuranceController {

    private final InsuranceService insuranceService;

    @PostMapping
    public ResponseEntity<ApiResponse<Map<String, Object>>> createInsurance(
            @RequestBody InsuranceRequestDTO dto) {

        InsuranceResponseDTO insurance = insuranceService.createInsurance(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.<Map<String, Object>>builder()
                        .message("Insurance created successfully")
                        .data(Map.of("insurance", insurance))
                        .error(null)
                        .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getInsuranceById(
            @PathVariable Long id) {

        InsuranceResponseDTO insurance = insuranceService.getInsuranceById(id);

        return ResponseEntity.ok(
                ApiResponse.<Map<String, Object>>builder()
                        .message("Insurance fetched successfully")
                        .data(Map.of("insurance", insurance))
                        .error(null)
                        .build());
    }

    @GetMapping("/policy/{policyNumber}")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getInsuranceByPolicy(
            @PathVariable String policyNumber) {

        InsuranceResponseDTO insurance = insuranceService.getInsuranceByPolicyNumber(policyNumber);

        return ResponseEntity.ok(
                ApiResponse.<Map<String, Object>>builder()
                        .message("Insurance fetched successfully")
                        .data(Map.of("insurance", insurance))
                        .error(null)
                        .build());
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Map<String, Object>>> getAllInsurances() {

        var insurances = insuranceService.getAllInsurances();

        return ResponseEntity.ok(
                ApiResponse.<Map<String, Object>>builder()
                        .message("Insurances fetched successfully")
                        .data(Map.of("insurances", insurances))
                        .error(null)
                        .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Map<String, Object>>> updateInsurance(
            @PathVariable Long id,
            @RequestBody InsuranceRequestDTO dto) {

        InsuranceResponseDTO insurance = insuranceService.updateInsurance(id, dto);

        return ResponseEntity.ok(
                ApiResponse.<Map<String, Object>>builder()
                        .message("Insurance updated successfully")
                        .data(Map.of("insurance", insurance))
                        .error(null)
                        .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteInsurance(@PathVariable Long id) {

        insuranceService.deleteInsurance(id);

        return ResponseEntity.ok(
                ApiResponse.builder()
                        .message("Insurance deleted successfully")
                        .data(new Object())
                        .error(null)
                        .build());
    }
}
