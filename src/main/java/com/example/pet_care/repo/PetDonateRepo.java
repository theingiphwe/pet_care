package com.example.pet_care.repo;

import com.example.pet_care.entity.PetDonate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetDonateRepo extends JpaRepository<PetDonate,Integer> {
}
