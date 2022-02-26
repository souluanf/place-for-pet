package com.fiap.placeforpet.domain.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agenda {
    private LocalDateTime data_entrada;
    private LocalDateTime data_saida;
    private Pet pet;
}
