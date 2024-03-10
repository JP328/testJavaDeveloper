package com.testJavaDeveloper.dtos;

import java.math.BigDecimal;

public record ClientDTO(
        String clientName,
        String cpf,
        String email,
        String password,
        BigDecimal balance) {
}
