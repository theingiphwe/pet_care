package com.example.pet_care.service;

import com.example.pet_care.entity.Donate;

import java.util.List;

public interface DonateService {
    Donate create(Donate donate);

    void deleteById(int id);

    List<Donate> findAllDonates();

    void updateById(int id, Donate donate);


    Donate findById(int id);
}
