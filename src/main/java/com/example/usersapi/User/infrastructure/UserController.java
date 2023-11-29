package com.example.usersapi.User.infrastructure;

import com.example.usersapi.User.application.*;
import com.example.usersapi.User.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final CreateUser createUser;
    private final FindUser findUser;
    private final UpdateUser updateUser;
    private final DeleteUser deleteUser;

    @Autowired
    public UserController(CreateUser createUser, FindUser findUser, UpdateUser updateUser, DeleteUser deleteUser) {
        this.createUser = createUser;
        this.findUser = findUser;
        this.updateUser = updateUser;
        this.deleteUser = deleteUser;
    }

    @GetMapping
    public ResponseEntity<Iterable<User>>getUsers() {
        return new ResponseEntity<>(this.findUser.findAll(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User>getUser(@PathVariable("id") String id) {
        return new ResponseEntity<>(this.findUser.find(id), HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<User>createUser(@RequestBody User user) {
        return new ResponseEntity<>(this.createUser.create(user), HttpStatusCode.valueOf(200));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User>updateUser(@PathVariable("id") String id,@RequestBody User user) {
        return new ResponseEntity<>(this.updateUser.update(id, user), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User>deleteUser(@PathVariable("id") String id) {
        this.deleteUser.delete(id);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
}
