package com.fiap.placeforpet.domain.entity;

import com.fiap.placeforpet.domain.dto.PrecoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Preco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorHora;

    public Preco(PrecoDto precoDto) {
        this.valorHora = precoDto.getValorHora();
    }

}