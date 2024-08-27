package com.example.desafio_picpay_iago_silva_devlooppear.database.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private UserSeeder userSeeder;

    @Autowired
    private TransactionSeeder transactionSeeder;

    @Override
    public void run(String... args) throws Exception {
        userSeeder.seed();
        transactionSeeder.seed();
    }
}
