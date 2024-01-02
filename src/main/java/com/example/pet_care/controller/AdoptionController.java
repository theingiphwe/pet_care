package com.example.pet_care.controller;

import com.example.pet_care.dto.AdoptionRequest;
import com.example.pet_care.dto.PetRequest;
import com.example.pet_care.entity.Adoption;
import com.example.pet_care.entity.Pet;
import com.example.pet_care.entity.User;
import com.example.pet_care.service.AdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("adoption")
public class AdoptionController {
    @Autowired
    private AdoptionService adoptionService;

    @PostMapping
    public ResponseEntity<AdoptionRequest> createUser(@RequestBody AdoptionRequest adoptionRequest){
        adoptionService.register(adoptionRequest);
        return  new ResponseEntity<>(adoptionRequest, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Adoption> findById(@PathVariable int id){
        Adoption adoption = adoptionService.findById(id);
        return new ResponseEntity<>(adoption,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Adoption>> findAll(){
        List<Adoption> adoptions = adoptionService.findAllAdoption();
        return new ResponseEntity<>(adoptions,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody AdoptionRequest adoptionRequest){
        adoptionService.updateById(id,adoptionRequest);
        return new ResponseEntity<>("done",HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        adoptionService.deleteById(id);
        return new ResponseEntity<>("done",HttpStatus.OK);
    }


}
