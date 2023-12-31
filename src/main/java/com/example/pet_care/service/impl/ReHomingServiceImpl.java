package com.example.pet_care.service.impl;

import com.example.pet_care.dto.ReHomingRequest;
import com.example.pet_care.entity.ReHoming;
import com.example.pet_care.entity.User;
import com.example.pet_care.repo.ReHomingRepo;
import com.example.pet_care.repo.UserRepo;
import com.example.pet_care.service.ReHomingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReHomingServiceImpl implements ReHomingService {


    private ReHomingRepo reHomingRepo;
    private UserRepo userRepo;
    @Override
    public void register(ReHomingRequest reHomingRequest) {
        User user = userRepo.findById(reHomingRequest.getUserId())
                .orElseThrow(()->new IllegalArgumentException());
        ReHoming reHoming = ReHoming.of(reHomingRequest);
        reHoming.setUser(user);
        reHomingRepo.save(reHoming);

    }

    @Override
    public List<ReHoming> findAllAdoption() {
        return reHomingRepo.findAll();
    }

    @Override
    public void updateById(int id, ReHoming reHoming) {
        Optional<ReHoming> existingReHome = reHomingRepo.findById(id);
        existingReHome.get().setDate(reHoming.getDate());
        existingReHome.get().setDescription(reHoming.getDescription());
        reHomingRepo.save(existingReHome.get());
    }

    @Override
    public void deleteById(int id) {
        if(reHomingRepo.existsById(id)){
            reHomingRepo.deleteById(id);
        }
    }

    @Override
    public ReHoming findById(int id) {
        return reHomingRepo.findById(id).orElseThrow(()->new IllegalArgumentException("invalid id"));
    }
}
