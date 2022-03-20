package com.fiap.placeforpet.domain.dto;

import com.fiap.placeforpet.domain.entity.Espaco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EspacoDto {

    private Integer capacidade;
    private LocalDate data;

    public  EspacoDto(Espaco espaco) {
        this.capacidade = espaco.getCapacidade();
        this.data = espaco.getData();
    }
}