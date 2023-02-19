package com.example.ecommerce.service;

import com.example.ecommerce.dao.UserRepository;
import com.example.ecommerce.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public int addUser(User user) {
        User user1=userRepository.save(user);
        return user1.getUserId();
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepository.findById(userId).get();
    }
}
