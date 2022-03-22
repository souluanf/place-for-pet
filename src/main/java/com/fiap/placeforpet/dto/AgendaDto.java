package com.fiap.placeforpet.dto;

import com.fiap.placeforpet.entity.Pet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgendaDto {

    private LocalDate dataAgenda;
    private Long petId;
}