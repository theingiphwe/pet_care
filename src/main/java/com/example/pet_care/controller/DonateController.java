package com.example.pet_care.controller;

import com.example.pet_care.dto.DonateRequest;
import com.example.pet_care.entity.Adoption;
import com.example.pet_care.entity.Donate;
import com.example.pet_care.service.DonateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donate")
public class DonateController {

    @Autowired
    private DonateService donateService;
    @PostMapping
    public ResponseEntity<DonateRequest> create(@RequestBody DonateRequest donateRequest){
        donateService.register(donateRequest);
        return new ResponseEntity<>(donateRequest, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Donate> findById(@PathVariable int id){
        Donate donate = donateService.findById(id);
        return new ResponseEntity<>(donate,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Donate>> findAll(){
        List<Donate> donates =donateService.findAllDonates();
        return new ResponseEntity<>(donates,HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        donateService.deleteById(id);
        return new ResponseEntity<>("1 row effected",HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<String> update(@PathVariable int id,@RequestBody DonateRequest donateRequest){
        donateService.updateById(id, donateRequest);
        return new ResponseEntity<>("Done",HttpStatus.OK);
    }
}
