package com.fiap.placeforpet.domain.entity;

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
    
    @OneToOne
    private Cliente cliente;


    public Endereco(Endereco endereco) {
        this.id = endereco.getId();
        this.lougadouro = endereco.getLougadouro();
        this.complemento = endereco.getComplemento();
        this.cep = endereco.getCep();
        this.cidade = endereco.getCidade();
        this.bairro = endereco.getBairro();
        this.uf = endereco.getUf();
        this.cliente = endereco.getCliente();
    }

}