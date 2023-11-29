package com.example.usersapi.User.application;

import com.example.usersapi.User.domain.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUser {
    private final IUserRepository userRepository;

    @Autowired
    public DeleteUser(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void delete(String id){
        this.userRepository.delete(id);
    }
}
