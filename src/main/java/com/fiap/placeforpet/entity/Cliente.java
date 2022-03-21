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
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    private String telefone;
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Pet> pet;

    @OneToOne(mappedBy = "cliente")
    private Endereco endereco;
}

