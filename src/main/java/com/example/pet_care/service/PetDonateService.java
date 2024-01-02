package com.example.pet_care.service;

import com.example.pet_care.dto.PetDonateRequest;
import com.example.pet_care.entity.PetDonate;

import java.util.List;

public interface PetDonateService {
    void create(PetDonateRequest petDonateRequest);

    List<PetDonate> findAllUser();

    void updateById(int id, PetDonate petDonate);

    void deleteById(int id);
}
