package com.fiap.placeforpet.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Espaco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer capacidade;
    private LocalDate data;

    public Espaco(Espaco espaco) {
        this.capacidade = espaco.getCapacidade();
        this.data = espaco.getData();
    }

    public Espaco(LocalDate data){
        this.data = data;
        this.capacidade = 20;
    }
}
