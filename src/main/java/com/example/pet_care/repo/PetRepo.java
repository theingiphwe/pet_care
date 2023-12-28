package com.example.pet_care.repo;

import com.example.pet_care.dto.PetRequest;
import com.example.pet_care.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepo extends JpaRepository<Pet,Integer> {
}
