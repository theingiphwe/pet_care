package com.example.pet_care.service.impl;

import com.example.pet_care.dto.DonateRequest;
import com.example.pet_care.entity.Donate;
import com.example.pet_care.entity.User;
import com.example.pet_care.repo.DonateRepo;
import com.example.pet_care.repo.UserRepo;
import com.example.pet_care.service.DonateService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DonateServiceImpl implements DonateService {

    private DonateRepo donateRepo;
    private UserRepo userRepo;
    @Override
    public void register(DonateRequest donateRequest){
        User user = userRepo.findById(donateRequest.getUserId())
                .orElseThrow(()->new IllegalArgumentException());
        Donate donate = Donate.of(donateRequest);
        donate.setUser(user);
        donateRepo.save(donate);
    }

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
    public void updateById(int id, DonateRequest donateRequest){
        Optional<Donate> existingDonate= donateRepo.findById(id);
        existingDonate.get().setAmount(donateRequest.getAmount());
        existingDonate.get().setDate(donateRequest.getDate());
        existingDonate.get().setDescription(donateRequest.getDescription());
        User user = userRepo.findById(donateRequest.getUserId())
                        .orElseThrow(()->new IllegalArgumentException());
        existingDonate.get().setUser(user);
        donateRepo.save(existingDonate.get());
    }

    @Override
    public Donate findById(int id) {
        return donateRepo.findById(id).orElseThrow(()->new IllegalArgumentException("invalid id"));
    }


}
