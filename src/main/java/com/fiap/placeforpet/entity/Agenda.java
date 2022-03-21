package com.fiap.placeforpet.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;


    @JoinColumn(name = "ID_PET")
    @ManyToOne(fetch = FetchType.EAGER)
    private Pet pet;

    public Agenda(Long id, LocalDate data, Pet pet) {
        this.id = id;
        this.data = data;
        this.pet = pet;
    }

}
