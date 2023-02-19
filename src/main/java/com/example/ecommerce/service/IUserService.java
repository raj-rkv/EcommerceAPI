package com.example.ecommerce.service;

import com.example.ecommerce.model.User;


public interface IUserService {
    public int addUser(User user);

    public User getUserById(Integer userId);
}
