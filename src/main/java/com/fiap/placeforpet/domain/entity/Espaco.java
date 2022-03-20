package com.fiap.placeforpet.domain.entity;

import com.fiap.placeforpet.domain.dto.EspacoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    public Espaco(EspacoDto espacoDto) {
        this.capacidade = espacoDto.getCapacidade();
        this.data = espacoDto.getData();
    }

    public Espaco(LocalDate data){
        this.data = data;
        this.capacidade = 20;
    }
}
