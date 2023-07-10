package com.hopefund.crm.controllers;

import com.hopefund.crm.DTO.ClientDTO;
import com.hopefund.crm.entities.Client;
import com.hopefund.crm.entities.Appointment;
import com.hopefund.crm.entities.enums.ClientStatus;
import com.hopefund.crm.entities.enums.ClientType;
import com.hopefund.crm.services.AppointmentService;
import com.hopefund.crm.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import java.util.List;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

@Controller
public class GraphqlController {
    private final ClientService clientService;
    private final AppointmentService appointmentService;

    public GraphqlController(ClientService clientService, AppointmentService appointmentService) {
        this.clientService = clientService;
        this.appointmentService = appointmentService;
    }

    @QueryMapping
    public List<Client> allClients() {
        return clientService.getAllClients();
    }

    @QueryMapping
    public Client client(@Argument Long id) {
        return clientService.getClientById(id);
    }

    @MutationMapping
    public Client createClient(@Argument String name,  @Argument String phone, @Argument String wechatId, @Argument String address, @Argument String note, @Argument ClientType type) {
        Client client = new Client();
        client.setName(name);
        client.setPhone(phone);
        client.setWechatId(wechatId);
//        client.setStatus(status);
        client.setStatus(ClientStatus.JOINED);
        client.setAddress(address);
        client.setNote(note);
        client.setType(type);
        return clientService.createClient(client);
    }

//    @Argument ClientStatus status,



//    @QueryMapping
//    public List<Appointment> allAppointments() {
//        return appointmentService.getAllAppointments();
//    }

}
