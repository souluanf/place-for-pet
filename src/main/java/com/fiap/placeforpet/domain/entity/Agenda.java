package com.fiap.placeforpet.domain.entity;

import com.fiap.placeforpet.domain.dto.AgendaDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @OneToOne
    @JoinColumn(name = "espaco_id")
    private Espaco espaco;

    @OneToOne
    @JoinColumn(name = "preco_id")
    private Preco preco;

    public Agenda(AgendaDto agendaDto) {
        this.dataEntrada = agendaDto.getDataentrada();
        this.dataSaida   = agendaDto.getDatasaida();
    }
}
