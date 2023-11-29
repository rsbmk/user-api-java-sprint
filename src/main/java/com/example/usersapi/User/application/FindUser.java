package com.example.usersapi.User.application;

import com.example.usersapi.User.domain.IUserRepository;
import com.example.usersapi.User.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindUser {
    private  final IUserRepository userRepository;

    @Autowired
    public FindUser(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User find(String id) {
        return this.userRepository.find(id);
    }

    public Iterable<User> findAll() {
        return this.userRepository.findAll();
    }
}
