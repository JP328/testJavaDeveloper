package com.testJavaDeveloper.dtos;

import java.math.BigDecimal;

public record CompanyDTO(
        String companyName,
        String cnpj,
        String password,
        BigDecimal tax,
        BigDecimal balance) {
}
