package com.fiap.placeforpet.service;

import com.fiap.placeforpet.dto.EnderecoDto;
import com.fiap.placeforpet.entity.Endereco;

import java.util.List;
public interface EnderecoService {
    Endereco getById(Long id);
    List<Endereco>getAll();
    Endereco create(EnderecoDto enderecoDto);
    Endereco update(Endereco endereco);
    void delete (Long id);
}
