package com.id3.day_1_rest_service.repository;

import com.id3.day_1_rest_service.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
