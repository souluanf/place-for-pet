package com.fiap.placeforpet.domain.entity;

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

    @OneToMany
    @JoinColumn(name = "pet_id")
    private List<Pet> pet;

    @OneToOne
    private Endereco endereco;

    public Cliente(Cliente cliente) {
        this.nome = cliente.getNome();
        this.endereco = cliente.getEndereco();
        this.telefone = cliente.getTelefone();
        this.email = cliente.getEmail();
    }
}

