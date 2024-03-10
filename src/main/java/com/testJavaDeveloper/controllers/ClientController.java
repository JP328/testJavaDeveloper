package com.testJavaDeveloper.controllers;

import com.testJavaDeveloper.dtos.ClientDTO;
import com.testJavaDeveloper.model.client.Client;
import com.testJavaDeveloper.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody ClientDTO client) {
        Client newClient = clientService.createClient(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> users = this.clientService.getAllClients();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
