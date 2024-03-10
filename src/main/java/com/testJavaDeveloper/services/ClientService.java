package com.testJavaDeveloper.services;

import com.testJavaDeveloper.dtos.ClientDTO;
import com.testJavaDeveloper.model.client.Client;
import com.testJavaDeveloper.model.company.Company;
import com.testJavaDeveloper.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public void validateBalance(Client client, BigDecimal amount) throws Exception {
        if(client.getBalance().compareTo(amount) < 0) {
            throw new Exception("Saldo insuficiente");
        }
    }

    public Client findClientById(Long id) throws Exception {
        return this.clientRepository.findClientById(id).orElseThrow(() -> new Exception("Usuário não encontrado."));
    }

    public Client createClient(ClientDTO data) {
        Client newClient = new Client(data);
        this.saveClient(newClient);

        return newClient;
    }

    public List<Client> getAllClients() {
        return this.clientRepository.findAll();
    }

    public void saveClient(Client client) {
        this.clientRepository.save(client);
    }
}
