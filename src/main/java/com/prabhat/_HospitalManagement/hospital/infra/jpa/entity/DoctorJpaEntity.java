package com.prabhat._HospitalManagement.hospital.infra.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctor")
public class DoctorJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 100)
    private String specialization;

    @Column(length = 150)
    private String degrees;

    @Column(nullable = false)
    private Integer experience; // in years

    @Column(length = 1000)
    private String overview;

    private String profileImage; // image URL or file path

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    private LocalTime availabilityStartTime;

    private LocalTime availabilityEndTime;

    private Boolean isAvailableForToday = true;

    private Boolean isOnLeave = false;

    private Double consultationFee;

    @OneToMany(mappedBy = "doctor")
    private List<AppointmentJpaEntity> appointments;

    @ManyToMany(mappedBy = "doctors")
    private List<DepartmentJpaEntity> departments;
}

