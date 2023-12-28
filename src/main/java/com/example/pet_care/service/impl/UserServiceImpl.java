package com.example.pet_care.service.impl;

import com.example.pet_care.entity.User;
import com.example.pet_care.repo.UserRepo;
import com.example.pet_care.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public void create(User user) {
        userRepo.save(user);
    }

    @Override
    public List<User> findAllUser() {
        return userRepo.findAll();
    }

    @Override
    public void updateById(int id, User user) {
        Optional<User> existingUser = userRepo.findById(id);
        existingUser.get().setName(user.getName());
        existingUser.get().setEmail(user.getEmail());
        existingUser.get().setPassword(user.getPassword());
        existingUser.get().setRole(user.getRole());
        existingUser.get().setAddress(user.getAddress());
        userRepo.save(existingUser.get());
    }

    @Override
    public void deleteById(int id) {
        if(userRepo.existsById(id)){
            userRepo.deleteById(id);
        }
    }

    @Override
    public User findById(int id) {
        return userRepo.findById(id).orElseThrow(()->new IllegalArgumentException("invalid id"));
    }

}
