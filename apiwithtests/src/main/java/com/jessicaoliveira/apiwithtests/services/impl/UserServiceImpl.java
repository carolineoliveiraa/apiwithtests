package com.jessicaoliveira.apiwithtests.services.impl;

import com.jessicaoliveira.apiwithtests.domain.User;
import com.jessicaoliveira.apiwithtests.domain.dto.UserDTO;
import com.jessicaoliveira.apiwithtests.repositories.UserRepository;
import com.jessicaoliveira.apiwithtests.services.UserService;
import com.jessicaoliveira.apiwithtests.services.exceptions.DataIntegratyViolationException;
import com.jessicaoliveira.apiwithtests.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Integer id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    @Override
    public List<User> findAll(){
        return repository.findAll();
    }

    @Override
    public User create(UserDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, User.class));
    }

    @Override
    public User update(UserDTO obj) {
        return repository.save(mapper.map(obj, User.class));
    }

    private void findByEmail(UserDTO obj) {
        Optional<User> user = repository.findByEmail(obj.getEmail());
        if (user.isPresent()){
            throw new DataIntegratyViolationException("E-mail já cadastrado no sistema");
        }
    }


}
