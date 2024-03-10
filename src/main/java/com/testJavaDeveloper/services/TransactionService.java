package com.testJavaDeveloper.services;

import com.testJavaDeveloper.dtos.TransactionDTO;
import com.testJavaDeveloper.model.client.Client;
import com.testJavaDeveloper.model.company.Company;
import com.testJavaDeveloper.model.transaction.Transaction;
import com.testJavaDeveloper.model.transaction.TransactionType;
import com.testJavaDeveloper.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TransactionService {
    @Autowired
    private ClientService clientService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NotificationService notificationService;

    public Transaction createTransaciton(TransactionDTO transaction) throws Exception {
        Client client = this.clientService.findClientById(transaction.client());
        Company company = this.companyService.findCompanyById(transaction.company());

        companyService.validateBalance(company, transaction.amount());
        clientService.validateBalance(client, transaction.amount());


        if(!this.systemIsAvailable()) {
            throw  new Exception("Transação não autorizada, sistema instável. Tente novamente mais tarde.");
        }

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transaction.amount());
        newTransaction.setClient(client);
        newTransaction.setCompany(company);
        newTransaction.setTransactionType(transaction.transactionType());
        newTransaction.setTimestamp(LocalDateTime.now());

        if(transaction.transactionType() == TransactionType.DEPOSIT) {
            client.setBalance(client.getBalance().subtract(( transaction.amount().add(company.getTax()) )));
            company.setBalance(company.getBalance().add(transaction.amount()));
        } else {
            company.setBalance(company.getBalance().subtract(transaction.amount()));
            client.setBalance(client.getBalance().add( transaction.amount().subtract(company.getTax()) ));
        }

        this.transactionRepository.save(newTransaction);
        this.clientService.saveClient(client);
        this.companyService.saveCompany(company);
        this.notificationService.sendNotification(client, "Transação realizada com sucesso!");

        return newTransaction;
    }

    public boolean systemIsAvailable() {
//        ResponseEntity<Map> authorizationResponse = restTemplate.
//                getForEntity("https://webhook.site/5d4551e8-1146-48dc-b211-1f5b1a4f6038", Map.class);
//
//        return authorizationResponse.getStatusCode() == HttpStatus.OK;
        return true;
    }
}
