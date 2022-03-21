package com.fiap.placeforpet.domain.dto;

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
    private String bairro;
    private String uf;

}