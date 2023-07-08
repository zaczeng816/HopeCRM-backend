package com.hopefund.crm.controllers;

import com.hopefund.crm.DTO.NewAppointmentDTO;
import com.hopefund.crm.entities.Appointment;
import com.hopefund.crm.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/new")
    public ResponseEntity<Appointment> createAppointment(@RequestBody NewAppointmentDTO newAppointment) {
        Appointment createdAppointment = appointmentService.createAppointment(newAppointment);
        return ResponseEntity.ok(createdAppointment);
    }
}
