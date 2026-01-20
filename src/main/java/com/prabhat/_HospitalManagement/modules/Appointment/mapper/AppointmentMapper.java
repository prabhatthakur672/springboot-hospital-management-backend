package com.prabhat._HospitalManagement.modules.Appointment.mapper;

import com.prabhat._HospitalManagement.modules.Appointment.dto.AppointmentResponseDTO;
import com.prabhat._HospitalManagement.modules.Appointment.entity.Appointment;

public class AppointmentMapper {

    public static AppointmentResponseDTO toDTO(Appointment appointment) {
        return AppointmentResponseDTO.builder()
                .id(appointment.getId())
                .appointmentTime(appointment.getAppointmentTime())
                .reason(appointment.getReason())
                .patientName(appointment.getPatient().getName())
                .doctorName(appointment.getDoctor().getName())
                .build();
    }
}
