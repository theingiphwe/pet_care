package com.example.pet_care.service;

import com.example.pet_care.entity.Species;
import com.example.pet_care.entity.User;

import java.util.List;

public interface UserService {
    void create(User user);

    List<User> findAllUser();

    void updateById(int id, User user);

    void deleteById(int id);

    User findById(int id);

    User loginUser(String userEmail,String userPassword);
}
