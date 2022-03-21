package com.fiap.placeforpet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    private String nome;
    private String raca;

    @JsonIgnore
    @OneToMany(mappedBy = "pet")
    private List<Agenda> agenda;


    @JoinColumn(name = "ID_CLIENTE")
    @ManyToOne
    private Cliente cliente;
}

