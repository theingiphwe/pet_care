package com.example.pet_care.controller;

import com.example.pet_care.entity.Adoption;
import com.example.pet_care.entity.ReHoming;
import com.example.pet_care.service.ReHomingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reHoming")
public class ReHomingController {

    @Autowired
    private ReHomingService reHomingService;

    @PostMapping
    public ResponseEntity<ReHoming> createUser(@RequestBody ReHoming reHoming){
        reHomingService.create(reHoming);
        return  new ResponseEntity<>(reHoming, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReHoming> findById(@PathVariable int id){
        ReHoming reHoming = reHomingService.findById(id);
        return new ResponseEntity<>(reHoming,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ReHoming>> findAll(){
        List<ReHoming> reHoming = reHomingService.findAllAdoption();
        return new ResponseEntity<>(reHoming,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody ReHoming reHoming){
        reHomingService.updateById(id,reHoming);
        return new ResponseEntity<>("done",HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        reHomingService.deleteById(id);
        return new ResponseEntity<>("done",HttpStatus.OK);
    }
}
