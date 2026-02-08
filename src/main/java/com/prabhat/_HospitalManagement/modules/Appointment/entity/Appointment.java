package com.prabhat._HospitalManagement.modules.Appointment.entity;

import com.prabhat._HospitalManagement.modules.Doctor.entity.Doctor;
import com.prabhat._HospitalManagement.modules.Insurance.entity.AppointmentStatus;
import com.prabhat._HospitalManagement.modules.Patient.entity.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentStartTime;

    @Column(nullable = false)
    private LocalDateTime appointmentEndTime;

    @Column(length = 500)
    private String reason;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AppointmentStatus status = AppointmentStatus.SCHEDULED;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}

