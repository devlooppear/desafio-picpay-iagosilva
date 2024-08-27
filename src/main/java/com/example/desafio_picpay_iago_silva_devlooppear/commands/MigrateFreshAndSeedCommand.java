package com.example.desafio_picpay_iago_silva_devlooppear.commands;

import com.example.desafio_picpay_iago_silva_devlooppear.database.seeders.DatabaseSeeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MigrateFreshAndSeedCommand implements CommandLineRunner {

    @Autowired
    private DatabaseSeeder databaseSeeder;

    @Override
    public void run(String... args) throws Exception {
        if (args.length > 0 && "migrate-fresh-and-seed".equals(args[0])) {
            databaseSeeder.seedDatabase();
            System.exit(0);
        }
    }
}
