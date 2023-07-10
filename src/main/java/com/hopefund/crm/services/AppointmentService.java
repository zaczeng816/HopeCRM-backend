package com.hopefund.crm.services;

import com.hopefund.crm.DTO.AppointmentDTO;
import com.hopefund.crm.entities.Appointment;
import com.hopefund.crm.entities.Client;
import com.hopefund.crm.entities.enums.AppointmentStatus;
import com.hopefund.crm.entities.enums.ClientType;
import com.hopefund.crm.repositories.AppointmentRepository;
import com.hopefund.crm.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Appointment createAppointment(AppointmentDTO dto) {
        Client client = clientRepository.findById(dto.clientId())
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id",  dto.clientId()));
        client.setType(ClientType.REAL);
        Appointment appointment = new Appointment();
        appointment.setClient(client);
        appointment.setTime(dto.time());
        appointment.setStatus(dto.status());
        appointment.setPersonInCharge(dto.personInCharge());
        appointment.setNote(dto.note());
        return appointmentRepository.save(appointment);
    }

    public Appointment createAppointment(Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    public Appointment editAppointment(AppointmentDTO dto){
        if(appointmentRepository.existsById(dto.id())){
            Appointment appointment = appointmentRepository.findById(dto.id()).get();
            appointment.setTime(dto.time());
            appointment.setStatus(dto.status());
            appointment.setPersonInCharge(dto.personInCharge());
            appointment.setNote(dto.note());
            appointment.setComment(dto.comment());
            return appointmentRepository.save(appointment);
        } else {
            throw new RuntimeException("Appointment not found");
        }
    }
    public void deleteAppointment(Long id){
        if(appointmentRepository.existsById(id)){
            appointmentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Appointment not found");
        }
    }
    public Appointment getMostRecentUncompletedAppointment(Client client) {
        List<Appointment> appointments = client.getAppointments();
        return appointments.stream()
                .filter(appointment -> appointment.getStatus() != AppointmentStatus.COMPLETED)
                .max(Comparator.comparing(Appointment::getTime))
                .orElse(null);
    }


}

