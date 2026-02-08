package com.prabhat._HospitalManagement.modules.Patient.entity;
import com.prabhat._HospitalManagement.modules.Appointment.entity.Appointment;
import com.prabhat._HospitalManagement.modules.Insurance.entity.Insurance;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    private LocalDate birthDate;

    private String gender;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false, length = 15)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @Column(length = 1000)
    private String pastHealthRecord;
    // diabetes, heart disease, surgery history, etc.

    @Column(length = 15)
    private String emergencyContactNumber;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "patient_insurance_id")
    private Insurance insurance;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;
}


