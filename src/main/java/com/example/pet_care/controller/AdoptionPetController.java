package com.example.pet_care.controller;

import com.example.pet_care.dto.AdoptionRequest;
import com.example.pet_care.entity.Adoption;
import com.example.pet_care.entity.Pet;
import com.example.pet_care.repo.AdoptionRepo;
import com.example.pet_care.service.AdoptionService;
import com.example.pet_care.service.PetService;
import com.example.pet_care.service.impl.AdoptionServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adoption/{adoptionId}/pet/{petId}")
@AllArgsConstructor
public class AdoptionPetController {

    private AdoptionService adoptionService;
    private PetService petService;
    private AdoptionRepo adoptionRepo;

    @PutMapping
    public ResponseEntity<String> joinAdoptionWithPet(@PathVariable int adoptionId,@PathVariable int petId){
        Adoption adoption = adoptionService.findById(adoptionId);
        Pet pet = petService.findById(petId);

        if(adoption == null && pet == null){
            return new ResponseEntity<>("pet or adoption not found", HttpStatus.NOT_FOUND);
        }

        adoption.getPets().add(pet);

        adoptionRepo.save(adoption);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }
}
