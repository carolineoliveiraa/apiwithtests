package com.jessicaoliveira.apiwithtests.config;

import com.jessicaoliveira.apiwithtests.domain.User;
import com.jessicaoliveira.apiwithtests.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void startDB(){
        User u1 = new User(null, "Valdir", "Valdir@mail.com", "123");
        User u2 = new User(null, "Jessica", "jessica@mail.com", "123");

        repository.saveAll(List.of(u1, u2));
    }
}
