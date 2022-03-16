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
    private String bairro;
    private String uf;

    @OneToOne(optional = false)
    private Cliente cliente;

    public Endereco(EnderecoDto enderecoDto) {
        this.lougadouro = enderecoDto.getLougadouro();
        this.complemento = enderecoDto.getComplemento();
        this.cep = enderecoDto.getCep();
        this.cidade = enderecoDto.getCidade();
        this.bairro = enderecoDto.getBairro();
        this.uf = enderecoDto.getUf();
    }
}