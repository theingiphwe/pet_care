package com.example.pet_care.controller;

import com.example.pet_care.dto.PetDonateRequest;
import com.example.pet_care.entity.Pet;
import com.example.pet_care.entity.PetDonate;
import com.example.pet_care.service.PetDonateService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/petDonate")
@AllArgsConstructor
public class PetDonateController {
    private PetDonateService petDonateService;

    @PostMapping
    public ResponseEntity<String> createDonation(@RequestBody PetDonateRequest petDonateRequest){
        petDonateService.create(petDonateRequest);
        return new ResponseEntity<>("donation created successfully", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PetDonate>> findAll(){
        List<PetDonate> petDonates = petDonateService.findAllUser();
        return new ResponseEntity<>(petDonates,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody PetDonateRequest petDonateRequest){
        petDonateService.updateById(id,petDonateRequest);
        return new ResponseEntity<>("done",HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        petDonateService.deleteById(id);
        return new ResponseEntity<>("done",HttpStatus.OK);
    }
}
