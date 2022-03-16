package com.fiap.placeforpet.domain.dto;

import com.fiap.placeforpet.domain.entity.Agenda;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgendaDto {

    private LocalDateTime dataentrada;
    private LocalDateTime datasaida;

    public  AgendaDto(Agenda agenda) {
        this.dataentrada = agenda.getDataEntrada();
        this.datasaida = agenda.getDataSaida();
    }
}