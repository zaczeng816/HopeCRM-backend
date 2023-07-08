package com.hopefund.crm.services;

import com.hopefund.crm.entities.Appointment;
import com.hopefund.crm.entities.Client;
import com.hopefund.crm.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client editClient(Client client) {
        if (clientRepository.existsById(client.getId())) {
            Client previousClient = clientRepository.findById(client.getId()).get();
            return clientRepository.save(client);
        } else {
            throw new RuntimeException("Client not found");
        }
    }
    public Client getClientById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            return client.get();
        } else {
            throw new RuntimeException("Client not found");
        }
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public List<Appointment> getAllAppointmentsByClientId(Long clientId) {
        Optional<Client> client = clientRepository.findById(clientId);
        if (client.isPresent()) {
            return client.get().getAppointments();
        }
        return new ArrayList<>();
    }
}
