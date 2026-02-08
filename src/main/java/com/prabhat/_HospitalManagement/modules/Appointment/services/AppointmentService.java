package com.prabhat._HospitalManagement.modules.Appointment.services;

import com.prabhat._HospitalManagement.modules.Appointment.dto.AppointmentRangeRequestDTO;
import com.prabhat._HospitalManagement.modules.Appointment.dto.AppointmentRequestDTO;
import com.prabhat._HospitalManagement.modules.Appointment.dto.AppointmentResponseDTO;

import java.util.List;

public interface AppointmentService {

    AppointmentResponseDTO createAppointment(AppointmentRequestDTO dto);

    AppointmentResponseDTO getAppointmentById(Long id);

    List<AppointmentResponseDTO> getAllAppointments();

    AppointmentResponseDTO updateAppointment(Long id, AppointmentRequestDTO dto);

    void deleteAppointment(Long id);

    List<AppointmentResponseDTO> getAppointmentsByPatient(Long patientId);

    List<AppointmentResponseDTO> getAppointmentsByDoctor(Long doctorId);

}
