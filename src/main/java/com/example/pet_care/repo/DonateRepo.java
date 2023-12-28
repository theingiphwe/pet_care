package com.example.pet_care.repo;

import com.example.pet_care.entity.Donate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonateRepo extends JpaRepository<Donate,Integer> {
}
