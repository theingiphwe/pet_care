package com.example.pet_care.controller;

import com.example.pet_care.entity.Pet_Type;
import com.example.pet_care.service.Pet_TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/petType")
public class Pet_TypeController {

    @Autowired
    private Pet_TypeService petTypeService;
    @PostMapping
    public ResponseEntity<Pet_Type> create(@RequestBody Pet_Type petType){
        return new ResponseEntity<>(petTypeService.create(petType), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        petTypeService.deleteById(id);
        return new ResponseEntity<>("1 row affected",HttpStatus.OK);
    }

}
