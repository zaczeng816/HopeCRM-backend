package com.hopefund.crm.controllers;

import com.hopefund.crm.DTO.ClientDTO;
import com.hopefund.crm.entities.Client;
import com.hopefund.crm.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client createdClient = clientService.createClient(client);
        return ResponseEntity.ok(createdClient);
    }

    @PutMapping("/edit")
    public ResponseEntity<Client> editClient(@RequestBody Client client) {
        Client updatedClient = clientService.editClient(client);
        return ResponseEntity.ok(updatedClient);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Client client = clientService.getClientById(id);
        return ResponseEntity.ok(client);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<ClientDTO>> getAllClientDTOs() {
        List<ClientDTO> clients = clientService.getAllClientDTOs();
        return ResponseEntity.ok(clients);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAll(){
        List<Client> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }
}
