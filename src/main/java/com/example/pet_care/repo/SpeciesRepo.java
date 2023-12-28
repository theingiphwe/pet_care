package com.example.pet_care.repo;

import com.example.pet_care.entity.Species;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeciesRepo extends JpaRepository<Species,Integer> {
}
