package com.prabhat._HospitalManagement.hospital.api.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    @GetMapping
    public String getAppointment(){
        return "Appointment Health Ok";
    }

    @PostMapping
    public String createAppointment(){
        return "Appointment Created";
    }
}
