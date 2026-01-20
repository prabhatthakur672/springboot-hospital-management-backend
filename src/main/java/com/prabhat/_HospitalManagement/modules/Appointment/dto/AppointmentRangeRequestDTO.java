package com.prabhat._HospitalManagement.modules.Appointment.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentRangeRequestDTO {

    private LocalDateTime start;
    private LocalDateTime end;
}
