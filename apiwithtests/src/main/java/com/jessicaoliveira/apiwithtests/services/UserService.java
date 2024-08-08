package com.jessicaoliveira.apiwithtests.services;

import com.jessicaoliveira.apiwithtests.domain.User;
import com.jessicaoliveira.apiwithtests.domain.dto.UserDTO;

import javax.xml.datatype.DatatypeConfigurationException;
import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();
    User create(UserDTO obj);
    User update(UserDTO obj);
    void delete(Integer id);
}
