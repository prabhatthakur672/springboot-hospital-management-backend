package com.prabhat._HospitalManagement.modules.Doctor.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class DoctorAppointmentDTO {

    private Long appointmentId;
    private LocalDateTime appointmentTime;
    private String patientName;
    private String reason;
}
