package com.prabhat._HospitalManagement.modules.Patient.controllers;

import com.prabhat._HospitalManagement.common.response.ApiResponse;
import com.prabhat._HospitalManagement.modules.Patient.dto.PatientRequestDTO;
import com.prabhat._HospitalManagement.modules.Patient.dto.PatientResponseDTO;
import com.prabhat._HospitalManagement.modules.Patient.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<ApiResponse<Map<String, Object>>> createPatient(
            @RequestBody PatientRequestDTO dto) {

        PatientResponseDTO patient = patientService.createPatient(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.<Map<String, Object>>builder()
                        .message("Patient created successfully")
                        .data(Map.of("patient", patient))
                        .error(null)
                        .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getPatient(@PathVariable Long id) {

        PatientResponseDTO patient = patientService.getPatientById(id);

        return ResponseEntity.ok(
                ApiResponse.<Map<String, Object>>builder()
                        .message("Patient fetched successfully")
                        .data(Map.of("patient", patient))
                        .error(null)
                        .build());
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Map<String, Object>>> getAllPatients() {

        var patients = patientService.getAllPatients();

        return ResponseEntity.ok(
                ApiResponse.<Map<String, Object>>builder()
                        .message("Patients fetched successfully")
                        .data(Map.of("patients", patients))
                        .error(null)
                        .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Map<String, Object>>> updatePatient(
            @PathVariable Long id,
            @RequestBody PatientRequestDTO dto) {

        PatientResponseDTO patient = patientService.updatePatient(id, dto);

        return ResponseEntity.ok(
                ApiResponse.<Map<String, Object>>builder()
                        .message("Patient updated successfully")
                        .data(Map.of("patient", patient))
                        .error(null)
                        .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deletePatient(@PathVariable Long id) {

        patientService.deletePatient(id);

        return ResponseEntity.ok(
                ApiResponse.builder()
                        .message("Patient deleted successfully")
                        .data(new Object())
                        .error(null)
                        .build());
    }
}

