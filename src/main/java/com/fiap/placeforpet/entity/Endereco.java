package com.fiap.placeforpet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lougadouro;
    private String complemento;
    private String cep;
    private String bairro;
    private String cidade;
    private String uf;

    @JsonIgnore
    @OneToOne(optional = false)
    private Cliente cliente;
}