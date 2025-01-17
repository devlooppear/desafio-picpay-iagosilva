package com.example.desafio_picpay_iago_silva_devlooppear.repositories;

import com.example.desafio_picpay_iago_silva_devlooppear.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByCpf(String cpf);

    Optional<User> findByEmail(String email);
}
