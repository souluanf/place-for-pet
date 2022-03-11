package com.fiap.placeforpet.domain.entity;

import com.fiap.placeforpet.domain.dto.AgendaDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataentrada;
    private LocalDateTime dataSaida;
//*    private Pet pet;

    public Agenda(AgendaDto agendaDto) {

        this.dataentrada = agendaDto.getDataentrada();
        this.dataSaida   = agendaDto.getDatasaida();
    }
}
