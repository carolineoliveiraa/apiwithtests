package com.jessicaoliveira.apiwithtests.services;

import com.jessicaoliveira.apiwithtests.domain.User;

public interface UserService {

    User findById(Integer id);

}
