package com.prabhat._HospitalManagement.modules.Doctor.controllers;

import com.prabhat._HospitalManagement.common.response.ApiResponse;
import com.prabhat._HospitalManagement.modules.Doctor.dto.DoctorRequestDTO;
import com.prabhat._HospitalManagement.modules.Doctor.services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping
    public ResponseEntity<ApiResponse<Map<String, Object>>> createDoctor(
            @RequestBody DoctorRequestDTO dto) {

        var doctor = doctorService.createDoctor(dto);

        return ResponseEntity.status(201).body(
                ApiResponse.<Map<String, Object>>builder()
                        .message("Doctor created successfully")
                        .data(Map.of("doctor", doctor))
                        .error(null)
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getDoctor(@PathVariable Long id) {

        var doctor = doctorService.getDoctorById(id);

        return ResponseEntity.ok(
                ApiResponse.<Map<String, Object>>builder()
                        .message("Doctor fetched successfully")
                        .data(Map.of("doctor", doctor))
                        .error(null)
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Map<String, Object>>> getAllDoctors() {

        var doctors = doctorService.getAllDoctors();

        return ResponseEntity.ok(
                ApiResponse.<Map<String, Object>>builder()
                        .message("Doctors fetched successfully")
                        .data(Map.of("doctors", doctors))
                        .error(null)
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Map<String, Object>>> updateDoctor(
            @PathVariable Long id,
            @RequestBody DoctorRequestDTO dto) {

        var doctor = doctorService.updateDoctor(id, dto);

        return ResponseEntity.ok(
                ApiResponse.<Map<String, Object>>builder()
                        .message("Doctor updated successfully")
                        .data(Map.of("doctor", doctor))
                        .error(null)
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteDoctor(@PathVariable Long id) {

        doctorService.deleteDoctor(id);

        return ResponseEntity.ok(
                ApiResponse.builder()
                        .message("Doctor deleted successfully")
                        .data(new Object())
                        .error(null)
                        .build()
        );
    }

    @GetMapping("/{id}/appointments")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getDoctorAppointments(
            @PathVariable Long id) {

        var appointments = doctorService.getDoctorAppointments(id);

        return ResponseEntity.ok(
                ApiResponse.<Map<String, Object>>builder()
                        .message("Doctor appointments fetched successfully")
                        .data(Map.of("appointments", appointments))
                        .error(null)
                        .build()
        );
    }

    @GetMapping("/{id}/departments")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getDoctorDepartments(
            @PathVariable Long id) {

        var departments = doctorService.getDoctorDepartments(id);

        return ResponseEntity.ok(
                ApiResponse.<Map<String, Object>>builder()
                        .message("Doctor departments fetched successfully")
                        .data(Map.of("departments", departments))
                        .error(null)
                        .build()
        );
    }
}
