package com.example.pet_care.service.impl;

import com.example.pet_care.entity.ReHoming;
import com.example.pet_care.repo.ReHomingRepo;
import com.example.pet_care.service.ReHomingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReHomingServiceImpl implements ReHomingService {

    @Autowired
    private ReHomingRepo reHomingRepo;
    @Override
    public void create(ReHoming reHoming) {
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
