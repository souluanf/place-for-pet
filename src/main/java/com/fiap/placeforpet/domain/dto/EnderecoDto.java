package com.fiap.placeforpet.domain.dto;

import com.fiap.placeforpet.domain.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EnderecoDto {

    private String lougadouro;
    private String complemento;
    private String cep;
    private String cidade;
    private String uf;


    public EnderecoDto(Endereco endereco) {
        this.lougadouro = endereco.getLougadouro();
        this.complemento = endereco.getComplemento();
        this.cep = endereco.getCep();
        this.cidade = endereco.getCidade();
        this.uf = endereco.getUf();
    }
}