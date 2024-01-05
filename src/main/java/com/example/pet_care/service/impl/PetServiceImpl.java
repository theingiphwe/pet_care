package com.example.pet_care.service.impl;

import com.example.pet_care.dto.PetRequest;
import com.example.pet_care.entity.*;
import com.example.pet_care.enumTypes.Adoptable;
import com.example.pet_care.enumTypes.AdoptionStatus;
import com.example.pet_care.enumTypes.DeleteStatus;
import com.example.pet_care.repo.*;
import com.example.pet_care.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PetServiceImpl implements PetService {
    private PetRepo petRepo;
    private SpeciesRepo speciesRepo;
    private AgeTypeRepo ageTypeRepo;

    @Override
    public void register(PetRequest petRequest) {
        Species species = speciesRepo.findById(petRequest.getSpeciesId())
                .orElseThrow(()->new IllegalArgumentException());
        AgeType ageType = ageTypeRepo.findById(petRequest.getAgeTypeId())
                .orElseThrow(()->new IllegalArgumentException());
        Pet pet = Pet.of(petRequest);
        pet.setSpecies(species);
        pet.setAgeType(ageType);
        pet.setDeleteStatus(DeleteStatus.ALLOW);
        pet.setAdoptionStatus(AdoptionStatus.ACTIVE);
        pet.setIsAdoptable(Adoptable.TRUE);
        petRepo.save(pet);
    }

    @Override
    public List<Pet> findAllUser() {
        return petRepo.findAll();
    }

    @Override
    public void updateById(int id, PetRequest petRequest) {
        Optional<Pet> existingPet = petRepo.findById(id);
        existingPet.get().setName(petRequest.getName());
        existingPet.get().setAge(petRequest.getAge());
        existingPet.get().setBreed(petRequest.getBreed());
        existingPet.get().setGender(petRequest.getGender());
        existingPet.get().setDescription(petRequest.getDescription());
        existingPet.get().setSize(petRequest.getSize());
        existingPet.get().setColor(petRequest.getColor());
        Species species = speciesRepo.findById(petRequest.getSpeciesId())
                .orElseThrow(()->new IllegalArgumentException());
        existingPet.get().setSpecies(species);
        AgeType ageType = ageTypeRepo.findById(petRequest.getAgeTypeId())
                .orElseThrow(()->new IllegalArgumentException());
        existingPet.get().setAgeType(ageType);
        petRepo.save(existingPet.get());
    }

    @Override
    public void deleteById(int id) {
        Optional<Pet> pet = petRepo.findById(id);
        if(pet.isPresent()){
            Pet deletePet = pet.get();
            deletePet.setDeleteStatus(DeleteStatus.DENY);
            deletePet.setIsAdoptable(Adoptable.FALSE);
            deletePet.setAdoptionStatus(AdoptionStatus.NOT_ACTIVE);
            petRepo.save(deletePet);
        }
    }

    @Override
    public Pet findById(int id) {
        return petRepo.findById(id).orElseThrow(()->new IllegalArgumentException("invalid id"));
    }

    @Override
    public void celebrity(int id, PetRequest petRequest) {
        Optional<Pet> pet = petRepo.findById(id);
        if(pet.isPresent()){
            Pet celePet = pet.get();
            celePet.setAdoptionStatus(AdoptionStatus.ACTIVE);
            celePet.setIsAdoptable(Adoptable.FALSE);
            petRepo.save(celePet);
        }
    }
}
