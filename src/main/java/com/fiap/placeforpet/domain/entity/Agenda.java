package com.fiap.placeforpet.domain.entity;

import com.fiap.placeforpet.domain.dto.AgendaDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
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

    private LocalDate dataAgenda;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @OneToOne
    @JoinColumn(name = "espaco_id")
    private Espaco espaco;

    public Agenda(AgendaDto agendaDto) {
        this.dataAgenda = agendaDto.getDataAgenda();
    }
}
