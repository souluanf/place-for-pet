package com.fiap.placeforpet.service;

import com.fiap.placeforpet.domain.dto.EnderecoDto;
import com.fiap.placeforpet.domain.entity.Endereco;

import java.util.List;
public interface EnderecoService {
    EnderecoDto create(Endereco endereco);
    EnderecoDto update(Endereco endereco);
    void delete (long id);
    List<EnderecoDto>getAll();
    EnderecoDto getById(long id);
}
