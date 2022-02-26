package com.fiap.placeforpet.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String lougadouro;
    private String complemento;
    private String cep;
    private String cidade;
    private String uf;
}
