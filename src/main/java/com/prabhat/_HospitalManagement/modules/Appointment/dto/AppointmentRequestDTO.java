package com.prabhat._HospitalManagement.modules.Appointment.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentRequestDTO {

    private LocalDateTime appointmentTime;
    private String reason;
    private Long patientId;
    private Long doctorId;
}
