package com.example.pet_care.entity;

import com.example.pet_care.dto.AdoptionRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Adoption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adoptionID;
    private Date date;
    private String comment;
    @ManyToOne
    @JoinColumn(name = "petId")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public static  Adoption of(AdoptionRequest adoptionRequest){
        Adoption adoption = new Adoption();
        adoption.setComment(adoptionRequest.getComment());
        adoption.setDate(adoptionRequest.getDate());
        return adoption;
    }


}
