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
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ElementCollection
    private List<String> telefone;

    @ElementCollection
    private List<String> email;

    @OneToOne(mappedBy = "cliente",optional = false)
    private Pet pet;

    @OneToOne(optional = false)
    private Endereco endereco;

    public Cliente(ClienteDto clienteDto) {
        this.nome = clienteDto.getNome();
        this.endereco = clienteDto.getEndereco();
        this.telefone = clienteDto.getTelefone();
        this.email = clienteDto.getEmail();
    }
}

