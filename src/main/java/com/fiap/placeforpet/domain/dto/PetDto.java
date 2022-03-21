package com.fiap.placeforpet.domain.dto;

import com.fiap.placeforpet.domain.enums.PorteEnum;
import com.fiap.placeforpet.domain.enums.TemperamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetDto {

    private String nomePet;
    private String raca;
    private PorteEnum porte;
    private TemperamentoEnum temperamento;
    private LocalDate proximoVencimentoVacina;
}