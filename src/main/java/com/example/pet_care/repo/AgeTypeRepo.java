package com.example.pet_care.repo;

import com.example.pet_care.entity.AgeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgeTypeRepo extends JpaRepository<AgeType ,Integer> {
}
