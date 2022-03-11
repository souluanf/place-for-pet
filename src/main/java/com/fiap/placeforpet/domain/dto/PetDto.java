package com.fiap.placeforpet.domain.dto;

import com.fiap.placeforpet.domain.entity.Pet;
import com.fiap.placeforpet.domain.enums.PorteEnum;
import com.fiap.placeforpet.domain.enums.TemperamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PetDto {

    private String nomepet;
    private String raca;
    private PorteEnum porte;
    private TemperamentoEnum temperamento;
    private Date proximoVencimentoVacina;

    public PetDto(Pet pet) {
        this.nomepet = pet.getNomepet();
        this.raca = pet.getRaca();
        this.porte = pet.getPorte();
        this.temperamento = pet.getTemperamento();
        this.proximoVencimentoVacina = pet.getProximoVencimentoVacina();
    }
}