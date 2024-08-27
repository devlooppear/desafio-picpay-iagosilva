package com.example.desafio_picpay_iago_silva_devlooppear.repositories;

import com.example.desafio_picpay_iago_silva_devlooppear.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
