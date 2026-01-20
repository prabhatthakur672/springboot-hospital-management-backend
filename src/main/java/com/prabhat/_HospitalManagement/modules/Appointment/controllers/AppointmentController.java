package com.prabhat._HospitalManagement.modules.Appointment.controllers;

import com.prabhat._HospitalManagement.common.response.ApiResponse;
import com.prabhat._HospitalManagement.modules.Appointment.dto.AppointmentRangeRequestDTO;
import com.prabhat._HospitalManagement.modules.Appointment.dto.AppointmentRequestDTO;
import com.prabhat._HospitalManagement.modules.Appointment.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<ApiResponse<Map<String, Object>>> createAppointment(
            @RequestBody AppointmentRequestDTO dto) {

        var appointment = appointmentService.createAppointment(dto);

        return ResponseEntity.status(201).body(
                ApiResponse.<Map<String, Object>>builder()
                        .message("Appointment created successfully")
                        .data(Map.of("appointment", appointment))
                        .error(null)
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getAppointment(
            @PathVariable Long id) {

        var appointment = appointmentService.getAppointmentById(id);

        return ResponseEntity.ok(
                ApiResponse.<Map<String, Object>>builder()
                        .message("Appointment fetched successfully")
                        .data(Map.of("appointment", appointment))
                        .error(null)
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Map<String, Object>>> getAllAppointments() {

        var appointments = appointmentService.getAllAppointments();

        return ResponseEntity.ok(
                ApiResponse.<Map<String, Object>>builder()
                        .message("Appointments fetched successfully")
                        .data(Map.of("appointments", appointments))
                        .error(null)
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Map<String, Object>>> updateAppointment(
            @PathVariable Long id,
            @RequestBody AppointmentRequestDTO dto) {

        var appointment = appointmentService.updateAppointment(id, dto);

        return ResponseEntity.ok(
                ApiResponse.<Map<String, Object>>builder()
                        .message("Appointment updated successfully")
                        .data(Map.of("appointment", appointment))
                        .error(null)
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteAppointment(
            @PathVariable Long id) {

        appointmentService.deleteAppointment(id);

        return ResponseEntity.ok(
                ApiResponse.builder()
                        .message("Appointment deleted successfully")
                        .data(new Object())
                        .error(null)
                        .build()
        );
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getByPatient(
            @PathVariable Long patientId) {

        var appointments = appointmentService.getAppointmentsByPatient(patientId);

        return ResponseEntity.ok(
                ApiResponse.<Map<String, Object>>builder()
                        .message("Patient appointments fetched successfully")
                        .data(Map.of("appointments", appointments))
                        .error(null)
                        .build()
        );
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getByDoctor(
            @PathVariable Long doctorId) {

        var appointments = appointmentService.getAppointmentsByDoctor(doctorId);

        return ResponseEntity.ok(
                ApiResponse.<Map<String, Object>>builder()
                        .message("Doctor appointments fetched successfully")
                        .data(Map.of("appointments", appointments))
                        .error(null)
                        .build()
        );
    }

    @PostMapping("/range")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getInRange(
            @RequestBody AppointmentRangeRequestDTO dto) {

        var appointments = appointmentService.getAppointmentsInRange(dto);

        return ResponseEntity.ok(
                ApiResponse.<Map<String, Object>>builder()
                        .message("Appointments fetched successfully")
                        .data(Map.of("appointments", appointments))
                        .error(null)
                        .build()
        );
    }
}
