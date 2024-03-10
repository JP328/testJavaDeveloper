package com.testJavaDeveloper.dtos;

import com.testJavaDeveloper.model.transaction.TransactionType;

import java.math.BigDecimal;

public record TransactionDTO(
        BigDecimal amount,
        Long client,
        Long company,
        TransactionType transactionType) {
}
