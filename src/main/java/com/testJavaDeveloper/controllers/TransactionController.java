package com.testJavaDeveloper.controllers;

import com.testJavaDeveloper.dtos.TransactionDTO;
import com.testJavaDeveloper.model.transaction.Transaction;
import com.testJavaDeveloper.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transaction) throws Exception {
        Transaction newTransaction = this.transactionService.createTransaciton(transaction);

        return new ResponseEntity<>(newTransaction, HttpStatus.OK);
    }

}

