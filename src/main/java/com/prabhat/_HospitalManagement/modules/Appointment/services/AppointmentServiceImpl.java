package com.prabhat._HospitalManagement.modules.Appointment.services;

import com.prabhat._HospitalManagement.modules.Appointment.dto.AppointmentRangeRequestDTO;
import com.prabhat._HospitalManagement.modules.Appointment.dto.AppointmentRequestDTO;
import com.prabhat._HospitalManagement.modules.Appointment.dto.AppointmentResponseDTO;
import com.prabhat._HospitalManagement.modules.Appointment.entity.Appointment;
import com.prabhat._HospitalManagement.modules.Appointment.mapper.AppointmentMapper;
import com.prabhat._HospitalManagement.modules.Appointment.repository.AppointmentRepository;
import com.prabhat._HospitalManagement.modules.Appointment.services.AppointmentService;
import com.prabhat._HospitalManagement.modules.Doctor.entity.Doctor;
import com.prabhat._HospitalManagement.modules.Doctor.repository.DoctorRepository;
import com.prabhat._HospitalManagement.modules.Patient.entity.Patient;
import com.prabhat._HospitalManagement.modules.Patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Override
    public AppointmentResponseDTO createAppointment(AppointmentRequestDTO dto) {

        // 1. check whether patient with this email already exists, if not create first
        // 2. check
        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Doctor doctor = doctorRepository.findById(dto.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Appointment appointment = new Appointment();
        appointment.setReason(dto.getReason());
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        return AppointmentMapper.toDTO(
                appointmentRepository.save(appointment)
        );
    }

    @Override
    public AppointmentResponseDTO getAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        return AppointmentMapper.toDTO(appointment);
    }

    @Override
    public List<AppointmentResponseDTO> getAllAppointments() {
        return appointmentRepository.findAll()
                .stream()
                .map(AppointmentMapper::toDTO)
                .toList();
    }

    @Override
    public AppointmentResponseDTO updateAppointment(Long id, AppointmentRequestDTO dto) {

        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appointment.setReason(dto.getReason());

        return AppointmentMapper.toDTO(
                appointmentRepository.save(appointment)
        );
    }

    @Override
    public void deleteAppointment(Long id) {
        if (!appointmentRepository.existsById(id)) {
            throw new RuntimeException("Appointment not found");
        }
        appointmentRepository.deleteById(id);
    }

    @Override
    public List<AppointmentResponseDTO> getAppointmentsByPatient(Long patientId) {
        return appointmentRepository.findByPatientId(patientId)
                .stream()
                .map(AppointmentMapper::toDTO)
                .toList();
    }

    @Override
    public List<AppointmentResponseDTO> getAppointmentsByDoctor(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId)
                .stream()
                .map(AppointmentMapper::toDTO)
                .toList();
    }
}
