package com.example.pet_care.controller;

import com.example.pet_care.entity.Adoption;
import com.example.pet_care.entity.Species;
import com.example.pet_care.entity.User;
import com.example.pet_care.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/petType")
public class SpeciesController {

    @Autowired
    private SpeciesService speciesService;
    @PostMapping
    public ResponseEntity<Species> create(@RequestBody Species petType){
        return new ResponseEntity<>(speciesService.create(petType), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Species> findById(@PathVariable int id){
        Species species = speciesService.findById(id);
        return new ResponseEntity<>(species,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Species>> findAll(){
        List<Species> species = speciesService.findAllSpecies();
        return new ResponseEntity<>(species,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody Species species){
        speciesService.updateById(id,species);
        return new ResponseEntity<>("done",HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        speciesService.deleteById(id);
        return new ResponseEntity<>("1 row affected",HttpStatus.OK);
    }

}
