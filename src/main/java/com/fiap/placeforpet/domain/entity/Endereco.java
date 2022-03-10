package com.fiap.placeforpet.domain.entity;

import com.fiap.placeforpet.domain.dto.EnderecoDto;
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
    private String cidade;
    private String uf;

    @OneToOne(mappedBy = "cliente",optional = false)
    private Pet pet;

    @OneToOne(optional = false)
    private Endereco endereco;

    public Endereco(EnderecoDto enderecoDto) {
        this.lougadouro = enderecoDto.getLougadouro();
        this.complemento = enderecoDto.getComplemento();
        this.cep = enderecoDto.getCep();
        this.cidade = enderecoDto.getCidade();
        this.uf = enderecoDto.getUf();
    }
}