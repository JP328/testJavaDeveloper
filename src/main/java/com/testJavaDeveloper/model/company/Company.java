package com.testJavaDeveloper.model.company;

import com.testJavaDeveloper.dtos.CompanyDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

import lombok.*;

@Entity(name="company")
@Table(name="company")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    @Column(unique=true)
    private String cnpj;

    private String password;

    private BigDecimal tax;

    private BigDecimal balance;

    public Company(CompanyDTO data) {
        this.companyName = data.companyName();
        this.cnpj = data.cnpj();
        this.password = data.password();
        this.tax = data.tax();
        this.balance = data.balance();
    }
}
