package com.example.pet_care.service;

import com.example.pet_care.dto.DonateRequest;
import com.example.pet_care.entity.Donate;

import java.util.List;

public interface DonateService {
    void register(DonateRequest donateRequest);

    void deleteById(int id);

    List<Donate> findAllDonates();

    void updateById(int id, Donate donate);


    Donate findById(int id);
}
