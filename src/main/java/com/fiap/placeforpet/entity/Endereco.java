package com.fiap.placeforpet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fiap.placeforpet.dto.EnderecoDto;
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

    public Endereco(EnderecoDto enderecoDto) {
        this.lougadouro = enderecoDto.getLougadouro();
        this.complemento = enderecoDto.getComplemento();
        this.cep = enderecoDto.getCep();
        this.bairro = enderecoDto.getBairro();
        this.cidade = enderecoDto.getCidade();
        this.uf = enderecoDto.getUf();
    }
}