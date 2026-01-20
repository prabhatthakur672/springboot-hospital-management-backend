package com.prabhat._HospitalManagement.modules.Appointment.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class AppointmentResponseDTO {

    private Long id;
    private LocalDateTime appointmentTime;
    private String reason;
    private String patientName;
    private String doctorName;
}
