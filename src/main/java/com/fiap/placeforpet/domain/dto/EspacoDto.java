package com.fiap.placeforpet.domain.dto;

import com.fiap.placeforpet.domain.entity.Espaco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EspacoDto {
    private Integer capacidade;

    public  EspacoDto(Espaco espaco) {
        this.capacidade = espaco.getCapacidade();
    }
}