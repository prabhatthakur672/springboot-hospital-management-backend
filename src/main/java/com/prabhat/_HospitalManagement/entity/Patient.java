package com.prabhat._HospitalManagement.entity;

import com.prabhat._HospitalManagement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@Table(
        name = "patient",
//        uniqueConstraints = {
//                @UniqueConstraint(name = "unique_email", columnNames = {"email"})
//        },
        indexes = {
                @Index(name = "idx_patient_birth_date", columnList = "birthDate")
        }
)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @ToString.Exclude
    private LocalDate birthDate;

    private String gender;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "patient_insurance_id") //owning side
    private Insurance insurance;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;
}



