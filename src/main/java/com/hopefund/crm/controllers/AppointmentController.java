package com.hopefund.crm.controllers;

import com.hopefund.crm.DTO.AppointmentDTO;
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
    public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody AppointmentDTO dto) {
        Appointment createdAppointment = appointmentService.createAppointment(dto);
        return ResponseEntity.ok(new AppointmentDTO(createdAppointment));
    }

    @PutMapping("/edit")
    public ResponseEntity<AppointmentDTO> editAppointment(@RequestBody AppointmentDTO dto) {
        Appointment updatedAppointment = appointmentService.editAppointment(dto);
        return ResponseEntity.ok(new AppointmentDTO(updatedAppointment));
    }
}
