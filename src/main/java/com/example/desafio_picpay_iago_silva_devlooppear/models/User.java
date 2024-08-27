package com.example.desafio_picpay_iago_silva_devlooppear.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "balance", precision = 10, scale = 2, columnDefinition = "DECIMAL(10, 2) DEFAULT 0")
    private BigDecimal balance = BigDecimal.ZERO;
}
