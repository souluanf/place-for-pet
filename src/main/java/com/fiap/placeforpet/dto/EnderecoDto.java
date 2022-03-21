package com.fiap.placeforpet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDto {
    String lougadouro;
    String complemento;
    String cep;
    String bairro;
    String cidade;
    String uf;
}