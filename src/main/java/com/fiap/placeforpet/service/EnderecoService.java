package com.fiap.placeforpet.service;

import com.fiap.placeforpet.domain.dto.EnderecoDto;
import com.fiap.placeforpet.domain.entity.Endereco;

import java.util.List;
public interface EnderecoService {
    Endereco getById(Long id);
    List<Endereco>getAll();
    Endereco create(EnderecoDto enderecoDto);
    Endereco update(Endereco endereco);
    void delete (Long id);
}
