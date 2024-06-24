package com.id3.day_1_rest_service.service;

import com.id3.day_1_rest_service.model.entity.User;
import com.id3.day_1_rest_service.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserManager implements IUserService {

    private final IUserRepository userDal;
    @Override
    public List<User> getAll() {
        return userDal.findAll();
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userDal.findById(id);
    }

    @Override
    public void createUser(User user) {
        userDal.save(user);
    }

    @Override
    public void updateUser(User user) {
        userDal.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userDal.deleteById(id);
    }
}
