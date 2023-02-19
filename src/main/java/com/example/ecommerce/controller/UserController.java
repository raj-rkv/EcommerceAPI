package com.example.ecommerce.controller;

import com.example.ecommerce.model.User;
import com.example.ecommerce.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/ecommerce-app")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/user")
    public ResponseEntity createUser(@RequestBody User user){
        int userId=userService.addUser(user);
        return new ResponseEntity<>("User created with user id- "+userId, HttpStatus.CREATED);
    }

    @GetMapping("/user")
    public User getUserById(@RequestParam Integer userId){
        return userService.getUserById(userId);
    }

    }
