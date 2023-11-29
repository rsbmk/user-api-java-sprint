package com.example.usersapi.User.application;

import com.example.usersapi.User.domain.IUserRepository;
import com.example.usersapi.User.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUser {
    private final IUserRepository userRepository;

    @Autowired
    public UpdateUser(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User update(String id, User user) {
        return this.userRepository.update(id, user);
    }
}
