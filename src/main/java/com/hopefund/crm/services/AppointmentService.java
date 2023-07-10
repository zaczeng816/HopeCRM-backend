package com.hopefund.crm.services;

import com.hopefund.crm.DTO.NewAppointmentDTO;
import com.hopefund.crm.entities.Appointment;
import com.hopefund.crm.entities.Client;
import com.hopefund.crm.entities.enums.AppointmentStatus;
import com.hopefund.crm.entities.enums.ClientType;
import com.hopefund.crm.repositories.AppointmentRepository;
import com.hopefund.crm.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class AppointmentService {

    static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue) {
            super(String.format("Resource %s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        }
    }
    private final AppointmentRepository appointmentRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository,  ClientRepository clientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.clientRepository = clientRepository;
    }

    public Appointment createAppointment(NewAppointmentDTO newAppointment) {
        Client client = clientRepository.findById(newAppointment.clientId())
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id",  newAppointment.clientId()));
        client.setType(ClientType.REAL);
        Appointment appointment = new Appointment();
        appointment.setClient(client);
        appointment.setTime(newAppointment.time());
        appointment.setStatus(newAppointment.status());
        appointment.setPersonInCharge(newAppointment.personInCharge());
        appointment.setNote(newAppointment.note());
        return appointmentRepository.save(appointment);
    }
    public Appointment getMostRecentUncompletedAppointment(Client client) {
        List<Appointment> appointments = client.getAppointments();
        return appointments.stream()
                .filter(appointment -> appointment.getStatus() != AppointmentStatus.COMPLETED)
                .max(Comparator.comparing(Appointment::getTime))
                .orElse(null);
    }


}

