package com.example.pet_care.service;

import com.example.pet_care.dto.PetRequest;
import com.example.pet_care.entity.Pet;
import com.example.pet_care.enumTypes.Adoptable;
import com.example.pet_care.enumTypes.AdoptionStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PetService {
    Pet register(PetRequest petRequest, MultipartFile file) throws IOException;

    List<Pet> findAllUser();

    void updateById(int id, PetRequest petRequest);

    void deleteById(int id);

    Pet findById(int id);

    void celebrity(int id, PetRequest petRequest);

    List<Pet> findAllByAdoptionStatus(AdoptionStatus status);

    List<Pet> findCelebrityPet(AdoptionStatus status);
}
