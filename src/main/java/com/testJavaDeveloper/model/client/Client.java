package com.testJavaDeveloper.model.client;

import com.testJavaDeveloper.dtos.ClientDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

import lombok.*;

@Entity(name="client")
@Table(name="client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientName;

    @Column(unique=true)
    private String cpf;

    @Column(unique=true)
    private String email;

    private String password;

    private BigDecimal balance;

    public Client(ClientDTO data) {
        this.clientName = data.clientName();
        this.cpf = data.cpf();
        this.email = data.email();
        this.password = data.password();
        this.balance = data.balance();

    }
}