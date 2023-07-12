package com.hopefund.crm.DTO;

import com.hopefund.crm.entities.Appointment;
import com.hopefund.crm.entities.enums.AppointmentStatus;

import java.time.ZonedDateTime;

public record AppointmentDTO(
        Long id,
        Long clientId,
        ZonedDateTime time,
        AppointmentStatus status,
        String personInCharge,
        String title,
        String note){
    public AppointmentDTO(Appointment appointment){
        this(
                appointment.getId(),
                appointment.getClient().getId(),
                appointment.getTime(),
                appointment.getStatus(),
                appointment.getPersonInCharge(),
                appointment.getTitle(),
                appointment.getNote()
        );
    }
}
