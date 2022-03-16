package com.fiap.placeforpet.domain.dto;

import com.fiap.placeforpet.domain.entity.Cliente;
import com.fiap.placeforpet.domain.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {

    private String nome;
    private Endereco endereco;
    private List<String> telefone;
    private List<String> email;

    public ClienteDto(Cliente cliente) {
        this.nome = cliente.getNome();
        this.endereco = cliente.getEndereco();
        this.telefone = cliente.getTelefone();
        this.email = cliente.getEmail();
    }

}
