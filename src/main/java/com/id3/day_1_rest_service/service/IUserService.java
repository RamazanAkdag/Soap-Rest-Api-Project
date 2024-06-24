package com.id3.day_1_rest_service.service;

import com.id3.day_1_rest_service.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public List<User> getAll();

    public Optional<User> getUserById(int id);

    public void createUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);
}
