package com.example.pet_care.repo;

import com.example.pet_care.entity.Pet;
import com.example.pet_care.enumTypes.Adoptable;
import com.example.pet_care.enumTypes.AdoptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PetRepo extends JpaRepository<Pet,Integer> {
    List<Pet> findAllByAdoptionStatus(AdoptionStatus adoptionStatus);

    List<Pet> findAllByIsAdoptable(Adoptable adoptable);
}
