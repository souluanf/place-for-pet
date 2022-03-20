package com.fiap.placeforpet.domain.dto;

import com.fiap.placeforpet.domain.entity.Agenda;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgendaDto {

    private LocalDate dataAgenda;

    public  AgendaDto(Agenda agenda) {
        this.dataAgenda = agenda.getDataAgenda();
    }
}