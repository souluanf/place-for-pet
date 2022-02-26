package com.fiap.placeforpet.domain.entity;

import com.fiap.placeforpet.domain.enums.PorteEnum;
import com.fiap.placeforpet.domain.enums.TemperamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String raca;
    private PorteEnum porte;
    private TemperamentoEnum temperamento;
    private Date proximoVencimentoVacina;
//    private Cliente cliente;
}
