package com.example.pet_care.controller;

import com.example.pet_care.entity.Pet;
import com.example.pet_care.entity.ReHoming;
import com.example.pet_care.repo.ReHomingRepo;
import com.example.pet_care.service.PetService;
import com.example.pet_care.service.ReHomingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reHoming/{reHomingId}/pet/{petId}")
@AllArgsConstructor
public class ReHomingPetController {

    private PetService petService;

    private ReHomingService reHomingService;
    private ReHomingRepo reHomingRepo;

    @PutMapping
    public ResponseEntity<String> joinReHomingWithPet(@PathVariable int reHomingId, @PathVariable int petId){
        ReHoming reHoming = reHomingService.findById(reHomingId);
        Pet pet = petService.findById(petId);

        if(reHoming == null && pet == null){
            return new ResponseEntity<>("pet or adoption not found", HttpStatus.NOT_FOUND);
        }

        reHoming.getPets().add(pet);
        reHomingRepo.save(reHoming);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }
}
