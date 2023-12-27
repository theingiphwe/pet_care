package com.example.pet_care.repo;

import com.example.pet_care.entity.Pet_Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pet_TypeRepo extends JpaRepository<Pet_Type,Integer> {
}
