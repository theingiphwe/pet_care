package com.example.pet_care.service;

import com.example.pet_care.entity.ReHoming;

import java.util.List;

public interface ReHomingService {
    void create(ReHoming reHoming);

    List<ReHoming> findAllAdoption();

    void updateById(int id, ReHoming reHoming);

    void deleteById(int id);

    ReHoming findById(int id);
}
