package com.example.pet_care.repo;

import com.example.pet_care.entity.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdoptionRepo extends JpaRepository<Adoption,Integer> {
}
