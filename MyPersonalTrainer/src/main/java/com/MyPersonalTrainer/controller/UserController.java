package com.MyPersonalTrainer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.MyPersonalTrainer.domain.User;
import com.MyPersonalTrainer.domain.UserDto;
import com.MyPersonalTrainer.service.UserService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/getUser", method = RequestMethod.GET)
    public User getUser(@RequestParam String name){
        return userService.findOne(name);
    }

    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public User saveUser(@RequestBody UserDto user){
        return userService.save(user);
    }
}
