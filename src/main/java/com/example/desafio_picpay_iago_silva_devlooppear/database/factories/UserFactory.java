package com.example.desafio_picpay_iago_silva_devlooppear.database.factories;

import com.example.desafio_picpay_iago_silva_devlooppear.models.User;
import com.github.javafaker.Faker;

import java.math.BigDecimal;

public class UserFactory {
    private static final Faker faker = new Faker();

    public static User createRandomUser() {
        User user = new User();
        user.setFullName(faker.name().fullName());
        user.setCpf(faker.idNumber().valid());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password());
        user.setBalance(BigDecimal.ZERO);
        return user;
    }
}
