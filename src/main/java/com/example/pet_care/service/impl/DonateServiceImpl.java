package com.example.pet_care.service.impl;

import com.example.pet_care.entity.Donate;
import com.example.pet_care.repo.DonateRepo;
import com.example.pet_care.service.DonateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DonateServiceImpl implements DonateService {
    @Autowired
    private DonateRepo donateRepo;
    @Override
    public Donate create(Donate donate){return donateRepo.save(donate);}

    @Override
    public void deleteById(int id) {
        if(donateRepo.existsById(id)){
            donateRepo.deleteById(id);
        }

    }
    @Override
    public List<Donate> findAllDonates(){
        return donateRepo.findAll();
    }

    @Override
    public void updateById(int id, Donate donate){
        Optional<Donate> existingDonate= donateRepo.findById(id);
        existingDonate.get().setAmount(donate.getAmount());
        existingDonate.get().setDate(donate.getDate());
        existingDonate.get().setDescription(donate.getDescription());
        donateRepo.save(existingDonate.get());
    }

    @Override
    public Donate findById(int id) {
        return donateRepo.findById(id).orElseThrow(()->new IllegalArgumentException("invalid id"));
    }


}
