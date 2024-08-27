package com.example.desafio_picpay_iago_silva_devlooppear.database.seeders;

import com.example.desafio_picpay_iago_silva_devlooppear.database.factories.UserFactory;
import com.example.desafio_picpay_iago_silva_devlooppear.models.User;
import com.example.desafio_picpay_iago_silva_devlooppear.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserSeeder {

    private static final int QUANTITY = 10;

    @Autowired
    private UserRepository userRepository;

    public void seed() {
        if (userRepository.count() == 0) {
            List<User> users = new ArrayList<>();
            for (int i = 0; i < QUANTITY; i++) {
                users.add(UserFactory.createRandomUser());
            }
            userRepository.saveAll(users);
            System.out.println("User seeding completed.");
        }
    }
}
