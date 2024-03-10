package com.testJavaDeveloper.repositories;

import com.testJavaDeveloper.model.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> { }
