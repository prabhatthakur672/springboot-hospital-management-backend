package com.prabhat._HospitalManagement.modules.Doctor.entity;

import com.prabhat._HospitalManagement.modules.Appointment.entity.Appointment;
import com.prabhat._HospitalManagement.modules.Department.entity.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 100)
    private String specialization;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;

    @ManyToMany(mappedBy = "doctors")
    private List<Department> departments;
}
