package com.prabhat._HospitalManagement.modules.Doctor.mapper;

import com.prabhat._HospitalManagement.modules.Doctor.dto.DoctorAppointmentDTO;
import com.prabhat._HospitalManagement.modules.Doctor.dto.DoctorRequestDTO;
import com.prabhat._HospitalManagement.modules.Doctor.dto.DoctorResponseDTO;
import com.prabhat._HospitalManagement.modules.Doctor.entity.Doctor;
import com.prabhat._HospitalManagement.modules.Appointment.entity.Appointment;

public class DoctorMapper {

    public static Doctor toEntity(DoctorRequestDTO dto) {
        Doctor doctor = new Doctor();
        doctor.setName(dto.getName());
        doctor.setSpecialization(dto.getSpecialization());
        doctor.setEmail(dto.getEmail());
        return doctor;
    }

    public static DoctorResponseDTO toDTO(Doctor doctor) {
        return DoctorResponseDTO.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .specialization(doctor.getSpecialization())
                .email(doctor.getEmail())
                .build();
    }

    public static DoctorAppointmentDTO toAppointmentDTO(Appointment appointment) {
        return DoctorAppointmentDTO.builder()
                .appointmentId(appointment.getId())
                .appointmentTime(appointment.getAppointmentTime())
                .patientName(appointment.getPatient().getName())
                .reason(appointment.getReason())
                .build();
    }
}
