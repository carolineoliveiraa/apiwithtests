package com.jessicaoliveira.apiwithtests.services.impl;

import com.jessicaoliveira.apiwithtests.domain.User;
import com.jessicaoliveira.apiwithtests.repositories.UserRepository;
import com.jessicaoliveira.apiwithtests.resources.UserResource;
import com.jessicaoliveira.apiwithtests.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Integer id){
        Optional<User> obj = repository.findById(id);
        return obj.orElse(null);
    }
}
