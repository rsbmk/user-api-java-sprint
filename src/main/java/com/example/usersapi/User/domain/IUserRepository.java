package com.example.usersapi.User.domain;

import java.util.List;

public interface IUserRepository {
    User find(String id);
    List<User> findAll();
    User save(User user);
    User update(String id, User user);
    void delete(String id);
}
