package com.fiap.placeforpet.service;

import com.fiap.placeforpet.domain.dto.PrecoDto;
import com.fiap.placeforpet.domain.entity.Preco;

import java.util.List;

public interface PrecoService {
    PrecoDto create(Preco preco);

    PrecoDto update(Preco preco);

    void delete(long id);

    List<PrecoDto> getAll();

    PrecoDto getById(long id);
}