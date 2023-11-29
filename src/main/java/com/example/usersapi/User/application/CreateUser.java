package com.example.usersapi.User.application;

import com.example.usersapi.User.domain.IUserRepository;
import com.example.usersapi.User.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUser {
    private final IUserRepository userRepository;

    @Autowired
    public CreateUser(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create (User user) {
        return this.userRepository.save(user);
    }
}
