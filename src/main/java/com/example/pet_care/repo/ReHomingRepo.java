package com.example.pet_care.repo;

import com.example.pet_care.entity.ReHoming;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReHomingRepo extends JpaRepository<ReHoming,Integer> {
}
