package com.example.demo.services;

import com.example.demo.entity.User;

import java.util.List;

public interface RegService {
    void addUser(User user);

    List<User> findAllUsers();
}
