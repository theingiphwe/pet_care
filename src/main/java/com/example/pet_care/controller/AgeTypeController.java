package com.example.pet_care.controller;

import com.example.pet_care.entity.AgeType;
import com.example.pet_care.service.AgeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ageType")
public class AgeTypeController {

    @Autowired
    private AgeTypeService ageTypeService;

    @PostMapping
    public ResponseEntity<AgeType> createAgeType(@RequestBody AgeType ageType){
        ageTypeService.create(ageType);
        return new ResponseEntity<>(ageType, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        ageTypeService.deleteById(id);
        return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
    }
}
