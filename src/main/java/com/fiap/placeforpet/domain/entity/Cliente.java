package com.fiap.placeforpet.domain.entity;

import com.fiap.placeforpet.domain.dto.ClienteDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;
    private List<String> telefone;
    private List<String> email;

    public Cliente (ClienteDto clienteDto) {
    this.nome = clienteDto.getNome();
    this.endereco = clienteDto.getEndereco();
    this.telefone = clienteDto.getTelefone();
    this.email = clienteDto.getEmail();


    }
 //    private Pet pet;
}

