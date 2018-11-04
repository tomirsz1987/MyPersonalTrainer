package com.MyPersonalTrainer.service;

import com.MyPersonalTrainer.domain.User;
import com.MyPersonalTrainer.domain.UserDto;
import com.MyPersonalTrainer.service.UserService;

public interface UserService {

    User save(UserDto user);
    User findOne(String username);

}
