package com.example.desafio_picpay_iago_silva_devlooppear.database.factories;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.desafio_picpay_iago_silva_devlooppear.enums.TransactionStatus;
import com.example.desafio_picpay_iago_silva_devlooppear.models.Transaction;

import com.example.desafio_picpay_iago_silva_devlooppear.models.User;
import com.github.javafaker.Faker;

public class TransactionFactory {
    private static final Faker faker = new Faker();

    public static Transaction createRandomTransaction(User payer, User payee, TransactionStatus status) {
        Transaction transaction = new Transaction();
        
        BigDecimal amount = BigDecimal.valueOf(faker.number().randomDouble(2, 1, 1000));
        transaction.setAmount(amount);
        
        transaction.setPayer(payer);
        transaction.setPayee(payee);
        
        transaction.setTransactionDate(LocalDateTime.now());
        
        transaction.setStatus(status);
        
        return transaction;
    }

    public static Transaction createRandomTransaction(User payer, User payee) {
        return createRandomTransaction(payer, payee, TransactionStatus.COMPLETED);
    }

    public static Transaction createTransactionWithRandomAmount(User payer, User payee, BigDecimal amount) {
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setPayer(payer);
        transaction.setPayee(payee);
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setStatus(TransactionStatus.COMPLETED);
        return transaction;
    }
}
