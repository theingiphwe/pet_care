package com.example.pet_care.repo;

import com.example.pet_care.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User,Integer> {
}
