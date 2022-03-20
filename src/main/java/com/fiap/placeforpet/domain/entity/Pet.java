package com.fiap.placeforpet.domain.entity;

import com.fiap.placeforpet.domain.dto.PetDto;
import com.fiap.placeforpet.domain.enums.PorteEnum;
import com.fiap.placeforpet.domain.enums.TemperamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomePet;
    private String raca;
    private PorteEnum porte;
    private TemperamentoEnum temperamento;
    private LocalDate proximoVencimentoVacina;

    @OneToMany
    @JoinColumn(name = "agenda_id")
    private List<Agenda> agenda;

    @ManyToOne(optional = false)
    private Cliente cliente;

    public Pet(PetDto petDto) {
        this.nomePet = petDto.getNomePet();
        this.raca = petDto.getRaca();
        this.porte = petDto.getPorte();
        this.temperamento = petDto.getTemperamento();
        this.proximoVencimentoVacina = petDto.getProximoVencimentoVacina();
    }
}

