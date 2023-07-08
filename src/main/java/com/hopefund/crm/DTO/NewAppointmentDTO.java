package com.hopefund.crm.DTO;

import com.hopefund.crm.entities.enums.AppointmentStatus;

import java.time.LocalDateTime;

public record NewAppointmentDTO (
        Long clientId,
        LocalDateTime time,
        AppointmentStatus status,
        String personInCharge,
        String note){
}
