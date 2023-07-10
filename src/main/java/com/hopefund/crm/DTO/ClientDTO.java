package com.hopefund.crm.DTO;

import com.hopefund.crm.entities.Appointment;
import com.hopefund.crm.entities.Client;
import com.hopefund.crm.entities.enums.ClientStatus;
import com.hopefund.crm.entities.enums.ClientType;

import java.time.LocalDateTime;

public record ClientDTO (
     Long id,
     String name,
     String phone,
     String wechatId,
     ClientType type,
     ClientStatus status,
     String address,
     Appointment appointment,
     LocalDateTime lastFollowupTime,
     String note){
    public ClientDTO(Client client, Appointment appointment) {
        this(
        client.getId(),
        client.getName(),
        client.getPhone(),
        client.getWechatId(),
        client.getType(),
        client.getStatus(),
        client.getAddress(),
        appointment,
        client.getLastFollowupTime(),
        client.getNote());
    }
}
