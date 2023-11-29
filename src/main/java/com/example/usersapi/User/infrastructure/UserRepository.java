package com.example.usersapi.User.infrastructure;

import com.example.usersapi.User.domain.IUserRepository;
import com.example.usersapi.User.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {
    private final List<User> users = new ArrayList<>(
            List.of(
                    new User("1", "Roberto", "rsbmk", "rsbmk@gmail.com"),
                    new User("2", "Roberto", "rsbmk", "")
            )
    );

    @Override
    public User save(User user) {
        this.users.add(user);
        return user;
    }

    @Override
    public User find(String id) {
        return this.users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<User> findAll() {
        return this.users;
    }

    @Override
    public User update(String id, User user) {
        User userToUpdate = this.find(id);
        userToUpdate.setName(user.getName());
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setEmail(user.getEmail());
        return userToUpdate;
    }

    @Override
    public void delete(String id) {
        this.users.removeIf(user -> user.getId().equals(id));
    }
}
