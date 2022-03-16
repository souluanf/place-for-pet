package com.fiap.placeforpet.domain.dto;

import com.fiap.placeforpet.domain.entity.Preco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrecoDto {

    private double valorHora;

    public  PrecoDto(Preco preco) {
        this.valorHora = preco.getValorHora();
            }
}