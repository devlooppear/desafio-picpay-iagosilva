package com.example.desafio_picpay_iago_silva_devlooppear.database.seeders;

import com.example.desafio_picpay_iago_silva_devlooppear.database.factories.TransactionFactory;
import com.example.desafio_picpay_iago_silva_devlooppear.models.Transaction;
import com.example.desafio_picpay_iago_silva_devlooppear.models.User;
import com.example.desafio_picpay_iago_silva_devlooppear.repositories.TransactionRepository;
import com.example.desafio_picpay_iago_silva_devlooppear.repositories.UserRepository;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionSeeder {

    private static final int QUANTITY = 10; 

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void seed() {
        List<User> users = userRepository.findAll();

        if (users.size() < 2) {
            System.out.println("Not enough users to create transactions.");
            return;
        }

        for (int i = 0; i < QUANTITY; i++) {
            User payer = users.get(i % users.size());
            User payee = users.get((i + 1) % users.size());

            Transaction transaction = TransactionFactory.createRandomTransaction(payer, payee);
            transactionRepository.save(transaction);
        }

        System.out.println("Transaction seeding completed.");
    }
}
