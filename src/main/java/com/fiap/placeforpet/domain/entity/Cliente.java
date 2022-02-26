package com.fiap.placeforpet.domain.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private Long id;
    private String nome;
    private String endereco;
    private List<String> telefone;
    private List<String> email;
    private Pet pet;
}
