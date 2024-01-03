package com.example.pet_care.controller;

import com.example.pet_care.dto.DonateRequest;
import com.example.pet_care.entity.AgeType;
import com.example.pet_care.entity.Donate;
import com.example.pet_care.service.AgeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/{id}")
    public  ResponseEntity<String> update(@PathVariable int id,@RequestBody AgeType ageType){
        ageTypeService.updateById(id, ageType);
        return new ResponseEntity<>("Done",HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AgeType>> findAll(){
        List<AgeType> donates =ageTypeService.findAllAgeType();
        return new ResponseEntity<>(donates,HttpStatus.OK);
    }
}
