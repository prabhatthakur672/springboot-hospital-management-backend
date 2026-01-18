package com.prabhat._HospitalManagement.service;

import com.prabhat._HospitalManagement.entity.Patient;
import com.prabhat._HospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional // means transaction start from here to DB (all db operation) and transaction completes when this method completes
    public Patient getStudentById(Long id){

        // Check in persistent context, not found then DB query calling and store in persistent context, and now use this object inside project
        Patient p1 = patientRepository.findById(id).orElseThrow();

        // Check in persistent context, found , so referenced to p1 object
        Patient p2 = patientRepository.findById(id).orElseThrow();

        // current in persistent context, so DIRTY CHECKING and update in persistent state and update name in db
        // without using patientRepository.save(p1);
        p1.setName("Yoyo");
        System.out.println(p1 == p2); // true = cuz pointing to same object

        return p1;
    }
}
