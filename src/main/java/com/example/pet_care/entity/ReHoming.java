package com.example.pet_care.entity;

import com.example.pet_care.dto.ReHomingRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class ReHoming {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reHomingId;
    private Date date;
    private String description;

    @OneToMany(mappedBy = "reHoming",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Pet> pets;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public static ReHoming of(ReHomingRequest reHomingRequest) {
        ReHoming reHoming = new ReHoming();
        reHoming.setDescription(reHomingRequest.getDescription());
        reHoming.setDate(reHomingRequest.getDate());
        return reHoming;
    }
}
