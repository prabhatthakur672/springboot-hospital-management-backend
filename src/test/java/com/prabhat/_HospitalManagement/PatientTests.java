package com.prabhat._HospitalManagement;

import com.prabhat._HospitalManagement.entity.Patient;
import com.prabhat._HospitalManagement.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testPatientRepository(){
        List<Patient> patientList = patientRepository.findAll();

        System.out.println("Patient List: "+patientList);

    }

    @Test
    public void testPatientJpaMethods(){
        Patient patient = patientRepository.findByName("Rahul Sharma");

        System.out.println("Patient: "+patient);
    }

    @Test
    public void testPatientJPQLMethods(){
        List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(1996, 3, 4));

        System.out.println("Patient: "+patientList);
    }
}
