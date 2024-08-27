package com.example.desafio_picpay_iago_silva_devlooppear.database.seeders;

import com.example.desafio_picpay_iago_silva_devlooppear.repositories.TransactionRepository;
import com.example.desafio_picpay_iago_silva_devlooppear.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private UserSeeder userSeeder;

    @Autowired
    private TransactionSeeder transactionSeeder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void run(String... args) throws Exception {
        transactionRepository.deleteAll();
        userRepository.deleteAll();

        userSeeder.seed();
        transactionSeeder.seed();
    }
}
